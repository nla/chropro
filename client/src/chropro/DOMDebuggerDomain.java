package chropro;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class DOMDebuggerDomain {
  private RpcClient rpcClient;

  public DOMDebuggerDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Sets breakpoint on particular operation with DOM.
   * @param nodeId Identifier of the node to set breakpoint on.
   * @param type Type of the operation to stop upon.
   */
  public CompletableFuture<Void> setDOMBreakpoint(@NotNull Integer nodeId, @NotNull String type) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("type", type);
    return rpcClient.call("DOMDebugger.setDOMBreakpoint", params, Void.class);
  }

  /**
   * Removes DOM breakpoint that was set using <code>setDOMBreakpoint</code>.
   * @param nodeId Identifier of the node to remove breakpoint from.
   * @param type Type of the breakpoint to remove.
   */
  public CompletableFuture<Void> removeDOMBreakpoint(@NotNull Integer nodeId, @NotNull String type) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("type", type);
    return rpcClient.call("DOMDebugger.removeDOMBreakpoint", params, Void.class);
  }

  /**
   * Sets breakpoint on particular DOM event.
   * @param eventName DOM Event name to stop on (any DOM event will do).
   * @param targetName EventTarget interface name to stop on. If equal to <code>"*"</code> or not provided, will stop on any EventTarget.
   */
  public CompletableFuture<Void> setEventListenerBreakpoint(@NotNull String eventName, @Nullable String targetName) {
    Map<String,Object> params = new HashMap<>();
    params.put("eventName", eventName);
    params.put("targetName", targetName);
    return rpcClient.call("DOMDebugger.setEventListenerBreakpoint", params, Void.class);
  }

  /**
   * Removes breakpoint on particular DOM event.
   * @param eventName Event name.
   * @param targetName EventTarget interface name.
   */
  public CompletableFuture<Void> removeEventListenerBreakpoint(@NotNull String eventName, @Nullable String targetName) {
    Map<String,Object> params = new HashMap<>();
    params.put("eventName", eventName);
    params.put("targetName", targetName);
    return rpcClient.call("DOMDebugger.removeEventListenerBreakpoint", params, Void.class);
  }

  /**
   * Sets breakpoint on particular native event.
   * @param eventName Instrumentation name to stop on.
   */
  public CompletableFuture<Void> setInstrumentationBreakpoint(@NotNull String eventName) {
    Map<String,Object> params = new HashMap<>();
    params.put("eventName", eventName);
    return rpcClient.call("DOMDebugger.setInstrumentationBreakpoint", params, Void.class);
  }

  /**
   * Removes breakpoint on particular native event.
   * @param eventName Instrumentation name to stop on.
   */
  public CompletableFuture<Void> removeInstrumentationBreakpoint(@NotNull String eventName) {
    Map<String,Object> params = new HashMap<>();
    params.put("eventName", eventName);
    return rpcClient.call("DOMDebugger.removeInstrumentationBreakpoint", params, Void.class);
  }

  /**
   * Sets breakpoint on XMLHttpRequest.
   * @param url Resource URL substring. All XHRs having this substring in the URL will get stopped upon.
   */
  public CompletableFuture<Void> setXHRBreakpoint(@NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    return rpcClient.call("DOMDebugger.setXHRBreakpoint", params, Void.class);
  }

  /**
   * Removes breakpoint from XMLHttpRequest.
   * @param url Resource URL substring.
   */
  public CompletableFuture<Void> removeXHRBreakpoint(@NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    return rpcClient.call("DOMDebugger.removeXHRBreakpoint", params, Void.class);
  }

  /**
   * Returns event listeners of the given object.
   * @param objectId Identifier of the object to return listeners for.
   */
  public CompletableFuture<GetEventListeners> getEventListeners(@NotNull String objectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    return rpcClient.call("DOMDebugger.getEventListeners", params, GetEventListeners.class);
  }

  /**
   * Object event listener.
   */
  public static class EventListener {
    /**
     * <code>EventListener</code>'s type.
     */
    public String type;

    /**
     * <code>EventListener</code>'s useCapture.
     */
    public Boolean useCapture;

    /**
     * <code>EventListener</code>'s passive flag.
     */
    public Boolean passive;

    /**
     * <code>EventListener</code>'s once flag.
     */
    public Boolean once;

    /**
     * Script id of the handler code.
     */
    public String scriptId;

    /**
     * Line number in the script (0-based).
     */
    public Integer lineNumber;

    /**
     * Column number in the script (0-based).
     */
    public Integer columnNumber;

    /**
     * Event handler function value.
     */
    public RuntimeDomain.RemoteObject handler;

    /**
     * Event original handler function value.
     */
    public RuntimeDomain.RemoteObject originalHandler;

    /**
     * Event listener remove function.
     */
    public RuntimeDomain.RemoteObject removeFunction;

    public String toString() {
      return "EventListener{type=" + type + ", useCapture=" + useCapture + ", passive=" + passive + ", once=" + once + ", scriptId=" + scriptId + ", lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + ", handler=" + handler + ", originalHandler=" + originalHandler + ", removeFunction=" + removeFunction + "}";
    }
  }

  public static class GetEventListeners {
    /**
     * Array of relevant listeners.
     */
    public List<EventListener> listeners;

    public String toString() {
      return "GetEventListeners{listeners=" + listeners + "}";
    }
  }
}
