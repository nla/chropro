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
    date = "2016-12-20T03:00:26.964Z"
)
public class ServiceWorkerDomain {
  private RpcClient rpcClient;

  public ServiceWorkerDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("ServiceWorker.enable", params, Void.class);
  }

  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("ServiceWorker.disable", params, Void.class);
  }

  public CompletableFuture<Void> unregister(@NotNull String scopeURL) {
    Map<String,Object> params = new HashMap<>();
    params.put("scopeURL", scopeURL);
    return rpcClient.call("ServiceWorker.unregister", params, Void.class);
  }

  public CompletableFuture<Void> updateRegistration(@NotNull String scopeURL) {
    Map<String,Object> params = new HashMap<>();
    params.put("scopeURL", scopeURL);
    return rpcClient.call("ServiceWorker.updateRegistration", params, Void.class);
  }

  public CompletableFuture<Void> startWorker(@NotNull String scopeURL) {
    Map<String,Object> params = new HashMap<>();
    params.put("scopeURL", scopeURL);
    return rpcClient.call("ServiceWorker.startWorker", params, Void.class);
  }

  public CompletableFuture<Void> skipWaiting(@NotNull String scopeURL) {
    Map<String,Object> params = new HashMap<>();
    params.put("scopeURL", scopeURL);
    return rpcClient.call("ServiceWorker.skipWaiting", params, Void.class);
  }

  public CompletableFuture<Void> stopWorker(@NotNull String versionId) {
    Map<String,Object> params = new HashMap<>();
    params.put("versionId", versionId);
    return rpcClient.call("ServiceWorker.stopWorker", params, Void.class);
  }

  public CompletableFuture<Void> inspectWorker(@NotNull String versionId) {
    Map<String,Object> params = new HashMap<>();
    params.put("versionId", versionId);
    return rpcClient.call("ServiceWorker.inspectWorker", params, Void.class);
  }

  public CompletableFuture<Void> setForceUpdateOnPageLoad(@NotNull Boolean forceUpdateOnPageLoad) {
    Map<String,Object> params = new HashMap<>();
    params.put("forceUpdateOnPageLoad", forceUpdateOnPageLoad);
    return rpcClient.call("ServiceWorker.setForceUpdateOnPageLoad", params, Void.class);
  }

  public CompletableFuture<Void> deliverPushMessage(@NotNull String origin, @NotNull String registrationId, @NotNull String data) {
    Map<String,Object> params = new HashMap<>();
    params.put("origin", origin);
    params.put("registrationId", registrationId);
    params.put("data", data);
    return rpcClient.call("ServiceWorker.deliverPushMessage", params, Void.class);
  }

  public CompletableFuture<Void> dispatchSyncEvent(@NotNull String origin, @NotNull String registrationId, @NotNull String tag, @NotNull Boolean lastChance) {
    Map<String,Object> params = new HashMap<>();
    params.put("origin", origin);
    params.put("registrationId", registrationId);
    params.put("tag", tag);
    params.put("lastChance", lastChance);
    return rpcClient.call("ServiceWorker.dispatchSyncEvent", params, Void.class);
  }

  public void onWorkerRegistrationUpdated(Consumer<WorkerRegistrationUpdated> listener) {
    rpcClient.addEventListener("ServiceWorker.workerRegistrationUpdated", listener, WorkerRegistrationUpdated.class);
  }

  public CompletableFuture<WorkerRegistrationUpdated> onWorkerRegistrationUpdated() {
    return rpcClient.eventFuture("ServiceWorker.workerRegistrationUpdated", WorkerRegistrationUpdated.class);
  }

  public void onWorkerVersionUpdated(Consumer<WorkerVersionUpdated> listener) {
    rpcClient.addEventListener("ServiceWorker.workerVersionUpdated", listener, WorkerVersionUpdated.class);
  }

  public CompletableFuture<WorkerVersionUpdated> onWorkerVersionUpdated() {
    return rpcClient.eventFuture("ServiceWorker.workerVersionUpdated", WorkerVersionUpdated.class);
  }

  public void onWorkerErrorReported(Consumer<WorkerErrorReported> listener) {
    rpcClient.addEventListener("ServiceWorker.workerErrorReported", listener, WorkerErrorReported.class);
  }

  public CompletableFuture<WorkerErrorReported> onWorkerErrorReported() {
    return rpcClient.eventFuture("ServiceWorker.workerErrorReported", WorkerErrorReported.class);
  }

  /**
   * ServiceWorker registration.
   */
  public static class ServiceWorkerRegistration {
    public String registrationId;

    public String scopeURL;

    public Boolean isDeleted;

    public String toString() {
      return "ServiceWorkerRegistration{registrationId=" + registrationId + ", scopeURL=" + scopeURL + ", isDeleted=" + isDeleted + "}";
    }
  }

  public static class WorkerRegistrationUpdated {
    public List<ServiceWorkerRegistration> registrations;

    public String toString() {
      return "WorkerRegistrationUpdated{registrations=" + registrations + "}";
    }
  }

  /**
   * ServiceWorker version.
   */
  public static class ServiceWorkerVersion {
    public String versionId;

    public String registrationId;

    public String scriptURL;

    public String runningStatus;

    public String status;

    /**
     * The Last-Modified header value of the main script.
     */
    public Double scriptLastModified;

    /**
     * The time at which the response headers of the main script were received from the server.  For cached script it is the last time the cache entry was validated.
     */
    public Double scriptResponseTime;

    public List<String> controlledClients;

    public String targetId;

    public String toString() {
      return "ServiceWorkerVersion{versionId=" + versionId + ", registrationId=" + registrationId + ", scriptURL=" + scriptURL + ", runningStatus=" + runningStatus + ", status=" + status + ", scriptLastModified=" + scriptLastModified + ", scriptResponseTime=" + scriptResponseTime + ", controlledClients=" + controlledClients + ", targetId=" + targetId + "}";
    }
  }

  public static class WorkerVersionUpdated {
    public List<ServiceWorkerVersion> versions;

    public String toString() {
      return "WorkerVersionUpdated{versions=" + versions + "}";
    }
  }

  /**
   * ServiceWorker error message.
   */
  public static class ServiceWorkerErrorMessage {
    public String errorMessage;

    public String registrationId;

    public String versionId;

    public String sourceURL;

    public Integer lineNumber;

    public Integer columnNumber;

    public String toString() {
      return "ServiceWorkerErrorMessage{errorMessage=" + errorMessage + ", registrationId=" + registrationId + ", versionId=" + versionId + ", sourceURL=" + sourceURL + ", lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + "}";
    }
  }

  public static class WorkerErrorReported {
    public ServiceWorkerErrorMessage errorMessage;

    public String toString() {
      return "WorkerErrorReported{errorMessage=" + errorMessage + "}";
    }
  }
}
