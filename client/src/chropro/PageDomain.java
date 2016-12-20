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
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class PageDomain {
  private RpcClient rpcClient;

  public PageDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables page domain notifications.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.enable", params, Void.class);
  }

  /**
   * Disables page domain notifications.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.disable", params, Void.class);
  }

  public CompletableFuture<AddScriptToEvaluateOnLoad> addScriptToEvaluateOnLoad(@NotNull String scriptSource) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptSource", scriptSource);
    return rpcClient.call("Page.addScriptToEvaluateOnLoad", params, AddScriptToEvaluateOnLoad.class);
  }

  public CompletableFuture<Void> removeScriptToEvaluateOnLoad(@NotNull String identifier) {
    Map<String,Object> params = new HashMap<>();
    params.put("identifier", identifier);
    return rpcClient.call("Page.removeScriptToEvaluateOnLoad", params, Void.class);
  }

  /**
   * Controls whether browser will open a new inspector window for connected pages.
   * @param autoAttach If true, browser will open a new inspector window for every page created from this one.
   */
  public CompletableFuture<Void> setAutoAttachToCreatedPages(@NotNull Boolean autoAttach) {
    Map<String,Object> params = new HashMap<>();
    params.put("autoAttach", autoAttach);
    return rpcClient.call("Page.setAutoAttachToCreatedPages", params, Void.class);
  }

  /**
   * Reloads given page optionally ignoring the cache.
   * @param ignoreCache If true, browser cache is ignored (as if the user pressed Shift+refresh).
   * @param scriptToEvaluateOnLoad If set, the script will be injected into all frames of the inspected page after reload.
   */
  public CompletableFuture<Void> reload(@Nullable Boolean ignoreCache, @Nullable String scriptToEvaluateOnLoad) {
    Map<String,Object> params = new HashMap<>();
    params.put("ignoreCache", ignoreCache);
    params.put("scriptToEvaluateOnLoad", scriptToEvaluateOnLoad);
    return rpcClient.call("Page.reload", params, Void.class);
  }

  /**
   * Navigates current page to the given URL.
   * @param url URL to navigate the page to.
   */
  public CompletableFuture<Navigate> navigate(@NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    return rpcClient.call("Page.navigate", params, Navigate.class);
  }

  /**
   * Force the page stop all navigations and pending resource fetches.
   */
  public CompletableFuture<Void> stopLoading() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.stopLoading", params, Void.class);
  }

  /**
   * Returns navigation history for the current page.
   */
  public CompletableFuture<GetNavigationHistory> getNavigationHistory() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.getNavigationHistory", params, GetNavigationHistory.class);
  }

  /**
   * Navigates current page to the given history entry.
   * @param entryId Unique id of the entry to navigate to.
   */
  public CompletableFuture<Void> navigateToHistoryEntry(@NotNull Integer entryId) {
    Map<String,Object> params = new HashMap<>();
    params.put("entryId", entryId);
    return rpcClient.call("Page.navigateToHistoryEntry", params, Void.class);
  }

  /**
   * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the <code>cookies</code> field.
   */
  public CompletableFuture<GetCookies> getCookies() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.getCookies", params, GetCookies.class);
  }

  /**
   * Deletes browser cookie with given name, domain and path.
   * @param cookieName Name of the cookie to remove.
   * @param url URL to match cooke domain and path.
   */
  public CompletableFuture<Void> deleteCookie(@NotNull String cookieName, @NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("cookieName", cookieName);
    params.put("url", url);
    return rpcClient.call("Page.deleteCookie", params, Void.class);
  }

  /**
   * Returns present frame / resource tree structure.
   */
  public CompletableFuture<GetResourceTree> getResourceTree() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.getResourceTree", params, GetResourceTree.class);
  }

  /**
   * Returns content of the given resource.
   * @param frameId Frame id to get resource for.
   * @param url URL of the resource to get content for.
   */
  public CompletableFuture<GetResourceContent> getResourceContent(@NotNull String frameId, @NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    params.put("url", url);
    return rpcClient.call("Page.getResourceContent", params, GetResourceContent.class);
  }

  /**
   * Searches for given string in resource content.
   * @param frameId Frame id for resource to search in.
   * @param url URL of the resource to search in.
   * @param query String to search for.
   * @param caseSensitive If true, search is case sensitive.
   * @param isRegex If true, treats string parameter as regex.
   */
  public CompletableFuture<SearchInResource> searchInResource(@NotNull String frameId, @NotNull String url, @NotNull String query, @Nullable Boolean caseSensitive, @Nullable Boolean isRegex) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    params.put("url", url);
    params.put("query", query);
    params.put("caseSensitive", caseSensitive);
    params.put("isRegex", isRegex);
    return rpcClient.call("Page.searchInResource", params, SearchInResource.class);
  }

  /**
   * Sets given markup as the document's HTML.
   * @param frameId Frame id to set HTML for.
   * @param html HTML content to set.
   */
  public CompletableFuture<Void> setDocumentContent(@NotNull String frameId, @NotNull String html) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    params.put("html", html);
    return rpcClient.call("Page.setDocumentContent", params, Void.class);
  }

  /**
   * Overrides the values of device screen dimensions (window.screen.width, window.screen.height, window.innerWidth, window.innerHeight, and "device-width"/"device-height"-related CSS media query results).
   * @param width Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param height Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override.
   * @param deviceScaleFactor Overriding device scale factor value. 0 disables the override.
   * @param mobile Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text autosizing and more.
   * @param fitWindow Whether a view that exceeds the available browser window area should be scaled down to fit.
   * @param scale Scale to apply to resulting view image. Ignored in |fitWindow| mode.
   * @param offsetX X offset to shift resulting view image by. Ignored in |fitWindow| mode.
   * @param offsetY Y offset to shift resulting view image by. Ignored in |fitWindow| mode.
   * @param screenWidth Overriding screen width value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param screenHeight Overriding screen height value in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param positionX Overriding view X position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param positionY Overriding view Y position on screen in pixels (minimum 0, maximum 10000000). Only used for |mobile==true|.
   * @param screenOrientation Screen orientation override.
   */
  public CompletableFuture<Void> setDeviceMetricsOverride(@NotNull Integer width, @NotNull Integer height, @NotNull Double deviceScaleFactor, @NotNull Boolean mobile, @NotNull Boolean fitWindow, @Nullable Double scale, @Nullable Double offsetX, @Nullable Double offsetY, @Nullable Integer screenWidth, @Nullable Integer screenHeight, @Nullable Integer positionX, @Nullable Integer positionY, @Nullable EmulationDomain.ScreenOrientation screenOrientation) {
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
    return rpcClient.call("Page.setDeviceMetricsOverride", params, Void.class);
  }

  /**
   * Clears the overriden device metrics.
   */
  public CompletableFuture<Void> clearDeviceMetricsOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.clearDeviceMetricsOverride", params, Void.class);
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
    return rpcClient.call("Page.setGeolocationOverride", params, Void.class);
  }

  /**
   * Clears the overriden Geolocation Position and Error.
   */
  public CompletableFuture<Void> clearGeolocationOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.clearGeolocationOverride", params, Void.class);
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
    return rpcClient.call("Page.setDeviceOrientationOverride", params, Void.class);
  }

  /**
   * Clears the overridden Device Orientation.
   */
  public CompletableFuture<Void> clearDeviceOrientationOverride() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.clearDeviceOrientationOverride", params, Void.class);
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
    return rpcClient.call("Page.setTouchEmulationEnabled", params, Void.class);
  }

  /**
   * Capture page screenshot.
   */
  public CompletableFuture<CaptureScreenshot> captureScreenshot() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.captureScreenshot", params, CaptureScreenshot.class);
  }

  /**
   * Starts sending each frame using the <code>screencastFrame</code> event.
   * @param format Image compression format.
   * @param quality Compression quality from range [0..100].
   * @param maxWidth Maximum screenshot width.
   * @param maxHeight Maximum screenshot height.
   * @param everyNthFrame Send every n-th frame.
   */
  public CompletableFuture<Void> startScreencast(@Nullable String format, @Nullable Integer quality, @Nullable Integer maxWidth, @Nullable Integer maxHeight, @Nullable Integer everyNthFrame) {
    Map<String,Object> params = new HashMap<>();
    params.put("format", format);
    params.put("quality", quality);
    params.put("maxWidth", maxWidth);
    params.put("maxHeight", maxHeight);
    params.put("everyNthFrame", everyNthFrame);
    return rpcClient.call("Page.startScreencast", params, Void.class);
  }

  /**
   * Stops sending each frame in the <code>screencastFrame</code>.
   */
  public CompletableFuture<Void> stopScreencast() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.stopScreencast", params, Void.class);
  }

  /**
   * Acknowledges that a screencast frame has been received by the frontend.
   * @param sessionId Frame number.
   */
  public CompletableFuture<Void> screencastFrameAck(@NotNull Integer sessionId) {
    Map<String,Object> params = new HashMap<>();
    params.put("sessionId", sessionId);
    return rpcClient.call("Page.screencastFrameAck", params, Void.class);
  }

  /**
   * Accepts or dismisses a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload).
   * @param accept Whether to accept or dismiss the dialog.
   * @param promptText The text to enter into the dialog prompt before accepting. Used only if this is a prompt dialog.
   */
  public CompletableFuture<Void> handleJavaScriptDialog(@NotNull Boolean accept, @Nullable String promptText) {
    Map<String,Object> params = new HashMap<>();
    params.put("accept", accept);
    params.put("promptText", promptText);
    return rpcClient.call("Page.handleJavaScriptDialog", params, Void.class);
  }

  /**
   * Shows / hides color picker
   * @param enabled Shows / hides color picker
   */
  public CompletableFuture<Void> setColorPickerEnabled(@NotNull Boolean enabled) {
    Map<String,Object> params = new HashMap<>();
    params.put("enabled", enabled);
    return rpcClient.call("Page.setColorPickerEnabled", params, Void.class);
  }

  /**
   * Configures overlay.
   * @param suspended Whether overlay should be suspended and not consume any resources.
   * @param message Overlay message to display.
   */
  public CompletableFuture<Void> configureOverlay(@Nullable Boolean suspended, @Nullable String message) {
    Map<String,Object> params = new HashMap<>();
    params.put("suspended", suspended);
    params.put("message", message);
    return rpcClient.call("Page.configureOverlay", params, Void.class);
  }

  public CompletableFuture<GetAppManifest> getAppManifest() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.getAppManifest", params, GetAppManifest.class);
  }

  public CompletableFuture<Void> requestAppBanner() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.requestAppBanner", params, Void.class);
  }

  /**
   * Toggles navigation throttling which allows programatic control over navigation and redirect response.
   */
  public CompletableFuture<Void> setControlNavigations(@NotNull Boolean enabled) {
    Map<String,Object> params = new HashMap<>();
    params.put("enabled", enabled);
    return rpcClient.call("Page.setControlNavigations", params, Void.class);
  }

  /**
   * Should be sent in response to a navigationRequested or a redirectRequested event, telling the browser how to handle the navigation.
   */
  public CompletableFuture<Void> processNavigation(@NotNull String response, @NotNull Integer navigationId) {
    Map<String,Object> params = new HashMap<>();
    params.put("response", response);
    params.put("navigationId", navigationId);
    return rpcClient.call("Page.processNavigation", params, Void.class);
  }

  /**
   * Returns metrics relating to the layouting of the page, such as viewport bounds/scale.
   */
  public CompletableFuture<GetLayoutMetrics> getLayoutMetrics() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Page.getLayoutMetrics", params, GetLayoutMetrics.class);
  }

  public void onDomContentEventFired(Consumer<DomContentEventFired> listener) {
    rpcClient.addEventListener("Page.domContentEventFired", listener, DomContentEventFired.class);
  }

  public CompletableFuture<DomContentEventFired> onDomContentEventFired() {
    return rpcClient.eventFuture("Page.domContentEventFired", DomContentEventFired.class);
  }

  public void onLoadEventFired(Consumer<LoadEventFired> listener) {
    rpcClient.addEventListener("Page.loadEventFired", listener, LoadEventFired.class);
  }

  public CompletableFuture<LoadEventFired> onLoadEventFired() {
    return rpcClient.eventFuture("Page.loadEventFired", LoadEventFired.class);
  }

  /**
   * Fired when frame has been attached to its parent.
   */
  public void onFrameAttached(Consumer<FrameAttached> listener) {
    rpcClient.addEventListener("Page.frameAttached", listener, FrameAttached.class);
  }

  /**
   * Fired when frame has been attached to its parent.
   */
  public CompletableFuture<FrameAttached> onFrameAttached() {
    return rpcClient.eventFuture("Page.frameAttached", FrameAttached.class);
  }

  /**
   * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
   */
  public void onFrameNavigated(Consumer<FrameNavigated> listener) {
    rpcClient.addEventListener("Page.frameNavigated", listener, FrameNavigated.class);
  }

  /**
   * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
   */
  public CompletableFuture<FrameNavigated> onFrameNavigated() {
    return rpcClient.eventFuture("Page.frameNavigated", FrameNavigated.class);
  }

  /**
   * Fired when frame has been detached from its parent.
   */
  public void onFrameDetached(Consumer<FrameDetached> listener) {
    rpcClient.addEventListener("Page.frameDetached", listener, FrameDetached.class);
  }

  /**
   * Fired when frame has been detached from its parent.
   */
  public CompletableFuture<FrameDetached> onFrameDetached() {
    return rpcClient.eventFuture("Page.frameDetached", FrameDetached.class);
  }

  /**
   * Fired when frame has started loading.
   */
  public void onFrameStartedLoading(Consumer<FrameStartedLoading> listener) {
    rpcClient.addEventListener("Page.frameStartedLoading", listener, FrameStartedLoading.class);
  }

  /**
   * Fired when frame has started loading.
   */
  public CompletableFuture<FrameStartedLoading> onFrameStartedLoading() {
    return rpcClient.eventFuture("Page.frameStartedLoading", FrameStartedLoading.class);
  }

  /**
   * Fired when frame has stopped loading.
   */
  public void onFrameStoppedLoading(Consumer<FrameStoppedLoading> listener) {
    rpcClient.addEventListener("Page.frameStoppedLoading", listener, FrameStoppedLoading.class);
  }

  /**
   * Fired when frame has stopped loading.
   */
  public CompletableFuture<FrameStoppedLoading> onFrameStoppedLoading() {
    return rpcClient.eventFuture("Page.frameStoppedLoading", FrameStoppedLoading.class);
  }

  /**
   * Fired when frame schedules a potential navigation.
   */
  public void onFrameScheduledNavigation(Consumer<FrameScheduledNavigation> listener) {
    rpcClient.addEventListener("Page.frameScheduledNavigation", listener, FrameScheduledNavigation.class);
  }

  /**
   * Fired when frame schedules a potential navigation.
   */
  public CompletableFuture<FrameScheduledNavigation> onFrameScheduledNavigation() {
    return rpcClient.eventFuture("Page.frameScheduledNavigation", FrameScheduledNavigation.class);
  }

  /**
   * Fired when frame no longer has a scheduled navigation.
   */
  public void onFrameClearedScheduledNavigation(Consumer<FrameClearedScheduledNavigation> listener) {
    rpcClient.addEventListener("Page.frameClearedScheduledNavigation", listener, FrameClearedScheduledNavigation.class);
  }

  /**
   * Fired when frame no longer has a scheduled navigation.
   */
  public CompletableFuture<FrameClearedScheduledNavigation> onFrameClearedScheduledNavigation() {
    return rpcClient.eventFuture("Page.frameClearedScheduledNavigation", FrameClearedScheduledNavigation.class);
  }

  public void onFrameResized(Consumer<FrameResized> listener) {
    rpcClient.addEventListener("Page.frameResized", listener, FrameResized.class);
  }

  public CompletableFuture<FrameResized> onFrameResized() {
    return rpcClient.eventFuture("Page.frameResized", FrameResized.class);
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
   */
  public void onJavascriptDialogOpening(Consumer<JavascriptDialogOpening> listener) {
    rpcClient.addEventListener("Page.javascriptDialogOpening", listener, JavascriptDialogOpening.class);
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
   */
  public CompletableFuture<JavascriptDialogOpening> onJavascriptDialogOpening() {
    return rpcClient.eventFuture("Page.javascriptDialogOpening", JavascriptDialogOpening.class);
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
   */
  public void onJavascriptDialogClosed(Consumer<JavascriptDialogClosed> listener) {
    rpcClient.addEventListener("Page.javascriptDialogClosed", listener, JavascriptDialogClosed.class);
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
   */
  public CompletableFuture<JavascriptDialogClosed> onJavascriptDialogClosed() {
    return rpcClient.eventFuture("Page.javascriptDialogClosed", JavascriptDialogClosed.class);
  }

  /**
   * Compressed image data requested by the <code>startScreencast</code>.
   */
  public void onScreencastFrame(Consumer<ScreencastFrame> listener) {
    rpcClient.addEventListener("Page.screencastFrame", listener, ScreencastFrame.class);
  }

  /**
   * Compressed image data requested by the <code>startScreencast</code>.
   */
  public CompletableFuture<ScreencastFrame> onScreencastFrame() {
    return rpcClient.eventFuture("Page.screencastFrame", ScreencastFrame.class);
  }

  /**
   * Fired when the page with currently enabled screencast was shown or hidden </code>.
   */
  public void onScreencastVisibilityChanged(Consumer<ScreencastVisibilityChanged> listener) {
    rpcClient.addEventListener("Page.screencastVisibilityChanged", listener, ScreencastVisibilityChanged.class);
  }

  /**
   * Fired when the page with currently enabled screencast was shown or hidden </code>.
   */
  public CompletableFuture<ScreencastVisibilityChanged> onScreencastVisibilityChanged() {
    return rpcClient.eventFuture("Page.screencastVisibilityChanged", ScreencastVisibilityChanged.class);
  }

  /**
   * Fired when a color has been picked.
   */
  public void onColorPicked(Consumer<ColorPicked> listener) {
    rpcClient.addEventListener("Page.colorPicked", listener, ColorPicked.class);
  }

  /**
   * Fired when a color has been picked.
   */
  public CompletableFuture<ColorPicked> onColorPicked() {
    return rpcClient.eventFuture("Page.colorPicked", ColorPicked.class);
  }

  /**
   * Fired when interstitial page was shown
   */
  public void onInterstitialShown(Consumer<InterstitialShown> listener) {
    rpcClient.addEventListener("Page.interstitialShown", listener, InterstitialShown.class);
  }

  /**
   * Fired when interstitial page was shown
   */
  public CompletableFuture<InterstitialShown> onInterstitialShown() {
    return rpcClient.eventFuture("Page.interstitialShown", InterstitialShown.class);
  }

  /**
   * Fired when interstitial page was hidden
   */
  public void onInterstitialHidden(Consumer<InterstitialHidden> listener) {
    rpcClient.addEventListener("Page.interstitialHidden", listener, InterstitialHidden.class);
  }

  /**
   * Fired when interstitial page was hidden
   */
  public CompletableFuture<InterstitialHidden> onInterstitialHidden() {
    return rpcClient.eventFuture("Page.interstitialHidden", InterstitialHidden.class);
  }

  /**
   * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
   */
  public void onNavigationRequested(Consumer<NavigationRequested> listener) {
    rpcClient.addEventListener("Page.navigationRequested", listener, NavigationRequested.class);
  }

  /**
   * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
   */
  public CompletableFuture<NavigationRequested> onNavigationRequested() {
    return rpcClient.eventFuture("Page.navigationRequested", NavigationRequested.class);
  }

  public static class AddScriptToEvaluateOnLoad {
    /**
     * Identifier of the added script.
     */
    public String identifier;

    public String toString() {
      return "AddScriptToEvaluateOnLoad{identifier=" + identifier + "}";
    }
  }

  public static class Navigate {
    /**
     * Frame id that will be navigated.
     */
    public String frameId;

    public String toString() {
      return "Navigate{frameId=" + frameId + "}";
    }
  }

  /**
   * Navigation history entry.
   */
  public static class NavigationEntry {
    /**
     * Unique id of the navigation history entry.
     */
    public Integer id;

    /**
     * URL of the navigation history entry.
     */
    public String url;

    /**
     * Title of the navigation history entry.
     */
    public String title;

    public String toString() {
      return "NavigationEntry{id=" + id + ", url=" + url + ", title=" + title + "}";
    }
  }

  public static class GetNavigationHistory {
    /**
     * Index of the current navigation history entry.
     */
    public Integer currentIndex;

    /**
     * Array of navigation history entries.
     */
    public List<NavigationEntry> entries;

    public String toString() {
      return "GetNavigationHistory{currentIndex=" + currentIndex + ", entries=" + entries + "}";
    }
  }

  public static class GetCookies {
    /**
     * Array of cookie objects.
     */
    public List<NetworkDomain.Cookie> cookies;

    public String toString() {
      return "GetCookies{cookies=" + cookies + "}";
    }
  }

  /**
   * Information about the Frame on the page.
   */
  public static class Frame {
    /**
     * Frame unique identifier.
     */
    public String id;

    /**
     * Parent frame identifier.
     */
    public String parentId;

    /**
     * Identifier of the loader associated with this frame.
     */
    public String loaderId;

    /**
     * Frame's name as specified in the tag.
     */
    public String name;

    /**
     * Frame document's URL.
     */
    public String url;

    /**
     * Frame document's security origin.
     */
    public String securityOrigin;

    /**
     * Frame document's mimeType as determined by the browser.
     */
    public String mimeType;

    public String toString() {
      return "Frame{id=" + id + ", parentId=" + parentId + ", loaderId=" + loaderId + ", name=" + name + ", url=" + url + ", securityOrigin=" + securityOrigin + ", mimeType=" + mimeType + "}";
    }
  }

  /**
   * Information about the Resource on the page.
   */
  public static class FrameResource {
    /**
     * Resource URL.
     */
    public String url;

    /**
     * Type of this resource.
     */
    public String type;

    /**
     * Resource mimeType as determined by the browser.
     */
    public String mimeType;

    /**
     * last-modified timestamp as reported by server.
     */
    public Double lastModified;

    /**
     * Resource content size.
     */
    public Double contentSize;

    /**
     * True if the resource failed to load.
     */
    public Boolean failed;

    /**
     * True if the resource was canceled during loading.
     */
    public Boolean canceled;

    public String toString() {
      return "FrameResource{url=" + url + ", type=" + type + ", mimeType=" + mimeType + ", lastModified=" + lastModified + ", contentSize=" + contentSize + ", failed=" + failed + ", canceled=" + canceled + "}";
    }
  }

  /**
   * Information about the Frame hierarchy along with their cached resources.
   */
  public static class FrameResourceTree {
    /**
     * Frame information for this tree item.
     */
    public Frame frame;

    /**
     * Child frames.
     */
    public List<FrameResourceTree> childFrames;

    /**
     * Information about frame resources.
     */
    public List<FrameResource> resources;

    public String toString() {
      return "FrameResourceTree{frame=" + frame + ", childFrames=" + childFrames + ", resources=" + resources + "}";
    }
  }

  public static class GetResourceTree {
    /**
     * Present frame / resource tree structure.
     */
    public FrameResourceTree frameTree;

    public String toString() {
      return "GetResourceTree{frameTree=" + frameTree + "}";
    }
  }

  public static class GetResourceContent {
    /**
     * Resource content.
     */
    public String content;

    /**
     * True, if content was served as base64.
     */
    public Boolean base64Encoded;

    public String toString() {
      return "GetResourceContent{content=" + content + ", base64Encoded=" + base64Encoded + "}";
    }
  }

  public static class SearchInResource {
    /**
     * List of search matches.
     */
    public List<DebuggerDomain.SearchMatch> result;

    public String toString() {
      return "SearchInResource{result=" + result + "}";
    }
  }

  public static class CaptureScreenshot {
    /**
     * Base64-encoded image data (PNG).
     */
    public String data;

    public String toString() {
      return "CaptureScreenshot{data=" + data + "}";
    }
  }

  /**
   * Error while paring app manifest.
   */
  public static class AppManifestError {
    /**
     * Error message.
     */
    public String message;

    /**
     * If criticial, this is a non-recoverable parse error.
     */
    public Integer critical;

    /**
     * Error line.
     */
    public Integer line;

    /**
     * Error column.
     */
    public Integer column;

    public String toString() {
      return "AppManifestError{message=" + message + ", critical=" + critical + ", line=" + line + ", column=" + column + "}";
    }
  }

  public static class GetAppManifest {
    /**
     * Manifest location.
     */
    public String url;

    public List<AppManifestError> errors;

    /**
     * Manifest content.
     */
    public String data;

    public String toString() {
      return "GetAppManifest{url=" + url + ", errors=" + errors + ", data=" + data + "}";
    }
  }

  /**
   * Layout viewport position and dimensions.
   */
  public static class LayoutViewport {
    /**
     * Horizontal offset relative to the document (CSS pixels).
     */
    public Integer pageX;

    /**
     * Vertical offset relative to the document (CSS pixels).
     */
    public Integer pageY;

    /**
     * Width (CSS pixels), excludes scrollbar if present.
     */
    public Integer clientWidth;

    /**
     * Height (CSS pixels), excludes scrollbar if present.
     */
    public Integer clientHeight;

    public String toString() {
      return "LayoutViewport{pageX=" + pageX + ", pageY=" + pageY + ", clientWidth=" + clientWidth + ", clientHeight=" + clientHeight + "}";
    }
  }

  /**
   * Visual viewport position, dimensions, and scale.
   */
  public static class VisualViewport {
    /**
     * Horizontal offset relative to the layout viewport (CSS pixels).
     */
    public Double offsetX;

    /**
     * Vertical offset relative to the layout viewport (CSS pixels).
     */
    public Double offsetY;

    /**
     * Horizontal offset relative to the document (CSS pixels).
     */
    public Double pageX;

    /**
     * Vertical offset relative to the document (CSS pixels).
     */
    public Double pageY;

    /**
     * Width (CSS pixels), excludes scrollbar if present.
     */
    public Double clientWidth;

    /**
     * Height (CSS pixels), excludes scrollbar if present.
     */
    public Double clientHeight;

    /**
     * Scale relative to the ideal viewport (size at width=device-width).
     */
    public Double scale;

    public String toString() {
      return "VisualViewport{offsetX=" + offsetX + ", offsetY=" + offsetY + ", pageX=" + pageX + ", pageY=" + pageY + ", clientWidth=" + clientWidth + ", clientHeight=" + clientHeight + ", scale=" + scale + "}";
    }
  }

  public static class GetLayoutMetrics {
    /**
     * Metrics relating to the layout viewport.
     */
    public LayoutViewport layoutViewport;

    /**
     * Metrics relating to the visual viewport.
     */
    public VisualViewport visualViewport;

    public String toString() {
      return "GetLayoutMetrics{layoutViewport=" + layoutViewport + ", visualViewport=" + visualViewport + "}";
    }
  }

  public static class DomContentEventFired {
    public Double timestamp;

    public String toString() {
      return "DomContentEventFired{timestamp=" + timestamp + "}";
    }
  }

  public static class LoadEventFired {
    public Double timestamp;

    public String toString() {
      return "LoadEventFired{timestamp=" + timestamp + "}";
    }
  }

  /**
   * Fired when frame has been attached to its parent.
   */
  public static class FrameAttached {
    /**
     * Id of the frame that has been attached.
     */
    public String frameId;

    /**
     * Parent frame identifier.
     */
    public String parentFrameId;

    public String toString() {
      return "FrameAttached{frameId=" + frameId + ", parentFrameId=" + parentFrameId + "}";
    }
  }

  /**
   * Fired once navigation of the frame has completed. Frame is now associated with the new loader.
   */
  public static class FrameNavigated {
    /**
     * Frame object.
     */
    public Frame frame;

    public String toString() {
      return "FrameNavigated{frame=" + frame + "}";
    }
  }

  /**
   * Fired when frame has been detached from its parent.
   */
  public static class FrameDetached {
    /**
     * Id of the frame that has been detached.
     */
    public String frameId;

    public String toString() {
      return "FrameDetached{frameId=" + frameId + "}";
    }
  }

  /**
   * Fired when frame has started loading.
   */
  public static class FrameStartedLoading {
    /**
     * Id of the frame that has started loading.
     */
    public String frameId;

    public String toString() {
      return "FrameStartedLoading{frameId=" + frameId + "}";
    }
  }

  /**
   * Fired when frame has stopped loading.
   */
  public static class FrameStoppedLoading {
    /**
     * Id of the frame that has stopped loading.
     */
    public String frameId;

    public String toString() {
      return "FrameStoppedLoading{frameId=" + frameId + "}";
    }
  }

  /**
   * Fired when frame schedules a potential navigation.
   */
  public static class FrameScheduledNavigation {
    /**
     * Id of the frame that has scheduled a navigation.
     */
    public String frameId;

    /**
     * Delay (in seconds) until the navigation is scheduled to begin. The navigation is not guaranteed to start.
     */
    public Double delay;

    public String toString() {
      return "FrameScheduledNavigation{frameId=" + frameId + ", delay=" + delay + "}";
    }
  }

  /**
   * Fired when frame no longer has a scheduled navigation.
   */
  public static class FrameClearedScheduledNavigation {
    /**
     * Id of the frame that has cleared its scheduled navigation.
     */
    public String frameId;

    public String toString() {
      return "FrameClearedScheduledNavigation{frameId=" + frameId + "}";
    }
  }

  public static class FrameResized {
    public String toString() {
      return "FrameResized{}";
    }
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to open.
   */
  public static class JavascriptDialogOpening {
    /**
     * Message that will be displayed by the dialog.
     */
    public String message;

    /**
     * Dialog type.
     */
    public String type;

    public String toString() {
      return "JavascriptDialogOpening{message=" + message + ", type=" + type + "}";
    }
  }

  /**
   * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been closed.
   */
  public static class JavascriptDialogClosed {
    /**
     * Whether dialog was confirmed.
     */
    public Boolean result;

    public String toString() {
      return "JavascriptDialogClosed{result=" + result + "}";
    }
  }

  /**
   * Screencast frame metadata.
   */
  public static class ScreencastFrameMetadata {
    /**
     * Top offset in DIP.
     */
    public Double offsetTop;

    /**
     * Page scale factor.
     */
    public Double pageScaleFactor;

    /**
     * Device screen width in DIP.
     */
    public Double deviceWidth;

    /**
     * Device screen height in DIP.
     */
    public Double deviceHeight;

    /**
     * Position of horizontal scroll in CSS pixels.
     */
    public Double scrollOffsetX;

    /**
     * Position of vertical scroll in CSS pixels.
     */
    public Double scrollOffsetY;

    /**
     * Frame swap timestamp.
     */
    public Double timestamp;

    public String toString() {
      return "ScreencastFrameMetadata{offsetTop=" + offsetTop + ", pageScaleFactor=" + pageScaleFactor + ", deviceWidth=" + deviceWidth + ", deviceHeight=" + deviceHeight + ", scrollOffsetX=" + scrollOffsetX + ", scrollOffsetY=" + scrollOffsetY + ", timestamp=" + timestamp + "}";
    }
  }

  /**
   * Compressed image data requested by the <code>startScreencast</code>.
   */
  public static class ScreencastFrame {
    /**
     * Base64-encoded compressed image.
     */
    public String data;

    /**
     * Screencast frame metadata.
     */
    public ScreencastFrameMetadata metadata;

    /**
     * Frame number.
     */
    public Integer sessionId;

    public String toString() {
      return "ScreencastFrame{data=" + data + ", metadata=" + metadata + ", sessionId=" + sessionId + "}";
    }
  }

  /**
   * Fired when the page with currently enabled screencast was shown or hidden </code>.
   */
  public static class ScreencastVisibilityChanged {
    /**
     * True if the page is visible.
     */
    public Boolean visible;

    public String toString() {
      return "ScreencastVisibilityChanged{visible=" + visible + "}";
    }
  }

  /**
   * Fired when a color has been picked.
   */
  public static class ColorPicked {
    /**
     * RGBA of the picked color.
     */
    public DOMDomain.RGBA color;

    public String toString() {
      return "ColorPicked{color=" + color + "}";
    }
  }

  /**
   * Fired when interstitial page was shown
   */
  public static class InterstitialShown {
    public String toString() {
      return "InterstitialShown{}";
    }
  }

  /**
   * Fired when interstitial page was hidden
   */
  public static class InterstitialHidden {
    public String toString() {
      return "InterstitialHidden{}";
    }
  }

  /**
   * Fired when a navigation is started if navigation throttles are enabled.  The navigation will be deferred until processNavigation is called.
   */
  public static class NavigationRequested {
    /**
     * Whether the navigation is taking place in the main frame or in a subframe.
     */
    public Boolean isInMainFrame;

    /**
     * Whether the navigation has encountered a server redirect or not.
     */
    public Boolean isRedirect;

    public Integer navigationId;

    /**
     * URL of requested navigation.
     */
    public String url;

    public String toString() {
      return "NavigationRequested{isInMainFrame=" + isInMainFrame + ", isRedirect=" + isRedirect + ", navigationId=" + navigationId + ", url=" + url + "}";
    }
  }
}
