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
public class LayerTreeDomain {
  private RpcClient rpcClient;

  public LayerTreeDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables compositing tree inspection.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("LayerTree.enable", params, Void.class);
  }

  /**
   * Disables compositing tree inspection.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("LayerTree.disable", params, Void.class);
  }

  /**
   * Provides the reasons why the given layer was composited.
   * @param layerId The id of the layer for which we want to get the reasons it was composited.
   */
  public CompletableFuture<CompositingReasons> compositingReasons(@NotNull String layerId) {
    Map<String,Object> params = new HashMap<>();
    params.put("layerId", layerId);
    return rpcClient.call("LayerTree.compositingReasons", params, CompositingReasons.class);
  }

  /**
   * Returns the layer snapshot identifier.
   * @param layerId The id of the layer.
   */
  public CompletableFuture<MakeSnapshot> makeSnapshot(@NotNull String layerId) {
    Map<String,Object> params = new HashMap<>();
    params.put("layerId", layerId);
    return rpcClient.call("LayerTree.makeSnapshot", params, MakeSnapshot.class);
  }

  /**
   * Returns the snapshot identifier.
   * @param tiles An array of tiles composing the snapshot.
   */
  public CompletableFuture<LoadSnapshot> loadSnapshot(@NotNull List<PictureTile> tiles) {
    Map<String,Object> params = new HashMap<>();
    params.put("tiles", tiles);
    return rpcClient.call("LayerTree.loadSnapshot", params, LoadSnapshot.class);
  }

  /**
   * Releases layer snapshot captured by the back-end.
   * @param snapshotId The id of the layer snapshot.
   */
  public CompletableFuture<Void> releaseSnapshot(@NotNull String snapshotId) {
    Map<String,Object> params = new HashMap<>();
    params.put("snapshotId", snapshotId);
    return rpcClient.call("LayerTree.releaseSnapshot", params, Void.class);
  }

  /**
   * @param snapshotId The id of the layer snapshot.
   * @param minRepeatCount The maximum number of times to replay the snapshot (1, if not specified).
   * @param minDuration The minimum duration (in seconds) to replay the snapshot.
   * @param clipRect The clip rectangle to apply when replaying the snapshot.
   */
  public CompletableFuture<ProfileSnapshot> profileSnapshot(@NotNull String snapshotId, @Nullable Integer minRepeatCount, @Nullable Double minDuration, @Nullable DOMDomain.Rect clipRect) {
    Map<String,Object> params = new HashMap<>();
    params.put("snapshotId", snapshotId);
    params.put("minRepeatCount", minRepeatCount);
    params.put("minDuration", minDuration);
    params.put("clipRect", clipRect);
    return rpcClient.call("LayerTree.profileSnapshot", params, ProfileSnapshot.class);
  }

  /**
   * Replays the layer snapshot and returns the resulting bitmap.
   * @param snapshotId The id of the layer snapshot.
   * @param fromStep The first step to replay from (replay from the very start if not specified).
   * @param toStep The last step to replay to (replay till the end if not specified).
   * @param scale The scale to apply while replaying (defaults to 1).
   */
  public CompletableFuture<ReplaySnapshot> replaySnapshot(@NotNull String snapshotId, @Nullable Integer fromStep, @Nullable Integer toStep, @Nullable Double scale) {
    Map<String,Object> params = new HashMap<>();
    params.put("snapshotId", snapshotId);
    params.put("fromStep", fromStep);
    params.put("toStep", toStep);
    params.put("scale", scale);
    return rpcClient.call("LayerTree.replaySnapshot", params, ReplaySnapshot.class);
  }

  /**
   * Replays the layer snapshot and returns canvas log.
   * @param snapshotId The id of the layer snapshot.
   */
  public CompletableFuture<SnapshotCommandLog> snapshotCommandLog(@NotNull String snapshotId) {
    Map<String,Object> params = new HashMap<>();
    params.put("snapshotId", snapshotId);
    return rpcClient.call("LayerTree.snapshotCommandLog", params, SnapshotCommandLog.class);
  }

  public void onLayerTreeDidChange(Consumer<LayerTreeDidChange> listener) {
    rpcClient.addEventListener("LayerTree.layerTreeDidChange", listener, LayerTreeDidChange.class);
  }

  public CompletableFuture<LayerTreeDidChange> onLayerTreeDidChange() {
    return rpcClient.eventFuture("LayerTree.layerTreeDidChange", LayerTreeDidChange.class);
  }

  public void onLayerPainted(Consumer<LayerPainted> listener) {
    rpcClient.addEventListener("LayerTree.layerPainted", listener, LayerPainted.class);
  }

  public CompletableFuture<LayerPainted> onLayerPainted() {
    return rpcClient.eventFuture("LayerTree.layerPainted", LayerPainted.class);
  }

  public static class CompositingReasons {
    /**
     * A list of strings specifying reasons for the given layer to become composited.
     */
    public List<String> compositingReasons;

    public String toString() {
      return "CompositingReasons{compositingReasons=" + compositingReasons + "}";
    }
  }

  public static class MakeSnapshot {
    /**
     * The id of the layer snapshot.
     */
    public String snapshotId;

    public String toString() {
      return "MakeSnapshot{snapshotId=" + snapshotId + "}";
    }
  }

  public static class LoadSnapshot {
    /**
     * The id of the snapshot.
     */
    public String snapshotId;

    public String toString() {
      return "LoadSnapshot{snapshotId=" + snapshotId + "}";
    }
  }

  /**
   * Serialized fragment of layer picture along with its offset within the layer.
   */
  public static class PictureTile {
    /**
     * Offset from owning layer left boundary
     */
    public Double x;

    /**
     * Offset from owning layer top boundary
     */
    public Double y;

    /**
     * Base64-encoded snapshot data.
     */
    public String picture;

    public String toString() {
      return "PictureTile{x=" + x + ", y=" + y + ", picture=" + picture + "}";
    }
  }

  public static class ProfileSnapshot {
    /**
     * The array of paint profiles, one per run.
     */
    public List<List<Double>> timings;

    public String toString() {
      return "ProfileSnapshot{timings=" + timings + "}";
    }
  }

  public static class ReplaySnapshot {
    /**
     * A data: URL for resulting image.
     */
    public String dataURL;

    public String toString() {
      return "ReplaySnapshot{dataURL=" + dataURL + "}";
    }
  }

  public static class SnapshotCommandLog {
    /**
     * The array of canvas function calls.
     */
    public List<Map<String, Object>> commandLog;

    public String toString() {
      return "SnapshotCommandLog{commandLog=" + commandLog + "}";
    }
  }

  /**
   * Rectangle where scrolling happens on the main thread.
   */
  public static class ScrollRect {
    /**
     * Rectangle itself.
     */
    public DOMDomain.Rect rect;

    /**
     * Reason for rectangle to force scrolling on the main thread
     */
    public String type;

    public String toString() {
      return "ScrollRect{rect=" + rect + ", type=" + type + "}";
    }
  }

  /**
   * Information about a compositing layer.
   */
  public static class Layer {
    /**
     * The unique id for this layer.
     */
    public String layerId;

    /**
     * The id of parent (not present for root).
     */
    public String parentLayerId;

    /**
     * The backend id for the node associated with this layer.
     */
    public Integer backendNodeId;

    /**
     * Offset from parent layer, X coordinate.
     */
    public Double offsetX;

    /**
     * Offset from parent layer, Y coordinate.
     */
    public Double offsetY;

    /**
     * Layer width.
     */
    public Double width;

    /**
     * Layer height.
     */
    public Double height;

    /**
     * Transformation matrix for layer, default is identity matrix
     */
    public List<Double> transform;

    /**
     * Transform anchor point X, absent if no transform specified
     */
    public Double anchorX;

    /**
     * Transform anchor point Y, absent if no transform specified
     */
    public Double anchorY;

    /**
     * Transform anchor point Z, absent if no transform specified
     */
    public Double anchorZ;

    /**
     * Indicates how many time this layer has painted.
     */
    public Integer paintCount;

    /**
     * Indicates whether this layer hosts any content, rather than being used for transform/scrolling purposes only.
     */
    public Boolean drawsContent;

    /**
     * Set if layer is not visible.
     */
    public Boolean invisible;

    /**
     * Rectangles scrolling on main thread only.
     */
    public List<ScrollRect> scrollRects;

    public String toString() {
      return "Layer{layerId=" + layerId + ", parentLayerId=" + parentLayerId + ", backendNodeId=" + backendNodeId + ", offsetX=" + offsetX + ", offsetY=" + offsetY + ", width=" + width + ", height=" + height + ", transform=" + transform + ", anchorX=" + anchorX + ", anchorY=" + anchorY + ", anchorZ=" + anchorZ + ", paintCount=" + paintCount + ", drawsContent=" + drawsContent + ", invisible=" + invisible + ", scrollRects=" + scrollRects + "}";
    }
  }

  public static class LayerTreeDidChange {
    /**
     * Layer tree, absent if not in the comspositing mode.
     */
    public List<Layer> layers;

    public String toString() {
      return "LayerTreeDidChange{layers=" + layers + "}";
    }
  }

  public static class LayerPainted {
    /**
     * The id of the painted layer.
     */
    public String layerId;

    /**
     * Clip rectangle.
     */
    public DOMDomain.Rect clip;

    public String toString() {
      return "LayerPainted{layerId=" + layerId + ", clip=" + clip + "}";
    }
  }
}
