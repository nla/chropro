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
public class AnimationDomain {
  private RpcClient rpcClient;

  public AnimationDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables animation domain notifications.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Animation.enable", params, Void.class);
  }

  /**
   * Disables animation domain notifications.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Animation.disable", params, Void.class);
  }

  /**
   * Gets the playback rate of the document timeline.
   */
  public CompletableFuture<GetPlaybackRate> getPlaybackRate() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Animation.getPlaybackRate", params, GetPlaybackRate.class);
  }

  /**
   * Sets the playback rate of the document timeline.
   * @param playbackRate Playback rate for animations on page
   */
  public CompletableFuture<Void> setPlaybackRate(@NotNull Double playbackRate) {
    Map<String,Object> params = new HashMap<>();
    params.put("playbackRate", playbackRate);
    return rpcClient.call("Animation.setPlaybackRate", params, Void.class);
  }

  /**
   * Returns the current time of the an animation.
   * @param id Id of animation.
   */
  public CompletableFuture<GetCurrentTime> getCurrentTime(@NotNull String id) {
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    return rpcClient.call("Animation.getCurrentTime", params, GetCurrentTime.class);
  }

  /**
   * Sets the paused state of a set of animations.
   * @param animations Animations to set the pause state of.
   * @param paused Paused state to set to.
   */
  public CompletableFuture<Void> setPaused(@NotNull List<String> animations, @NotNull Boolean paused) {
    Map<String,Object> params = new HashMap<>();
    params.put("animations", animations);
    params.put("paused", paused);
    return rpcClient.call("Animation.setPaused", params, Void.class);
  }

  /**
   * Sets the timing of an animation node.
   * @param animationId Animation id.
   * @param duration Duration of the animation.
   * @param delay Delay of the animation.
   */
  public CompletableFuture<Void> setTiming(@NotNull String animationId, @NotNull Double duration, @NotNull Double delay) {
    Map<String,Object> params = new HashMap<>();
    params.put("animationId", animationId);
    params.put("duration", duration);
    params.put("delay", delay);
    return rpcClient.call("Animation.setTiming", params, Void.class);
  }

  /**
   * Seek a set of animations to a particular time within each animation.
   * @param animations List of animation ids to seek.
   * @param currentTime Set the current time of each animation.
   */
  public CompletableFuture<Void> seekAnimations(@NotNull List<String> animations, @NotNull Double currentTime) {
    Map<String,Object> params = new HashMap<>();
    params.put("animations", animations);
    params.put("currentTime", currentTime);
    return rpcClient.call("Animation.seekAnimations", params, Void.class);
  }

  /**
   * Releases a set of animations to no longer be manipulated.
   * @param animations List of animation ids to seek.
   */
  public CompletableFuture<Void> releaseAnimations(@NotNull List<String> animations) {
    Map<String,Object> params = new HashMap<>();
    params.put("animations", animations);
    return rpcClient.call("Animation.releaseAnimations", params, Void.class);
  }

  /**
   * Gets the remote object of the Animation.
   * @param animationId Animation id.
   */
  public CompletableFuture<ResolveAnimation> resolveAnimation(@NotNull String animationId) {
    Map<String,Object> params = new HashMap<>();
    params.put("animationId", animationId);
    return rpcClient.call("Animation.resolveAnimation", params, ResolveAnimation.class);
  }

  /**
   * Event for each animation that has been created.
   */
  public void onAnimationCreated(Consumer<AnimationCreated> listener) {
    rpcClient.addEventListener("Animation.animationCreated", listener, AnimationCreated.class);
  }

  /**
   * Event for each animation that has been created.
   */
  public CompletableFuture<AnimationCreated> onAnimationCreated() {
    return rpcClient.eventFuture("Animation.animationCreated", AnimationCreated.class);
  }

  /**
   * Event for animation that has been started.
   */
  public void onAnimationStarted(Consumer<AnimationStarted> listener) {
    rpcClient.addEventListener("Animation.animationStarted", listener, AnimationStarted.class);
  }

  /**
   * Event for animation that has been started.
   */
  public CompletableFuture<AnimationStarted> onAnimationStarted() {
    return rpcClient.eventFuture("Animation.animationStarted", AnimationStarted.class);
  }

  /**
   * Event for when an animation has been cancelled.
   */
  public void onAnimationCanceled(Consumer<AnimationCanceled> listener) {
    rpcClient.addEventListener("Animation.animationCanceled", listener, AnimationCanceled.class);
  }

  /**
   * Event for when an animation has been cancelled.
   */
  public CompletableFuture<AnimationCanceled> onAnimationCanceled() {
    return rpcClient.eventFuture("Animation.animationCanceled", AnimationCanceled.class);
  }

  public static class GetPlaybackRate {
    /**
     * Playback rate for animations on page.
     */
    public Double playbackRate;

    public String toString() {
      return "GetPlaybackRate{playbackRate=" + playbackRate + "}";
    }
  }

  public static class GetCurrentTime {
    /**
     * Current time of the page.
     */
    public Double currentTime;

    public String toString() {
      return "GetCurrentTime{currentTime=" + currentTime + "}";
    }
  }

  public static class ResolveAnimation {
    /**
     * Corresponding remote object.
     */
    public RuntimeDomain.RemoteObject remoteObject;

    public String toString() {
      return "ResolveAnimation{remoteObject=" + remoteObject + "}";
    }
  }

  /**
   * Event for each animation that has been created.
   */
  public static class AnimationCreated {
    /**
     * Id of the animation that was created.
     */
    public String id;

    public String toString() {
      return "AnimationCreated{id=" + id + "}";
    }
  }

  /**
   * Keyframe Style
   */
  public static class KeyframeStyle {
    /**
     * Keyframe's time offset.
     */
    public String offset;

    /**
     * <code>AnimationEffect</code>'s timing function.
     */
    public String easing;

    public String toString() {
      return "KeyframeStyle{offset=" + offset + ", easing=" + easing + "}";
    }
  }

  /**
   * Keyframes Rule
   */
  public static class KeyframesRule {
    /**
     * CSS keyframed animation's name.
     */
    public String name;

    /**
     * List of animation keyframes.
     */
    public List<KeyframeStyle> keyframes;

    public String toString() {
      return "KeyframesRule{name=" + name + ", keyframes=" + keyframes + "}";
    }
  }

  /**
   * AnimationEffect instance
   */
  public static class AnimationEffect {
    /**
     * <code>AnimationEffect</code>'s delay.
     */
    public Double delay;

    /**
     * <code>AnimationEffect</code>'s end delay.
     */
    public Double endDelay;

    /**
     * <code>AnimationEffect</code>'s iteration start.
     */
    public Double iterationStart;

    /**
     * <code>AnimationEffect</code>'s iterations.
     */
    public Double iterations;

    /**
     * <code>AnimationEffect</code>'s iteration duration.
     */
    public Double duration;

    /**
     * <code>AnimationEffect</code>'s playback direction.
     */
    public String direction;

    /**
     * <code>AnimationEffect</code>'s fill mode.
     */
    public String fill;

    /**
     * <code>AnimationEffect</code>'s target node.
     */
    public Integer backendNodeId;

    /**
     * <code>AnimationEffect</code>'s keyframes.
     */
    public KeyframesRule keyframesRule;

    /**
     * <code>AnimationEffect</code>'s timing function.
     */
    public String easing;

    public String toString() {
      return "AnimationEffect{delay=" + delay + ", endDelay=" + endDelay + ", iterationStart=" + iterationStart + ", iterations=" + iterations + ", duration=" + duration + ", direction=" + direction + ", fill=" + fill + ", backendNodeId=" + backendNodeId + ", keyframesRule=" + keyframesRule + ", easing=" + easing + "}";
    }
  }

  /**
   * Animation instance.
   */
  public static class Animation {
    /**
     * <code>Animation</code>'s id.
     */
    public String id;

    /**
     * <code>Animation</code>'s name.
     */
    public String name;

    /**
     * <code>Animation</code>'s internal paused state.
     */
    public Boolean pausedState;

    /**
     * <code>Animation</code>'s play state.
     */
    public String playState;

    /**
     * <code>Animation</code>'s playback rate.
     */
    public Double playbackRate;

    /**
     * <code>Animation</code>'s start time.
     */
    public Double startTime;

    /**
     * <code>Animation</code>'s current time.
     */
    public Double currentTime;

    /**
     * <code>Animation</code>'s source animation node.
     */
    public AnimationEffect source;

    /**
     * Animation type of <code>Animation</code>.
     */
    public String type;

    /**
     * A unique ID for <code>Animation</code> representing the sources that triggered this CSS animation/transition.
     */
    public String cssId;

    public String toString() {
      return "Animation{id=" + id + ", name=" + name + ", pausedState=" + pausedState + ", playState=" + playState + ", playbackRate=" + playbackRate + ", startTime=" + startTime + ", currentTime=" + currentTime + ", source=" + source + ", type=" + type + ", cssId=" + cssId + "}";
    }
  }

  /**
   * Event for animation that has been started.
   */
  public static class AnimationStarted {
    /**
     * Animation that was started.
     */
    public Animation animation;

    public String toString() {
      return "AnimationStarted{animation=" + animation + "}";
    }
  }

  /**
   * Event for when an animation has been cancelled.
   */
  public static class AnimationCanceled {
    /**
     * Id of the animation that was cancelled.
     */
    public String id;

    public String toString() {
      return "AnimationCanceled{id=" + id + "}";
    }
  }
}
