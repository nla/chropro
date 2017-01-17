package chropro;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class RuntimeDomain {
  private RpcClient rpcClient;

  public RuntimeDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Evaluates expression on global object.
   * @param expression Expression to evaluate.
   * @param objectGroup Symbolic group name that can be used to release multiple objects.
   * @param includeCommandLineAPI Determines whether Command Line API should be available during the evaluation.
   * @param silent In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
   * @param contextId Specifies in which execution context to perform evaluation. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
   * @param returnByValue Whether the result is expected to be a JSON object that should be sent by value.
   * @param generatePreview Whether preview should be generated for the result.
   * @param userGesture Whether execution should be treated as initiated by user in the UI.
   * @param awaitPromise Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
   */
  public CompletableFuture<Evaluate> evaluate(@NotNull String expression, @Nullable String objectGroup, @Nullable Boolean includeCommandLineAPI, @Nullable Boolean silent, @Nullable Integer contextId, @Nullable Boolean returnByValue, @Nullable Boolean generatePreview, @Nullable Boolean userGesture, @Nullable Boolean awaitPromise) {
    Map<String,Object> params = new HashMap<>();
    params.put("expression", expression);
    params.put("objectGroup", objectGroup);
    params.put("includeCommandLineAPI", includeCommandLineAPI);
    params.put("silent", silent);
    params.put("contextId", contextId);
    params.put("returnByValue", returnByValue);
    params.put("generatePreview", generatePreview);
    params.put("userGesture", userGesture);
    params.put("awaitPromise", awaitPromise);
    return rpcClient.call("Runtime.evaluate", params, Evaluate.class);
  }

  /**
   * Add handler to promise with given promise object id.
   * @param promiseObjectId Identifier of the promise.
   * @param returnByValue Whether the result is expected to be a JSON object that should be sent by value.
   * @param generatePreview Whether preview should be generated for the result.
   */
  public CompletableFuture<AwaitPromise> awaitPromise(@NotNull String promiseObjectId, @Nullable Boolean returnByValue, @Nullable Boolean generatePreview) {
    Map<String,Object> params = new HashMap<>();
    params.put("promiseObjectId", promiseObjectId);
    params.put("returnByValue", returnByValue);
    params.put("generatePreview", generatePreview);
    return rpcClient.call("Runtime.awaitPromise", params, AwaitPromise.class);
  }

  /**
   * Calls function with given declaration on the given object. Object group of the result is inherited from the target object.
   * @param objectId Identifier of the object to call function on.
   * @param functionDeclaration Declaration of the function to call.
   * @param arguments Call arguments. All call arguments must belong to the same JavaScript world as the target object.
   * @param silent In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
   * @param returnByValue Whether the result is expected to be a JSON object which should be sent by value.
   * @param generatePreview Whether preview should be generated for the result.
   * @param userGesture Whether execution should be treated as initiated by user in the UI.
   * @param awaitPromise Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
   */
  public CompletableFuture<CallFunctionOn> callFunctionOn(@NotNull String objectId, @NotNull String functionDeclaration, @Nullable List<CallArgument> arguments, @Nullable Boolean silent, @Nullable Boolean returnByValue, @Nullable Boolean generatePreview, @Nullable Boolean userGesture, @Nullable Boolean awaitPromise) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    params.put("functionDeclaration", functionDeclaration);
    params.put("arguments", arguments);
    params.put("silent", silent);
    params.put("returnByValue", returnByValue);
    params.put("generatePreview", generatePreview);
    params.put("userGesture", userGesture);
    params.put("awaitPromise", awaitPromise);
    return rpcClient.call("Runtime.callFunctionOn", params, CallFunctionOn.class);
  }

  /**
   * Returns properties of a given object. Object group of the result is inherited from the target object.
   * @param objectId Identifier of the object to return properties for.
   * @param ownProperties If true, returns properties belonging only to the element itself, not to its prototype chain.
   * @param accessorPropertiesOnly If true, returns accessor properties (with getter/setter) only; internal properties are not returned either.
   * @param generatePreview Whether preview should be generated for the results.
   */
  public CompletableFuture<GetProperties> getProperties(@NotNull String objectId, @Nullable Boolean ownProperties, @Nullable Boolean accessorPropertiesOnly, @Nullable Boolean generatePreview) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    params.put("ownProperties", ownProperties);
    params.put("accessorPropertiesOnly", accessorPropertiesOnly);
    params.put("generatePreview", generatePreview);
    return rpcClient.call("Runtime.getProperties", params, GetProperties.class);
  }

  /**
   * Releases remote object with given id.
   * @param objectId Identifier of the object to release.
   */
  public CompletableFuture<Void> releaseObject(@NotNull String objectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    return rpcClient.call("Runtime.releaseObject", params, Void.class);
  }

  /**
   * Releases all remote objects that belong to a given group.
   * @param objectGroup Symbolic object group name.
   */
  public CompletableFuture<Void> releaseObjectGroup(@NotNull String objectGroup) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectGroup", objectGroup);
    return rpcClient.call("Runtime.releaseObjectGroup", params, Void.class);
  }

  /**
   * Tells inspected instance to run if it was waiting for debugger to attach.
   */
  public CompletableFuture<Void> runIfWaitingForDebugger() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Runtime.runIfWaitingForDebugger", params, Void.class);
  }

  /**
   * Enables reporting of execution contexts creation by means of <code>executionContextCreated</code> event. When the reporting gets enabled the event will be sent immediately for each existing execution context.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Runtime.enable", params, Void.class);
  }

  /**
   * Disables reporting of execution contexts creation.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Runtime.disable", params, Void.class);
  }

  /**
   * Discards collected exceptions and console API calls.
   */
  public CompletableFuture<Void> discardConsoleEntries() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Runtime.discardConsoleEntries", params, Void.class);
  }

  public CompletableFuture<Void> setCustomObjectFormatterEnabled(@NotNull Boolean enabled) {
    Map<String,Object> params = new HashMap<>();
    params.put("enabled", enabled);
    return rpcClient.call("Runtime.setCustomObjectFormatterEnabled", params, Void.class);
  }

  /**
   * Compiles expression.
   * @param expression Expression to compile.
   * @param sourceURL Source url to be set for the script.
   * @param persistScript Specifies whether the compiled script should be persisted.
   * @param executionContextId Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
   */
  public CompletableFuture<CompileScript> compileScript(@NotNull String expression, @NotNull String sourceURL, @NotNull Boolean persistScript, @Nullable Integer executionContextId) {
    Map<String,Object> params = new HashMap<>();
    params.put("expression", expression);
    params.put("sourceURL", sourceURL);
    params.put("persistScript", persistScript);
    params.put("executionContextId", executionContextId);
    return rpcClient.call("Runtime.compileScript", params, CompileScript.class);
  }

  /**
   * Runs script with given id in a given context.
   * @param scriptId Id of the script to run.
   * @param executionContextId Specifies in which execution context to perform script run. If the parameter is omitted the evaluation will be performed in the context of the inspected page.
   * @param objectGroup Symbolic group name that can be used to release multiple objects.
   * @param silent In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
   * @param includeCommandLineAPI Determines whether Command Line API should be available during the evaluation.
   * @param returnByValue Whether the result is expected to be a JSON object which should be sent by value.
   * @param generatePreview Whether preview should be generated for the result.
   * @param awaitPromise Whether execution should wait for promise to be resolved. If the result of evaluation is not a Promise, it's considered to be an error.
   */
  public CompletableFuture<RunScript> runScript(@NotNull String scriptId, @Nullable Integer executionContextId, @Nullable String objectGroup, @Nullable Boolean silent, @Nullable Boolean includeCommandLineAPI, @Nullable Boolean returnByValue, @Nullable Boolean generatePreview, @Nullable Boolean awaitPromise) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptId", scriptId);
    params.put("executionContextId", executionContextId);
    params.put("objectGroup", objectGroup);
    params.put("silent", silent);
    params.put("includeCommandLineAPI", includeCommandLineAPI);
    params.put("returnByValue", returnByValue);
    params.put("generatePreview", generatePreview);
    params.put("awaitPromise", awaitPromise);
    return rpcClient.call("Runtime.runScript", params, RunScript.class);
  }

  /**
   * Issued when new execution context is created.
   */
  public void onExecutionContextCreated(Consumer<ExecutionContextCreated> listener) {
    rpcClient.addEventListener("Runtime.executionContextCreated", listener, ExecutionContextCreated.class);
  }

  /**
   * Issued when new execution context is created.
   */
  public CompletableFuture<ExecutionContextCreated> onExecutionContextCreated() {
    return rpcClient.eventFuture("Runtime.executionContextCreated", ExecutionContextCreated.class);
  }

  /**
   * Issued when execution context is destroyed.
   */
  public void onExecutionContextDestroyed(Consumer<ExecutionContextDestroyed> listener) {
    rpcClient.addEventListener("Runtime.executionContextDestroyed", listener, ExecutionContextDestroyed.class);
  }

  /**
   * Issued when execution context is destroyed.
   */
  public CompletableFuture<ExecutionContextDestroyed> onExecutionContextDestroyed() {
    return rpcClient.eventFuture("Runtime.executionContextDestroyed", ExecutionContextDestroyed.class);
  }

  /**
   * Issued when all executionContexts were cleared in browser
   */
  public void onExecutionContextsCleared(Consumer<ExecutionContextsCleared> listener) {
    rpcClient.addEventListener("Runtime.executionContextsCleared", listener, ExecutionContextsCleared.class);
  }

  /**
   * Issued when all executionContexts were cleared in browser
   */
  public CompletableFuture<ExecutionContextsCleared> onExecutionContextsCleared() {
    return rpcClient.eventFuture("Runtime.executionContextsCleared", ExecutionContextsCleared.class);
  }

  /**
   * Issued when exception was thrown and unhandled.
   */
  public void onExceptionThrown(Consumer<ExceptionThrown> listener) {
    rpcClient.addEventListener("Runtime.exceptionThrown", listener, ExceptionThrown.class);
  }

  /**
   * Issued when exception was thrown and unhandled.
   */
  public CompletableFuture<ExceptionThrown> onExceptionThrown() {
    return rpcClient.eventFuture("Runtime.exceptionThrown", ExceptionThrown.class);
  }

  /**
   * Issued when unhandled exception was revoked.
   */
  public void onExceptionRevoked(Consumer<ExceptionRevoked> listener) {
    rpcClient.addEventListener("Runtime.exceptionRevoked", listener, ExceptionRevoked.class);
  }

  /**
   * Issued when unhandled exception was revoked.
   */
  public CompletableFuture<ExceptionRevoked> onExceptionRevoked() {
    return rpcClient.eventFuture("Runtime.exceptionRevoked", ExceptionRevoked.class);
  }

  /**
   * Issued when console API was called.
   */
  public void onConsoleAPICalled(Consumer<ConsoleAPICalled> listener) {
    rpcClient.addEventListener("Runtime.consoleAPICalled", listener, ConsoleAPICalled.class);
  }

  /**
   * Issued when console API was called.
   */
  public CompletableFuture<ConsoleAPICalled> onConsoleAPICalled() {
    return rpcClient.eventFuture("Runtime.consoleAPICalled", ConsoleAPICalled.class);
  }

  /**
   * Issued when object should be inspected (for example, as a result of inspect() command line API call).
   */
  public void onInspectRequested(Consumer<InspectRequested> listener) {
    rpcClient.addEventListener("Runtime.inspectRequested", listener, InspectRequested.class);
  }

  /**
   * Issued when object should be inspected (for example, as a result of inspect() command line API call).
   */
  public CompletableFuture<InspectRequested> onInspectRequested() {
    return rpcClient.eventFuture("Runtime.inspectRequested", InspectRequested.class);
  }

  /**
   * Stack entry for runtime errors and assertions.
   */
  public static class CallFrame {
    /**
     * JavaScript function name.
     */
    public String functionName;

    /**
     * JavaScript script id.
     */
    public String scriptId;

    /**
     * JavaScript script name or url.
     */
    public String url;

    /**
     * JavaScript script line number (0-based).
     */
    public Integer lineNumber;

    /**
     * JavaScript script column number (0-based).
     */
    public Integer columnNumber;

    public String toString() {
      return "CallFrame{functionName=" + functionName + ", scriptId=" + scriptId + ", url=" + url + ", lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + "}";
    }
  }

  /**
   * Call frames for assertions or error messages.
   */
  public static class StackTrace {
    /**
     * String label of this stack trace. For async traces this may be a name of the function that initiated the async call.
     */
    public String description;

    /**
     * JavaScript function name.
     */
    public List<CallFrame> callFrames;

    /**
     * Asynchronous JavaScript stack trace that preceded this stack, if available.
     */
    public StackTrace parent;

    public String toString() {
      return "StackTrace{description=" + description + ", callFrames=" + callFrames + ", parent=" + parent + "}";
    }
  }

  public static class PropertyPreview {
    /**
     * Property name.
     */
    public String name;

    /**
     * Object type. Accessor means that the property itself is an accessor property.
     */
    public String type;

    /**
     * User-friendly property value string.
     */
    public String value;

    /**
     * Nested value preview.
     */
    public ObjectPreview valuePreview;

    /**
     * Object subtype hint. Specified for <code>object</code> type values only.
     */
    public String subtype;

    public String toString() {
      return "PropertyPreview{name=" + name + ", type=" + type + ", value=" + value + ", valuePreview=" + valuePreview + ", subtype=" + subtype + "}";
    }
  }

  public static class EntryPreview {
    /**
     * Preview of the key. Specified for map-like collection entries.
     */
    public ObjectPreview key;

    /**
     * Preview of the value.
     */
    public ObjectPreview value;

    public String toString() {
      return "EntryPreview{key=" + key + ", value=" + value + "}";
    }
  }

  /**
   * Object containing abbreviated remote object value.
   */
  public static class ObjectPreview {
    /**
     * Object type.
     */
    public String type;

    /**
     * Object subtype hint. Specified for <code>object</code> type values only.
     */
    public String subtype;

    /**
     * String representation of the object.
     */
    public String description;

    /**
     * True iff some of the properties or entries of the original object did not fit.
     */
    public Boolean overflow;

    /**
     * List of the properties.
     */
    public List<PropertyPreview> properties;

    /**
     * List of the entries. Specified for <code>map</code> and <code>set</code> subtype values only.
     */
    public List<EntryPreview> entries;

    public String toString() {
      return "ObjectPreview{type=" + type + ", subtype=" + subtype + ", description=" + description + ", overflow=" + overflow + ", properties=" + properties + ", entries=" + entries + "}";
    }
  }

  public static class CustomPreview {
    public String header;

    public Boolean hasBody;

    public String formatterObjectId;

    public String bindRemoteObjectFunctionId;

    public String configObjectId;

    public String toString() {
      return "CustomPreview{header=" + header + ", hasBody=" + hasBody + ", formatterObjectId=" + formatterObjectId + ", bindRemoteObjectFunctionId=" + bindRemoteObjectFunctionId + ", configObjectId=" + configObjectId + "}";
    }
  }

  /**
   * Mirror object referencing original JavaScript object.
   */
  public static class RemoteObject {
    /**
     * Object type.
     */
    public String type;

    /**
     * Object subtype hint. Specified for <code>object</code> type values only.
     */
    public String subtype;

    /**
     * Object class (constructor) name. Specified for <code>object</code> type values only.
     */
    public String className;

    /**
     * Remote object value in case of primitive values or JSON values (if it was requested).
     */
    public Object value;

    /**
     * Primitive value which can not be JSON-stringified does not have <code>value</code>, but gets this property.
     */
    public String unserializableValue;

    /**
     * String representation of the object.
     */
    public String description;

    /**
     * Unique object identifier (for non-primitive values).
     */
    public String objectId;

    /**
     * Preview containing abbreviated property values. Specified for <code>object</code> type values only.
     */
    public ObjectPreview preview;

    public CustomPreview customPreview;

    public String toString() {
      return "RemoteObject{type=" + type + ", subtype=" + subtype + ", className=" + className + ", value=" + value + ", unserializableValue=" + unserializableValue + ", description=" + description + ", objectId=" + objectId + ", preview=" + preview + ", customPreview=" + customPreview + "}";
    }
  }

  /**
   * Detailed information about exception (or error) that was thrown during script compilation or execution.
   */
  public static class ExceptionDetails {
    /**
     * Exception id.
     */
    public Integer exceptionId;

    /**
     * Exception text, which should be used together with exception object when available.
     */
    public String text;

    /**
     * Line number of the exception location (0-based).
     */
    public Integer lineNumber;

    /**
     * Column number of the exception location (0-based).
     */
    public Integer columnNumber;

    /**
     * Script ID of the exception location.
     */
    public String scriptId;

    /**
     * URL of the exception location, to be used when the script was not reported.
     */
    public String url;

    /**
     * JavaScript stack trace if available.
     */
    public StackTrace stackTrace;

    /**
     * Exception object if available.
     */
    public RemoteObject exception;

    /**
     * Identifier of the context where exception happened.
     */
    public Integer executionContextId;

    public String toString() {
      return "ExceptionDetails{exceptionId=" + exceptionId + ", text=" + text + ", lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + ", scriptId=" + scriptId + ", url=" + url + ", stackTrace=" + stackTrace + ", exception=" + exception + ", executionContextId=" + executionContextId + "}";
    }
  }

  public static class Evaluate {
    /**
     * Evaluation result.
     */
    public RemoteObject result;

    /**
     * Exception details.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "Evaluate{result=" + result + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  public static class AwaitPromise {
    /**
     * Promise result. Will contain rejected value if promise was rejected.
     */
    public RemoteObject result;

    /**
     * Exception details if stack strace is available.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "AwaitPromise{result=" + result + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  public static class CallFunctionOn {
    /**
     * Call result.
     */
    public RemoteObject result;

    /**
     * Exception details.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "CallFunctionOn{result=" + result + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  /**
   * Represents function call argument. Either remote object id <code>objectId</code>, primitive <code>value</code>, unserializable primitive value or neither of (for undefined) them should be specified.
   */
  public static class CallArgument {
    /**
     * Primitive value.
     */
    public Object value;

    /**
     * Primitive value which can not be JSON-stringified.
     */
    public String unserializableValue;

    /**
     * Remote object handle.
     */
    public String objectId;

    public String toString() {
      return "CallArgument{value=" + value + ", unserializableValue=" + unserializableValue + ", objectId=" + objectId + "}";
    }
  }

  /**
   * Object property descriptor.
   */
  public static class PropertyDescriptor {
    /**
     * Property name or symbol description.
     */
    public String name;

    /**
     * The value associated with the property.
     */
    public RemoteObject value;

    /**
     * True if the value associated with the property may be changed (data descriptors only).
     */
    public Boolean writable;

    /**
     * A function which serves as a getter for the property, or <code>undefined</code> if there is no getter (accessor descriptors only).
     */
    public RemoteObject get;

    /**
     * A function which serves as a setter for the property, or <code>undefined</code> if there is no setter (accessor descriptors only).
     */
    public RemoteObject set;

    /**
     * True if the type of this property descriptor may be changed and if the property may be deleted from the corresponding object.
     */
    public Boolean configurable;

    /**
     * True if this property shows up during enumeration of the properties on the corresponding object.
     */
    public Boolean enumerable;

    /**
     * True if the result was thrown during the evaluation.
     */
    public Boolean wasThrown;

    /**
     * True if the property is owned for the object.
     */
    public Boolean isOwn;

    /**
     * Property symbol object, if the property is of the <code>symbol</code> type.
     */
    public RemoteObject symbol;

    public String toString() {
      return "PropertyDescriptor{name=" + name + ", value=" + value + ", writable=" + writable + ", get=" + get + ", set=" + set + ", configurable=" + configurable + ", enumerable=" + enumerable + ", wasThrown=" + wasThrown + ", isOwn=" + isOwn + ", symbol=" + symbol + "}";
    }
  }

  /**
   * Object internal property descriptor. This property isn't normally visible in JavaScript code.
   */
  public static class InternalPropertyDescriptor {
    /**
     * Conventional property name.
     */
    public String name;

    /**
     * The value associated with the property.
     */
    public RemoteObject value;

    public String toString() {
      return "InternalPropertyDescriptor{name=" + name + ", value=" + value + "}";
    }
  }

  public static class GetProperties {
    /**
     * Object properties.
     */
    public List<PropertyDescriptor> result;

    /**
     * Internal object properties (only of the element itself).
     */
    public List<InternalPropertyDescriptor> internalProperties;

    /**
     * Exception details.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "GetProperties{result=" + result + ", internalProperties=" + internalProperties + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  public static class CompileScript {
    /**
     * Id of the script.
     */
    public String scriptId;

    /**
     * Exception details.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "CompileScript{scriptId=" + scriptId + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  public static class RunScript {
    /**
     * Run result.
     */
    public RemoteObject result;

    /**
     * Exception details.
     */
    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "RunScript{result=" + result + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  /**
   * Description of an isolated world.
   */
  public static class ExecutionContextDescription {
    /**
     * Unique id of the execution context. It can be used to specify in which execution context script evaluation should be performed.
     */
    public Integer id;

    /**
     * Execution context origin.
     */
    public String origin;

    /**
     * Human readable name describing given context.
     */
    public String name;

    /**
     * Embedder-specific auxiliary data.
     */
    public Map<String, Object> auxData;

    public String toString() {
      return "ExecutionContextDescription{id=" + id + ", origin=" + origin + ", name=" + name + ", auxData=" + auxData + "}";
    }
  }

  /**
   * Issued when new execution context is created.
   */
  public static class ExecutionContextCreated {
    /**
     * A newly created execution contex.
     */
    public ExecutionContextDescription context;

    public String toString() {
      return "ExecutionContextCreated{context=" + context + "}";
    }
  }

  /**
   * Issued when execution context is destroyed.
   */
  public static class ExecutionContextDestroyed {
    /**
     * Id of the destroyed context
     */
    public Integer executionContextId;

    public String toString() {
      return "ExecutionContextDestroyed{executionContextId=" + executionContextId + "}";
    }
  }

  /**
   * Issued when all executionContexts were cleared in browser
   */
  public static class ExecutionContextsCleared {
    public String toString() {
      return "ExecutionContextsCleared{}";
    }
  }

  /**
   * Issued when exception was thrown and unhandled.
   */
  public static class ExceptionThrown {
    /**
     * Timestamp of the exception.
     */
    public Double timestamp;

    public ExceptionDetails exceptionDetails;

    public String toString() {
      return "ExceptionThrown{timestamp=" + timestamp + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  /**
   * Issued when unhandled exception was revoked.
   */
  public static class ExceptionRevoked {
    /**
     * Reason describing why exception was revoked.
     */
    public String reason;

    /**
     * The id of revoked exception, as reported in <code>exceptionUnhandled</code>.
     */
    public Integer exceptionId;

    public String toString() {
      return "ExceptionRevoked{reason=" + reason + ", exceptionId=" + exceptionId + "}";
    }
  }

  /**
   * Issued when console API was called.
   */
  public static class ConsoleAPICalled {
    /**
     * Type of the call.
     */
    public String type;

    /**
     * Call arguments.
     */
    public List<RemoteObject> args;

    /**
     * Identifier of the context where the call was made.
     */
    public Integer executionContextId;

    /**
     * Call timestamp.
     */
    public Double timestamp;

    /**
     * Stack trace captured when the call was made.
     */
    public StackTrace stackTrace;

    public String toString() {
      return "ConsoleAPICalled{type=" + type + ", args=" + args + ", executionContextId=" + executionContextId + ", timestamp=" + timestamp + ", stackTrace=" + stackTrace + "}";
    }
  }

  /**
   * Issued when object should be inspected (for example, as a result of inspect() command line API call).
   */
  public static class InspectRequested {
    public RemoteObject object;

    public Map<String, Object> hints;

    public String toString() {
      return "InspectRequested{object=" + object + ", hints=" + hints + "}";
    }
  }
}
