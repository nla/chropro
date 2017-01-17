package chropro;

import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class DOMStorageDomain {
  private RpcClient rpcClient;

  public DOMStorageDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables storage tracking, storage events will now be delivered to the client.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOMStorage.enable", params, Void.class);
  }

  /**
   * Disables storage tracking, prevents storage events from being sent to the client.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOMStorage.disable", params, Void.class);
  }

  public CompletableFuture<GetDOMStorageItems> getDOMStorageItems(@NotNull StorageId storageId) {
    Map<String,Object> params = new HashMap<>();
    params.put("storageId", storageId);
    return rpcClient.call("DOMStorage.getDOMStorageItems", params, GetDOMStorageItems.class);
  }

  public CompletableFuture<Void> setDOMStorageItem(@NotNull StorageId storageId, @NotNull String key, @NotNull String value) {
    Map<String,Object> params = new HashMap<>();
    params.put("storageId", storageId);
    params.put("key", key);
    params.put("value", value);
    return rpcClient.call("DOMStorage.setDOMStorageItem", params, Void.class);
  }

  public CompletableFuture<Void> removeDOMStorageItem(@NotNull StorageId storageId, @NotNull String key) {
    Map<String,Object> params = new HashMap<>();
    params.put("storageId", storageId);
    params.put("key", key);
    return rpcClient.call("DOMStorage.removeDOMStorageItem", params, Void.class);
  }

  public void onDomStorageItemsCleared(Consumer<DomStorageItemsCleared> listener) {
    rpcClient.addEventListener("DOMStorage.domStorageItemsCleared", listener, DomStorageItemsCleared.class);
  }

  public CompletableFuture<DomStorageItemsCleared> onDomStorageItemsCleared() {
    return rpcClient.eventFuture("DOMStorage.domStorageItemsCleared", DomStorageItemsCleared.class);
  }

  public void onDomStorageItemRemoved(Consumer<DomStorageItemRemoved> listener) {
    rpcClient.addEventListener("DOMStorage.domStorageItemRemoved", listener, DomStorageItemRemoved.class);
  }

  public CompletableFuture<DomStorageItemRemoved> onDomStorageItemRemoved() {
    return rpcClient.eventFuture("DOMStorage.domStorageItemRemoved", DomStorageItemRemoved.class);
  }

  public void onDomStorageItemAdded(Consumer<DomStorageItemAdded> listener) {
    rpcClient.addEventListener("DOMStorage.domStorageItemAdded", listener, DomStorageItemAdded.class);
  }

  public CompletableFuture<DomStorageItemAdded> onDomStorageItemAdded() {
    return rpcClient.eventFuture("DOMStorage.domStorageItemAdded", DomStorageItemAdded.class);
  }

  public void onDomStorageItemUpdated(Consumer<DomStorageItemUpdated> listener) {
    rpcClient.addEventListener("DOMStorage.domStorageItemUpdated", listener, DomStorageItemUpdated.class);
  }

  public CompletableFuture<DomStorageItemUpdated> onDomStorageItemUpdated() {
    return rpcClient.eventFuture("DOMStorage.domStorageItemUpdated", DomStorageItemUpdated.class);
  }

  public static class GetDOMStorageItems {
    public List<List<String>> entries;

    public String toString() {
      return "GetDOMStorageItems{entries=" + entries + "}";
    }
  }

  /**
   * DOM Storage identifier.
   */
  public static class StorageId {
    /**
     * Security origin for the storage.
     */
    public String securityOrigin;

    /**
     * Whether the storage is local storage (not session storage).
     */
    public Boolean isLocalStorage;

    public String toString() {
      return "StorageId{securityOrigin=" + securityOrigin + ", isLocalStorage=" + isLocalStorage + "}";
    }
  }

  public static class DomStorageItemsCleared {
    public StorageId storageId;

    public String toString() {
      return "DomStorageItemsCleared{storageId=" + storageId + "}";
    }
  }

  public static class DomStorageItemRemoved {
    public StorageId storageId;

    public String key;

    public String toString() {
      return "DomStorageItemRemoved{storageId=" + storageId + ", key=" + key + "}";
    }
  }

  public static class DomStorageItemAdded {
    public StorageId storageId;

    public String key;

    public String newValue;

    public String toString() {
      return "DomStorageItemAdded{storageId=" + storageId + ", key=" + key + ", newValue=" + newValue + "}";
    }
  }

  public static class DomStorageItemUpdated {
    public StorageId storageId;

    public String key;

    public String oldValue;

    public String newValue;

    public String toString() {
      return "DomStorageItemUpdated{storageId=" + storageId + ", key=" + key + ", oldValue=" + oldValue + ", newValue=" + newValue + "}";
    }
  }
}
