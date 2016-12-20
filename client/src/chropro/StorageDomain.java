package chropro;

import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class StorageDomain {
  private RpcClient rpcClient;

  public StorageDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Clears storage for origin.
   * @param origin Security origin.
   * @param storageTypes Comma separated origin names.
   */
  public CompletableFuture<Void> clearDataForOrigin(@NotNull String origin, @NotNull String storageTypes) {
    Map<String,Object> params = new HashMap<>();
    params.put("origin", origin);
    params.put("storageTypes", storageTypes);
    return rpcClient.call("Storage.clearDataForOrigin", params, Void.class);
  }
}
