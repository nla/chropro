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
public class HeapProfilerDomain {
  private RpcClient rpcClient;

  public HeapProfilerDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("HeapProfiler.enable", params, Void.class);
  }

  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("HeapProfiler.disable", params, Void.class);
  }

  public CompletableFuture<Void> startTrackingHeapObjects(@Nullable Boolean trackAllocations) {
    Map<String,Object> params = new HashMap<>();
    params.put("trackAllocations", trackAllocations);
    return rpcClient.call("HeapProfiler.startTrackingHeapObjects", params, Void.class);
  }

  /**
   * @param reportProgress If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken when the tracking is stopped.
   */
  public CompletableFuture<Void> stopTrackingHeapObjects(@Nullable Boolean reportProgress) {
    Map<String,Object> params = new HashMap<>();
    params.put("reportProgress", reportProgress);
    return rpcClient.call("HeapProfiler.stopTrackingHeapObjects", params, Void.class);
  }

  /**
   * @param reportProgress If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
   */
  public CompletableFuture<Void> takeHeapSnapshot(@Nullable Boolean reportProgress) {
    Map<String,Object> params = new HashMap<>();
    params.put("reportProgress", reportProgress);
    return rpcClient.call("HeapProfiler.takeHeapSnapshot", params, Void.class);
  }

  public CompletableFuture<Void> collectGarbage() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("HeapProfiler.collectGarbage", params, Void.class);
  }

  /**
   * @param objectGroup Symbolic group name that can be used to release multiple objects.
   */
  public CompletableFuture<GetObjectByHeapObjectId> getObjectByHeapObjectId(@NotNull String objectId, @Nullable String objectGroup) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    params.put("objectGroup", objectGroup);
    return rpcClient.call("HeapProfiler.getObjectByHeapObjectId", params, GetObjectByHeapObjectId.class);
  }

  /**
   * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
   * @param heapObjectId Heap snapshot object id to be accessible by means of $x command line API.
   */
  public CompletableFuture<Void> addInspectedHeapObject(@NotNull String heapObjectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("heapObjectId", heapObjectId);
    return rpcClient.call("HeapProfiler.addInspectedHeapObject", params, Void.class);
  }

  /**
   * @param objectId Identifier of the object to get heap object id for.
   */
  public CompletableFuture<GetHeapObjectId> getHeapObjectId(@NotNull String objectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    return rpcClient.call("HeapProfiler.getHeapObjectId", params, GetHeapObjectId.class);
  }

  /**
   * @param samplingInterval Average sample interval in bytes. Poisson distribution is used for the intervals. The default value is 32768 bytes.
   */
  public CompletableFuture<Void> startSampling(@Nullable Double samplingInterval) {
    Map<String,Object> params = new HashMap<>();
    params.put("samplingInterval", samplingInterval);
    return rpcClient.call("HeapProfiler.startSampling", params, Void.class);
  }

  public CompletableFuture<StopSampling> stopSampling() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("HeapProfiler.stopSampling", params, StopSampling.class);
  }

  public void onAddHeapSnapshotChunk(Consumer<AddHeapSnapshotChunk> listener) {
    rpcClient.addEventListener("HeapProfiler.addHeapSnapshotChunk", listener, AddHeapSnapshotChunk.class);
  }

  public CompletableFuture<AddHeapSnapshotChunk> onAddHeapSnapshotChunk() {
    return rpcClient.eventFuture("HeapProfiler.addHeapSnapshotChunk", AddHeapSnapshotChunk.class);
  }

  public void onResetProfiles(Consumer<ResetProfiles> listener) {
    rpcClient.addEventListener("HeapProfiler.resetProfiles", listener, ResetProfiles.class);
  }

  public CompletableFuture<ResetProfiles> onResetProfiles() {
    return rpcClient.eventFuture("HeapProfiler.resetProfiles", ResetProfiles.class);
  }

  public void onReportHeapSnapshotProgress(Consumer<ReportHeapSnapshotProgress> listener) {
    rpcClient.addEventListener("HeapProfiler.reportHeapSnapshotProgress", listener, ReportHeapSnapshotProgress.class);
  }

  public CompletableFuture<ReportHeapSnapshotProgress> onReportHeapSnapshotProgress() {
    return rpcClient.eventFuture("HeapProfiler.reportHeapSnapshotProgress", ReportHeapSnapshotProgress.class);
  }

  /**
   * If heap objects tracking has been started then backend regulary sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
   */
  public void onLastSeenObjectId(Consumer<LastSeenObjectId> listener) {
    rpcClient.addEventListener("HeapProfiler.lastSeenObjectId", listener, LastSeenObjectId.class);
  }

  /**
   * If heap objects tracking has been started then backend regulary sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
   */
  public CompletableFuture<LastSeenObjectId> onLastSeenObjectId() {
    return rpcClient.eventFuture("HeapProfiler.lastSeenObjectId", LastSeenObjectId.class);
  }

  /**
   * If heap objects tracking has been started then backend may send update for one or more fragments
   */
  public void onHeapStatsUpdate(Consumer<HeapStatsUpdate> listener) {
    rpcClient.addEventListener("HeapProfiler.heapStatsUpdate", listener, HeapStatsUpdate.class);
  }

  /**
   * If heap objects tracking has been started then backend may send update for one or more fragments
   */
  public CompletableFuture<HeapStatsUpdate> onHeapStatsUpdate() {
    return rpcClient.eventFuture("HeapProfiler.heapStatsUpdate", HeapStatsUpdate.class);
  }

  public static class GetObjectByHeapObjectId {
    /**
     * Evaluation result.
     */
    public RuntimeDomain.RemoteObject result;

    public String toString() {
      return "GetObjectByHeapObjectId{result=" + result + "}";
    }
  }

  public static class GetHeapObjectId {
    /**
     * Id of the heap snapshot object corresponding to the passed remote object id.
     */
    public String heapSnapshotObjectId;

    public String toString() {
      return "GetHeapObjectId{heapSnapshotObjectId=" + heapSnapshotObjectId + "}";
    }
  }

  /**
   * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
   */
  public static class SamplingHeapProfileNode {
    /**
     * Function location.
     */
    public RuntimeDomain.CallFrame callFrame;

    /**
     * Allocations size in bytes for the node excluding children.
     */
    public Double selfSize;

    /**
     * Child nodes.
     */
    public List<SamplingHeapProfileNode> children;

    public String toString() {
      return "SamplingHeapProfileNode{callFrame=" + callFrame + ", selfSize=" + selfSize + ", children=" + children + "}";
    }
  }

  /**
   * Profile.
   */
  public static class SamplingHeapProfile {
    public SamplingHeapProfileNode head;

    public String toString() {
      return "SamplingHeapProfile{head=" + head + "}";
    }
  }

  public static class StopSampling {
    /**
     * Recorded sampling heap profile.
     */
    public SamplingHeapProfile profile;

    public String toString() {
      return "StopSampling{profile=" + profile + "}";
    }
  }

  public static class AddHeapSnapshotChunk {
    public String chunk;

    public String toString() {
      return "AddHeapSnapshotChunk{chunk=" + chunk + "}";
    }
  }

  public static class ResetProfiles {
    public String toString() {
      return "ResetProfiles{}";
    }
  }

  public static class ReportHeapSnapshotProgress {
    public Integer done;

    public Integer total;

    public Boolean finished;

    public String toString() {
      return "ReportHeapSnapshotProgress{done=" + done + ", total=" + total + ", finished=" + finished + "}";
    }
  }

  /**
   * If heap objects tracking has been started then backend regulary sends a current value for last seen object id and corresponding timestamp. If the were changes in the heap since last event then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
   */
  public static class LastSeenObjectId {
    public Integer lastSeenObjectId;

    public Double timestamp;

    public String toString() {
      return "LastSeenObjectId{lastSeenObjectId=" + lastSeenObjectId + ", timestamp=" + timestamp + "}";
    }
  }

  /**
   * If heap objects tracking has been started then backend may send update for one or more fragments
   */
  public static class HeapStatsUpdate {
    /**
     * An array of triplets. Each triplet describes a fragment. The first integer is the fragment index, the second integer is a total count of objects for the fragment, the third integer is a total size of the objects for the fragment.
     */
    public List<Integer> statsUpdate;

    public String toString() {
      return "HeapStatsUpdate{statsUpdate=" + statsUpdate + "}";
    }
  }
}
