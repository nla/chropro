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
    date = "2016-12-20T03:33:59.982Z"
)
public class CSSDomain {
  private RpcClient rpcClient;

  public CSSDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables the CSS agent for the given page. Clients should not assume that the CSS agent has been enabled until the result of this command is received.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("CSS.enable", params, Void.class);
  }

  /**
   * Disables the CSS agent for the given page.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("CSS.disable", params, Void.class);
  }

  /**
   * Returns requested styles for a DOM node identified by <code>nodeId</code>.
   */
  public CompletableFuture<GetMatchedStylesForNode> getMatchedStylesForNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("CSS.getMatchedStylesForNode", params, GetMatchedStylesForNode.class);
  }

  /**
   * Returns the styles defined inline (explicitly in the "style" attribute and implicitly, using DOM attributes) for a DOM node identified by <code>nodeId</code>.
   */
  public CompletableFuture<GetInlineStylesForNode> getInlineStylesForNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("CSS.getInlineStylesForNode", params, GetInlineStylesForNode.class);
  }

  /**
   * Returns the computed style for a DOM node identified by <code>nodeId</code>.
   */
  public CompletableFuture<GetComputedStyleForNode> getComputedStyleForNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("CSS.getComputedStyleForNode", params, GetComputedStyleForNode.class);
  }

  /**
   * Requests information about platform fonts which we used to render child TextNodes in the given node.
   */
  public CompletableFuture<GetPlatformFontsForNode> getPlatformFontsForNode(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("CSS.getPlatformFontsForNode", params, GetPlatformFontsForNode.class);
  }

  /**
   * Returns the current textual content and the URL for a stylesheet.
   */
  public CompletableFuture<GetStyleSheetText> getStyleSheetText(@NotNull String styleSheetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    return rpcClient.call("CSS.getStyleSheetText", params, GetStyleSheetText.class);
  }

  /**
   * Returns all class names from specified stylesheet.
   */
  public CompletableFuture<CollectClassNames> collectClassNames(@NotNull String styleSheetId) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    return rpcClient.call("CSS.collectClassNames", params, CollectClassNames.class);
  }

  /**
   * Sets the new stylesheet text.
   */
  public CompletableFuture<SetStyleSheetText> setStyleSheetText(@NotNull String styleSheetId, @NotNull String text) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    params.put("text", text);
    return rpcClient.call("CSS.setStyleSheetText", params, SetStyleSheetText.class);
  }

  /**
   * Modifies the rule selector.
   */
  public CompletableFuture<SetRuleSelector> setRuleSelector(@NotNull String styleSheetId, @NotNull SourceRange range, @NotNull String selector) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    params.put("range", range);
    params.put("selector", selector);
    return rpcClient.call("CSS.setRuleSelector", params, SetRuleSelector.class);
  }

  /**
   * Modifies the keyframe rule key text.
   */
  public CompletableFuture<SetKeyframeKey> setKeyframeKey(@NotNull String styleSheetId, @NotNull SourceRange range, @NotNull String keyText) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    params.put("range", range);
    params.put("keyText", keyText);
    return rpcClient.call("CSS.setKeyframeKey", params, SetKeyframeKey.class);
  }

  /**
   * Applies specified style edits one after another in the given order.
   */
  public CompletableFuture<SetStyleTexts> setStyleTexts(@NotNull List<StyleDeclarationEdit> edits) {
    Map<String,Object> params = new HashMap<>();
    params.put("edits", edits);
    return rpcClient.call("CSS.setStyleTexts", params, SetStyleTexts.class);
  }

  /**
   * Modifies the rule selector.
   */
  public CompletableFuture<SetMediaText> setMediaText(@NotNull String styleSheetId, @NotNull SourceRange range, @NotNull String text) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    params.put("range", range);
    params.put("text", text);
    return rpcClient.call("CSS.setMediaText", params, SetMediaText.class);
  }

  /**
   * Creates a new special "via-inspector" stylesheet in the frame with given <code>frameId</code>.
   * @param frameId Identifier of the frame where "via-inspector" stylesheet should be created.
   */
  public CompletableFuture<CreateStyleSheet> createStyleSheet(@NotNull String frameId) {
    Map<String,Object> params = new HashMap<>();
    params.put("frameId", frameId);
    return rpcClient.call("CSS.createStyleSheet", params, CreateStyleSheet.class);
  }

  /**
   * Inserts a new rule with the given <code>ruleText</code> in a stylesheet with given <code>styleSheetId</code>, at the position specified by <code>location</code>.
   * @param styleSheetId The css style sheet identifier where a new rule should be inserted.
   * @param ruleText The text of a new rule.
   * @param location Text position of a new rule in the target style sheet.
   */
  public CompletableFuture<AddRule> addRule(@NotNull String styleSheetId, @NotNull String ruleText, @NotNull SourceRange location) {
    Map<String,Object> params = new HashMap<>();
    params.put("styleSheetId", styleSheetId);
    params.put("ruleText", ruleText);
    params.put("location", location);
    return rpcClient.call("CSS.addRule", params, AddRule.class);
  }

  /**
   * Ensures that the given node will have specified pseudo-classes whenever its style is computed by the browser.
   * @param nodeId The element id for which to force the pseudo state.
   * @param forcedPseudoClasses Element pseudo classes to force when computing the element's style.
   */
  public CompletableFuture<Void> forcePseudoState(@NotNull Integer nodeId, @NotNull List<String> forcedPseudoClasses) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("forcedPseudoClasses", forcedPseudoClasses);
    return rpcClient.call("CSS.forcePseudoState", params, Void.class);
  }

  /**
   * Returns all media queries parsed by the rendering engine.
   */
  public CompletableFuture<GetMediaQueries> getMediaQueries() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("CSS.getMediaQueries", params, GetMediaQueries.class);
  }

  /**
   * Find a rule with the given active property for the given node and set the new value for this property
   * @param nodeId The element id for which to set property.
   */
  public CompletableFuture<Void> setEffectivePropertyValueForNode(@NotNull Integer nodeId, @NotNull String propertyName, @NotNull String value) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    params.put("propertyName", propertyName);
    params.put("value", value);
    return rpcClient.call("CSS.setEffectivePropertyValueForNode", params, Void.class);
  }

  /**
   * @param nodeId Id of the node to get background colors for.
   */
  public CompletableFuture<GetBackgroundColors> getBackgroundColors(@NotNull Integer nodeId) {
    Map<String,Object> params = new HashMap<>();
    params.put("nodeId", nodeId);
    return rpcClient.call("CSS.getBackgroundColors", params, GetBackgroundColors.class);
  }

  /**
   * For the main document and any content documents, return the LayoutTreeNodes and a whitelisted subset of the computed style. It only returns pushed nodes, on way to pull all nodes is to call DOM.getDocument with a depth of -1.
   * @param computedStyleWhitelist Whitelist of computed styles to return.
   */
  public CompletableFuture<GetLayoutTreeAndStyles> getLayoutTreeAndStyles(@NotNull List<String> computedStyleWhitelist) {
    Map<String,Object> params = new HashMap<>();
    params.put("computedStyleWhitelist", computedStyleWhitelist);
    return rpcClient.call("CSS.getLayoutTreeAndStyles", params, GetLayoutTreeAndStyles.class);
  }

  /**
   * Enables the selector recording.
   */
  public CompletableFuture<Void> startRuleUsageTracking() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("CSS.startRuleUsageTracking", params, Void.class);
  }

  /**
   * The list of rules with an indication of whether these were used
   */
  public CompletableFuture<StopRuleUsageTracking> stopRuleUsageTracking() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("CSS.stopRuleUsageTracking", params, StopRuleUsageTracking.class);
  }

  /**
   * Fires whenever a MediaQuery result changes (for example, after a browser window has been resized.) The current implementation considers only viewport-dependent media features.
   */
  public void onMediaQueryResultChanged(Consumer<MediaQueryResultChanged> listener) {
    rpcClient.addEventListener("CSS.mediaQueryResultChanged", listener, MediaQueryResultChanged.class);
  }

  /**
   * Fires whenever a MediaQuery result changes (for example, after a browser window has been resized.) The current implementation considers only viewport-dependent media features.
   */
  public CompletableFuture<MediaQueryResultChanged> onMediaQueryResultChanged() {
    return rpcClient.eventFuture("CSS.mediaQueryResultChanged", MediaQueryResultChanged.class);
  }

  /**
   * Fires whenever a web font gets loaded.
   */
  public void onFontsUpdated(Consumer<FontsUpdated> listener) {
    rpcClient.addEventListener("CSS.fontsUpdated", listener, FontsUpdated.class);
  }

  /**
   * Fires whenever a web font gets loaded.
   */
  public CompletableFuture<FontsUpdated> onFontsUpdated() {
    return rpcClient.eventFuture("CSS.fontsUpdated", FontsUpdated.class);
  }

  /**
   * Fired whenever a stylesheet is changed as a result of the client operation.
   */
  public void onStyleSheetChanged(Consumer<StyleSheetChanged> listener) {
    rpcClient.addEventListener("CSS.styleSheetChanged", listener, StyleSheetChanged.class);
  }

  /**
   * Fired whenever a stylesheet is changed as a result of the client operation.
   */
  public CompletableFuture<StyleSheetChanged> onStyleSheetChanged() {
    return rpcClient.eventFuture("CSS.styleSheetChanged", StyleSheetChanged.class);
  }

  /**
   * Fired whenever an active document stylesheet is added.
   */
  public void onStyleSheetAdded(Consumer<StyleSheetAdded> listener) {
    rpcClient.addEventListener("CSS.styleSheetAdded", listener, StyleSheetAdded.class);
  }

  /**
   * Fired whenever an active document stylesheet is added.
   */
  public CompletableFuture<StyleSheetAdded> onStyleSheetAdded() {
    return rpcClient.eventFuture("CSS.styleSheetAdded", StyleSheetAdded.class);
  }

  /**
   * Fired whenever an active document stylesheet is removed.
   */
  public void onStyleSheetRemoved(Consumer<StyleSheetRemoved> listener) {
    rpcClient.addEventListener("CSS.styleSheetRemoved", listener, StyleSheetRemoved.class);
  }

  /**
   * Fired whenever an active document stylesheet is removed.
   */
  public CompletableFuture<StyleSheetRemoved> onStyleSheetRemoved() {
    return rpcClient.eventFuture("CSS.styleSheetRemoved", StyleSheetRemoved.class);
  }

  /**
   * Text range within a resource. All numbers are zero-based.
   */
  public static class SourceRange {
    /**
     * Start line of range.
     */
    public Integer startLine;

    /**
     * Start column of range (inclusive).
     */
    public Integer startColumn;

    /**
     * End line of range
     */
    public Integer endLine;

    /**
     * End column of range (exclusive).
     */
    public Integer endColumn;

    public String toString() {
      return "SourceRange{startLine=" + startLine + ", startColumn=" + startColumn + ", endLine=" + endLine + ", endColumn=" + endColumn + "}";
    }
  }

  /**
   * CSS property declaration data.
   */
  public static class CSSProperty {
    /**
     * The property name.
     */
    public String name;

    /**
     * The property value.
     */
    public String value;

    /**
     * Whether the property has "!important" annotation (implies <code>false</code> if absent).
     */
    public Boolean important;

    /**
     * Whether the property is implicit (implies <code>false</code> if absent).
     */
    public Boolean implicit;

    /**
     * The full property text as specified in the style.
     */
    public String text;

    /**
     * Whether the property is understood by the browser (implies <code>true</code> if absent).
     */
    public Boolean parsedOk;

    /**
     * Whether the property is disabled by the user (present for source-based properties only).
     */
    public Boolean disabled;

    /**
     * The entire property range in the enclosing style declaration (if available).
     */
    public SourceRange range;

    public String toString() {
      return "CSSProperty{name=" + name + ", value=" + value + ", important=" + important + ", implicit=" + implicit + ", text=" + text + ", parsedOk=" + parsedOk + ", disabled=" + disabled + ", range=" + range + "}";
    }
  }

  public static class ShorthandEntry {
    /**
     * Shorthand name.
     */
    public String name;

    /**
     * Shorthand value.
     */
    public String value;

    /**
     * Whether the property has "!important" annotation (implies <code>false</code> if absent).
     */
    public Boolean important;

    public String toString() {
      return "ShorthandEntry{name=" + name + ", value=" + value + ", important=" + important + "}";
    }
  }

  /**
   * CSS style representation.
   */
  public static class CSSStyle {
    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
     */
    public String styleSheetId;

    /**
     * CSS properties in the style.
     */
    public List<CSSProperty> cssProperties;

    /**
     * Computed values for all shorthands found in the style.
     */
    public List<ShorthandEntry> shorthandEntries;

    /**
     * Style declaration text (if available).
     */
    public String cssText;

    /**
     * Style declaration range in the enclosing stylesheet (if available).
     */
    public SourceRange range;

    public String toString() {
      return "CSSStyle{styleSheetId=" + styleSheetId + ", cssProperties=" + cssProperties + ", shorthandEntries=" + shorthandEntries + ", cssText=" + cssText + ", range=" + range + "}";
    }
  }

  /**
   * Data for a simple selector (these are delimited by commas in a selector list).
   */
  public static class Value {
    /**
     * Value text.
     */
    public String text;

    /**
     * Value range in the underlying resource (if available).
     */
    public SourceRange range;

    public String toString() {
      return "Value{text=" + text + ", range=" + range + "}";
    }
  }

  /**
   * Selector list data.
   */
  public static class SelectorList {
    /**
     * Selectors in the list.
     */
    public List<Value> selectors;

    /**
     * Rule selector text.
     */
    public String text;

    public String toString() {
      return "SelectorList{selectors=" + selectors + ", text=" + text + "}";
    }
  }

  /**
   * Media query expression descriptor.
   */
  public static class MediaQueryExpression {
    /**
     * Media query expression value.
     */
    public Double value;

    /**
     * Media query expression units.
     */
    public String unit;

    /**
     * Media query expression feature.
     */
    public String feature;

    /**
     * The associated range of the value text in the enclosing stylesheet (if available).
     */
    public SourceRange valueRange;

    /**
     * Computed length of media query expression (if applicable).
     */
    public Double computedLength;

    public String toString() {
      return "MediaQueryExpression{value=" + value + ", unit=" + unit + ", feature=" + feature + ", valueRange=" + valueRange + ", computedLength=" + computedLength + "}";
    }
  }

  /**
   * Media query descriptor.
   */
  public static class MediaQuery {
    /**
     * Array of media query expressions.
     */
    public List<MediaQueryExpression> expressions;

    /**
     * Whether the media query condition is satisfied.
     */
    public Boolean active;

    public String toString() {
      return "MediaQuery{expressions=" + expressions + ", active=" + active + "}";
    }
  }

  /**
   * CSS media rule descriptor.
   */
  public static class CSSMedia {
    /**
     * Media query text.
     */
    public String text;

    /**
     * Source of the media query: "mediaRule" if specified by a @media rule, "importRule" if specified by an @import rule, "linkedSheet" if specified by a "media" attribute in a linked stylesheet's LINK tag, "inlineSheet" if specified by a "media" attribute in an inline stylesheet's STYLE tag.
     */
    public String source;

    /**
     * URL of the document containing the media query description.
     */
    public String sourceURL;

    /**
     * The associated rule (@media or @import) header range in the enclosing stylesheet (if available).
     */
    public SourceRange range;

    /**
     * Identifier of the stylesheet containing this object (if exists).
     */
    public String styleSheetId;

    /**
     * Array of media queries.
     */
    public List<MediaQuery> mediaList;

    public String toString() {
      return "CSSMedia{text=" + text + ", source=" + source + ", sourceURL=" + sourceURL + ", range=" + range + ", styleSheetId=" + styleSheetId + ", mediaList=" + mediaList + "}";
    }
  }

  /**
   * CSS rule representation.
   */
  public static class CSSRule {
    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
     */
    public String styleSheetId;

    /**
     * Rule selector data.
     */
    public SelectorList selectorList;

    /**
     * Parent stylesheet's origin.
     */
    public String origin;

    /**
     * Associated style declaration.
     */
    public CSSStyle style;

    /**
     * Media list array (for rules involving media queries). The array enumerates media queries starting with the innermost one, going outwards.
     */
    public List<CSSMedia> media;

    public String toString() {
      return "CSSRule{styleSheetId=" + styleSheetId + ", selectorList=" + selectorList + ", origin=" + origin + ", style=" + style + ", media=" + media + "}";
    }
  }

  /**
   * Match data for a CSS rule.
   */
  public static class RuleMatch {
    /**
     * CSS rule in the match.
     */
    public CSSRule rule;

    /**
     * Matching selector indices in the rule's selectorList selectors (0-based).
     */
    public List<Integer> matchingSelectors;

    public String toString() {
      return "RuleMatch{rule=" + rule + ", matchingSelectors=" + matchingSelectors + "}";
    }
  }

  /**
   * CSS rule collection for a single pseudo style.
   */
  public static class PseudoElementMatches {
    /**
     * Pseudo element type.
     */
    public String pseudoType;

    /**
     * Matches of CSS rules applicable to the pseudo style.
     */
    public List<RuleMatch> matches;

    public String toString() {
      return "PseudoElementMatches{pseudoType=" + pseudoType + ", matches=" + matches + "}";
    }
  }

  /**
   * Inherited CSS rule collection from ancestor node.
   */
  public static class InheritedStyleEntry {
    /**
     * The ancestor node's inline style, if any, in the style inheritance chain.
     */
    public CSSStyle inlineStyle;

    /**
     * Matches of CSS rules matching the ancestor node in the style inheritance chain.
     */
    public List<RuleMatch> matchedCSSRules;

    public String toString() {
      return "InheritedStyleEntry{inlineStyle=" + inlineStyle + ", matchedCSSRules=" + matchedCSSRules + "}";
    }
  }

  /**
   * CSS keyframe rule representation.
   */
  public static class CSSKeyframeRule {
    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
     */
    public String styleSheetId;

    /**
     * Parent stylesheet's origin.
     */
    public String origin;

    /**
     * Associated key text.
     */
    public Value keyText;

    /**
     * Associated style declaration.
     */
    public CSSStyle style;

    public String toString() {
      return "CSSKeyframeRule{styleSheetId=" + styleSheetId + ", origin=" + origin + ", keyText=" + keyText + ", style=" + style + "}";
    }
  }

  /**
   * CSS keyframes rule representation.
   */
  public static class CSSKeyframesRule {
    /**
     * Animation name.
     */
    public Value animationName;

    /**
     * List of keyframes.
     */
    public List<CSSKeyframeRule> keyframes;

    public String toString() {
      return "CSSKeyframesRule{animationName=" + animationName + ", keyframes=" + keyframes + "}";
    }
  }

  public static class GetMatchedStylesForNode {
    /**
     * Inline style for the specified DOM node.
     */
    public CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    public CSSStyle attributesStyle;

    /**
     * CSS rules matching this node, from all applicable stylesheets.
     */
    public List<RuleMatch> matchedCSSRules;

    /**
     * Pseudo style matches for this node.
     */
    public List<PseudoElementMatches> pseudoElements;

    /**
     * A chain of inherited styles (from the immediate node parent up to the DOM tree root).
     */
    public List<InheritedStyleEntry> inherited;

    /**
     * A list of CSS keyframed animations matching this node.
     */
    public List<CSSKeyframesRule> cssKeyframesRules;

    public String toString() {
      return "GetMatchedStylesForNode{inlineStyle=" + inlineStyle + ", attributesStyle=" + attributesStyle + ", matchedCSSRules=" + matchedCSSRules + ", pseudoElements=" + pseudoElements + ", inherited=" + inherited + ", cssKeyframesRules=" + cssKeyframesRules + "}";
    }
  }

  public static class GetInlineStylesForNode {
    /**
     * Inline style for the specified DOM node.
     */
    public CSSStyle inlineStyle;

    /**
     * Attribute-defined element style (e.g. resulting from "width=20 height=100%").
     */
    public CSSStyle attributesStyle;

    public String toString() {
      return "GetInlineStylesForNode{inlineStyle=" + inlineStyle + ", attributesStyle=" + attributesStyle + "}";
    }
  }

  public static class CSSComputedStyleProperty {
    /**
     * Computed style property name.
     */
    public String name;

    /**
     * Computed style property value.
     */
    public String value;

    public String toString() {
      return "CSSComputedStyleProperty{name=" + name + ", value=" + value + "}";
    }
  }

  public static class GetComputedStyleForNode {
    /**
     * Computed style for the specified DOM node.
     */
    public List<CSSComputedStyleProperty> computedStyle;

    public String toString() {
      return "GetComputedStyleForNode{computedStyle=" + computedStyle + "}";
    }
  }

  /**
   * Information about amount of glyphs that were rendered with given font.
   */
  public static class PlatformFontUsage {
    /**
     * Font's family name reported by platform.
     */
    public String familyName;

    /**
     * Indicates if the font was downloaded or resolved locally.
     */
    public Boolean isCustomFont;

    /**
     * Amount of glyphs that were rendered with this font.
     */
    public Double glyphCount;

    public String toString() {
      return "PlatformFontUsage{familyName=" + familyName + ", isCustomFont=" + isCustomFont + ", glyphCount=" + glyphCount + "}";
    }
  }

  public static class GetPlatformFontsForNode {
    /**
     * Usage statistics for every employed platform font.
     */
    public List<PlatformFontUsage> fonts;

    public String toString() {
      return "GetPlatformFontsForNode{fonts=" + fonts + "}";
    }
  }

  public static class GetStyleSheetText {
    /**
     * The stylesheet text.
     */
    public String text;

    public String toString() {
      return "GetStyleSheetText{text=" + text + "}";
    }
  }

  public static class CollectClassNames {
    /**
     * Class name list.
     */
    public List<String> classNames;

    public String toString() {
      return "CollectClassNames{classNames=" + classNames + "}";
    }
  }

  public static class SetStyleSheetText {
    /**
     * URL of source map associated with script (if any).
     */
    public String sourceMapURL;

    public String toString() {
      return "SetStyleSheetText{sourceMapURL=" + sourceMapURL + "}";
    }
  }

  public static class SetRuleSelector {
    /**
     * The resulting selector list after modification.
     */
    public SelectorList selectorList;

    public String toString() {
      return "SetRuleSelector{selectorList=" + selectorList + "}";
    }
  }

  public static class SetKeyframeKey {
    /**
     * The resulting key text after modification.
     */
    public Value keyText;

    public String toString() {
      return "SetKeyframeKey{keyText=" + keyText + "}";
    }
  }

  public static class SetStyleTexts {
    /**
     * The resulting styles after modification.
     */
    public List<CSSStyle> styles;

    public String toString() {
      return "SetStyleTexts{styles=" + styles + "}";
    }
  }

  /**
   * A descriptor of operation to mutate style declaration text.
   */
  public static class StyleDeclarationEdit {
    /**
     * The css style sheet identifier.
     */
    public String styleSheetId;

    /**
     * The range of the style text in the enclosing stylesheet.
     */
    public SourceRange range;

    /**
     * New style text.
     */
    public String text;

    public String toString() {
      return "StyleDeclarationEdit{styleSheetId=" + styleSheetId + ", range=" + range + ", text=" + text + "}";
    }
  }

  public static class SetMediaText {
    /**
     * The resulting CSS media rule after modification.
     */
    public CSSMedia media;

    public String toString() {
      return "SetMediaText{media=" + media + "}";
    }
  }

  public static class CreateStyleSheet {
    /**
     * Identifier of the created "via-inspector" stylesheet.
     */
    public String styleSheetId;

    public String toString() {
      return "CreateStyleSheet{styleSheetId=" + styleSheetId + "}";
    }
  }

  public static class AddRule {
    /**
     * The newly created rule.
     */
    public CSSRule rule;

    public String toString() {
      return "AddRule{rule=" + rule + "}";
    }
  }

  public static class GetMediaQueries {
    public List<CSSMedia> medias;

    public String toString() {
      return "GetMediaQueries{medias=" + medias + "}";
    }
  }

  public static class GetBackgroundColors {
    /**
     * The range of background colors behind this element, if it contains any visible text. If no visible text is present, this will be undefined. In the case of a flat background color, this will consist of simply that color. In the case of a gradient, this will consist of each of the color stops. For anything more complicated, this will be an empty array. Images will be ignored (as if the image had failed to load).
     */
    public List<String> backgroundColors;

    public String toString() {
      return "GetBackgroundColors{backgroundColors=" + backgroundColors + "}";
    }
  }

  /**
   * Details of post layout rendered text positions. The exact layout should not be regarded as stable and may change between versions.
   */
  public static class InlineTextBox {
    /**
     * The absolute position bounding box.
     */
    public DOMDomain.Rect boundingBox;

    /**
     * The starting index in characters, for this post layout textbox substring.
     */
    public Integer startCharacterIndex;

    /**
     * The number of characters in this post layout textbox substring.
     */
    public Integer numCharacters;

    public String toString() {
      return "InlineTextBox{boundingBox=" + boundingBox + ", startCharacterIndex=" + startCharacterIndex + ", numCharacters=" + numCharacters + "}";
    }
  }

  /**
   * Details of an element in the DOM tree with a LayoutObject.
   */
  public static class LayoutTreeNode {
    /**
     * The id of the related DOM node matching one from DOM.GetDocument.
     */
    public Integer nodeId;

    /**
     * The absolute position bounding box.
     */
    public DOMDomain.Rect boundingBox;

    /**
     * Contents of the LayoutText if any
     */
    public String layoutText;

    /**
     * The post layout inline text nodes, if any.
     */
    public List<InlineTextBox> inlineTextNodes;

    /**
     * Index into the computedStyles array returned by getLayoutTreeAndStyles.
     */
    public Integer styleIndex;

    public String toString() {
      return "LayoutTreeNode{nodeId=" + nodeId + ", boundingBox=" + boundingBox + ", layoutText=" + layoutText + ", inlineTextNodes=" + inlineTextNodes + ", styleIndex=" + styleIndex + "}";
    }
  }

  /**
   * A subset of the full ComputedStyle as defined by the request whitelist.
   */
  public static class ComputedStyle {
    public List<CSSComputedStyleProperty> properties;

    public String toString() {
      return "ComputedStyle{properties=" + properties + "}";
    }
  }

  public static class GetLayoutTreeAndStyles {
    public List<LayoutTreeNode> layoutTreeNodes;

    public List<ComputedStyle> computedStyles;

    public String toString() {
      return "GetLayoutTreeAndStyles{layoutTreeNodes=" + layoutTreeNodes + ", computedStyles=" + computedStyles + "}";
    }
  }

  /**
   * CSS rule usage information.
   */
  public static class RuleUsage {
    /**
     * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet rules) this rule came from.
     */
    public String styleSheetId;

    /**
     * Style declaration range in the enclosing stylesheet (if available).
     */
    public SourceRange range;

    /**
     * Indicates whether the rule was actually used by some element in the page.
     */
    public Boolean used;

    public String toString() {
      return "RuleUsage{styleSheetId=" + styleSheetId + ", range=" + range + ", used=" + used + "}";
    }
  }

  public static class StopRuleUsageTracking {
    public List<RuleUsage> ruleUsage;

    public String toString() {
      return "StopRuleUsageTracking{ruleUsage=" + ruleUsage + "}";
    }
  }

  /**
   * Fires whenever a MediaQuery result changes (for example, after a browser window has been resized.) The current implementation considers only viewport-dependent media features.
   */
  public static class MediaQueryResultChanged {
    public String toString() {
      return "MediaQueryResultChanged{}";
    }
  }

  /**
   * Fires whenever a web font gets loaded.
   */
  public static class FontsUpdated {
    public String toString() {
      return "FontsUpdated{}";
    }
  }

  /**
   * Fired whenever a stylesheet is changed as a result of the client operation.
   */
  public static class StyleSheetChanged {
    public String styleSheetId;

    public String toString() {
      return "StyleSheetChanged{styleSheetId=" + styleSheetId + "}";
    }
  }

  /**
   * CSS stylesheet metainformation.
   */
  public static class CSSStyleSheetHeader {
    /**
     * The stylesheet identifier.
     */
    public String styleSheetId;

    /**
     * Owner frame identifier.
     */
    public String frameId;

    /**
     * Stylesheet resource URL.
     */
    public String sourceURL;

    /**
     * URL of source map associated with the stylesheet (if any).
     */
    public String sourceMapURL;

    /**
     * Stylesheet origin.
     */
    public String origin;

    /**
     * Stylesheet title.
     */
    public String title;

    /**
     * The backend id for the owner node of the stylesheet.
     */
    public Integer ownerNode;

    /**
     * Denotes whether the stylesheet is disabled.
     */
    public Boolean disabled;

    /**
     * Whether the sourceURL field value comes from the sourceURL comment.
     */
    public Boolean hasSourceURL;

    /**
     * Whether this stylesheet is created for STYLE tag by parser. This flag is not set for document.written STYLE tags.
     */
    public Boolean isInline;

    /**
     * Line offset of the stylesheet within the resource (zero based).
     */
    public Double startLine;

    /**
     * Column offset of the stylesheet within the resource (zero based).
     */
    public Double startColumn;

    public String toString() {
      return "CSSStyleSheetHeader{styleSheetId=" + styleSheetId + ", frameId=" + frameId + ", sourceURL=" + sourceURL + ", sourceMapURL=" + sourceMapURL + ", origin=" + origin + ", title=" + title + ", ownerNode=" + ownerNode + ", disabled=" + disabled + ", hasSourceURL=" + hasSourceURL + ", isInline=" + isInline + ", startLine=" + startLine + ", startColumn=" + startColumn + "}";
    }
  }

  /**
   * Fired whenever an active document stylesheet is added.
   */
  public static class StyleSheetAdded {
    /**
     * Added stylesheet metainfo.
     */
    public CSSStyleSheetHeader header;

    public String toString() {
      return "StyleSheetAdded{header=" + header + "}";
    }
  }

  /**
   * Fired whenever an active document stylesheet is removed.
   */
  public static class StyleSheetRemoved {
    /**
     * Identifier of the removed stylesheet.
     */
    public String styleSheetId;

    public String toString() {
      return "StyleSheetRemoved{styleSheetId=" + styleSheetId + "}";
    }
  }
}
