package chropro;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class MemoryDomain {
  private RpcClient rpcClient;

  public MemoryDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  public CompletableFuture<GetDOMCounters> getDOMCounters() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Memory.getDOMCounters", params, GetDOMCounters.class);
  }

  /**
   * Enable/disable suppressing memory pressure notifications in all processes.
   * @param suppressed If true, memory pressure notifications will be suppressed.
   */
  public CompletableFuture<Void> setPressureNotificationsSuppressed(@NotNull Boolean suppressed) {
    Map<String,Object> params = new HashMap<>();
    params.put("suppressed", suppressed);
    return rpcClient.call("Memory.setPressureNotificationsSuppressed", params, Void.class);
  }

  /**
   * Simulate a memory pressure notification in all processes.
   * @param level Memory pressure level of the notification.
   */
  public CompletableFuture<Void> simulatePressureNotification(@NotNull String level) {
    Map<String,Object> params = new HashMap<>();
    params.put("level", level);
    return rpcClient.call("Memory.simulatePressureNotification", params, Void.class);
  }

  public static class GetDOMCounters {
    public Integer documents;

    public Integer nodes;

    public Integer jsEventListeners;

    public String toString() {
      return "GetDOMCounters{documents=" + documents + ", nodes=" + nodes + ", jsEventListeners=" + jsEventListeners + "}";
    }
  }
}
