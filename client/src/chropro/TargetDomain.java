package chropro;

import java.lang.Boolean;
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
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class TargetDomain {
  private RpcClient rpcClient;

  public TargetDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Controls whether to discover available targets and notify via <code>targetCreated/targetDestroyed</code> events.
   * @param discover Whether to discover available targets.
   */
  public CompletableFuture<Void> setDiscoverTargets(@NotNull Boolean discover) {
    Map<String,Object> params = new HashMap<>();
    params.put("discover", discover);
    return rpcClient.call("Target.setDiscoverTargets", params, Void.class);
  }

  /**
   * Controls whether to automatically attach to new targets which are considered to be related to this one. When turned on, attaches to all existing related targets as well. When turned off, automatically detaches from all currently attached targets.
   * @param autoAttach Whether to auto-attach to related targets.
   * @param waitForDebuggerOnStart Whether to pause new targets when attaching to them. Use <code>Runtime.runIfWaitingForDebugger</code> to run paused targets.
   */
  public CompletableFuture<Void> setAutoAttach(@NotNull Boolean autoAttach, @NotNull Boolean waitForDebuggerOnStart) {
    Map<String,Object> params = new HashMap<>();
    params.put("autoAttach", autoAttach);
    params.put("waitForDebuggerOnStart", waitForDebuggerOnStart);
    return rpcClient.call("Target.setAutoAttach", params, Void.class);
  }

  /**
   * @param value Whether to attach to frames.
   */
  public CompletableFuture<Void> setAttachToFrames(@NotNull Boolean value) {
    Map<String,Object> params = new HashMap<>();
    params.put("value", value);
    return rpcClient.call("Target.setAttachToFrames", params, Void.class);
  }

  /**
   * Enables target discovery for the specified locations, when <code>setDiscoverTargets</code> was set to <code>true</code>.
   * @param locations List of remote locations.
   */
  public CompletableFuture<Void> setRemoteLocations(@NotNull List<RemoteLocation> locations) {
    Map<String,Object> params = new HashMap<>();
    params.put("locations", locations);
    return rpcClient.call("Target.setRemoteLocations", params, Void.class);
  }

  /**
   * Sends protocol message to the target with given id.
   */
  public CompletableFuture<Void> sendMessageToTarget(@NotNull String targetId, @NotNull String message) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    params.put("message", message);
    return rpcClient.call("Target.sendMessageToTarget", params, Void.class);
  }

  /**
   * Returns information about a target.
   */
  public CompletableFuture<GetTargetInfo> getTargetInfo(@NotNull String targetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    return rpcClient.call("Target.getTargetInfo", params, GetTargetInfo.class);
  }

  /**
   * Activates (focuses) the target.
   */
  public CompletableFuture<Void> activateTarget(@NotNull String targetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    return rpcClient.call("Target.activateTarget", params, Void.class);
  }

  /**
   * Closes the target. If the target is a page that gets closed too.
   */
  public CompletableFuture<CloseTarget> closeTarget(@NotNull String targetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    return rpcClient.call("Target.closeTarget", params, CloseTarget.class);
  }

  /**
   * Attaches to the target with given id.
   */
  public CompletableFuture<AttachToTarget> attachToTarget(@NotNull String targetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    return rpcClient.call("Target.attachToTarget", params, AttachToTarget.class);
  }

  /**
   * Detaches from the target with given id.
   */
  public CompletableFuture<Void> detachFromTarget(@NotNull String targetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("targetId", targetId);
    return rpcClient.call("Target.detachFromTarget", params, Void.class);
  }

  /**
   * Creates a new empty BrowserContext. Similar to an incognito profile but you can have more than one.
   */
  public CompletableFuture<CreateBrowserContext> createBrowserContext() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Target.createBrowserContext", params, CreateBrowserContext.class);
  }

  /**
   * Deletes a BrowserContext, will fail of any open page uses it.
   */
  public CompletableFuture<DisposeBrowserContext> disposeBrowserContext(@NotNull String browserContextId) {
    Map<String,Object> params = new HashMap<>();
    params.put("browserContextId", browserContextId);
    return rpcClient.call("Target.disposeBrowserContext", params, DisposeBrowserContext.class);
  }

  /**
   * Creates a new page.
   * @param url The initial URL the page will be navigated to.
   * @param width Frame width in DIP (headless chrome only).
   * @param height Frame height in DIP (headless chrome only).
   * @param browserContextId The browser context to create the page in (headless chrome only).
   */
  public CompletableFuture<CreateTarget> createTarget(@NotNull String url, @Nullable Integer width, @Nullable Integer height, @Nullable String browserContextId) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    params.put("width", width);
    params.put("height", height);
    params.put("browserContextId", browserContextId);
    return rpcClient.call("Target.createTarget", params, CreateTarget.class);
  }

  /**
   * Retrieves a list of available targets.
   */
  public CompletableFuture<GetTargets> getTargets() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Target.getTargets", params, GetTargets.class);
  }

  /**
   * Issued when a possible inspection target is created.
   */
  public void onTargetCreated(Consumer<TargetCreated> listener) {
    rpcClient.addEventListener("Target.targetCreated", listener, TargetCreated.class);
  }

  /**
   * Issued when a possible inspection target is created.
   */
  public CompletableFuture<TargetCreated> onTargetCreated() {
    return rpcClient.eventFuture("Target.targetCreated", TargetCreated.class);
  }

  /**
   * Issued when a target is destroyed.
   */
  public void onTargetDestroyed(Consumer<TargetDestroyed> listener) {
    rpcClient.addEventListener("Target.targetDestroyed", listener, TargetDestroyed.class);
  }

  /**
   * Issued when a target is destroyed.
   */
  public CompletableFuture<TargetDestroyed> onTargetDestroyed() {
    return rpcClient.eventFuture("Target.targetDestroyed", TargetDestroyed.class);
  }

  /**
   * Issued when attached to target because of auto-attach or <code>attachToTarget</code> command.
   */
  public void onAttachedToTarget(Consumer<AttachedToTarget> listener) {
    rpcClient.addEventListener("Target.attachedToTarget", listener, AttachedToTarget.class);
  }

  /**
   * Issued when attached to target because of auto-attach or <code>attachToTarget</code> command.
   */
  public CompletableFuture<AttachedToTarget> onAttachedToTarget() {
    return rpcClient.eventFuture("Target.attachedToTarget", AttachedToTarget.class);
  }

  /**
   * Issued when detached from target for any reason (including <code>detachFromTarget</code> command).
   */
  public void onDetachedFromTarget(Consumer<DetachedFromTarget> listener) {
    rpcClient.addEventListener("Target.detachedFromTarget", listener, DetachedFromTarget.class);
  }

  /**
   * Issued when detached from target for any reason (including <code>detachFromTarget</code> command).
   */
  public CompletableFuture<DetachedFromTarget> onDetachedFromTarget() {
    return rpcClient.eventFuture("Target.detachedFromTarget", DetachedFromTarget.class);
  }

  /**
   * Notifies about new protocol message from attached target.
   */
  public void onReceivedMessageFromTarget(Consumer<ReceivedMessageFromTarget> listener) {
    rpcClient.addEventListener("Target.receivedMessageFromTarget", listener, ReceivedMessageFromTarget.class);
  }

  /**
   * Notifies about new protocol message from attached target.
   */
  public CompletableFuture<ReceivedMessageFromTarget> onReceivedMessageFromTarget() {
    return rpcClient.eventFuture("Target.receivedMessageFromTarget", ReceivedMessageFromTarget.class);
  }

  public static class RemoteLocation {
    public String host;

    public Integer port;

    public String toString() {
      return "RemoteLocation{host=" + host + ", port=" + port + "}";
    }
  }

  public static class TargetInfo {
    public String targetId;

    public String type;

    public String title;

    public String url;

    public String toString() {
      return "TargetInfo{targetId=" + targetId + ", type=" + type + ", title=" + title + ", url=" + url + "}";
    }
  }

  public static class GetTargetInfo {
    public TargetInfo targetInfo;

    public String toString() {
      return "GetTargetInfo{targetInfo=" + targetInfo + "}";
    }
  }

  public static class CloseTarget {
    public Boolean success;

    public String toString() {
      return "CloseTarget{success=" + success + "}";
    }
  }

  public static class AttachToTarget {
    /**
     * Whether attach succeeded.
     */
    public Boolean success;

    public String toString() {
      return "AttachToTarget{success=" + success + "}";
    }
  }

  public static class CreateBrowserContext {
    /**
     * The id of the context created.
     */
    public String browserContextId;

    public String toString() {
      return "CreateBrowserContext{browserContextId=" + browserContextId + "}";
    }
  }

  public static class DisposeBrowserContext {
    public Boolean success;

    public String toString() {
      return "DisposeBrowserContext{success=" + success + "}";
    }
  }

  public static class CreateTarget {
    /**
     * The id of the page opened.
     */
    public String targetId;

    public String toString() {
      return "CreateTarget{targetId=" + targetId + "}";
    }
  }

  public static class GetTargets {
    /**
     * The list of targets.
     */
    public List<TargetInfo> targetInfos;

    public String toString() {
      return "GetTargets{targetInfos=" + targetInfos + "}";
    }
  }

  /**
   * Issued when a possible inspection target is created.
   */
  public static class TargetCreated {
    public TargetInfo targetInfo;

    public String toString() {
      return "TargetCreated{targetInfo=" + targetInfo + "}";
    }
  }

  /**
   * Issued when a target is destroyed.
   */
  public static class TargetDestroyed {
    public String targetId;

    public String toString() {
      return "TargetDestroyed{targetId=" + targetId + "}";
    }
  }

  /**
   * Issued when attached to target because of auto-attach or <code>attachToTarget</code> command.
   */
  public static class AttachedToTarget {
    public TargetInfo targetInfo;

    public Boolean waitingForDebugger;

    public String toString() {
      return "AttachedToTarget{targetInfo=" + targetInfo + ", waitingForDebugger=" + waitingForDebugger + "}";
    }
  }

  /**
   * Issued when detached from target for any reason (including <code>detachFromTarget</code> command).
   */
  public static class DetachedFromTarget {
    public String targetId;

    public String toString() {
      return "DetachedFromTarget{targetId=" + targetId + "}";
    }
  }

  /**
   * Notifies about new protocol message from attached target.
   */
  public static class ReceivedMessageFromTarget {
    public String targetId;

    public String message;

    public String toString() {
      return "ReceivedMessageFromTarget{targetId=" + targetId + ", message=" + message + "}";
    }
  }
}
