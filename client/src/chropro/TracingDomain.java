package chropro;

import java.lang.Boolean;
import java.lang.Double;
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
public class TracingDomain {
  private RpcClient rpcClient;

  public TracingDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Start trace events collection.
   * @param categories Category/tag filter
   * @param options Tracing options
   * @param bufferUsageReportingInterval If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
   * @param transferMode Whether to report trace events as series of dataCollected events or to save trace to a stream (defaults to <code>ReportEvents</code>).
   * @param traceConfig 
   */
  public CompletableFuture<Void> start(@Nullable String categories, @Nullable String options, @Nullable Double bufferUsageReportingInterval, @Nullable String transferMode, @Nullable TraceConfig traceConfig) {
    Map<String,Object> params = new HashMap<>();
    params.put("categories", categories);
    params.put("options", options);
    params.put("bufferUsageReportingInterval", bufferUsageReportingInterval);
    params.put("transferMode", transferMode);
    params.put("traceConfig", traceConfig);
    return rpcClient.call("Tracing.start", params, Void.class);
  }

  /**
   * Stop trace events collection.
   */
  public CompletableFuture<Void> end() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Tracing.end", params, Void.class);
  }

  /**
   * Gets supported tracing categories.
   */
  public CompletableFuture<GetCategories> getCategories() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Tracing.getCategories", params, GetCategories.class);
  }

  /**
   * Request a global memory dump.
   */
  public CompletableFuture<RequestMemoryDump> requestMemoryDump() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Tracing.requestMemoryDump", params, RequestMemoryDump.class);
  }

  /**
   * Record a clock sync marker in the trace.
   * @param syncId The ID of this clock sync marker
   */
  public CompletableFuture<Void> recordClockSyncMarker(@NotNull String syncId) {
    Map<String,Object> params = new HashMap<>();
    params.put("syncId", syncId);
    return rpcClient.call("Tracing.recordClockSyncMarker", params, Void.class);
  }

  /**
   * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
   */
  public void onDataCollected(Consumer<DataCollected> listener) {
    rpcClient.addEventListener("Tracing.dataCollected", listener, DataCollected.class);
  }

  /**
   * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
   */
  public CompletableFuture<DataCollected> onDataCollected() {
    return rpcClient.eventFuture("Tracing.dataCollected", DataCollected.class);
  }

  /**
   * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
   */
  public void onTracingComplete(Consumer<TracingComplete> listener) {
    rpcClient.addEventListener("Tracing.tracingComplete", listener, TracingComplete.class);
  }

  /**
   * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
   */
  public CompletableFuture<TracingComplete> onTracingComplete() {
    return rpcClient.eventFuture("Tracing.tracingComplete", TracingComplete.class);
  }

  public void onBufferUsage(Consumer<BufferUsage> listener) {
    rpcClient.addEventListener("Tracing.bufferUsage", listener, BufferUsage.class);
  }

  public CompletableFuture<BufferUsage> onBufferUsage() {
    return rpcClient.eventFuture("Tracing.bufferUsage", BufferUsage.class);
  }

  public static class TraceConfig {
    /**
     * Controls how the trace buffer stores data.
     */
    public String recordMode;

    /**
     * Turns on JavaScript stack sampling.
     */
    public Boolean enableSampling;

    /**
     * Turns on system tracing.
     */
    public Boolean enableSystrace;

    /**
     * Turns on argument filter.
     */
    public Boolean enableArgumentFilter;

    /**
     * Included category filters.
     */
    public List<String> includedCategories;

    /**
     * Excluded category filters.
     */
    public List<String> excludedCategories;

    /**
     * Configuration to synthesize the delays in tracing.
     */
    public List<String> syntheticDelays;

    /**
     * Configuration for memory dump triggers. Used only when "memory-infra" category is enabled.
     */
    public Map<String, Object> memoryDumpConfig;

    public String toString() {
      return "TraceConfig{recordMode=" + recordMode + ", enableSampling=" + enableSampling + ", enableSystrace=" + enableSystrace + ", enableArgumentFilter=" + enableArgumentFilter + ", includedCategories=" + includedCategories + ", excludedCategories=" + excludedCategories + ", syntheticDelays=" + syntheticDelays + ", memoryDumpConfig=" + memoryDumpConfig + "}";
    }
  }

  public static class GetCategories {
    /**
     * A list of supported tracing categories.
     */
    public List<String> categories;

    public String toString() {
      return "GetCategories{categories=" + categories + "}";
    }
  }

  public static class RequestMemoryDump {
    /**
     * GUID of the resulting global memory dump.
     */
    public String dumpGuid;

    /**
     * True iff the global memory dump succeeded.
     */
    public Boolean success;

    public String toString() {
      return "RequestMemoryDump{dumpGuid=" + dumpGuid + ", success=" + success + "}";
    }
  }

  /**
   * Contains an bucket of collected trace events. When tracing is stopped collected events will be send as a sequence of dataCollected events followed by tracingComplete event.
   */
  public static class DataCollected {
    public List<Map<String, Object>> value;

    public String toString() {
      return "DataCollected{value=" + value + "}";
    }
  }

  /**
   * Signals that tracing is stopped and there is no trace buffers pending flush, all data were delivered via dataCollected events.
   */
  public static class TracingComplete {
    /**
     * A handle of the stream that holds resulting trace data.
     */
    public String stream;

    public String toString() {
      return "TracingComplete{stream=" + stream + "}";
    }
  }

  public static class BufferUsage {
    /**
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
     */
    public Double percentFull;

    /**
     * An approximate number of events in the trace log.
     */
    public Double eventCount;

    /**
     * A number in range [0..1] that indicates the used size of event buffer as a fraction of its total size.
     */
    public Double value;

    public String toString() {
      return "BufferUsage{percentFull=" + percentFull + ", eventCount=" + eventCount + ", value=" + value + "}";
    }
  }
}
