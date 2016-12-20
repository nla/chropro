package chropro;

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
public class LogDomain {
  private RpcClient rpcClient;

  public LogDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables log domain, sends the entries collected so far to the client by means of the <code>entryAdded</code> notification.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Log.enable", params, Void.class);
  }

  /**
   * Disables log domain, prevents further log entries from being reported to the client.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Log.disable", params, Void.class);
  }

  /**
   * Clears the log.
   */
  public CompletableFuture<Void> clear() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Log.clear", params, Void.class);
  }

  /**
   * start violation reporting.
   * @param config Configuration for violations.
   */
  public CompletableFuture<Void> startViolationsReport(@NotNull List<ViolationSetting> config) {
    Map<String,Object> params = new HashMap<>();
    params.put("config", config);
    return rpcClient.call("Log.startViolationsReport", params, Void.class);
  }

  /**
   * Stop violation reporting.
   */
  public CompletableFuture<Void> stopViolationsReport() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Log.stopViolationsReport", params, Void.class);
  }

  /**
   * Issued when new message was logged.
   */
  public void onEntryAdded(Consumer<EntryAdded> listener) {
    rpcClient.addEventListener("Log.entryAdded", listener, EntryAdded.class);
  }

  /**
   * Issued when new message was logged.
   */
  public CompletableFuture<EntryAdded> onEntryAdded() {
    return rpcClient.eventFuture("Log.entryAdded", EntryAdded.class);
  }

  /**
   * Violation configuration setting.
   */
  public static class ViolationSetting {
    /**
     * Violation type.
     */
    public String name;

    /**
     * Time threshold to trigger upon.
     */
    public Double threshold;

    public String toString() {
      return "ViolationSetting{name=" + name + ", threshold=" + threshold + "}";
    }
  }

  /**
   * Log entry.
   */
  public static class LogEntry {
    /**
     * Log entry source.
     */
    public String source;

    /**
     * Log entry severity.
     */
    public String level;

    /**
     * Logged text.
     */
    public String text;

    /**
     * Timestamp when this entry was added.
     */
    public Double timestamp;

    /**
     * URL of the resource if known.
     */
    public String url;

    /**
     * Line number in the resource.
     */
    public Integer lineNumber;

    /**
     * JavaScript stack trace.
     */
    public RuntimeDomain.StackTrace stackTrace;

    /**
     * Identifier of the network request associated with this entry.
     */
    public String networkRequestId;

    /**
     * Identifier of the worker associated with this entry.
     */
    public String workerId;

    public String toString() {
      return "LogEntry{source=" + source + ", level=" + level + ", text=" + text + ", timestamp=" + timestamp + ", url=" + url + ", lineNumber=" + lineNumber + ", stackTrace=" + stackTrace + ", networkRequestId=" + networkRequestId + ", workerId=" + workerId + "}";
    }
  }

  /**
   * Issued when new message was logged.
   */
  public static class EntryAdded {
    /**
     * The entry.
     */
    public LogEntry entry;

    public String toString() {
      return "EntryAdded{entry=" + entry + "}";
    }
  }
}
