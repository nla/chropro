package chropro;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class AccessibilityDomain {
  private RpcClient rpcClient;

  public AccessibilityDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Fetches the accessibility node and partial accessibility tree for this DOM node, if it exists.
   * @param nodeId ID of node to get the partial accessibility tree for.
   * @param fetchRelatives Whether to fetch this nodes ancestors, siblings and children. Defaults to true.
   */
  public CompletableFuture<GetPartialAXTree> getPartialAXTree(@NotNull Integer nodeId, @Nullable Boolean fetchRelatives) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("fetchRelatives", fetchRelatives);
    return rpcClient.call("Accessibility.getPartialAXTree", params, GetPartialAXTree.class);
  }

  public static class AXRelatedNode {
    /**
     * The BackendNodeId of the related DOM node.
     */
    public Integer backendDOMNodeId;

    /**
     * The IDRef value provided, if any.
     */
    public String idref;

    /**
     * The text alternative of this node in the current context.
     */
    public String text;

    public String toString() {
      return "AXRelatedNode{backendDOMNodeId=" + backendDOMNodeId + ", idref=" + idref + ", text=" + text + "}";
    }
  }

  /**
   * A single source for a computed AX property.
   */
  public static class AXValueSource {
    /**
     * What type of source this is.
     */
    public String type;

    /**
     * The value of this property source.
     */
    public AXValue value;

    /**
     * The name of the relevant attribute, if any.
     */
    public String attribute;

    /**
     * The value of the relevant attribute, if any.
     */
    public AXValue attributeValue;

    /**
     * Whether this source is superseded by a higher priority source.
     */
    public Boolean superseded;

    /**
     * The native markup source for this value, e.g. a <label> element.
     */
    public String nativeSource;

    /**
     * The value, such as a node or node list, of the native source.
     */
    public AXValue nativeSourceValue;

    /**
     * Whether the value for this property is invalid.
     */
    public Boolean invalid;

    /**
     * Reason for the value being invalid, if it is.
     */
    public String invalidReason;

    public String toString() {
      return "AXValueSource{type=" + type + ", value=" + value + ", attribute=" + attribute + ", attributeValue=" + attributeValue + ", superseded=" + superseded + ", nativeSource=" + nativeSource + ", nativeSourceValue=" + nativeSourceValue + ", invalid=" + invalid + ", invalidReason=" + invalidReason + "}";
    }
  }

  /**
   * A single computed AX property.
   */
  public static class AXValue {
    /**
     * The type of this value.
     */
    public String type;

    /**
     * The computed value of this property.
     */
    public Object value;

    /**
     * One or more related nodes, if applicable.
     */
    public List<AXRelatedNode> relatedNodes;

    /**
     * The sources which contributed to the computation of this property.
     */
    public List<AXValueSource> sources;

    public String toString() {
      return "AXValue{type=" + type + ", value=" + value + ", relatedNodes=" + relatedNodes + ", sources=" + sources + "}";
    }
  }

  public static class AXProperty {
    /**
     * The name of this property.
     */
    public String name;

    /**
     * The value of this property.
     */
    public AXValue value;

    public String toString() {
      return "AXProperty{name=" + name + ", value=" + value + "}";
    }
  }

  /**
   * A node in the accessibility tree.
   */
  public static class AXNode {
    /**
     * Unique identifier for this node.
     */
    public String nodeId;

    /**
     * Whether this node is ignored for accessibility
     */
    public Boolean ignored;

    /**
     * Collection of reasons why this node is hidden.
     */
    public List<AXProperty> ignoredReasons;

    /**
     * This <code>Node</code>'s role, whether explicit or implicit.
     */
    public AXValue role;

    /**
     * The accessible name for this <code>Node</code>.
     */
    public AXValue name;

    /**
     * The accessible description for this <code>Node</code>.
     */
    public AXValue description;

    /**
     * The value for this <code>Node</code>.
     */
    public AXValue value;

    /**
     * All other properties
     */
    public List<AXProperty> properties;

    /**
     * IDs for each of this node's child nodes.
     */
    public List<String> childIds;

    /**
     * The backend ID for the associated DOM node, if any.
     */
    public Integer backendDOMNodeId;

    public String toString() {
      return "AXNode{nodeId=" + nodeId + ", ignored=" + ignored + ", ignoredReasons=" + ignoredReasons + ", role=" + role + ", name=" + name + ", description=" + description + ", value=" + value + ", properties=" + properties + ", childIds=" + childIds + ", backendDOMNodeId=" + backendDOMNodeId + "}";
    }
  }

  public static class GetPartialAXTree {
    /**
     * The <code>Accessibility.AXNode</code> for this DOM node, if it exists, plus its ancestors, siblings and children, if requested.
     */
    public List<AXNode> nodes;

    public String toString() {
      return "GetPartialAXTree{nodes=" + nodes + "}";
    }
  }
}
