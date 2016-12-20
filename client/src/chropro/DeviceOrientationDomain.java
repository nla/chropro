package chropro;

import java.lang.Double;
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
public class DeviceOrientationDomain {
  private RpcClient rpcClient;

  public DeviceOrientationDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Overrides the Device Orientation.
   * @param alpha Mock alpha
   * @param beta Mock beta
   * @param gamma Mock gamma
   */
  public CompletableFuture<Void> setDeviceOrientationOverride(@NotNull Double alpha, @NotNull Double beta, @NotNull Double gamma) {
    Map<String,Object> params = new HashMap<>();
    params.put("alpha", alpha);
    params.put("beta", beta);
    params.put("gamma", gamma);
    return rpcClient.call("DeviceOrientation.setDeviceOrientationOverride", params, Void.class);
  }

  /**
   * Clears the overridden Device Orientation.
   */
  public CompletableFuture<Void> clearDeviceOrientationOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DeviceOrientation.clearDeviceOrientationOverride", params, Void.class);
  }
}
