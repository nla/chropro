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
public class DOMDomain {
  private RpcClient rpcClient;

  public DOMDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables DOM agent for the given page.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.enable", params, Void.class);
  }

  /**
   * Disables DOM agent for the given page.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.disable", params, Void.class);
  }

  /**
   * Returns the root DOM node (and optionally the subtree) to the caller.
   * @param depth The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
   * @param pierce Whether or not iframes and shadow roots should be traversed when returning the subtree (default is false).
   */
  public CompletableFuture<GetDocument> getDocument(@Nullable Integer depth, @Nullable Boolean pierce) {
    Map<String,Object> params = new HashMap<>();
    params.put("depth", depth);
    params.put("pierce", pierce);
    return rpcClient.call("DOM.getDocument", params, GetDocument.class);
  }

  /**
   * Collects class names for the node with given id and all of it's child nodes.
   * @param nodeId Id of the node to collect class names.
   */
  public CompletableFuture<CollectClassNamesFromSubtree> collectClassNamesFromSubtree(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.collectClassNamesFromSubtree", params, CollectClassNamesFromSubtree.class);
  }

  /**
   * Requests that children of the node with given id are returned to the caller in form of <code>setChildNodes</code> events where not only immediate children are retrieved, but all children down to the specified depth.
   * @param nodeId Id of the node to get children for.
   * @param depth The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire subtree or provide an integer larger than 0.
   * @param pierce Whether or not iframes and shadow roots should be traversed when returning the sub-tree (default is false).
   */
  public CompletableFuture<Void> requestChildNodes(@NotNull Integer nodeId, @Nullable Integer depth, @Nullable Boolean pierce) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("depth", depth);
    params.put("pierce", pierce);
    return rpcClient.call("DOM.requestChildNodes", params, Void.class);
  }

  /**
   * Executes <code>querySelector</code> on a given node.
   * @param nodeId Id of the node to query upon.
   * @param selector Selector string.
   */
  public CompletableFuture<QuerySelector> querySelector(@NotNull Integer nodeId, @NotNull String selector) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("selector", selector);
    return rpcClient.call("DOM.querySelector", params, QuerySelector.class);
  }

  /**
   * Executes <code>querySelectorAll</code> on a given node.
   * @param nodeId Id of the node to query upon.
   * @param selector Selector string.
   */
  public CompletableFuture<QuerySelectorAll> querySelectorAll(@NotNull Integer nodeId, @NotNull String selector) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("selector", selector);
    return rpcClient.call("DOM.querySelectorAll", params, QuerySelectorAll.class);
  }

  /**
   * Sets node name for a node with given id.
   * @param nodeId Id of the node to set name for.
   * @param name New node's name.
   */
  public CompletableFuture<SetNodeName> setNodeName(@NotNull Integer nodeId, @NotNull String name) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("name", name);
    return rpcClient.call("DOM.setNodeName", params, SetNodeName.class);
  }

  /**
   * Sets node value for a node with given id.
   * @param nodeId Id of the node to set value for.
   * @param value New node's value.
   */
  public CompletableFuture<Void> setNodeValue(@NotNull Integer nodeId, @NotNull String value) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("value", value);
    return rpcClient.call("DOM.setNodeValue", params, Void.class);
  }

  /**
   * Removes node with given id.
   * @param nodeId Id of the node to remove.
   */
  public CompletableFuture<Void> removeNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.removeNode", params, Void.class);
  }

  /**
   * Sets attribute for an element with given id.
   * @param nodeId Id of the element to set attribute for.
   * @param name Attribute name.
   * @param value Attribute value.
   */
  public CompletableFuture<Void> setAttributeValue(@NotNull Integer nodeId, @NotNull String name, @NotNull String value) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("name", name);
    params.put("value", value);
    return rpcClient.call("DOM.setAttributeValue", params, Void.class);
  }

  /**
   * Sets attributes on element with given id. This method is useful when user edits some existing attribute value and types in several attribute name/value pairs.
   * @param nodeId Id of the element to set attributes for.
   * @param text Text with a number of attributes. Will parse this text using HTML parser.
   * @param name Attribute name to replace with new attributes derived from text in case text parsed successfully.
   */
  public CompletableFuture<Void> setAttributesAsText(@NotNull Integer nodeId, @NotNull String text, @Nullable String name) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("text", text);
    params.put("name", name);
    return rpcClient.call("DOM.setAttributesAsText", params, Void.class);
  }

  /**
   * Removes attribute with given name from an element with given id.
   * @param nodeId Id of the element to remove attribute from.
   * @param name Name of the attribute to remove.
   */
  public CompletableFuture<Void> removeAttribute(@NotNull Integer nodeId, @NotNull String name) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("name", name);
    return rpcClient.call("DOM.removeAttribute", params, Void.class);
  }

  /**
   * Returns node's HTML markup.
   * @param nodeId Id of the node to get markup for.
   */
  public CompletableFuture<GetOuterHTML> getOuterHTML(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.getOuterHTML", params, GetOuterHTML.class);
  }

  /**
   * Sets node HTML markup, returns new node id.
   * @param nodeId Id of the node to set markup for.
   * @param outerHTML Outer HTML markup to set.
   */
  public CompletableFuture<Void> setOuterHTML(@NotNull Integer nodeId, @NotNull String outerHTML) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("outerHTML", outerHTML);
    return rpcClient.call("DOM.setOuterHTML", params, Void.class);
  }

  /**
   * Searches for a given string in the DOM tree. Use <code>getSearchResults</code> to access search results or <code>cancelSearch</code> to end this search session.
   * @param query Plain text or query selector or XPath search query.
   * @param includeUserAgentShadowDOM True to search in user agent shadow DOM.
   */
  public CompletableFuture<PerformSearch> performSearch(@NotNull String query, @Nullable Boolean includeUserAgentShadowDOM) {
    Map<String,Object> params = new HashMap<>();
    params.put("query", query);
    params.put("includeUserAgentShadowDOM", includeUserAgentShadowDOM);
    return rpcClient.call("DOM.performSearch", params, PerformSearch.class);
  }

  /**
   * Returns search results from given <code>fromIndex</code> to given <code>toIndex</code> from the sarch with the given identifier.
   * @param searchId Unique search session identifier.
   * @param fromIndex Start index of the search result to be returned.
   * @param toIndex End index of the search result to be returned.
   */
  public CompletableFuture<GetSearchResults> getSearchResults(@NotNull String searchId, @NotNull Integer fromIndex, @NotNull Integer toIndex) {
    Map<String,Object> params = new HashMap<>();
    params.put("searchId", searchId);
    params.put("fromIndex", fromIndex);
    params.put("toIndex", toIndex);
    return rpcClient.call("DOM.getSearchResults", params, GetSearchResults.class);
  }

  /**
   * Discards search results from the session with the given id. <code>getSearchResults</code> should no longer be called for that search.
   * @param searchId Unique search session identifier.
   */
  public CompletableFuture<Void> discardSearchResults(@NotNull String searchId) {
    Map<String,Object> params = new HashMap<>();
    params.put("searchId", searchId);
    return rpcClient.call("DOM.discardSearchResults", params, Void.class);
  }

  /**
   * Requests that the node is sent to the caller given the JavaScript node object reference. All nodes that form the path from the node to the root are also sent to the client as a series of <code>setChildNodes</code> notifications.
   * @param objectId JavaScript object id to convert into node.
   */
  public CompletableFuture<RequestNode> requestNode(@NotNull String objectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("objectId", objectId);
    return rpcClient.call("DOM.requestNode", params, RequestNode.class);
  }

  /**
   * Enters the 'inspect' mode. In this mode, elements that user is hovering over are highlighted. Backend then generates 'inspectNodeRequested' event upon element selection.
   * @param mode Set an inspection mode.
   * @param highlightConfig A descriptor for the highlight appearance of hovered-over nodes. May be omitted if <code>enabled == false</code>.
   */
  public CompletableFuture<Void> setInspectMode(@NotNull String mode, @Nullable HighlightConfig highlightConfig) {
    Map<String,Object> params = new HashMap<>();
    params.put("mode", mode);
    params.put("highlightConfig", highlightConfig);
    return rpcClient.call("DOM.setInspectMode", params, Void.class);
  }

  /**
   * Highlights given rectangle. Coordinates are absolute with respect to the main frame viewport.
   * @param x X coordinate
   * @param y Y coordinate
   * @param width Rectangle width
   * @param height Rectangle height
   * @param color The highlight fill color (default: transparent).
   * @param outlineColor The highlight outline color (default: transparent).
   */
  public CompletableFuture<Void> highlightRect(@NotNull Integer x, @NotNull Integer y, @NotNull Integer width, @NotNull Integer height, @Nullable RGBA color, @Nullable RGBA outlineColor) {
    Map<String,Object> params = new HashMap<>();
    params.put("x", x);
    params.put("y", y);
    params.put("width", width);
    params.put("height", height);
    params.put("color", color);
    params.put("outlineColor", outlineColor);
    return rpcClient.call("DOM.highlightRect", params, Void.class);
  }

  /**
   * Highlights given quad. Coordinates are absolute with respect to the main frame viewport.
   * @param quad Quad to highlight
   * @param color The highlight fill color (default: transparent).
   * @param outlineColor The highlight outline color (default: transparent).
   */
  public CompletableFuture<Void> highlightQuad(@NotNull List<Double> quad, @Nullable RGBA color, @Nullable RGBA outlineColor) {
    Map<String,Object> params = new HashMap<>();
    params.put("quad", quad);
    params.put("color", color);
    params.put("outlineColor", outlineColor);
    return rpcClient.call("DOM.highlightQuad", params, Void.class);
  }

  /**
   * Highlights DOM node with given id or with the given JavaScript object wrapper. Either nodeId or objectId must be specified.
   * @param highlightConfig A descriptor for the highlight appearance.
   * @param nodeId Identifier of the node to highlight.
   * @param backendNodeId Identifier of the backend node to highlight.
   * @param objectId JavaScript object id of the node to be highlighted.
   */
  public CompletableFuture<Void> highlightNode(@NotNull HighlightConfig highlightConfig, @Nullable Integer nodeId, @Nullable Integer backendNodeId, @Nullable String objectId) {
    Map<String,Object> params = new HashMap<>();
    params.put("highlightConfig", highlightConfig);
    params.put("nodeId", nodeId);
    params.put("backendNodeId", backendNodeId);
    params.put("objectId", objectId);
    return rpcClient.call("DOM.highlightNode", params, Void.class);
  }

  /**
   * Hides DOM node highlight.
   */
  public CompletableFuture<Void> hideHighlight() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.hideHighlight", params, Void.class);
  }

  /**
   * Highlights owner element of the frame with given id.
   * @param frameId Identifier of the frame to highlight.
   * @param contentColor The content box highlight fill color (default: transparent).
   * @param contentOutlineColor The content box highlight outline color (default: transparent).
   */
  public CompletableFuture<Void> highlightFrame(@NotNull String frameId, @Nullable RGBA contentColor, @Nullable RGBA contentOutlineColor) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    params.put("contentColor", contentColor);
    params.put("contentOutlineColor", contentOutlineColor);
    return rpcClient.call("DOM.highlightFrame", params, Void.class);
  }

  /**
   * Requests that the node is sent to the caller given its path. // FIXME, use XPath
   * @param path Path to node in the proprietary format.
   */
  public CompletableFuture<PushNodeByPathToFrontend> pushNodeByPathToFrontend(@NotNull String path) {
    Map<String,Object> params = new HashMap<>();
    params.put("path", path);
    return rpcClient.call("DOM.pushNodeByPathToFrontend", params, PushNodeByPathToFrontend.class);
  }

  /**
   * Requests that a batch of nodes is sent to the caller given their backend node ids.
   * @param backendNodeIds The array of backend node ids.
   */
  public CompletableFuture<PushNodesByBackendIdsToFrontend> pushNodesByBackendIdsToFrontend(@NotNull List<Integer> backendNodeIds) {
    Map<String,Object> params = new HashMap<>();
    params.put("backendNodeIds", backendNodeIds);
    return rpcClient.call("DOM.pushNodesByBackendIdsToFrontend", params, PushNodesByBackendIdsToFrontend.class);
  }

  /**
   * Enables console to refer to the node with given id via $x (see Command Line API for more details $x functions).
   * @param nodeId DOM node id to be accessible by means of $x command line API.
   */
  public CompletableFuture<Void> setInspectedNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.setInspectedNode", params, Void.class);
  }

  /**
   * Resolves JavaScript node object for given node id.
   * @param nodeId Id of the node to resolve.
   * @param objectGroup Symbolic group name that can be used to release multiple objects.
   */
  public CompletableFuture<ResolveNode> resolveNode(@NotNull Integer nodeId, @Nullable String objectGroup) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("objectGroup", objectGroup);
    return rpcClient.call("DOM.resolveNode", params, ResolveNode.class);
  }

  /**
   * Returns attributes for the specified node.
   * @param nodeId Id of the node to retrieve attibutes for.
   */
  public CompletableFuture<GetAttributes> getAttributes(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.getAttributes", params, GetAttributes.class);
  }

  /**
   * Creates a deep copy of the specified node and places it into the target container before the given anchor.
   * @param nodeId Id of the node to copy.
   * @param targetNodeId Id of the element to drop the copy into.
   * @param insertBeforeNodeId Drop the copy before this node (if absent, the copy becomes the last child of <code>targetNodeId</code>).
   */
  public CompletableFuture<CopyTo> copyTo(@NotNull Integer nodeId, @NotNull Integer targetNodeId, @Nullable Integer insertBeforeNodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("targetNodeId", targetNodeId);
    params.put("insertBeforeNodeId", insertBeforeNodeId);
    return rpcClient.call("DOM.copyTo", params, CopyTo.class);
  }

  /**
   * Moves node into the new container, places it before the given anchor.
   * @param nodeId Id of the node to move.
   * @param targetNodeId Id of the element to drop the moved node into.
   * @param insertBeforeNodeId Drop node before this one (if absent, the moved node becomes the last child of <code>targetNodeId</code>).
   */
  public CompletableFuture<MoveTo> moveTo(@NotNull Integer nodeId, @NotNull Integer targetNodeId, @Nullable Integer insertBeforeNodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("targetNodeId", targetNodeId);
    params.put("insertBeforeNodeId", insertBeforeNodeId);
    return rpcClient.call("DOM.moveTo", params, MoveTo.class);
  }

  /**
   * Undoes the last performed action.
   */
  public CompletableFuture<Void> undo() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.undo", params, Void.class);
  }

  /**
   * Re-does the last undone action.
   */
  public CompletableFuture<Void> redo() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.redo", params, Void.class);
  }

  /**
   * Marks last undoable state.
   */
  public CompletableFuture<Void> markUndoableState() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("DOM.markUndoableState", params, Void.class);
  }

  /**
   * Focuses the given element.
   * @param nodeId Id of the node to focus.
   */
  public CompletableFuture<Void> focus(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.focus", params, Void.class);
  }

  /**
   * Sets files for the given file input element.
   * @param nodeId Id of the file input node to set files for.
   * @param files Array of file paths to set.
   */
  public CompletableFuture<Void> setFileInputFiles(@NotNull Integer nodeId, @NotNull List<String> files) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("files", files);
    return rpcClient.call("DOM.setFileInputFiles", params, Void.class);
  }

  /**
   * Returns boxes for the currently selected nodes.
   * @param nodeId Id of the node to get box model for.
   */
  public CompletableFuture<GetBoxModel> getBoxModel(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.getBoxModel", params, GetBoxModel.class);
  }

  /**
   * Returns node id at given location.
   * @param x X coordinate.
   * @param y Y coordinate.
   */
  public CompletableFuture<GetNodeForLocation> getNodeForLocation(@NotNull Integer x, @NotNull Integer y) {
    Map<String,Object> params = new HashMap<>();
    params.put("x", x);
    params.put("y", y);
    return rpcClient.call("DOM.getNodeForLocation", params, GetNodeForLocation.class);
  }

  /**
   * Returns the id of the nearest ancestor that is a relayout boundary.
   * @param nodeId Id of the node.
   */
  public CompletableFuture<GetRelayoutBoundary> getRelayoutBoundary(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.getRelayoutBoundary", params, GetRelayoutBoundary.class);
  }

  /**
   * For testing.
   * @param nodeId Id of the node to get highlight object for.
   */
  public CompletableFuture<GetHighlightObjectForTest> getHighlightObjectForTest(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("DOM.getHighlightObjectForTest", params, GetHighlightObjectForTest.class);
  }

  /**
   * Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
   */
  public void onDocumentUpdated(Consumer<DocumentUpdated> listener) {
    rpcClient.addEventListener("DOM.documentUpdated", listener, DocumentUpdated.class);
  }

  /**
   * Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
   */
  public CompletableFuture<DocumentUpdated> onDocumentUpdated() {
    return rpcClient.eventFuture("DOM.documentUpdated", DocumentUpdated.class);
  }

  /**
   * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
   */
  public void onInspectNodeRequested(Consumer<InspectNodeRequested> listener) {
    rpcClient.addEventListener("DOM.inspectNodeRequested", listener, InspectNodeRequested.class);
  }

  /**
   * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
   */
  public CompletableFuture<InspectNodeRequested> onInspectNodeRequested() {
    return rpcClient.eventFuture("DOM.inspectNodeRequested", InspectNodeRequested.class);
  }

  /**
   * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
   */
  public void onSetChildNodes(Consumer<SetChildNodes> listener) {
    rpcClient.addEventListener("DOM.setChildNodes", listener, SetChildNodes.class);
  }

  /**
   * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
   */
  public CompletableFuture<SetChildNodes> onSetChildNodes() {
    return rpcClient.eventFuture("DOM.setChildNodes", SetChildNodes.class);
  }

  /**
   * Fired when <code>Element</code>'s attribute is modified.
   */
  public void onAttributeModified(Consumer<AttributeModified> listener) {
    rpcClient.addEventListener("DOM.attributeModified", listener, AttributeModified.class);
  }

  /**
   * Fired when <code>Element</code>'s attribute is modified.
   */
  public CompletableFuture<AttributeModified> onAttributeModified() {
    return rpcClient.eventFuture("DOM.attributeModified", AttributeModified.class);
  }

  /**
   * Fired when <code>Element</code>'s attribute is removed.
   */
  public void onAttributeRemoved(Consumer<AttributeRemoved> listener) {
    rpcClient.addEventListener("DOM.attributeRemoved", listener, AttributeRemoved.class);
  }

  /**
   * Fired when <code>Element</code>'s attribute is removed.
   */
  public CompletableFuture<AttributeRemoved> onAttributeRemoved() {
    return rpcClient.eventFuture("DOM.attributeRemoved", AttributeRemoved.class);
  }

  /**
   * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
   */
  public void onInlineStyleInvalidated(Consumer<InlineStyleInvalidated> listener) {
    rpcClient.addEventListener("DOM.inlineStyleInvalidated", listener, InlineStyleInvalidated.class);
  }

  /**
   * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
   */
  public CompletableFuture<InlineStyleInvalidated> onInlineStyleInvalidated() {
    return rpcClient.eventFuture("DOM.inlineStyleInvalidated", InlineStyleInvalidated.class);
  }

  /**
   * Mirrors <code>DOMCharacterDataModified</code> event.
   */
  public void onCharacterDataModified(Consumer<CharacterDataModified> listener) {
    rpcClient.addEventListener("DOM.characterDataModified", listener, CharacterDataModified.class);
  }

  /**
   * Mirrors <code>DOMCharacterDataModified</code> event.
   */
  public CompletableFuture<CharacterDataModified> onCharacterDataModified() {
    return rpcClient.eventFuture("DOM.characterDataModified", CharacterDataModified.class);
  }

  /**
   * Fired when <code>Container</code>'s child node count has changed.
   */
  public void onChildNodeCountUpdated(Consumer<ChildNodeCountUpdated> listener) {
    rpcClient.addEventListener("DOM.childNodeCountUpdated", listener, ChildNodeCountUpdated.class);
  }

  /**
   * Fired when <code>Container</code>'s child node count has changed.
   */
  public CompletableFuture<ChildNodeCountUpdated> onChildNodeCountUpdated() {
    return rpcClient.eventFuture("DOM.childNodeCountUpdated", ChildNodeCountUpdated.class);
  }

  /**
   * Mirrors <code>DOMNodeInserted</code> event.
   */
  public void onChildNodeInserted(Consumer<ChildNodeInserted> listener) {
    rpcClient.addEventListener("DOM.childNodeInserted", listener, ChildNodeInserted.class);
  }

  /**
   * Mirrors <code>DOMNodeInserted</code> event.
   */
  public CompletableFuture<ChildNodeInserted> onChildNodeInserted() {
    return rpcClient.eventFuture("DOM.childNodeInserted", ChildNodeInserted.class);
  }

  /**
   * Mirrors <code>DOMNodeRemoved</code> event.
   */
  public void onChildNodeRemoved(Consumer<ChildNodeRemoved> listener) {
    rpcClient.addEventListener("DOM.childNodeRemoved", listener, ChildNodeRemoved.class);
  }

  /**
   * Mirrors <code>DOMNodeRemoved</code> event.
   */
  public CompletableFuture<ChildNodeRemoved> onChildNodeRemoved() {
    return rpcClient.eventFuture("DOM.childNodeRemoved", ChildNodeRemoved.class);
  }

  /**
   * Called when shadow root is pushed into the element.
   */
  public void onShadowRootPushed(Consumer<ShadowRootPushed> listener) {
    rpcClient.addEventListener("DOM.shadowRootPushed", listener, ShadowRootPushed.class);
  }

  /**
   * Called when shadow root is pushed into the element.
   */
  public CompletableFuture<ShadowRootPushed> onShadowRootPushed() {
    return rpcClient.eventFuture("DOM.shadowRootPushed", ShadowRootPushed.class);
  }

  /**
   * Called when shadow root is popped from the element.
   */
  public void onShadowRootPopped(Consumer<ShadowRootPopped> listener) {
    rpcClient.addEventListener("DOM.shadowRootPopped", listener, ShadowRootPopped.class);
  }

  /**
   * Called when shadow root is popped from the element.
   */
  public CompletableFuture<ShadowRootPopped> onShadowRootPopped() {
    return rpcClient.eventFuture("DOM.shadowRootPopped", ShadowRootPopped.class);
  }

  /**
   * Called when a pseudo element is added to an element.
   */
  public void onPseudoElementAdded(Consumer<PseudoElementAdded> listener) {
    rpcClient.addEventListener("DOM.pseudoElementAdded", listener, PseudoElementAdded.class);
  }

  /**
   * Called when a pseudo element is added to an element.
   */
  public CompletableFuture<PseudoElementAdded> onPseudoElementAdded() {
    return rpcClient.eventFuture("DOM.pseudoElementAdded", PseudoElementAdded.class);
  }

  /**
   * Called when a pseudo element is removed from an element.
   */
  public void onPseudoElementRemoved(Consumer<PseudoElementRemoved> listener) {
    rpcClient.addEventListener("DOM.pseudoElementRemoved", listener, PseudoElementRemoved.class);
  }

  /**
   * Called when a pseudo element is removed from an element.
   */
  public CompletableFuture<PseudoElementRemoved> onPseudoElementRemoved() {
    return rpcClient.eventFuture("DOM.pseudoElementRemoved", PseudoElementRemoved.class);
  }

  /**
   * Called when distrubution is changed.
   */
  public void onDistributedNodesUpdated(Consumer<DistributedNodesUpdated> listener) {
    rpcClient.addEventListener("DOM.distributedNodesUpdated", listener, DistributedNodesUpdated.class);
  }

  /**
   * Called when distrubution is changed.
   */
  public CompletableFuture<DistributedNodesUpdated> onDistributedNodesUpdated() {
    return rpcClient.eventFuture("DOM.distributedNodesUpdated", DistributedNodesUpdated.class);
  }

  public void onNodeHighlightRequested(Consumer<NodeHighlightRequested> listener) {
    rpcClient.addEventListener("DOM.nodeHighlightRequested", listener, NodeHighlightRequested.class);
  }

  public CompletableFuture<NodeHighlightRequested> onNodeHighlightRequested() {
    return rpcClient.eventFuture("DOM.nodeHighlightRequested", NodeHighlightRequested.class);
  }

  /**
   * A structure holding an RGBA color.
   */
  public static class RGBA {
    /**
     * The red component, in the [0-255] range.
     */
    public Integer r;

    /**
     * The green component, in the [0-255] range.
     */
    public Integer g;

    /**
     * The blue component, in the [0-255] range.
     */
    public Integer b;

    /**
     * The alpha component, in the [0-1] range (default: 1).
     */
    public Double a;

    public String toString() {
      return "RGBA{r=" + r + ", g=" + g + ", b=" + b + ", a=" + a + "}";
    }
  }

  /**
   * Backend node with a friendly name.
   */
  public static class BackendNode {
    /**
     * <code>Node</code>'s nodeType.
     */
    public Integer nodeType;

    /**
     * <code>Node</code>'s nodeName.
     */
    public String nodeName;

    public Integer backendNodeId;

    public String toString() {
      return "BackendNode{nodeType=" + nodeType + ", nodeName=" + nodeName + ", backendNodeId=" + backendNodeId + "}";
    }
  }

  /**
   * DOM interaction is implemented in terms of mirror objects that represent the actual DOM nodes. DOMNode is a base node mirror type.
   */
  public static class Node {
    /**
     * Node identifier that is passed into the rest of the DOM messages as the <code>nodeId</code>. Backend will only push node with given <code>id</code> once. It is aware of all requested nodes and will only fire DOM events for nodes known to the client.
     */
    public Integer nodeId;

    /**
     * The BackendNodeId for this node.
     */
    public Integer backendNodeId;

    /**
     * <code>Node</code>'s nodeType.
     */
    public Integer nodeType;

    /**
     * <code>Node</code>'s nodeName.
     */
    public String nodeName;

    /**
     * <code>Node</code>'s localName.
     */
    public String localName;

    /**
     * <code>Node</code>'s nodeValue.
     */
    public String nodeValue;

    /**
     * Child count for <code>Container</code> nodes.
     */
    public Integer childNodeCount;

    /**
     * Child nodes of this node when requested with children.
     */
    public List<Node> children;

    /**
     * Attributes of the <code>Element</code> node in the form of flat array <code>[name1, value1, name2, value2]</code>.
     */
    public List<String> attributes;

    /**
     * Document URL that <code>Document</code> or <code>FrameOwner</code> node points to.
     */
    public String documentURL;

    /**
     * Base URL that <code>Document</code> or <code>FrameOwner</code> node uses for URL completion.
     */
    public String baseURL;

    /**
     * <code>DocumentType</code>'s publicId.
     */
    public String publicId;

    /**
     * <code>DocumentType</code>'s systemId.
     */
    public String systemId;

    /**
     * <code>DocumentType</code>'s internalSubset.
     */
    public String internalSubset;

    /**
     * <code>Document</code>'s XML version in case of XML documents.
     */
    public String xmlVersion;

    /**
     * <code>Attr</code>'s name.
     */
    public String name;

    /**
     * <code>Attr</code>'s value.
     */
    public String value;

    /**
     * Pseudo element type for this node.
     */
    public String pseudoType;

    /**
     * Shadow root type.
     */
    public String shadowRootType;

    /**
     * Frame ID for frame owner elements.
     */
    public String frameId;

    /**
     * Content document for frame owner elements.
     */
    public Node contentDocument;

    /**
     * Shadow root list for given element host.
     */
    public List<Node> shadowRoots;

    /**
     * Content document fragment for template elements.
     */
    public Node templateContent;

    /**
     * Pseudo elements associated with this node.
     */
    public List<Node> pseudoElements;

    /**
     * Import document for the HTMLImport links.
     */
    public Node importedDocument;

    /**
     * Distributed nodes for given insertion point.
     */
    public List<BackendNode> distributedNodes;

    /**
     * Whether the node is SVG.
     */
    public Boolean isSVG;

    public String toString() {
      return "Node{nodeId=" + nodeId + ", backendNodeId=" + backendNodeId + ", nodeType=" + nodeType + ", nodeName=" + nodeName + ", localName=" + localName + ", nodeValue=" + nodeValue + ", childNodeCount=" + childNodeCount + ", children=" + children + ", attributes=" + attributes + ", documentURL=" + documentURL + ", baseURL=" + baseURL + ", publicId=" + publicId + ", systemId=" + systemId + ", internalSubset=" + internalSubset + ", xmlVersion=" + xmlVersion + ", name=" + name + ", value=" + value + ", pseudoType=" + pseudoType + ", shadowRootType=" + shadowRootType + ", frameId=" + frameId + ", contentDocument=" + contentDocument + ", shadowRoots=" + shadowRoots + ", templateContent=" + templateContent + ", pseudoElements=" + pseudoElements + ", importedDocument=" + importedDocument + ", distributedNodes=" + distributedNodes + ", isSVG=" + isSVG + "}";
    }
  }

  public static class GetDocument {
    /**
     * Resulting node.
     */
    public Node root;

    public String toString() {
      return "GetDocument{root=" + root + "}";
    }
  }

  public static class CollectClassNamesFromSubtree {
    /**
     * Class name list.
     */
    public List<String> classNames;

    public String toString() {
      return "CollectClassNamesFromSubtree{classNames=" + classNames + "}";
    }
  }

  public static class QuerySelector {
    /**
     * Query selector result.
     */
    public Integer nodeId;

    public String toString() {
      return "QuerySelector{nodeId=" + nodeId + "}";
    }
  }

  public static class QuerySelectorAll {
    /**
     * Query selector result.
     */
    public List<Integer> nodeIds;

    public String toString() {
      return "QuerySelectorAll{nodeIds=" + nodeIds + "}";
    }
  }

  public static class SetNodeName {
    /**
     * New node's id.
     */
    public Integer nodeId;

    public String toString() {
      return "SetNodeName{nodeId=" + nodeId + "}";
    }
  }

  public static class GetOuterHTML {
    /**
     * Outer HTML markup.
     */
    public String outerHTML;

    public String toString() {
      return "GetOuterHTML{outerHTML=" + outerHTML + "}";
    }
  }

  public static class PerformSearch {
    /**
     * Unique search session identifier.
     */
    public String searchId;

    /**
     * Number of search results.
     */
    public Integer resultCount;

    public String toString() {
      return "PerformSearch{searchId=" + searchId + ", resultCount=" + resultCount + "}";
    }
  }

  public static class GetSearchResults {
    /**
     * Ids of the search result nodes.
     */
    public List<Integer> nodeIds;

    public String toString() {
      return "GetSearchResults{nodeIds=" + nodeIds + "}";
    }
  }

  public static class RequestNode {
    /**
     * Node id for given object.
     */
    public Integer nodeId;

    public String toString() {
      return "RequestNode{nodeId=" + nodeId + "}";
    }
  }

  /**
   * Configuration data for the highlighting of page elements.
   */
  public static class HighlightConfig {
    /**
     * Whether the node info tooltip should be shown (default: false).
     */
    public Boolean showInfo;

    /**
     * Whether the rulers should be shown (default: false).
     */
    public Boolean showRulers;

    /**
     * Whether the extension lines from node to the rulers should be shown (default: false).
     */
    public Boolean showExtensionLines;

    public Boolean displayAsMaterial;

    /**
     * The content box highlight fill color (default: transparent).
     */
    public RGBA contentColor;

    /**
     * The padding highlight fill color (default: transparent).
     */
    public RGBA paddingColor;

    /**
     * The border highlight fill color (default: transparent).
     */
    public RGBA borderColor;

    /**
     * The margin highlight fill color (default: transparent).
     */
    public RGBA marginColor;

    /**
     * The event target element highlight fill color (default: transparent).
     */
    public RGBA eventTargetColor;

    /**
     * The shape outside fill color (default: transparent).
     */
    public RGBA shapeColor;

    /**
     * The shape margin fill color (default: transparent).
     */
    public RGBA shapeMarginColor;

    /**
     * Selectors to highlight relevant nodes.
     */
    public String selectorList;

    public String toString() {
      return "HighlightConfig{showInfo=" + showInfo + ", showRulers=" + showRulers + ", showExtensionLines=" + showExtensionLines + ", displayAsMaterial=" + displayAsMaterial + ", contentColor=" + contentColor + ", paddingColor=" + paddingColor + ", borderColor=" + borderColor + ", marginColor=" + marginColor + ", eventTargetColor=" + eventTargetColor + ", shapeColor=" + shapeColor + ", shapeMarginColor=" + shapeMarginColor + ", selectorList=" + selectorList + "}";
    }
  }

  public static class PushNodeByPathToFrontend {
    /**
     * Id of the node for given path.
     */
    public Integer nodeId;

    public String toString() {
      return "PushNodeByPathToFrontend{nodeId=" + nodeId + "}";
    }
  }

  public static class PushNodesByBackendIdsToFrontend {
    /**
     * The array of ids of pushed nodes that correspond to the backend ids specified in backendNodeIds.
     */
    public List<Integer> nodeIds;

    public String toString() {
      return "PushNodesByBackendIdsToFrontend{nodeIds=" + nodeIds + "}";
    }
  }

  public static class ResolveNode {
    /**
     * JavaScript object wrapper for given node.
     */
    public RuntimeDomain.RemoteObject object;

    public String toString() {
      return "ResolveNode{object=" + object + "}";
    }
  }

  public static class GetAttributes {
    /**
     * An interleaved array of node attribute names and values.
     */
    public List<String> attributes;

    public String toString() {
      return "GetAttributes{attributes=" + attributes + "}";
    }
  }

  public static class CopyTo {
    /**
     * Id of the node clone.
     */
    public Integer nodeId;

    public String toString() {
      return "CopyTo{nodeId=" + nodeId + "}";
    }
  }

  public static class MoveTo {
    /**
     * New id of the moved node.
     */
    public Integer nodeId;

    public String toString() {
      return "MoveTo{nodeId=" + nodeId + "}";
    }
  }

  /**
   * CSS Shape Outside details.
   */
  public static class ShapeOutsideInfo {
    /**
     * Shape bounds
     */
    public List<Double> bounds;

    /**
     * Shape coordinate details
     */
    public List<Object> shape;

    /**
     * Margin shape bounds
     */
    public List<Object> marginShape;

    public String toString() {
      return "ShapeOutsideInfo{bounds=" + bounds + ", shape=" + shape + ", marginShape=" + marginShape + "}";
    }
  }

  /**
   * Box model.
   */
  public static class BoxModel {
    /**
     * Content box
     */
    public List<Double> content;

    /**
     * Padding box
     */
    public List<Double> padding;

    /**
     * Border box
     */
    public List<Double> border;

    /**
     * Margin box
     */
    public List<Double> margin;

    /**
     * Node width
     */
    public Integer width;

    /**
     * Node height
     */
    public Integer height;

    /**
     * Shape outside coordinates
     */
    public ShapeOutsideInfo shapeOutside;

    public String toString() {
      return "BoxModel{content=" + content + ", padding=" + padding + ", border=" + border + ", margin=" + margin + ", width=" + width + ", height=" + height + ", shapeOutside=" + shapeOutside + "}";
    }
  }

  public static class GetBoxModel {
    /**
     * Box model for the node.
     */
    public BoxModel model;

    public String toString() {
      return "GetBoxModel{model=" + model + "}";
    }
  }

  public static class GetNodeForLocation {
    /**
     * Id of the node at given coordinates.
     */
    public Integer nodeId;

    public String toString() {
      return "GetNodeForLocation{nodeId=" + nodeId + "}";
    }
  }

  public static class GetRelayoutBoundary {
    /**
     * Relayout boundary node id for the given node.
     */
    public Integer nodeId;

    public String toString() {
      return "GetRelayoutBoundary{nodeId=" + nodeId + "}";
    }
  }

  public static class GetHighlightObjectForTest {
    /**
     * Highlight data for the node.
     */
    public Map<String, Object> highlight;

    public String toString() {
      return "GetHighlightObjectForTest{highlight=" + highlight + "}";
    }
  }

  /**
   * Fired when <code>Document</code> has been totally updated. Node ids are no longer valid.
   */
  public static class DocumentUpdated {
    public String toString() {
      return "DocumentUpdated{}";
    }
  }

  /**
   * Fired when the node should be inspected. This happens after call to <code>setInspectMode</code>.
   */
  public static class InspectNodeRequested {
    /**
     * Id of the node to inspect.
     */
    public Integer backendNodeId;

    public String toString() {
      return "InspectNodeRequested{backendNodeId=" + backendNodeId + "}";
    }
  }

  /**
   * Fired when backend wants to provide client with the missing DOM structure. This happens upon most of the calls requesting node ids.
   */
  public static class SetChildNodes {
    /**
     * Parent node id to populate with children.
     */
    public Integer parentId;

    /**
     * Child nodes array.
     */
    public List<Node> nodes;

    public String toString() {
      return "SetChildNodes{parentId=" + parentId + ", nodes=" + nodes + "}";
    }
  }

  /**
   * Fired when <code>Element</code>'s attribute is modified.
   */
  public static class AttributeModified {
    /**
     * Id of the node that has changed.
     */
    public Integer nodeId;

    /**
     * Attribute name.
     */
    public String name;

    /**
     * Attribute value.
     */
    public String value;

    public String toString() {
      return "AttributeModified{nodeId=" + nodeId + ", name=" + name + ", value=" + value + "}";
    }
  }

  /**
   * Fired when <code>Element</code>'s attribute is removed.
   */
  public static class AttributeRemoved {
    /**
     * Id of the node that has changed.
     */
    public Integer nodeId;

    /**
     * A ttribute name.
     */
    public String name;

    public String toString() {
      return "AttributeRemoved{nodeId=" + nodeId + ", name=" + name + "}";
    }
  }

  /**
   * Fired when <code>Element</code>'s inline style is modified via a CSS property modification.
   */
  public static class InlineStyleInvalidated {
    /**
     * Ids of the nodes for which the inline styles have been invalidated.
     */
    public List<Integer> nodeIds;

    public String toString() {
      return "InlineStyleInvalidated{nodeIds=" + nodeIds + "}";
    }
  }

  /**
   * Mirrors <code>DOMCharacterDataModified</code> event.
   */
  public static class CharacterDataModified {
    /**
     * Id of the node that has changed.
     */
    public Integer nodeId;

    /**
     * New text value.
     */
    public String characterData;

    public String toString() {
      return "CharacterDataModified{nodeId=" + nodeId + ", characterData=" + characterData + "}";
    }
  }

  /**
   * Fired when <code>Container</code>'s child node count has changed.
   */
  public static class ChildNodeCountUpdated {
    /**
     * Id of the node that has changed.
     */
    public Integer nodeId;

    /**
     * New node count.
     */
    public Integer childNodeCount;

    public String toString() {
      return "ChildNodeCountUpdated{nodeId=" + nodeId + ", childNodeCount=" + childNodeCount + "}";
    }
  }

  /**
   * Mirrors <code>DOMNodeInserted</code> event.
   */
  public static class ChildNodeInserted {
    /**
     * Id of the node that has changed.
     */
    public Integer parentNodeId;

    /**
     * If of the previous siblint.
     */
    public Integer previousNodeId;

    /**
     * Inserted node data.
     */
    public Node node;

    public String toString() {
      return "ChildNodeInserted{parentNodeId=" + parentNodeId + ", previousNodeId=" + previousNodeId + ", node=" + node + "}";
    }
  }

  /**
   * Mirrors <code>DOMNodeRemoved</code> event.
   */
  public static class ChildNodeRemoved {
    /**
     * Parent id.
     */
    public Integer parentNodeId;

    /**
     * Id of the node that has been removed.
     */
    public Integer nodeId;

    public String toString() {
      return "ChildNodeRemoved{parentNodeId=" + parentNodeId + ", nodeId=" + nodeId + "}";
    }
  }

  /**
   * Called when shadow root is pushed into the element.
   */
  public static class ShadowRootPushed {
    /**
     * Host element id.
     */
    public Integer hostId;

    /**
     * Shadow root.
     */
    public Node root;

    public String toString() {
      return "ShadowRootPushed{hostId=" + hostId + ", root=" + root + "}";
    }
  }

  /**
   * Called when shadow root is popped from the element.
   */
  public static class ShadowRootPopped {
    /**
     * Host element id.
     */
    public Integer hostId;

    /**
     * Shadow root id.
     */
    public Integer rootId;

    public String toString() {
      return "ShadowRootPopped{hostId=" + hostId + ", rootId=" + rootId + "}";
    }
  }

  /**
   * Called when a pseudo element is added to an element.
   */
  public static class PseudoElementAdded {
    /**
     * Pseudo element's parent element id.
     */
    public Integer parentId;

    /**
     * The added pseudo element.
     */
    public Node pseudoElement;

    public String toString() {
      return "PseudoElementAdded{parentId=" + parentId + ", pseudoElement=" + pseudoElement + "}";
    }
  }

  /**
   * Called when a pseudo element is removed from an element.
   */
  public static class PseudoElementRemoved {
    /**
     * Pseudo element's parent element id.
     */
    public Integer parentId;

    /**
     * The removed pseudo element id.
     */
    public Integer pseudoElementId;

    public String toString() {
      return "PseudoElementRemoved{parentId=" + parentId + ", pseudoElementId=" + pseudoElementId + "}";
    }
  }

  /**
   * Called when distrubution is changed.
   */
  public static class DistributedNodesUpdated {
    /**
     * Insertion point where distrubuted nodes were updated.
     */
    public Integer insertionPointId;

    /**
     * Distributed nodes for given insertion point.
     */
    public List<BackendNode> distributedNodes;

    public String toString() {
      return "DistributedNodesUpdated{insertionPointId=" + insertionPointId + ", distributedNodes=" + distributedNodes + "}";
    }
  }

  public static class NodeHighlightRequested {
    public Integer nodeId;

    public String toString() {
      return "NodeHighlightRequested{nodeId=" + nodeId + "}";
    }
  }

  /**
   * Rectangle.
   */
  public static class Rect {
    /**
     * X coordinate
     */
    public Double x;

    /**
     * Y coordinate
     */
    public Double y;

    /**
     * Rectangle width
     */
    public Double width;

    /**
     * Rectangle height
     */
    public Double height;

    public String toString() {
      return "Rect{x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "}";
    }
  }
}
