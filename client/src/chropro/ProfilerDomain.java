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
    date = "2016-12-20T03:00:26.964Z"
)
public class ProfilerDomain {
  private RpcClient rpcClient;

  public ProfilerDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Profiler.enable", params, Void.class);
  }

  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Profiler.disable", params, Void.class);
  }

  /**
   * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
   * @param interval New sampling interval in microseconds.
   */
  public CompletableFuture<Void> setSamplingInterval(@NotNull Integer interval) {
    Map<String,Object> params = new HashMap<>();
    params.put("interval", interval);
    return rpcClient.call("Profiler.setSamplingInterval", params, Void.class);
  }

  public CompletableFuture<Void> start() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Profiler.start", params, Void.class);
  }

  public CompletableFuture<Stop> stop() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Profiler.stop", params, Stop.class);
  }

  /**
   * Sent when new profile recodring is started using console.profile() call.
   */
  public void onConsoleProfileStarted(Consumer<ConsoleProfileStarted> listener) {
    rpcClient.addEventListener("Profiler.consoleProfileStarted", listener, ConsoleProfileStarted.class);
  }

  /**
   * Sent when new profile recodring is started using console.profile() call.
   */
  public CompletableFuture<ConsoleProfileStarted> onConsoleProfileStarted() {
    return rpcClient.eventFuture("Profiler.consoleProfileStarted", ConsoleProfileStarted.class);
  }

  public void onConsoleProfileFinished(Consumer<ConsoleProfileFinished> listener) {
    rpcClient.addEventListener("Profiler.consoleProfileFinished", listener, ConsoleProfileFinished.class);
  }

  public CompletableFuture<ConsoleProfileFinished> onConsoleProfileFinished() {
    return rpcClient.eventFuture("Profiler.consoleProfileFinished", ConsoleProfileFinished.class);
  }

  /**
   * Specifies a number of samples attributed to a certain source position.
   */
  public static class PositionTickInfo {
    /**
     * Source line number (1-based).
     */
    public Integer line;

    /**
     * Number of samples attributed to the source line.
     */
    public Integer ticks;

    public String toString() {
      return "PositionTickInfo{line=" + line + ", ticks=" + ticks + "}";
    }
  }

  /**
   * Profile node. Holds callsite information, execution statistics and child nodes.
   */
  public static class ProfileNode {
    /**
     * Unique id of the node.
     */
    public Integer id;

    /**
     * Function location.
     */
    public RuntimeDomain.CallFrame callFrame;

    /**
     * Number of samples where this node was on top of the call stack.
     */
    public Integer hitCount;

    /**
     * Child node ids.
     */
    public List<Integer> children;

    /**
     * The reason of being not optimized. The function may be deoptimized or marked as don't optimize.
     */
    public String deoptReason;

    /**
     * An array of source position ticks.
     */
    public List<PositionTickInfo> positionTicks;

    public String toString() {
      return "ProfileNode{id=" + id + ", callFrame=" + callFrame + ", hitCount=" + hitCount + ", children=" + children + ", deoptReason=" + deoptReason + ", positionTicks=" + positionTicks + "}";
    }
  }

  /**
   * Profile.
   */
  public static class Profile {
    /**
     * The list of profile nodes. First item is the root node.
     */
    public List<ProfileNode> nodes;

    /**
     * Profiling start timestamp in microseconds.
     */
    public Double startTime;

    /**
     * Profiling end timestamp in microseconds.
     */
    public Double endTime;

    /**
     * Ids of samples top nodes.
     */
    public List<Integer> samples;

    /**
     * Time intervals between adjacent samples in microseconds. The first delta is relative to the profile startTime.
     */
    public List<Integer> timeDeltas;

    public String toString() {
      return "Profile{nodes=" + nodes + ", startTime=" + startTime + ", endTime=" + endTime + ", samples=" + samples + ", timeDeltas=" + timeDeltas + "}";
    }
  }

  public static class Stop {
    /**
     * Recorded profile.
     */
    public Profile profile;

    public String toString() {
      return "Stop{profile=" + profile + "}";
    }
  }

  /**
   * Sent when new profile recodring is started using console.profile() call.
   */
  public static class ConsoleProfileStarted {
    public String id;

    /**
     * Location of console.profile().
     */
    public DebuggerDomain.Location location;

    /**
     * Profile title passed as an argument to console.profile().
     */
    public String title;

    public String toString() {
      return "ConsoleProfileStarted{id=" + id + ", location=" + location + ", title=" + title + "}";
    }
  }

  public static class ConsoleProfileFinished {
    public String id;

    /**
     * Location of console.profileEnd().
     */
    public DebuggerDomain.Location location;

    public Profile profile;

    /**
     * Profile title passed as an argument to console.profile().
     */
    public String title;

    public String toString() {
      return "ConsoleProfileFinished{id=" + id + ", location=" + location + ", profile=" + profile + ", title=" + title + "}";
    }
  }
}
