package chropro;

import com.google.gson.Gson;
import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class Chropro {
    static Gson gson = new Gson();

    public static void main(String args[]) throws IOException {
        Protocol protocol = loadProtocol("browser_protocol.json");
        protocol.merge(loadProtocol("js_protocol.json"));

        protocol.buildJavaFile().writeTo(System.out);
    }

    static Protocol loadProtocol(String name) throws IOException {
        try (InputStream stream = Chropro.class.getResourceAsStream(name);
             InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
            return gson.fromJson(reader, Protocol.class);
        }
    }

    public static class Protocol {
        Version version;
        List<Domain> domains;

        JavaFile buildJavaFile() {
            TypeSpec.Builder typeSpec = TypeSpec.classBuilder("Chropro")
                    .addModifiers(Modifier.PUBLIC);
            for (Domain domain: domains) {
                typeSpec.addType(domain.buildType(this));
            }
            return JavaFile.builder("test", typeSpec.build()).build();
        }

        public Parameter ref(String domainName, String typeName) {
            for (Domain domain: domains) {
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

    public static class Version {
        public int major, minor;
    }

    public static class Domain {
        public String domain;
        public List<Parameter> types;
        public List<Command> commands;

        public TypeSpec buildType(Protocol protocol) {
            TypeSpec.Builder b = TypeSpec.classBuilder(domain)
                    .addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.ABSTRACT);
            for (Command command: commands) {

                command.build(b, protocol, this);

            }
            return b.build();
        }

        public Parameter ref(String id) {
            for (Parameter t: types) {
                if (id.equals(t.id)) {
                    return t;
                }
            }
            throw new IllegalStateException("Unresolved $ref: " + id);
        }
    }

    public static class Command {
        String name, description;
        public List<Parameter> parameters = Collections.emptyList();
        public List<Parameter> returns = Collections.emptyList();


        public void build(TypeSpec.Builder b, Protocol protocol, Domain domain) {
            MethodSpec.Builder methodSpec = MethodSpec.methodBuilder(name)
                    .addModifiers(Modifier.PUBLIC);
            if (description != null) {
                methodSpec.addJavadoc(description.replace("$", "$$") + "\n");
            }

            for (Parameter param : parameters) {
                TypeName type = param.typeName(protocol, domain);
                if (type != null) {
                    param.spec = ParameterSpec.builder(type, param.name).build();
                } else {
                    param.spec = ParameterSpec.builder(Object.class, param.name).build();
                }
                methodSpec.addParameter(param.spec);
            }

            methodSpec.addStatement("Map<String,Object> params = new HashMap<>()");
            for (Parameter param : parameters) {
                methodSpec.addStatement("params.put($S, $N)", param.name, param.spec);
            }
            methodSpec.addStatement("client.call($S, params)", name);

            b.addMethod(methodSpec.build());
        }
    }

    public static class Parameter {
        String id;
        String name, type;
        Parameter items;
        String $ref;
        private Class javaClass;
        private ParameterSpec spec;

        public TypeName typeName(Protocol protocol, Domain domain) {
            if ($ref != null) {
                if ($ref.contains(".")) {
                    String[] parts = $ref.split("\\.");
                    return protocol.ref(parts[0], parts[1]).typeName(protocol, domain);
                } else {
                    return domain.ref($ref).typeName(protocol, domain);
                }
            }
            if (type == null) {
                return null;
            }
            switch (type) {
                case "string": return TypeName.get(String.class);
                case "integer": return TypeName.INT;
                case "boolean": return TypeName.BOOLEAN;
                case "number": return TypeName.DOUBLE;
                default: return null;
            }
        }
    }
}
