package chropro;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class EmulationDomain {
  private RpcClient rpcClient;

  public EmulationDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
   * @param width Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param height Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param deviceScaleFactor Overriding device scale factor value. 0 disables the override.
   * @param mobile Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text autosizing and more.
   * @param fitWindow Whether a view that exceeds the available browser window area should be scaled down to fit.
   * @param scale Scale to apply to resulting view image. Ignored in |fitWindow| mode.
   * @param offsetX Not used.
   * @param offsetY Not used.
   * @param screenWidth Overriding screen width value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param screenHeight Overriding screen height value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param positionX Overriding view X position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param positionY Overriding view Y position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param screenOrientation Screen orientation override.
   */
  public CompletableFuture<Void> setDeviceMetricsOverride(@NotNull Integer width, @NotNull Integer height, @NotNull Double deviceScaleFactor, @NotNull Boolean mobile, @NotNull Boolean fitWindow, @Nullable Double scale, @Nullable Double offsetX, @Nullable Double offsetY, @Nullable Integer screenWidth, @Nullable Integer screenHeight, @Nullable Integer positionX, @Nullable Integer positionY, @Nullable ScreenOrientation screenOrientation) {
    Map<String,Object> params = new HashMap<>();
    params.put("width", width);
    params.put("height", height);
    params.put("deviceScaleFactor", deviceScaleFactor);
    params.put("mobile", mobile);
    params.put("fitWindow", fitWindow);
    params.put("scale", scale);
    params.put("offsetX", offsetX);
    params.put("offsetY", offsetY);
    params.put("screenWidth", screenWidth);
    params.put("screenHeight", screenHeight);
    params.put("positionX", positionX);
    params.put("positionY", positionY);
    params.put("screenOrientation", screenOrientation);
    return rpcClient.call("Emulation.setDeviceMetricsOverride", params, Void.class);
  }

  /**
   * Clears the overriden device metrics.
   */
  public CompletableFuture<Void> clearDeviceMetricsOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Emulation.clearDeviceMetricsOverride", params, Void.class);
  }

  /**
   * Overrides the visible area of the page. The change is hidden from the page, i.e. the observable scroll position and page scale does not change. In effect, the command moves the specified area of the page into the top-left corner of the frame.
   * @param x X coordinate of top-left corner of the area (CSS pixels).
   * @param y Y coordinate of top-left corner of the area (CSS pixels).
   * @param scale Scale to apply to the area (relative to a page scale of 1.0).
   */
  public CompletableFuture<Void> forceViewport(@NotNull Double x, @NotNull Double y, @NotNull Double scale) {
    Map<String,Object> params = new HashMap<>();
    params.put("x", x);
    params.put("y", y);
    params.put("scale", scale);
    return rpcClient.call("Emulation.forceViewport", params, Void.class);
  }

  /**
   * Resets the visible area of the page to the original viewport, undoing any effects of the <code>forceViewport</code> command.
   */
  public CompletableFuture<Void> resetViewport() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Emulation.resetViewport", params, Void.class);
  }

  /**
   * Requests that page scale factor is reset to initial values.
   */
  public CompletableFuture<Void> resetPageScaleFactor() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Emulation.resetPageScaleFactor", params, Void.class);
  }

  /**
   * Sets a specified page scale factor.
   * @param pageScaleFactor Page scale factor.
   */
  public CompletableFuture<Void> setPageScaleFactor(@NotNull Double pageScaleFactor) {
    Map<String,Object> params = new HashMap<>();
    params.put("pageScaleFactor", pageScaleFactor);
    return rpcClient.call("Emulation.setPageScaleFactor", params, Void.class);
  }

  /**
   * Resizes the frame/viewport of the page. Note that this does not affect the frame's container (e.g. browser window). Can be used to produce screenshots of the specified size. Not supported on Android.
   * @param width Frame width (DIP).
   * @param height Frame height (DIP).
   */
  public CompletableFuture<Void> setVisibleSize(@NotNull Integer width, @NotNull Integer height) {
    Map<String,Object> params = new HashMap<>();
    params.put("width", width);
    params.put("height", height);
    return rpcClient.call("Emulation.setVisibleSize", params, Void.class);
  }

  /**
   * Switches script execution in the page.
   * @param value Whether script execution should be disabled in the page.
   */
  public CompletableFuture<Void> setScriptExecutionDisabled(@NotNull Boolean value) {
    Map<String,Object> params = new HashMap<>();
    params.put("value", value);
    return rpcClient.call("Emulation.setScriptExecutionDisabled", params, Void.class);
  }

  /**
   * Overrides the Geolocation Position or Error. Omitting any of the parameters emulates position unavailable.
   * @param latitude Mock latitude
   * @param longitude Mock longitude
   * @param accuracy Mock accuracy
   */
  public CompletableFuture<Void> setGeolocationOverride(@Nullable Double latitude, @Nullable Double longitude, @Nullable Double accuracy) {
    Map<String,Object> params = new HashMap<>();
    params.put("latitude", latitude);
    params.put("longitude", longitude);
    params.put("accuracy", accuracy);
    return rpcClient.call("Emulation.setGeolocationOverride", params, Void.class);
  }

  /**
   * Clears the overriden Geolocation Position and Error.
   */
  public CompletableFuture<Void> clearGeolocationOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Emulation.clearGeolocationOverride", params, Void.class);
  }

  /**
   * Toggles mouse event-based touch event emulation.
   * @param enabled Whether the touch event emulation should be enabled.
   * @param configuration Touch/gesture events configuration. Default: current platform.
   */
  public CompletableFuture<Void> setTouchEmulationEnabled(@NotNull Boolean enabled, @Nullable String configuration) {
    Map<String,Object> params = new HashMap<>();
    params.put("enabled", enabled);
    params.put("configuration", configuration);
    return rpcClient.call("Emulation.setTouchEmulationEnabled", params, Void.class);
  }

  /**
   * Emulates the given media for CSS media queries.
   * @param media Media type to emulate. Empty string disables the override.
   */
  public CompletableFuture<Void> setEmulatedMedia(@NotNull String media) {
    Map<String,Object> params = new HashMap<>();
    params.put("media", media);
    return rpcClient.call("Emulation.setEmulatedMedia", params, Void.class);
  }

  /**
   * Enables CPU throttling to emulate slow CPUs.
   * @param rate Throttling rate as a slowdown factor (1 is no throttle, 2 is 2x slowdown, etc).
   */
  public CompletableFuture<Void> setCPUThrottlingRate(@NotNull Double rate) {
    Map<String,Object> params = new HashMap<>();
    params.put("rate", rate);
    return rpcClient.call("Emulation.setCPUThrottlingRate", params, Void.class);
  }

  /**
   * Tells whether emulation is supported.
   */
  public CompletableFuture<CanEmulate> canEmulate() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Emulation.canEmulate", params, CanEmulate.class);
  }

  /**
   * Turns on virtual time for all frames (replacing real-time with a synthetic time source) and sets the current virtual time policy.  Note this supersedes any previous time budget.
   * @param budget If set, after this many virtual milliseconds have elapsed virtual time will be paused and a virtualTimeBudgetExpired event is sent.
   */
  public CompletableFuture<Void> setVirtualTimePolicy(@NotNull String policy, @Nullable Integer budget) {
    Map<String,Object> params = new HashMap<>();
    params.put("policy", policy);
    params.put("budget", budget);
    return rpcClient.call("Emulation.setVirtualTimePolicy", params, Void.class);
  }

  /**
   * Notification sent after the virual time budget for the current VirtualTimePolicy has run out.
   */
  public void onVirtualTimeBudgetExpired(Consumer<VirtualTimeBudgetExpired> listener) {
    rpcClient.addEventListener("Emulation.virtualTimeBudgetExpired", listener, VirtualTimeBudgetExpired.class);
  }

  /**
   * Notification sent after the virual time budget for the current VirtualTimePolicy has run out.
   */
  public CompletableFuture<VirtualTimeBudgetExpired> onVirtualTimeBudgetExpired() {
    return rpcClient.eventFuture("Emulation.virtualTimeBudgetExpired", VirtualTimeBudgetExpired.class);
  }

  /**
   * Screen orientation.
   */
  public static class ScreenOrientation {
    /**
     * Orientation type.
     */
    public String type;

    /**
     * Orientation angle.
     */
    public Integer angle;

    public String toString() {
      return "ScreenOrientation{type=" + type + ", angle=" + angle + "}";
    }
  }

  public static class CanEmulate {
    /**
     * True if emulation is supported.
     */
    public Boolean result;

    public String toString() {
      return "CanEmulate{result=" + result + "}";
    }
  }

  /**
   * Notification sent after the virual time budget for the current VirtualTimePolicy has run out.
   */
  public static class VirtualTimeBudgetExpired {
    public String toString() {
      return "VirtualTimeBudgetExpired{}";
    }
  }
}
