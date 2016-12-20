package chropro;

import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class InspectorDomain {
  private RpcClient rpcClient;

  public InspectorDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables inspector domain notifications.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Inspector.enable", params, Void.class);
  }

  /**
   * Disables inspector domain notifications.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Inspector.disable", params, Void.class);
  }

  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
  public void onDetached(Consumer<Detached> listener) {
    rpcClient.addEventListener("Inspector.detached", listener, Detached.class);
  }

  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
  public CompletableFuture<Detached> onDetached() {
    return rpcClient.eventFuture("Inspector.detached", Detached.class);
  }

  /**
   * Fired when debugging target has crashed
   */
  public void onTargetCrashed(Consumer<TargetCrashed> listener) {
    rpcClient.addEventListener("Inspector.targetCrashed", listener, TargetCrashed.class);
  }

  /**
   * Fired when debugging target has crashed
   */
  public CompletableFuture<TargetCrashed> onTargetCrashed() {
    return rpcClient.eventFuture("Inspector.targetCrashed", TargetCrashed.class);
  }

  /**
   * Fired when remote debugging connection is about to be terminated. Contains detach reason.
   */
  public static class Detached {
    /**
     * The reason why connection has been terminated.
     */
    public String reason;

    public String toString() {
      return "Detached{reason=" + reason + "}";
    }
  }

  /**
   * Fired when debugging target has crashed
   */
  public static class TargetCrashed {
    public String toString() {
      return "TargetCrashed{}";
    }
  }
}
