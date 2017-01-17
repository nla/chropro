package chropro;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
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
public class ApplicationCacheDomain {
  private RpcClient rpcClient;

  public ApplicationCacheDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Returns array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
   */
  public CompletableFuture<GetFramesWithManifests> getFramesWithManifests() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("ApplicationCache.getFramesWithManifests", params, GetFramesWithManifests.class);
  }

  /**
   * Enables application cache domain notifications.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("ApplicationCache.enable", params, Void.class);
  }

  /**
   * Returns manifest URL for document in the given frame.
   * @param frameId Identifier of the frame containing document whose manifest is retrieved.
   */
  public CompletableFuture<GetManifestForFrame> getManifestForFrame(@NotNull String frameId) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    return rpcClient.call("ApplicationCache.getManifestForFrame", params, GetManifestForFrame.class);
  }

  /**
   * Returns relevant application cache data for the document in given frame.
   * @param frameId Identifier of the frame containing document whose application cache is retrieved.
   */
  public CompletableFuture<GetApplicationCacheForFrame> getApplicationCacheForFrame(@NotNull String frameId) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    return rpcClient.call("ApplicationCache.getApplicationCacheForFrame", params, GetApplicationCacheForFrame.class);
  }

  public void onApplicationCacheStatusUpdated(Consumer<ApplicationCacheStatusUpdated> listener) {
    rpcClient.addEventListener("ApplicationCache.applicationCacheStatusUpdated", listener, ApplicationCacheStatusUpdated.class);
  }

  public CompletableFuture<ApplicationCacheStatusUpdated> onApplicationCacheStatusUpdated() {
    return rpcClient.eventFuture("ApplicationCache.applicationCacheStatusUpdated", ApplicationCacheStatusUpdated.class);
  }

  public void onNetworkStateUpdated(Consumer<NetworkStateUpdated> listener) {
    rpcClient.addEventListener("ApplicationCache.networkStateUpdated", listener, NetworkStateUpdated.class);
  }

  public CompletableFuture<NetworkStateUpdated> onNetworkStateUpdated() {
    return rpcClient.eventFuture("ApplicationCache.networkStateUpdated", NetworkStateUpdated.class);
  }

  /**
   * Frame identifier - manifest URL pair.
   */
  public static class FrameWithManifest {
    /**
     * Frame identifier.
     */
    public String frameId;

    /**
     * Manifest URL.
     */
    public String manifestURL;

    /**
     * Application cache status.
     */
    public Integer status;

    public String toString() {
      return "FrameWithManifest{frameId=" + frameId + ", manifestURL=" + manifestURL + ", status=" + status + "}";
    }
  }

  public static class GetFramesWithManifests {
    /**
     * Array of frame identifiers with manifest urls for each frame containing a document associated with some application cache.
     */
    public List<FrameWithManifest> frameIds;

    public String toString() {
      return "GetFramesWithManifests{frameIds=" + frameIds + "}";
    }
  }

  public static class GetManifestForFrame {
    /**
     * Manifest URL for document in the given frame.
     */
    public String manifestURL;

    public String toString() {
      return "GetManifestForFrame{manifestURL=" + manifestURL + "}";
    }
  }

  /**
   * Detailed application cache resource information.
   */
  public static class ApplicationCacheResource {
    /**
     * Resource url.
     */
    public String url;

    /**
     * Resource size.
     */
    public Integer size;

    /**
     * Resource type.
     */
    public String type;

    public String toString() {
      return "ApplicationCacheResource{url=" + url + ", size=" + size + ", type=" + type + "}";
    }
  }

  /**
   * Detailed application cache information.
   */
  public static class ApplicationCache {
    /**
     * Manifest URL.
     */
    public String manifestURL;

    /**
     * Application cache size.
     */
    public Double size;

    /**
     * Application cache creation time.
     */
    public Double creationTime;

    /**
     * Application cache update time.
     */
    public Double updateTime;

    /**
     * Application cache resources.
     */
    public List<ApplicationCacheResource> resources;

    public String toString() {
      return "ApplicationCache{manifestURL=" + manifestURL + ", size=" + size + ", creationTime=" + creationTime + ", updateTime=" + updateTime + ", resources=" + resources + "}";
    }
  }

  public static class GetApplicationCacheForFrame {
    /**
     * Relevant application cache data for the document in given frame.
     */
    public ApplicationCache applicationCache;

    public String toString() {
      return "GetApplicationCacheForFrame{applicationCache=" + applicationCache + "}";
    }
  }

  public static class ApplicationCacheStatusUpdated {
    /**
     * Identifier of the frame containing document whose application cache updated status.
     */
    public String frameId;

    /**
     * Manifest URL.
     */
    public String manifestURL;

    /**
     * Updated application cache status.
     */
    public Integer status;

    public String toString() {
      return "ApplicationCacheStatusUpdated{frameId=" + frameId + ", manifestURL=" + manifestURL + ", status=" + status + "}";
    }
  }

  public static class NetworkStateUpdated {
    public Boolean isNowOnline;

    public String toString() {
      return "NetworkStateUpdated{isNowOnline=" + isNowOnline + "}";
    }
  }
}
