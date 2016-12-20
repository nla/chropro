package chropro;

import com.google.gson.annotations.SerializedName;
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
    date = "2016-12-20T03:00:26.964Z"
)
public class DebuggerDomain {
  private RpcClient rpcClient;

  public DebuggerDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables debugger for the given page. Clients should not assume that the debugging has been enabled until the result for this command is received.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.enable", params, Void.class);
  }

  /**
   * Disables debugger for given page.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.disable", params, Void.class);
  }

  /**
   * Activates / deactivates all breakpoints on the page.
   * @param active New value for breakpoints active state.
   */
  public CompletableFuture<Void> setBreakpointsActive(@NotNull Boolean active) {
    Map<String,Object> params = new HashMap<>();
    params.put("active", active);
    return rpcClient.call("Debugger.setBreakpointsActive", params, Void.class);
  }

  /**
   * Makes page not interrupt on any pauses (breakpoint, exception, dom exception etc).
   * @param skip New value for skip pauses state.
   */
  public CompletableFuture<Void> setSkipAllPauses(@NotNull Boolean skip) {
    Map<String,Object> params = new HashMap<>();
    params.put("skip", skip);
    return rpcClient.call("Debugger.setSkipAllPauses", params, Void.class);
  }

  /**
   * Sets JavaScript breakpoint at given location specified either by URL or URL regex. Once this command is issued, all existing parsed scripts will have breakpoints resolved and returned in <code>locations</code> property. Further matching script parsing will result in subsequent <code>breakpointResolved</code> events issued. This logical breakpoint will survive page reloads.
   * @param lineNumber Line number to set breakpoint at.
   * @param url URL of the resources to set breakpoint on.
   * @param urlRegex Regex pattern for the URLs of the resources to set breakpoints on. Either <code>url</code> or <code>urlRegex</code> must be specified.
   * @param columnNumber Offset in the line to set breakpoint at.
   * @param condition Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
   */
  public CompletableFuture<SetBreakpointByUrl> setBreakpointByUrl(@NotNull Integer lineNumber, @Nullable String url, @Nullable String urlRegex, @Nullable Integer columnNumber, @Nullable String condition) {
    Map<String,Object> params = new HashMap<>();
    params.put("lineNumber", lineNumber);
    params.put("url", url);
    params.put("urlRegex", urlRegex);
    params.put("columnNumber", columnNumber);
    params.put("condition", condition);
    return rpcClient.call("Debugger.setBreakpointByUrl", params, SetBreakpointByUrl.class);
  }

  /**
   * Sets JavaScript breakpoint at a given location.
   * @param location Location to set breakpoint in.
   * @param condition Expression to use as a breakpoint condition. When specified, debugger will only stop on the breakpoint if this expression evaluates to true.
   */
  public CompletableFuture<SetBreakpoint> setBreakpoint(@NotNull Location location, @Nullable String condition) {
    Map<String,Object> params = new HashMap<>();
    params.put("location", location);
    params.put("condition", condition);
    return rpcClient.call("Debugger.setBreakpoint", params, SetBreakpoint.class);
  }

  /**
   * Removes JavaScript breakpoint.
   */
  public CompletableFuture<Void> removeBreakpoint(@NotNull String breakpointId) {
    Map<String,Object> params = new HashMap<>();
    params.put("breakpointId", breakpointId);
    return rpcClient.call("Debugger.removeBreakpoint", params, Void.class);
  }

  /**
   * Returns possible locations for breakpoint. scriptId in start and end range locations should be the same.
   * @param start Start of range to search possible breakpoint locations in.
   * @param end End of range to search possible breakpoint locations in (excluding). When not specifed, end of scripts is used as end of range.
   */
  public CompletableFuture<GetPossibleBreakpoints> getPossibleBreakpoints(@NotNull Location start, @Nullable Location end) {
    Map<String,Object> params = new HashMap<>();
    params.put("start", start);
    params.put("end", end);
    return rpcClient.call("Debugger.getPossibleBreakpoints", params, GetPossibleBreakpoints.class);
  }

  /**
   * Continues execution until specific location is reached.
   * @param location Location to continue to.
   */
  public CompletableFuture<Void> continueToLocation(@NotNull Location location) {
    Map<String,Object> params = new HashMap<>();
    params.put("location", location);
    return rpcClient.call("Debugger.continueToLocation", params, Void.class);
  }

  /**
   * Steps over the statement.
   */
  public CompletableFuture<Void> stepOver() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.stepOver", params, Void.class);
  }

  /**
   * Steps into the function call.
   */
  public CompletableFuture<Void> stepInto() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.stepInto", params, Void.class);
  }

  /**
   * Steps out of the function call.
   */
  public CompletableFuture<Void> stepOut() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.stepOut", params, Void.class);
  }

  /**
   * Stops on the next JavaScript statement.
   */
  public CompletableFuture<Void> pause() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.pause", params, Void.class);
  }

  /**
   * Resumes JavaScript execution.
   */
  public CompletableFuture<Void> resume() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Debugger.resume", params, Void.class);
  }

  /**
   * Searches for given string in script content.
   * @param scriptId Id of the script to search in.
   * @param query String to search for.
   * @param caseSensitive If true, search is case sensitive.
   * @param isRegex If true, treats string parameter as regex.
   */
  public CompletableFuture<SearchInContent> searchInContent(@NotNull String scriptId, @NotNull String query, @Nullable Boolean caseSensitive, @Nullable Boolean isRegex) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptId", scriptId);
    params.put("query", query);
    params.put("caseSensitive", caseSensitive);
    params.put("isRegex", isRegex);
    return rpcClient.call("Debugger.searchInContent", params, SearchInContent.class);
  }

  /**
   * Edits JavaScript source live.
   * @param scriptId Id of the script to edit.
   * @param scriptSource New content of the script.
   * @param dryRun  If true the change will not actually be applied. Dry run may be used to get result description without actually modifying the code.
   */
  public CompletableFuture<SetScriptSource> setScriptSource(@NotNull String scriptId, @NotNull String scriptSource, @Nullable Boolean dryRun) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptId", scriptId);
    params.put("scriptSource", scriptSource);
    params.put("dryRun", dryRun);
    return rpcClient.call("Debugger.setScriptSource", params, SetScriptSource.class);
  }

  /**
   * Restarts particular call frame from the beginning.
   * @param callFrameId Call frame identifier to evaluate on.
   */
  public CompletableFuture<RestartFrame> restartFrame(@NotNull String callFrameId) {
    Map<String,Object> params = new HashMap<>();
    params.put("callFrameId", callFrameId);
    return rpcClient.call("Debugger.restartFrame", params, RestartFrame.class);
  }

  /**
   * Returns source for the script with given id.
   * @param scriptId Id of the script to get source for.
   */
  public CompletableFuture<GetScriptSource> getScriptSource(@NotNull String scriptId) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptId", scriptId);
    return rpcClient.call("Debugger.getScriptSource", params, GetScriptSource.class);
  }

  /**
   * Defines pause on exceptions state. Can be set to stop on all exceptions, uncaught exceptions or no exceptions. Initial pause on exceptions state is <code>none</code>.
   * @param state Pause on exceptions mode.
   */
  public CompletableFuture<Void> setPauseOnExceptions(@NotNull String state) {
    Map<String,Object> params = new HashMap<>();
    params.put("state", state);
    return rpcClient.call("Debugger.setPauseOnExceptions", params, Void.class);
  }

  /**
   * Evaluates expression on a given call frame.
   * @param callFrameId Call frame identifier to evaluate on.
   * @param expression Expression to evaluate.
   * @param objectGroup String object group name to put result into (allows rapid releasing resulting object handles using <code>releaseObjectGroup</code>).
   * @param includeCommandLineAPI Specifies whether command line API should be available to the evaluated expression, defaults to false.
   * @param silent In silent mode exceptions thrown during evaluation are not reported and do not pause execution. Overrides <code>setPauseOnException</code> state.
   * @param returnByValue Whether the result is expected to be a JSON object that should be sent by value.
   * @param generatePreview Whether preview should be generated for the result.
   */
  public CompletableFuture<EvaluateOnCallFrame> evaluateOnCallFrame(@NotNull String callFrameId, @NotNull String expression, @Nullable String objectGroup, @Nullable Boolean includeCommandLineAPI, @Nullable Boolean silent, @Nullable Boolean returnByValue, @Nullable Boolean generatePreview) {
    Map<String,Object> params = new HashMap<>();
    params.put("callFrameId", callFrameId);
    params.put("expression", expression);
    params.put("objectGroup", objectGroup);
    params.put("includeCommandLineAPI", includeCommandLineAPI);
    params.put("silent", silent);
    params.put("returnByValue", returnByValue);
    params.put("generatePreview", generatePreview);
    return rpcClient.call("Debugger.evaluateOnCallFrame", params, EvaluateOnCallFrame.class);
  }

  /**
   * Changes value of variable in a callframe. Object-based scopes are not supported and must be mutated manually.
   * @param scopeNumber 0-based number of scope as was listed in scope chain. Only 'local', 'closure' and 'catch' scope types are allowed. Other scopes could be manipulated manually.
   * @param variableName Variable name.
   * @param newValue New variable value.
   * @param callFrameId Id of callframe that holds variable.
   */
  public CompletableFuture<Void> setVariableValue(@NotNull Integer scopeNumber, @NotNull String variableName, @NotNull RuntimeDomain.CallArgument newValue, @NotNull String callFrameId) {
    Map<String,Object> params = new HashMap<>();
    params.put("scopeNumber", scopeNumber);
    params.put("variableName", variableName);
    params.put("newValue", newValue);
    params.put("callFrameId", callFrameId);
    return rpcClient.call("Debugger.setVariableValue", params, Void.class);
  }

  /**
   * Enables or disables async call stacks tracking.
   * @param maxDepth Maximum depth of async call stacks. Setting to <code>0</code> will effectively disable collecting async call stacks (default).
   */
  public CompletableFuture<Void> setAsyncCallStackDepth(@NotNull Integer maxDepth) {
    Map<String,Object> params = new HashMap<>();
    params.put("maxDepth", maxDepth);
    return rpcClient.call("Debugger.setAsyncCallStackDepth", params, Void.class);
  }

  /**
   * Replace previous blackbox patterns with passed ones. Forces backend to skip stepping/pausing in scripts with url matching one of the patterns. VM will try to leave blackboxed script by performing 'step in' several times, finally resorting to 'step out' if unsuccessful.
   * @param patterns Array of regexps that will be used to check script url for blackbox state.
   */
  public CompletableFuture<Void> setBlackboxPatterns(@NotNull List<String> patterns) {
    Map<String,Object> params = new HashMap<>();
    params.put("patterns", patterns);
    return rpcClient.call("Debugger.setBlackboxPatterns", params, Void.class);
  }

  /**
   * Makes backend skip steps in the script in blackboxed ranges. VM will try leave blacklisted scripts by performing 'step in' several times, finally resorting to 'step out' if unsuccessful. Positions array contains positions where blackbox state is changed. First interval isn't blackboxed. Array should be sorted.
   * @param scriptId Id of the script.
   */
  public CompletableFuture<Void> setBlackboxedRanges(@NotNull String scriptId, @NotNull List<ScriptPosition> positions) {
    Map<String,Object> params = new HashMap<>();
    params.put("scriptId", scriptId);
    params.put("positions", positions);
    return rpcClient.call("Debugger.setBlackboxedRanges", params, Void.class);
  }

  /**
   * Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
   */
  public void onScriptParsed(Consumer<ScriptParsed> listener) {
    rpcClient.addEventListener("Debugger.scriptParsed", listener, ScriptParsed.class);
  }

  /**
   * Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
   */
  public CompletableFuture<ScriptParsed> onScriptParsed() {
    return rpcClient.eventFuture("Debugger.scriptParsed", ScriptParsed.class);
  }

  /**
   * Fired when virtual machine fails to parse the script.
   */
  public void onScriptFailedToParse(Consumer<ScriptFailedToParse> listener) {
    rpcClient.addEventListener("Debugger.scriptFailedToParse", listener, ScriptFailedToParse.class);
  }

  /**
   * Fired when virtual machine fails to parse the script.
   */
  public CompletableFuture<ScriptFailedToParse> onScriptFailedToParse() {
    return rpcClient.eventFuture("Debugger.scriptFailedToParse", ScriptFailedToParse.class);
  }

  /**
   * Fired when breakpoint is resolved to an actual script and location.
   */
  public void onBreakpointResolved(Consumer<BreakpointResolved> listener) {
    rpcClient.addEventListener("Debugger.breakpointResolved", listener, BreakpointResolved.class);
  }

  /**
   * Fired when breakpoint is resolved to an actual script and location.
   */
  public CompletableFuture<BreakpointResolved> onBreakpointResolved() {
    return rpcClient.eventFuture("Debugger.breakpointResolved", BreakpointResolved.class);
  }

  /**
   * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
   */
  public void onPaused(Consumer<Paused> listener) {
    rpcClient.addEventListener("Debugger.paused", listener, Paused.class);
  }

  /**
   * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
   */
  public CompletableFuture<Paused> onPaused() {
    return rpcClient.eventFuture("Debugger.paused", Paused.class);
  }

  /**
   * Fired when the virtual machine resumed execution.
   */
  public void onResumed(Consumer<Resumed> listener) {
    rpcClient.addEventListener("Debugger.resumed", listener, Resumed.class);
  }

  /**
   * Fired when the virtual machine resumed execution.
   */
  public CompletableFuture<Resumed> onResumed() {
    return rpcClient.eventFuture("Debugger.resumed", Resumed.class);
  }

  /**
   * Search match for resource.
   */
  public static class SearchMatch {
    /**
     * Line number in resource content.
     */
    public Double lineNumber;

    /**
     * Line with match content.
     */
    public String lineContent;

    public String toString() {
      return "SearchMatch{lineNumber=" + lineNumber + ", lineContent=" + lineContent + "}";
    }
  }

  /**
   * Location in the source code.
   */
  public static class Location {
    /**
     * Script identifier as reported in the <code>Debugger.scriptParsed</code>.
     */
    public String scriptId;

    /**
     * Line number in the script (0-based).
     */
    public Integer lineNumber;

    /**
     * Column number in the script (0-based).
     */
    public Integer columnNumber;

    public String toString() {
      return "Location{scriptId=" + scriptId + ", lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + "}";
    }
  }

  public static class SetBreakpointByUrl {
    /**
     * Id of the created breakpoint for further reference.
     */
    public String breakpointId;

    /**
     * List of the locations this breakpoint resolved into upon addition.
     */
    public List<Location> locations;

    public String toString() {
      return "SetBreakpointByUrl{breakpointId=" + breakpointId + ", locations=" + locations + "}";
    }
  }

  public static class SetBreakpoint {
    /**
     * Id of the created breakpoint for further reference.
     */
    public String breakpointId;

    /**
     * Location this breakpoint resolved into.
     */
    public Location actualLocation;

    public String toString() {
      return "SetBreakpoint{breakpointId=" + breakpointId + ", actualLocation=" + actualLocation + "}";
    }
  }

  public static class GetPossibleBreakpoints {
    /**
     * List of the possible breakpoint locations.
     */
    public List<Location> locations;

    public String toString() {
      return "GetPossibleBreakpoints{locations=" + locations + "}";
    }
  }

  public static class SearchInContent {
    /**
     * List of search matches.
     */
    public List<SearchMatch> result;

    public String toString() {
      return "SearchInContent{result=" + result + "}";
    }
  }

  /**
   * Scope description.
   */
  public static class Scope {
    /**
     * Scope type.
     */
    public String type;

    /**
     * Object representing the scope. For <code>global</code> and <code>with</code> scopes it represents the actual object; for the rest of the scopes, it is artificial transient object enumerating scope variables as its properties.
     */
    public RuntimeDomain.RemoteObject object;

    public String name;

    /**
     * Location in the source code where scope starts
     */
    public Location startLocation;

    /**
     * Location in the source code where scope ends
     */
    public Location endLocation;

    public String toString() {
      return "Scope{type=" + type + ", object=" + object + ", name=" + name + ", startLocation=" + startLocation + ", endLocation=" + endLocation + "}";
    }
  }

  /**
   * JavaScript call frame. Array of call frames form the call stack.
   */
  public static class CallFrame {
    /**
     * Call frame identifier. This identifier is only valid while the virtual machine is paused.
     */
    public String callFrameId;

    /**
     * Name of the JavaScript function called on this call frame.
     */
    public String functionName;

    /**
     * Location in the source code.
     */
    public Location functionLocation;

    /**
     * Location in the source code.
     */
    public Location location;

    /**
     * Scope chain for this call frame.
     */
    public List<Scope> scopeChain;

    /**
     * <code>this</code> object for this call frame.
     */
    @SerializedName("this")
    public RuntimeDomain.RemoteObject this_;

    /**
     * The value being returned, if the function is at return point.
     */
    public RuntimeDomain.RemoteObject returnValue;

    public String toString() {
      return "CallFrame{callFrameId=" + callFrameId + ", functionName=" + functionName + ", functionLocation=" + functionLocation + ", location=" + location + ", scopeChain=" + scopeChain + ", this_=" + this_ + ", returnValue=" + returnValue + "}";
    }
  }

  public static class SetScriptSource {
    /**
     * New stack trace in case editing has happened while VM was stopped.
     */
    public List<CallFrame> callFrames;

    /**
     * Whether current call stack  was modified after applying the changes.
     */
    public Boolean stackChanged;

    /**
     * Async stack trace, if any.
     */
    public RuntimeDomain.StackTrace asyncStackTrace;

    /**
     * Exception details if any.
     */
    public RuntimeDomain.ExceptionDetails exceptionDetails;

    public String toString() {
      return "SetScriptSource{callFrames=" + callFrames + ", stackChanged=" + stackChanged + ", asyncStackTrace=" + asyncStackTrace + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  public static class RestartFrame {
    /**
     * New stack trace.
     */
    public List<CallFrame> callFrames;

    /**
     * Async stack trace, if any.
     */
    public RuntimeDomain.StackTrace asyncStackTrace;

    public String toString() {
      return "RestartFrame{callFrames=" + callFrames + ", asyncStackTrace=" + asyncStackTrace + "}";
    }
  }

  public static class GetScriptSource {
    /**
     * Script source.
     */
    public String scriptSource;

    public String toString() {
      return "GetScriptSource{scriptSource=" + scriptSource + "}";
    }
  }

  public static class EvaluateOnCallFrame {
    /**
     * Object wrapper for the evaluation result.
     */
    public RuntimeDomain.RemoteObject result;

    /**
     * Exception details.
     */
    public RuntimeDomain.ExceptionDetails exceptionDetails;

    public String toString() {
      return "EvaluateOnCallFrame{result=" + result + ", exceptionDetails=" + exceptionDetails + "}";
    }
  }

  /**
   * Location in the source code.
   */
  public static class ScriptPosition {
    public Integer lineNumber;

    public Integer columnNumber;

    public String toString() {
      return "ScriptPosition{lineNumber=" + lineNumber + ", columnNumber=" + columnNumber + "}";
    }
  }

  /**
   * Fired when virtual machine parses script. This event is also fired for all known and uncollected scripts upon enabling debugger.
   */
  public static class ScriptParsed {
    /**
     * Identifier of the script parsed.
     */
    public String scriptId;

    /**
     * URL or name of the script parsed (if any).
     */
    public String url;

    /**
     * Line offset of the script within the resource with given URL (for script tags).
     */
    public Integer startLine;

    /**
     * Column offset of the script within the resource with given URL.
     */
    public Integer startColumn;

    /**
     * Last line of the script.
     */
    public Integer endLine;

    /**
     * Length of the last line of the script.
     */
    public Integer endColumn;

    /**
     * Specifies script creation context.
     */
    public Integer executionContextId;

    /**
     * Content hash of the script.
     */
    public String hash;

    /**
     * Embedder-specific auxiliary data.
     */
    public Map<String, Object> executionContextAuxData;

    /**
     * True, if this script is generated as a result of the live edit operation.
     */
    public Boolean isLiveEdit;

    /**
     * URL of source map associated with script (if any).
     */
    public String sourceMapURL;

    /**
     * True, if this script has sourceURL.
     */
    public Boolean hasSourceURL;

    public String toString() {
      return "ScriptParsed{scriptId=" + scriptId + ", url=" + url + ", startLine=" + startLine + ", startColumn=" + startColumn + ", endLine=" + endLine + ", endColumn=" + endColumn + ", executionContextId=" + executionContextId + ", hash=" + hash + ", executionContextAuxData=" + executionContextAuxData + ", isLiveEdit=" + isLiveEdit + ", sourceMapURL=" + sourceMapURL + ", hasSourceURL=" + hasSourceURL + "}";
    }
  }

  /**
   * Fired when virtual machine fails to parse the script.
   */
  public static class ScriptFailedToParse {
    /**
     * Identifier of the script parsed.
     */
    public String scriptId;

    /**
     * URL or name of the script parsed (if any).
     */
    public String url;

    /**
     * Line offset of the script within the resource with given URL (for script tags).
     */
    public Integer startLine;

    /**
     * Column offset of the script within the resource with given URL.
     */
    public Integer startColumn;

    /**
     * Last line of the script.
     */
    public Integer endLine;

    /**
     * Length of the last line of the script.
     */
    public Integer endColumn;

    /**
     * Specifies script creation context.
     */
    public Integer executionContextId;

    /**
     * Content hash of the script.
     */
    public String hash;

    /**
     * Embedder-specific auxiliary data.
     */
    public Map<String, Object> executionContextAuxData;

    /**
     * URL of source map associated with script (if any).
     */
    public String sourceMapURL;

    /**
     * True, if this script has sourceURL.
     */
    public Boolean hasSourceURL;

    public String toString() {
      return "ScriptFailedToParse{scriptId=" + scriptId + ", url=" + url + ", startLine=" + startLine + ", startColumn=" + startColumn + ", endLine=" + endLine + ", endColumn=" + endColumn + ", executionContextId=" + executionContextId + ", hash=" + hash + ", executionContextAuxData=" + executionContextAuxData + ", sourceMapURL=" + sourceMapURL + ", hasSourceURL=" + hasSourceURL + "}";
    }
  }

  /**
   * Fired when breakpoint is resolved to an actual script and location.
   */
  public static class BreakpointResolved {
    /**
     * Breakpoint unique identifier.
     */
    public String breakpointId;

    /**
     * Actual breakpoint location.
     */
    public Location location;

    public String toString() {
      return "BreakpointResolved{breakpointId=" + breakpointId + ", location=" + location + "}";
    }
  }

  /**
   * Fired when the virtual machine stopped on breakpoint or exception or any other stop criteria.
   */
  public static class Paused {
    /**
     * Call stack the virtual machine stopped on.
     */
    public List<CallFrame> callFrames;

    /**
     * Pause reason.
     */
    public String reason;

    /**
     * Object containing break-specific auxiliary properties.
     */
    public Map<String, Object> data;

    /**
     * Hit breakpoints IDs
     */
    public List<String> hitBreakpoints;

    /**
     * Async stack trace, if any.
     */
    public RuntimeDomain.StackTrace asyncStackTrace;

    public String toString() {
      return "Paused{callFrames=" + callFrames + ", reason=" + reason + ", data=" + data + ", hitBreakpoints=" + hitBreakpoints + ", asyncStackTrace=" + asyncStackTrace + "}";
    }
  }

  /**
   * Fired when the virtual machine resumed execution.
   */
  public static class Resumed {
    public String toString() {
      return "Resumed{}";
    }
  }
}
