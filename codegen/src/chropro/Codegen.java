package chropro;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.squareup.javapoet.*;

import javax.annotation.Generated;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static javax.lang.model.element.Modifier.*;

public class Codegen {
    static Gson gson = new Gson();

    static String PACKAGE = "chropro";
    private static ClassName CLIENT_CLASS = ClassName.get(Codegen.class.getPackage().getName(), "RpcClient");

    public static void main(String args[]) throws IOException {
        Protocol protocol = loadProtocol("browser_protocol.json");
        protocol.merge(loadProtocol("js_protocol.json"));

        File outdir = args.length > 0 ? new File(args[0]) : null;
        protocol.gencode(outdir);
    }

    static Protocol loadProtocol(String name) throws IOException {
        try (InputStream stream = Codegen.class.getResourceAsStream(name);
             InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, Protocol.class);
        }
    }

    static ClassName buildStruct(TypeSpec.Builder b, String name, String description, List<Parameter> members, Protocol protocol, Domain domain) {
        String typeName = name.substring(0, 1).toUpperCase() + name.substring(1);
        TypeSpec.Builder typeSpec = TypeSpec.classBuilder(typeName)
                .addModifiers(PUBLIC, STATIC);

        StringBuilder fieldStrings = new StringBuilder();

        if (description != null) {
            typeSpec.addJavadoc(description.replace("$", "$$") + "\n");
        }

        for (Parameter member : members) {
            if (Objects.equals(member.name, "this")) {
                member.name = "this_";
            }
            FieldSpec.Builder field = FieldSpec.builder(member.typeName(protocol, domain), member.name, PUBLIC);
            if (member.name.equals("this_")) {
                field.addAnnotation(AnnotationSpec.builder(SerializedName.class)
                        .addMember("value", "$S", "this").build());
            }
            if (member.description != null) {
                field.addJavadoc(member.description.replace("$", "$$") + "\n");
            }
            typeSpec.addField(field.build());

            if (fieldStrings.length() > 0) {
                fieldStrings.append(", ");
            }
            fieldStrings.append(member.name + "=\" + " + member.name + " + \"");
        }

        typeSpec.addMethod(MethodSpec.methodBuilder("toString")
                .addModifiers(PUBLIC)
                .returns(String.class)
                .addStatement("return \"" + typeName + "{" + fieldStrings + "}\"").build());

        TypeSpec spec = typeSpec.build();
        b.addType(typeSpec.build());
        return ClassName.get(PACKAGE, domain.javaName, typeName);
    }

    public static String coalesce(String... strs) {
        for (String s : strs) {
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    public static class Protocol {
        List<Domain> domains;
        Pattern pattern = Pattern.compile("([A-Z]+)(.*)");

        void gencode(File outdir) throws IOException {
            AnnotationSpec generatedAnnotation = AnnotationSpec.builder(Generated.class)
                    .addMember("value", "$S", Codegen.class.getCanonicalName())
                    .addMember("date", "$S", Instant.now().toString())
                    .build();

            for (Domain domain : domains) {
                domain.init(generatedAnnotation);
            }

            for (Domain domain : domains) {
                domain.buildType(this);
            }

            for (Domain domain : domains) {
                JavaFile javaFile = JavaFile.builder(PACKAGE, domain.builder.build()).build();
                if (outdir == null) {
                    javaFile.writeTo(System.out);
                } else {
                    javaFile.writeTo(outdir);
                }
            }

            genEntrypoint(outdir);
        }

        private void genEntrypoint(File outdir) throws IOException {
            TypeSpec.Builder entrypoint = TypeSpec.classBuilder("Chropro")
                    .addModifiers(PUBLIC)
                    .addSuperinterface(Closeable.class)
                    .addField(CLIENT_CLASS, "rpcClient", PUBLIC, FINAL);
            MethodSpec.Builder constructor = MethodSpec.constructorBuilder()
                    .addParameter(CLIENT_CLASS, "rpcClient")
                    .addModifiers(PUBLIC)
                    .addStatement("this.rpcClient = rpcClient");
            for (Domain domain : domains) {
                FieldSpec field = FieldSpec.builder(domain.className, uncap(domain.domain), PUBLIC, FINAL).build();
                entrypoint.addField(field);
                constructor.addStatement("$N = new $T(rpcClient)", field, domain.className);
            }

            entrypoint.addMethod(MethodSpec.constructorBuilder()
                    .addParameter(TypeName.INT, "port")
                    .addModifiers(PUBLIC)
                    .addException(IOException.class)
                    .addStatement("this(new $T(port))", CLIENT_CLASS)
                    .build());

            entrypoint.addMethod(constructor.build());

            entrypoint.addMethod(MethodSpec.methodBuilder("close")
                    .addModifiers(PUBLIC)
                    .addException(IOException.class)
                    .addStatement("rpcClient.close()")
                    .build());

            JavaFile javaFile = JavaFile.builder(PACKAGE, entrypoint.build()).build();
            if (outdir == null) {
                javaFile.writeTo(System.out);
            } else {
                javaFile.writeTo(outdir);
            }
        }

        private String uncap(String name) {
            Matcher m = pattern.matcher(name);
            if (m.matches()) {
                return m.group(1).toLowerCase() + m.group(2);
            } else {
                return name;
            }
        }

        public Domain domain(String domainName) {
            for (Domain domain : domains) {
                if (domainName.equals(domain.domain)) {
                    return domain;
                }
            }
            throw new IllegalArgumentException("No such domain: " + domainName);
        }

        public Parameter ref(String domainName, String typeName) {
            for (Domain domain : domains) {
                if (domainName.equals(domain.domain)) {
                    return domain.ref(typeName);
                }
            }
            throw new IllegalStateException("Unresolved $ref: missing domain " + domainName);
        }

        public void merge(Protocol other) {
            domains.addAll(other.domains);
        }
    }

    public static class Domain {
        public String domain;
        public String javaName;
        public ClassName className;
        public List<Parameter> types;
        public List<Command> commands;
        TypeSpec.Builder builder;

        void init(AnnotationSpec generatedAnnotation) {
            javaName = domain + "Domain";
            className = ClassName.get(PACKAGE, javaName);

            builder = TypeSpec.classBuilder(className)
                    .addModifiers(PUBLIC)
                    .addAnnotation(generatedAnnotation);

            builder.addField(CLIENT_CLASS, "rpcClient", PRIVATE);

            builder.addMethod(MethodSpec.constructorBuilder()
                    .addModifiers(PUBLIC)
                    .addParameter(CLIENT_CLASS, "rpcClient")
                    .addStatement("this.rpcClient = rpcClient")
                    .build());
        }

        public void buildType(Protocol protocol) {
            for (Command command : commands) {
                command.build(builder, protocol, this);
            }
        }

        public Parameter ref(String id) {
            for (Parameter t : types) {
                if (id.equals(t.id)) {
                    return t;
                }
            }
            throw new IllegalStateException("Unresolved $ref: " + id + " in " + domain);
        }
    }

    public static class Command {
        public List<Parameter> parameters = Collections.emptyList();
        public List<Parameter> returns = Collections.emptyList();
        String name, description;

        public void build(TypeSpec.Builder b, Protocol protocol, Domain domain) {
            MethodSpec.Builder methodSpec = MethodSpec.methodBuilder(name)
                    .addModifiers(PUBLIC);
            if (description != null) {
                methodSpec.addJavadoc(description.replace("$", "$$") + "\n");
            }

            ClassName resultType;

            if (returns.isEmpty()) {
                resultType = ClassName.get(Void.class);
            } else {
                resultType = buildStruct(b, name, null, returns, protocol, domain);
            }
            TypeName returnType = ParameterizedTypeName.get(ClassName.get(CompletableFuture.class), resultType);
            methodSpec.returns(returnType);

            for (Parameter param : parameters) {
                TypeName type = param.typeName(protocol, domain);
                if (type != null) {
                    param.spec = ParameterSpec.builder(type, param.name).build();
                } else {
                    param.spec = ParameterSpec.builder(Object.class, param.name).build();
                }
                methodSpec.addParameter(param.spec);
            }

            methodSpec.addStatement("$T<String,Object> params = new $T<>()", Map.class, HashMap.class);
            for (Parameter param : parameters) {
                methodSpec.addStatement("params.put($S, $N)", param.name, param.spec);
            }
            methodSpec.addStatement("return rpcClient.call($S, params, $T.class)", domain.domain + "." + name, resultType);

            b.addMethod(methodSpec.build());
        }
    }

    public static class Parameter {
        public String description;
        String id;
        String name, type;
        Parameter items;
        String $ref;
        List<Parameter> properties;
        private ClassName className;
        private ParameterSpec spec;

        public TypeName typeName(Protocol protocol, Domain domain) {
            if ($ref != null) {
                if ($ref.contains(".")) {
                    String[] parts = $ref.split("\\.");
                    Domain refDomain = protocol.domain(parts[0]);
                    return refDomain.ref(parts[1]).typeName(protocol, refDomain);
                } else {
                    return domain.ref($ref).typeName(protocol, domain);
                }
            }
            if (type == null) {
                return TypeName.get(Object.class);
            }
            switch (type) {
                case "string":
                    return TypeName.get(String.class);
                case "integer":
                    return TypeName.get(Integer.class);
                case "boolean":
                    return TypeName.get(Boolean.class);
                case "number":
                    return TypeName.get(Double.class);
                case "object":
                    if (properties == null) {
                        return ParameterizedTypeName.get(Map.class, String.class, Object.class);
                    }
                    if (className == null) {
                        String typeName = cap(coalesce(id, name, "anonymous"));
                        className = ClassName.get(PACKAGE, domain.javaName, typeName);
                        buildStruct(domain.builder, typeName, description, properties, protocol, domain);
                    }
                    return className;
                case "array":
                    return ParameterizedTypeName.get(ClassName.get(List.class), items.typeName(protocol, domain));
                default:
                    return TypeName.get(Object.class);
            }
        }

        private String cap(String name) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }
    }
}
