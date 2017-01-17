package chropro;

import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
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
public class NetworkDomain {
  private RpcClient rpcClient;

  public NetworkDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables network tracking, network events will now be delivered to the client.
   * @param maxTotalBufferSize Buffer size in bytes to use when preserving network payloads (XHRs, etc).
   * @param maxResourceBufferSize Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc).
   */
  public CompletableFuture<Void> enable(@Nullable Integer maxTotalBufferSize, @Nullable Integer maxResourceBufferSize) {
    Map<String,Object> params = new HashMap<>();
    params.put("maxTotalBufferSize", maxTotalBufferSize);
    params.put("maxResourceBufferSize", maxResourceBufferSize);
    return rpcClient.call("Network.enable", params, Void.class);
  }

  /**
   * Disables network tracking, prevents network events from being sent to the client.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.disable", params, Void.class);
  }

  /**
   * Allows overriding user agent with the given string.
   * @param userAgent User agent to use.
   */
  public CompletableFuture<Void> setUserAgentOverride(@NotNull String userAgent) {
    Map<String,Object> params = new HashMap<>();
    params.put("userAgent", userAgent);
    return rpcClient.call("Network.setUserAgentOverride", params, Void.class);
  }

  /**
   * Specifies whether to always send extra HTTP headers with the requests from this page.
   * @param headers Map with extra HTTP headers.
   */
  public CompletableFuture<Void> setExtraHTTPHeaders(@NotNull Map<String, Object> headers) {
    Map<String,Object> params = new HashMap<>();
    params.put("headers", headers);
    return rpcClient.call("Network.setExtraHTTPHeaders", params, Void.class);
  }

  /**
   * Returns content served for the given request.
   * @param requestId Identifier of the network request to get content for.
   */
  public CompletableFuture<GetResponseBody> getResponseBody(@NotNull String requestId) {
    Map<String,Object> params = new HashMap<>();
    params.put("requestId", requestId);
    return rpcClient.call("Network.getResponseBody", params, GetResponseBody.class);
  }

  /**
   * Blocks specific URL from loading.
   * @param url URL to block.
   */
  public CompletableFuture<Void> addBlockedURL(@NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    return rpcClient.call("Network.addBlockedURL", params, Void.class);
  }

  /**
   * Cancels blocking of a specific URL from loading.
   * @param url URL to stop blocking.
   */
  public CompletableFuture<Void> removeBlockedURL(@NotNull String url) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    return rpcClient.call("Network.removeBlockedURL", params, Void.class);
  }

  /**
   * This method sends a new XMLHttpRequest which is identical to the original one. The following parameters should be identical: method, url, async, request body, extra headers, withCredentials attribute, user, password.
   * @param requestId Identifier of XHR to replay.
   */
  public CompletableFuture<Void> replayXHR(@NotNull String requestId) {
    Map<String,Object> params = new HashMap<>();
    params.put("requestId", requestId);
    return rpcClient.call("Network.replayXHR", params, Void.class);
  }

  /**
   * Toggles monitoring of XMLHttpRequest. If <code>true</code>, console will receive messages upon each XHR issued.
   * @param enabled Monitoring enabled state.
   */
  public CompletableFuture<Void> setMonitoringXHREnabled(@NotNull Boolean enabled) {
    Map<String,Object> params = new HashMap<>();
    params.put("enabled", enabled);
    return rpcClient.call("Network.setMonitoringXHREnabled", params, Void.class);
  }

  /**
   * Tells whether clearing browser cache is supported.
   */
  public CompletableFuture<CanClearBrowserCache> canClearBrowserCache() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.canClearBrowserCache", params, CanClearBrowserCache.class);
  }

  /**
   * Clears browser cache.
   */
  public CompletableFuture<Void> clearBrowserCache() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.clearBrowserCache", params, Void.class);
  }

  /**
   * Tells whether clearing browser cookies is supported.
   */
  public CompletableFuture<CanClearBrowserCookies> canClearBrowserCookies() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.canClearBrowserCookies", params, CanClearBrowserCookies.class);
  }

  /**
   * Clears browser cookies.
   */
  public CompletableFuture<Void> clearBrowserCookies() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.clearBrowserCookies", params, Void.class);
  }

  /**
   * Returns all browser cookies for the current URL. Depending on the backend support, will return detailed cookie information in the <code>cookies</code> field.
   */
  public CompletableFuture<GetCookies> getCookies() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.getCookies", params, GetCookies.class);
  }

  /**
   * Returns all browser cookies. Depending on the backend support, will return detailed cookie information in the <code>cookies</code> field.
   */
  public CompletableFuture<GetAllCookies> getAllCookies() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.getAllCookies", params, GetAllCookies.class);
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
    return rpcClient.call("Network.deleteCookie", params, Void.class);
  }

  /**
   * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
   * @param url The request-URI to associate with the setting of the cookie. This value can affect the default domain and path values of the created cookie.
   * @param name The name of the cookie.
   * @param value The value of the cookie.
   * @param domain If omitted, the cookie becomes a host-only cookie.
   * @param path Defaults to the path portion of the url parameter.
   * @param secure Defaults ot false.
   * @param httpOnly Defaults to false.
   * @param sameSite Defaults to browser default behavior.
   * @param expirationDate If omitted, the cookie becomes a session cookie.
   */
  public CompletableFuture<SetCookie> setCookie(@NotNull String url, @NotNull String name, @NotNull String value, @Nullable String domain, @Nullable String path, @Nullable Boolean secure, @Nullable Boolean httpOnly, @Nullable String sameSite, @Nullable Double expirationDate) {
    Map<String,Object> params = new HashMap<>();
    params.put("url", url);
    params.put("name", name);
    params.put("value", value);
    params.put("domain", domain);
    params.put("path", path);
    params.put("secure", secure);
    params.put("httpOnly", httpOnly);
    params.put("sameSite", sameSite);
    params.put("expirationDate", expirationDate);
    return rpcClient.call("Network.setCookie", params, SetCookie.class);
  }

  /**
   * Tells whether emulation of network conditions is supported.
   */
  public CompletableFuture<CanEmulateNetworkConditions> canEmulateNetworkConditions() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Network.canEmulateNetworkConditions", params, CanEmulateNetworkConditions.class);
  }

  /**
   * Activates emulation of network conditions.
   * @param offline True to emulate internet disconnection.
   * @param latency Additional latency (ms).
   * @param downloadThroughput Maximal aggregated download throughput.
   * @param uploadThroughput Maximal aggregated upload throughput.
   * @param connectionType Connection type if known.
   */
  public CompletableFuture<Void> emulateNetworkConditions(@NotNull Boolean offline, @NotNull Double latency, @NotNull Double downloadThroughput, @NotNull Double uploadThroughput, @Nullable String connectionType) {
    Map<String,Object> params = new HashMap<>();
    params.put("offline", offline);
    params.put("latency", latency);
    params.put("downloadThroughput", downloadThroughput);
    params.put("uploadThroughput", uploadThroughput);
    params.put("connectionType", connectionType);
    return rpcClient.call("Network.emulateNetworkConditions", params, Void.class);
  }

  /**
   * Toggles ignoring cache for each request. If <code>true</code>, cache will not be used.
   * @param cacheDisabled Cache disabled state.
   */
  public CompletableFuture<Void> setCacheDisabled(@NotNull Boolean cacheDisabled) {
    Map<String,Object> params = new HashMap<>();
    params.put("cacheDisabled", cacheDisabled);
    return rpcClient.call("Network.setCacheDisabled", params, Void.class);
  }

  /**
   * Toggles ignoring of service worker for each request.
   * @param bypass Bypass service worker and load from network.
   */
  public CompletableFuture<Void> setBypassServiceWorker(@NotNull Boolean bypass) {
    Map<String,Object> params = new HashMap<>();
    params.put("bypass", bypass);
    return rpcClient.call("Network.setBypassServiceWorker", params, Void.class);
  }

  /**
   * For testing.
   * @param maxTotalSize Maximum total buffer size.
   * @param maxResourceSize Maximum per-resource size.
   */
  public CompletableFuture<Void> setDataSizeLimitsForTest(@NotNull Integer maxTotalSize, @NotNull Integer maxResourceSize) {
    Map<String,Object> params = new HashMap<>();
    params.put("maxTotalSize", maxTotalSize);
    params.put("maxResourceSize", maxResourceSize);
    return rpcClient.call("Network.setDataSizeLimitsForTest", params, Void.class);
  }

  /**
   * Returns the DER-encoded certificate.
   * @param origin Origin to get certificate for.
   */
  public CompletableFuture<GetCertificate> getCertificate(@NotNull String origin) {
    Map<String,Object> params = new HashMap<>();
    params.put("origin", origin);
    return rpcClient.call("Network.getCertificate", params, GetCertificate.class);
  }

  /**
   * Fired when resource loading priority is changed
   */
  public void onResourceChangedPriority(Consumer<ResourceChangedPriority> listener) {
    rpcClient.addEventListener("Network.resourceChangedPriority", listener, ResourceChangedPriority.class);
  }

  /**
   * Fired when resource loading priority is changed
   */
  public CompletableFuture<ResourceChangedPriority> onResourceChangedPriority() {
    return rpcClient.eventFuture("Network.resourceChangedPriority", ResourceChangedPriority.class);
  }

  /**
   * Fired when page is about to send HTTP request.
   */
  public void onRequestWillBeSent(Consumer<RequestWillBeSent> listener) {
    rpcClient.addEventListener("Network.requestWillBeSent", listener, RequestWillBeSent.class);
  }

  /**
   * Fired when page is about to send HTTP request.
   */
  public CompletableFuture<RequestWillBeSent> onRequestWillBeSent() {
    return rpcClient.eventFuture("Network.requestWillBeSent", RequestWillBeSent.class);
  }

  /**
   * Fired if request ended up loading from cache.
   */
  public void onRequestServedFromCache(Consumer<RequestServedFromCache> listener) {
    rpcClient.addEventListener("Network.requestServedFromCache", listener, RequestServedFromCache.class);
  }

  /**
   * Fired if request ended up loading from cache.
   */
  public CompletableFuture<RequestServedFromCache> onRequestServedFromCache() {
    return rpcClient.eventFuture("Network.requestServedFromCache", RequestServedFromCache.class);
  }

  /**
   * Fired when HTTP response is available.
   */
  public void onResponseReceived(Consumer<ResponseReceived> listener) {
    rpcClient.addEventListener("Network.responseReceived", listener, ResponseReceived.class);
  }

  /**
   * Fired when HTTP response is available.
   */
  public CompletableFuture<ResponseReceived> onResponseReceived() {
    return rpcClient.eventFuture("Network.responseReceived", ResponseReceived.class);
  }

  /**
   * Fired when data chunk was received over the network.
   */
  public void onDataReceived(Consumer<DataReceived> listener) {
    rpcClient.addEventListener("Network.dataReceived", listener, DataReceived.class);
  }

  /**
   * Fired when data chunk was received over the network.
   */
  public CompletableFuture<DataReceived> onDataReceived() {
    return rpcClient.eventFuture("Network.dataReceived", DataReceived.class);
  }

  /**
   * Fired when HTTP request has finished loading.
   */
  public void onLoadingFinished(Consumer<LoadingFinished> listener) {
    rpcClient.addEventListener("Network.loadingFinished", listener, LoadingFinished.class);
  }

  /**
   * Fired when HTTP request has finished loading.
   */
  public CompletableFuture<LoadingFinished> onLoadingFinished() {
    return rpcClient.eventFuture("Network.loadingFinished", LoadingFinished.class);
  }

  /**
   * Fired when HTTP request has failed to load.
   */
  public void onLoadingFailed(Consumer<LoadingFailed> listener) {
    rpcClient.addEventListener("Network.loadingFailed", listener, LoadingFailed.class);
  }

  /**
   * Fired when HTTP request has failed to load.
   */
  public CompletableFuture<LoadingFailed> onLoadingFailed() {
    return rpcClient.eventFuture("Network.loadingFailed", LoadingFailed.class);
  }

  /**
   * Fired when WebSocket is about to initiate handshake.
   */
  public void onWebSocketWillSendHandshakeRequest(Consumer<WebSocketWillSendHandshakeRequest> listener) {
    rpcClient.addEventListener("Network.webSocketWillSendHandshakeRequest", listener, WebSocketWillSendHandshakeRequest.class);
  }

  /**
   * Fired when WebSocket is about to initiate handshake.
   */
  public CompletableFuture<WebSocketWillSendHandshakeRequest> onWebSocketWillSendHandshakeRequest() {
    return rpcClient.eventFuture("Network.webSocketWillSendHandshakeRequest", WebSocketWillSendHandshakeRequest.class);
  }

  /**
   * Fired when WebSocket handshake response becomes available.
   */
  public void onWebSocketHandshakeResponseReceived(Consumer<WebSocketHandshakeResponseReceived> listener) {
    rpcClient.addEventListener("Network.webSocketHandshakeResponseReceived", listener, WebSocketHandshakeResponseReceived.class);
  }

  /**
   * Fired when WebSocket handshake response becomes available.
   */
  public CompletableFuture<WebSocketHandshakeResponseReceived> onWebSocketHandshakeResponseReceived() {
    return rpcClient.eventFuture("Network.webSocketHandshakeResponseReceived", WebSocketHandshakeResponseReceived.class);
  }

  /**
   * Fired upon WebSocket creation.
   */
  public void onWebSocketCreated(Consumer<WebSocketCreated> listener) {
    rpcClient.addEventListener("Network.webSocketCreated", listener, WebSocketCreated.class);
  }

  /**
   * Fired upon WebSocket creation.
   */
  public CompletableFuture<WebSocketCreated> onWebSocketCreated() {
    return rpcClient.eventFuture("Network.webSocketCreated", WebSocketCreated.class);
  }

  /**
   * Fired when WebSocket is closed.
   */
  public void onWebSocketClosed(Consumer<WebSocketClosed> listener) {
    rpcClient.addEventListener("Network.webSocketClosed", listener, WebSocketClosed.class);
  }

  /**
   * Fired when WebSocket is closed.
   */
  public CompletableFuture<WebSocketClosed> onWebSocketClosed() {
    return rpcClient.eventFuture("Network.webSocketClosed", WebSocketClosed.class);
  }

  /**
   * Fired when WebSocket frame is received.
   */
  public void onWebSocketFrameReceived(Consumer<WebSocketFrameReceived> listener) {
    rpcClient.addEventListener("Network.webSocketFrameReceived", listener, WebSocketFrameReceived.class);
  }

  /**
   * Fired when WebSocket frame is received.
   */
  public CompletableFuture<WebSocketFrameReceived> onWebSocketFrameReceived() {
    return rpcClient.eventFuture("Network.webSocketFrameReceived", WebSocketFrameReceived.class);
  }

  /**
   * Fired when WebSocket frame error occurs.
   */
  public void onWebSocketFrameError(Consumer<WebSocketFrameError> listener) {
    rpcClient.addEventListener("Network.webSocketFrameError", listener, WebSocketFrameError.class);
  }

  /**
   * Fired when WebSocket frame error occurs.
   */
  public CompletableFuture<WebSocketFrameError> onWebSocketFrameError() {
    return rpcClient.eventFuture("Network.webSocketFrameError", WebSocketFrameError.class);
  }

  /**
   * Fired when WebSocket frame is sent.
   */
  public void onWebSocketFrameSent(Consumer<WebSocketFrameSent> listener) {
    rpcClient.addEventListener("Network.webSocketFrameSent", listener, WebSocketFrameSent.class);
  }

  /**
   * Fired when WebSocket frame is sent.
   */
  public CompletableFuture<WebSocketFrameSent> onWebSocketFrameSent() {
    return rpcClient.eventFuture("Network.webSocketFrameSent", WebSocketFrameSent.class);
  }

  /**
   * Fired when EventSource message is received.
   */
  public void onEventSourceMessageReceived(Consumer<EventSourceMessageReceived> listener) {
    rpcClient.addEventListener("Network.eventSourceMessageReceived", listener, EventSourceMessageReceived.class);
  }

  /**
   * Fired when EventSource message is received.
   */
  public CompletableFuture<EventSourceMessageReceived> onEventSourceMessageReceived() {
    return rpcClient.eventFuture("Network.eventSourceMessageReceived", EventSourceMessageReceived.class);
  }

  /**
   * Cookie object
   */
  public static class Cookie {
    /**
     * Cookie name.
     */
    public String name;

    /**
     * Cookie value.
     */
    public String value;

    /**
     * Cookie domain.
     */
    public String domain;

    /**
     * Cookie path.
     */
    public String path;

    /**
     * Cookie expiration date as the number of seconds since the UNIX epoch.
     */
    public Double expires;

    /**
     * Cookie size.
     */
    public Integer size;

    /**
     * True if cookie is http-only.
     */
    public Boolean httpOnly;

    /**
     * True if cookie is secure.
     */
    public Boolean secure;

    /**
     * True in case of session cookie.
     */
    public Boolean session;

    /**
     * Cookie SameSite type.
     */
    public String sameSite;

    public String toString() {
      return "Cookie{name=" + name + ", value=" + value + ", domain=" + domain + ", path=" + path + ", expires=" + expires + ", size=" + size + ", httpOnly=" + httpOnly + ", secure=" + secure + ", session=" + session + ", sameSite=" + sameSite + "}";
    }
  }

  public static class GetResponseBody {
    /**
     * Response body.
     */
    public String body;

    /**
     * True, if content was sent as base64.
     */
    public Boolean base64Encoded;

    public String toString() {
      return "GetResponseBody{body=" + body + ", base64Encoded=" + base64Encoded + "}";
    }
  }

  public static class CanClearBrowserCache {
    /**
     * True if browser cache can be cleared.
     */
    public Boolean result;

    public String toString() {
      return "CanClearBrowserCache{result=" + result + "}";
    }
  }

  public static class CanClearBrowserCookies {
    /**
     * True if browser cookies can be cleared.
     */
    public Boolean result;

    public String toString() {
      return "CanClearBrowserCookies{result=" + result + "}";
    }
  }

  public static class GetCookies {
    /**
     * Array of cookie objects.
     */
    public List<Cookie> cookies;

    public String toString() {
      return "GetCookies{cookies=" + cookies + "}";
    }
  }

  public static class GetAllCookies {
    /**
     * Array of cookie objects.
     */
    public List<Cookie> cookies;

    public String toString() {
      return "GetAllCookies{cookies=" + cookies + "}";
    }
  }

  public static class SetCookie {
    /**
     * True if successfully set cookie.
     */
    public Boolean success;

    public String toString() {
      return "SetCookie{success=" + success + "}";
    }
  }

  public static class CanEmulateNetworkConditions {
    /**
     * True if emulation of network conditions is supported.
     */
    public Boolean result;

    public String toString() {
      return "CanEmulateNetworkConditions{result=" + result + "}";
    }
  }

  public static class GetCertificate {
    public List<String> tableNames;

    public String toString() {
      return "GetCertificate{tableNames=" + tableNames + "}";
    }
  }

  /**
   * Fired when resource loading priority is changed
   */
  public static class ResourceChangedPriority {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * New priority
     */
    public String newPriority;

    /**
     * Timestamp.
     */
    public Double timestamp;

    public String toString() {
      return "ResourceChangedPriority{requestId=" + requestId + ", newPriority=" + newPriority + ", timestamp=" + timestamp + "}";
    }
  }

  /**
   * HTTP request data.
   */
  public static class Request {
    /**
     * Request URL.
     */
    public String url;

    /**
     * HTTP request method.
     */
    public String method;

    /**
     * HTTP request headers.
     */
    public Map<String, Object> headers;

    /**
     * HTTP POST request data.
     */
    public String postData;

    /**
     * The mixed content status of the request, as defined in http://www.w3.org/TR/mixed-content/
     */
    public String mixedContentType;

    /**
     * Priority of the resource request at the time request is sent.
     */
    public String initialPriority;

    public String toString() {
      return "Request{url=" + url + ", method=" + method + ", headers=" + headers + ", postData=" + postData + ", mixedContentType=" + mixedContentType + ", initialPriority=" + initialPriority + "}";
    }
  }

  /**
   * Information about the request initiator.
   */
  public static class Initiator {
    /**
     * Type of this initiator.
     */
    public String type;

    /**
     * Initiator JavaScript stack trace, set for Script only.
     */
    public RuntimeDomain.StackTrace stack;

    /**
     * Initiator URL, set for Parser type only.
     */
    public String url;

    /**
     * Initiator line number, set for Parser type only (0-based).
     */
    public Double lineNumber;

    public String toString() {
      return "Initiator{type=" + type + ", stack=" + stack + ", url=" + url + ", lineNumber=" + lineNumber + "}";
    }
  }

  /**
   * Timing information for the request.
   */
  public static class ResourceTiming {
    /**
     * Timing's requestTime is a baseline in seconds, while the other numbers are ticks in milliseconds relatively to this requestTime.
     */
    public Double requestTime;

    /**
     * Started resolving proxy.
     */
    public Double proxyStart;

    /**
     * Finished resolving proxy.
     */
    public Double proxyEnd;

    /**
     * Started DNS address resolve.
     */
    public Double dnsStart;

    /**
     * Finished DNS address resolve.
     */
    public Double dnsEnd;

    /**
     * Started connecting to the remote host.
     */
    public Double connectStart;

    /**
     * Connected to the remote host.
     */
    public Double connectEnd;

    /**
     * Started SSL handshake.
     */
    public Double sslStart;

    /**
     * Finished SSL handshake.
     */
    public Double sslEnd;

    /**
     * Started running ServiceWorker.
     */
    public Double workerStart;

    /**
     * Finished Starting ServiceWorker.
     */
    public Double workerReady;

    /**
     * Started sending request.
     */
    public Double sendStart;

    /**
     * Finished sending request.
     */
    public Double sendEnd;

    /**
     * Time the server started pushing request.
     */
    public Double pushStart;

    /**
     * Time the server finished pushing request.
     */
    public Double pushEnd;

    /**
     * Finished receiving response headers.
     */
    public Double receiveHeadersEnd;

    public String toString() {
      return "ResourceTiming{requestTime=" + requestTime + ", proxyStart=" + proxyStart + ", proxyEnd=" + proxyEnd + ", dnsStart=" + dnsStart + ", dnsEnd=" + dnsEnd + ", connectStart=" + connectStart + ", connectEnd=" + connectEnd + ", sslStart=" + sslStart + ", sslEnd=" + sslEnd + ", workerStart=" + workerStart + ", workerReady=" + workerReady + ", sendStart=" + sendStart + ", sendEnd=" + sendEnd + ", pushStart=" + pushStart + ", pushEnd=" + pushEnd + ", receiveHeadersEnd=" + receiveHeadersEnd + "}";
    }
  }

  /**
   * Details of a signed certificate timestamp (SCT).
   */
  public static class SignedCertificateTimestamp {
    /**
     * Validation status.
     */
    public String status;

    /**
     * Origin.
     */
    public String origin;

    /**
     * Log name / description.
     */
    public String logDescription;

    /**
     * Log ID.
     */
    public String logId;

    /**
     * Issuance date.
     */
    public Double timestamp;

    /**
     * Hash algorithm.
     */
    public String hashAlgorithm;

    /**
     * Signature algorithm.
     */
    public String signatureAlgorithm;

    /**
     * Signature data.
     */
    public String signatureData;

    public String toString() {
      return "SignedCertificateTimestamp{status=" + status + ", origin=" + origin + ", logDescription=" + logDescription + ", logId=" + logId + ", timestamp=" + timestamp + ", hashAlgorithm=" + hashAlgorithm + ", signatureAlgorithm=" + signatureAlgorithm + ", signatureData=" + signatureData + "}";
    }
  }

  /**
   * Security details about a request.
   */
  public static class SecurityDetails {
    /**
     * Protocol name (e.g. "TLS 1.2" or "QUIC").
     */
    public String protocol;

    /**
     * Key Exchange used by the connection, or the empty string if not applicable.
     */
    public String keyExchange;

    /**
     * (EC)DH group used by the connection, if applicable.
     */
    public String keyExchangeGroup;

    /**
     * Cipher name.
     */
    public String cipher;

    /**
     * TLS MAC. Note that AEAD ciphers do not have separate MACs.
     */
    public String mac;

    /**
     * Certificate ID value.
     */
    public Integer certificateId;

    /**
     * Certificate subject name.
     */
    public String subjectName;

    /**
     * Subject Alternative Name (SAN) DNS names and IP addresses.
     */
    public List<String> sanList;

    /**
     * Name of the issuing CA.
     */
    public String issuer;

    /**
     * Certificate valid from date.
     */
    public Double validFrom;

    /**
     * Certificate valid to (expiration) date
     */
    public Double validTo;

    /**
     * List of signed certificate timestamps (SCTs).
     */
    public List<SignedCertificateTimestamp> signedCertificateTimestampList;

    public String toString() {
      return "SecurityDetails{protocol=" + protocol + ", keyExchange=" + keyExchange + ", keyExchangeGroup=" + keyExchangeGroup + ", cipher=" + cipher + ", mac=" + mac + ", certificateId=" + certificateId + ", subjectName=" + subjectName + ", sanList=" + sanList + ", issuer=" + issuer + ", validFrom=" + validFrom + ", validTo=" + validTo + ", signedCertificateTimestampList=" + signedCertificateTimestampList + "}";
    }
  }

  /**
   * HTTP response data.
   */
  public static class Response {
    /**
     * Response URL. This URL can be different from CachedResource.url in case of redirect.
     */
    public String url;

    /**
     * HTTP response status code.
     */
    public Double status;

    /**
     * HTTP response status text.
     */
    public String statusText;

    /**
     * HTTP response headers.
     */
    public Map<String, Object> headers;

    /**
     * HTTP response headers text.
     */
    public String headersText;

    /**
     * Resource mimeType as determined by the browser.
     */
    public String mimeType;

    /**
     * Refined HTTP request headers that were actually transmitted over the network.
     */
    public Map<String, Object> requestHeaders;

    /**
     * HTTP request headers text.
     */
    public String requestHeadersText;

    /**
     * Specifies whether physical connection was actually reused for this request.
     */
    public Boolean connectionReused;

    /**
     * Physical connection id that was actually used for this request.
     */
    public Double connectionId;

    /**
     * Remote IP address.
     */
    public String remoteIPAddress;

    /**
     * Remote port.
     */
    public Integer remotePort;

    /**
     * Specifies that the request was served from the disk cache.
     */
    public Boolean fromDiskCache;

    /**
     * Specifies that the request was served from the ServiceWorker.
     */
    public Boolean fromServiceWorker;

    /**
     * Total number of bytes received for this request so far.
     */
    public Double encodedDataLength;

    /**
     * Timing information for the given request.
     */
    public ResourceTiming timing;

    /**
     * Protocol used to fetch this request.
     */
    public String protocol;

    /**
     * Security state of the request resource.
     */
    public String securityState;

    /**
     * Security details for the request.
     */
    public SecurityDetails securityDetails;

    public String toString() {
      return "Response{url=" + url + ", status=" + status + ", statusText=" + statusText + ", headers=" + headers + ", headersText=" + headersText + ", mimeType=" + mimeType + ", requestHeaders=" + requestHeaders + ", requestHeadersText=" + requestHeadersText + ", connectionReused=" + connectionReused + ", connectionId=" + connectionId + ", remoteIPAddress=" + remoteIPAddress + ", remotePort=" + remotePort + ", fromDiskCache=" + fromDiskCache + ", fromServiceWorker=" + fromServiceWorker + ", encodedDataLength=" + encodedDataLength + ", timing=" + timing + ", protocol=" + protocol + ", securityState=" + securityState + ", securityDetails=" + securityDetails + "}";
    }
  }

  /**
   * Fired when page is about to send HTTP request.
   */
  public static class RequestWillBeSent {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Frame identifier.
     */
    public String frameId;

    /**
     * Loader identifier.
     */
    public String loaderId;

    /**
     * URL of the document this request is loaded for.
     */
    public String documentURL;

    /**
     * Request data.
     */
    public Request request;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * UTC Timestamp.
     */
    public Double wallTime;

    /**
     * Request initiator.
     */
    public Initiator initiator;

    /**
     * Redirect response data.
     */
    public Response redirectResponse;

    /**
     * Type of this resource.
     */
    public String type;

    public String toString() {
      return "RequestWillBeSent{requestId=" + requestId + ", frameId=" + frameId + ", loaderId=" + loaderId + ", documentURL=" + documentURL + ", request=" + request + ", timestamp=" + timestamp + ", wallTime=" + wallTime + ", initiator=" + initiator + ", redirectResponse=" + redirectResponse + ", type=" + type + "}";
    }
  }

  /**
   * Fired if request ended up loading from cache.
   */
  public static class RequestServedFromCache {
    /**
     * Request identifier.
     */
    public String requestId;

    public String toString() {
      return "RequestServedFromCache{requestId=" + requestId + "}";
    }
  }

  /**
   * Fired when HTTP response is available.
   */
  public static class ResponseReceived {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Frame identifier.
     */
    public String frameId;

    /**
     * Loader identifier.
     */
    public String loaderId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * Resource type.
     */
    public String type;

    /**
     * Response data.
     */
    public Response response;

    public String toString() {
      return "ResponseReceived{requestId=" + requestId + ", frameId=" + frameId + ", loaderId=" + loaderId + ", timestamp=" + timestamp + ", type=" + type + ", response=" + response + "}";
    }
  }

  /**
   * Fired when data chunk was received over the network.
   */
  public static class DataReceived {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * Data chunk length.
     */
    public Integer dataLength;

    /**
     * Actual bytes received (might be less than dataLength for compressed encodings).
     */
    public Integer encodedDataLength;

    public String toString() {
      return "DataReceived{requestId=" + requestId + ", timestamp=" + timestamp + ", dataLength=" + dataLength + ", encodedDataLength=" + encodedDataLength + "}";
    }
  }

  /**
   * Fired when HTTP request has finished loading.
   */
  public static class LoadingFinished {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * Total number of bytes received for this request.
     */
    public Double encodedDataLength;

    public String toString() {
      return "LoadingFinished{requestId=" + requestId + ", timestamp=" + timestamp + ", encodedDataLength=" + encodedDataLength + "}";
    }
  }

  /**
   * Fired when HTTP request has failed to load.
   */
  public static class LoadingFailed {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * Resource type.
     */
    public String type;

    /**
     * User friendly error message.
     */
    public String errorText;

    /**
     * True if loading was canceled.
     */
    public Boolean canceled;

    /**
     * The reason why loading was blocked, if any.
     */
    public String blockedReason;

    public String toString() {
      return "LoadingFailed{requestId=" + requestId + ", timestamp=" + timestamp + ", type=" + type + ", errorText=" + errorText + ", canceled=" + canceled + ", blockedReason=" + blockedReason + "}";
    }
  }

  /**
   * WebSocket request data.
   */
  public static class WebSocketRequest {
    /**
     * HTTP request headers.
     */
    public Map<String, Object> headers;

    public String toString() {
      return "WebSocketRequest{headers=" + headers + "}";
    }
  }

  /**
   * Fired when WebSocket is about to initiate handshake.
   */
  public static class WebSocketWillSendHandshakeRequest {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * UTC Timestamp.
     */
    public Double wallTime;

    /**
     * WebSocket request data.
     */
    public WebSocketRequest request;

    public String toString() {
      return "WebSocketWillSendHandshakeRequest{requestId=" + requestId + ", timestamp=" + timestamp + ", wallTime=" + wallTime + ", request=" + request + "}";
    }
  }

  /**
   * WebSocket response data.
   */
  public static class WebSocketResponse {
    /**
     * HTTP response status code.
     */
    public Double status;

    /**
     * HTTP response status text.
     */
    public String statusText;

    /**
     * HTTP response headers.
     */
    public Map<String, Object> headers;

    /**
     * HTTP response headers text.
     */
    public String headersText;

    /**
     * HTTP request headers.
     */
    public Map<String, Object> requestHeaders;

    /**
     * HTTP request headers text.
     */
    public String requestHeadersText;

    public String toString() {
      return "WebSocketResponse{status=" + status + ", statusText=" + statusText + ", headers=" + headers + ", headersText=" + headersText + ", requestHeaders=" + requestHeaders + ", requestHeadersText=" + requestHeadersText + "}";
    }
  }

  /**
   * Fired when WebSocket handshake response becomes available.
   */
  public static class WebSocketHandshakeResponseReceived {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * WebSocket response data.
     */
    public WebSocketResponse response;

    public String toString() {
      return "WebSocketHandshakeResponseReceived{requestId=" + requestId + ", timestamp=" + timestamp + ", response=" + response + "}";
    }
  }

  /**
   * Fired upon WebSocket creation.
   */
  public static class WebSocketCreated {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * WebSocket request URL.
     */
    public String url;

    /**
     * Request initiator.
     */
    public Initiator initiator;

    public String toString() {
      return "WebSocketCreated{requestId=" + requestId + ", url=" + url + ", initiator=" + initiator + "}";
    }
  }

  /**
   * Fired when WebSocket is closed.
   */
  public static class WebSocketClosed {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    public String toString() {
      return "WebSocketClosed{requestId=" + requestId + ", timestamp=" + timestamp + "}";
    }
  }

  /**
   * WebSocket frame data.
   */
  public static class WebSocketFrame {
    /**
     * WebSocket frame opcode.
     */
    public Double opcode;

    /**
     * WebSocke frame mask.
     */
    public Boolean mask;

    /**
     * WebSocke frame payload data.
     */
    public String payloadData;

    public String toString() {
      return "WebSocketFrame{opcode=" + opcode + ", mask=" + mask + ", payloadData=" + payloadData + "}";
    }
  }

  /**
   * Fired when WebSocket frame is received.
   */
  public static class WebSocketFrameReceived {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * WebSocket response data.
     */
    public WebSocketFrame response;

    public String toString() {
      return "WebSocketFrameReceived{requestId=" + requestId + ", timestamp=" + timestamp + ", response=" + response + "}";
    }
  }

  /**
   * Fired when WebSocket frame error occurs.
   */
  public static class WebSocketFrameError {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * WebSocket frame error message.
     */
    public String errorMessage;

    public String toString() {
      return "WebSocketFrameError{requestId=" + requestId + ", timestamp=" + timestamp + ", errorMessage=" + errorMessage + "}";
    }
  }

  /**
   * Fired when WebSocket frame is sent.
   */
  public static class WebSocketFrameSent {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * WebSocket response data.
     */
    public WebSocketFrame response;

    public String toString() {
      return "WebSocketFrameSent{requestId=" + requestId + ", timestamp=" + timestamp + ", response=" + response + "}";
    }
  }

  /**
   * Fired when EventSource message is received.
   */
  public static class EventSourceMessageReceived {
    /**
     * Request identifier.
     */
    public String requestId;

    /**
     * Timestamp.
     */
    public Double timestamp;

    /**
     * Message type.
     */
    public String eventName;

    /**
     * Message identifier.
     */
    public String eventId;

    /**
     * Message content.
     */
    public String data;

    public String toString() {
      return "EventSourceMessageReceived{requestId=" + requestId + ", timestamp=" + timestamp + ", eventName=" + eventName + ", eventId=" + eventId + ", data=" + data + "}";
    }
  }
}
