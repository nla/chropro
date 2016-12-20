package chropro;

import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class TetheringDomain {
  private RpcClient rpcClient;

  public TetheringDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Request browser port binding.
   * @param port Port number to bind.
   */
  public CompletableFuture<Void> bind(@NotNull Integer port) {
    Map<String,Object> params = new HashMap<>();
    params.put("port", port);
    return rpcClient.call("Tethering.bind", params, Void.class);
  }

  /**
   * Request browser port unbinding.
   * @param port Port number to unbind.
   */
  public CompletableFuture<Void> unbind(@NotNull Integer port) {
    Map<String,Object> params = new HashMap<>();
    params.put("port", port);
    return rpcClient.call("Tethering.unbind", params, Void.class);
  }

  /**
   * Informs that port was successfully bound and got a specified connection id.
   */
  public void onAccepted(Consumer<Accepted> listener) {
    rpcClient.addEventListener("Tethering.accepted", listener, Accepted.class);
  }

  /**
   * Informs that port was successfully bound and got a specified connection id.
   */
  public CompletableFuture<Accepted> onAccepted() {
    return rpcClient.eventFuture("Tethering.accepted", Accepted.class);
  }

  /**
   * Informs that port was successfully bound and got a specified connection id.
   */
  public static class Accepted {
    /**
     * Port number that was successfully bound.
     */
    public Integer port;

    /**
     * Connection id to be used.
     */
    public String connectionId;

    public String toString() {
      return "Accepted{port=" + port + ", connectionId=" + connectionId + "}";
    }
  }
}
