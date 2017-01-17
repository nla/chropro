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

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class CacheStorageDomain {
  private RpcClient rpcClient;

  public CacheStorageDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Requests cache names.
   * @param securityOrigin Security origin.
   */
  public CompletableFuture<RequestCacheNames> requestCacheNames(@NotNull String securityOrigin) {
    Map<String,Object> params = new HashMap<>();
    params.put("securityOrigin", securityOrigin);
    return rpcClient.call("CacheStorage.requestCacheNames", params, RequestCacheNames.class);
  }

  /**
   * Requests data from cache.
   * @param cacheId ID of cache to get entries from.
   * @param skipCount Number of records to skip.
   * @param pageSize Number of records to fetch.
   */
  public CompletableFuture<RequestEntries> requestEntries(@NotNull String cacheId, @NotNull Integer skipCount, @NotNull Integer pageSize) {
    Map<String,Object> params = new HashMap<>();
    params.put("cacheId", cacheId);
    params.put("skipCount", skipCount);
    params.put("pageSize", pageSize);
    return rpcClient.call("CacheStorage.requestEntries", params, RequestEntries.class);
  }

  /**
   * Deletes a cache.
   * @param cacheId Id of cache for deletion.
   */
  public CompletableFuture<Void> deleteCache(@NotNull String cacheId) {
    Map<String,Object> params = new HashMap<>();
    params.put("cacheId", cacheId);
    return rpcClient.call("CacheStorage.deleteCache", params, Void.class);
  }

  /**
   * Deletes a cache entry.
   * @param cacheId Id of cache where the entry will be deleted.
   * @param request URL spec of the request.
   */
  public CompletableFuture<Void> deleteEntry(@NotNull String cacheId, @NotNull String request) {
    Map<String,Object> params = new HashMap<>();
    params.put("cacheId", cacheId);
    params.put("request", request);
    return rpcClient.call("CacheStorage.deleteEntry", params, Void.class);
  }

  /**
   * Cache identifier.
   */
  public static class Cache {
    /**
     * An opaque unique id of the cache.
     */
    public String cacheId;

    /**
     * Security origin of the cache.
     */
    public String securityOrigin;

    /**
     * The name of the cache.
     */
    public String cacheName;

    public String toString() {
      return "Cache{cacheId=" + cacheId + ", securityOrigin=" + securityOrigin + ", cacheName=" + cacheName + "}";
    }
  }

  public static class RequestCacheNames {
    /**
     * Caches for the security origin.
     */
    public List<Cache> caches;

    public String toString() {
      return "RequestCacheNames{caches=" + caches + "}";
    }
  }

  /**
   * Data entry.
   */
  public static class DataEntry {
    /**
     * Request url spec.
     */
    public String request;

    /**
     * Response stataus text.
     */
    public String response;

    public String toString() {
      return "DataEntry{request=" + request + ", response=" + response + "}";
    }
  }

  public static class RequestEntries {
    /**
     * Array of object store data entries.
     */
    public List<DataEntry> cacheDataEntries;

    /**
     * If true, there are more entries to fetch in the given range.
     */
    public Boolean hasMore;

    public String toString() {
      return "RequestEntries{cacheDataEntries=" + cacheDataEntries + ", hasMore=" + hasMore + "}";
    }
  }
}
