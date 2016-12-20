package chropro;

import java.lang.Boolean;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class RenderingDomain {
  private RpcClient rpcClient;

  public RenderingDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Requests that backend shows paint rectangles
   * @param result True for showing paint rectangles
   */
  public CompletableFuture<Void> setShowPaintRects(@NotNull Boolean result) {
    Map<String,Object> params = new HashMap<>();
    params.put("result", result);
    return rpcClient.call("Rendering.setShowPaintRects", params, Void.class);
  }

  /**
   * Requests that backend shows debug borders on layers
   * @param show True for showing debug borders
   */
  public CompletableFuture<Void> setShowDebugBorders(@NotNull Boolean show) {
    Map<String,Object> params = new HashMap<>();
    params.put("show", show);
    return rpcClient.call("Rendering.setShowDebugBorders", params, Void.class);
  }

  /**
   * Requests that backend shows the FPS counter
   * @param show True for showing the FPS counter
   */
  public CompletableFuture<Void> setShowFPSCounter(@NotNull Boolean show) {
    Map<String,Object> params = new HashMap<>();
    params.put("show", show);
    return rpcClient.call("Rendering.setShowFPSCounter", params, Void.class);
  }

  /**
   * Requests that backend shows scroll bottleneck rects
   * @param show True for showing scroll bottleneck rects
   */
  public CompletableFuture<Void> setShowScrollBottleneckRects(@NotNull Boolean show) {
    Map<String,Object> params = new HashMap<>();
    params.put("show", show);
    return rpcClient.call("Rendering.setShowScrollBottleneckRects", params, Void.class);
  }

  /**
   * Paints viewport size upon main frame resize.
   * @param show Whether to paint size or not.
   */
  public CompletableFuture<Void> setShowViewportSizeOnResize(@NotNull Boolean show) {
    Map<String,Object> params = new HashMap<>();
    params.put("show", show);
    return rpcClient.call("Rendering.setShowViewportSizeOnResize", params, Void.class);
  }
}
