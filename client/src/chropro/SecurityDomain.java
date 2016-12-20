package chropro;

import java.lang.Boolean;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class SecurityDomain {
  private RpcClient rpcClient;

  public SecurityDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables tracking security state changes.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Security.enable", params, Void.class);
  }

  /**
   * Disables tracking security state changes.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Security.disable", params, Void.class);
  }

  /**
   * Displays native dialog with the certificate details.
   */
  public CompletableFuture<Void> showCertificateViewer() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Security.showCertificateViewer", params, Void.class);
  }

  /**
   * The security state of the page changed.
   */
  public void onSecurityStateChanged(Consumer<SecurityStateChanged> listener) {
    rpcClient.addEventListener("Security.securityStateChanged", listener, SecurityStateChanged.class);
  }

  /**
   * The security state of the page changed.
   */
  public CompletableFuture<SecurityStateChanged> onSecurityStateChanged() {
    return rpcClient.eventFuture("Security.securityStateChanged", SecurityStateChanged.class);
  }

  /**
   * An explanation of an factor contributing to the security state.
   */
  public static class SecurityStateExplanation {
    /**
     * Security state representing the severity of the factor being explained.
     */
    public String securityState;

    /**
     * Short phrase describing the type of factor.
     */
    public String summary;

    /**
     * Full text explanation of the factor.
     */
    public String description;

    /**
     * True if the page has a certificate.
     */
    public Boolean hasCertificate;

    public String toString() {
      return "SecurityStateExplanation{securityState=" + securityState + ", summary=" + summary + ", description=" + description + ", hasCertificate=" + hasCertificate + "}";
    }
  }

  /**
   * Information about insecure content on the page.
   */
  public static class InsecureContentStatus {
    /**
     * True if the page was loaded over HTTPS and ran mixed (HTTP) content such as scripts.
     */
    public Boolean ranMixedContent;

    /**
     * True if the page was loaded over HTTPS and displayed mixed (HTTP) content such as images.
     */
    public Boolean displayedMixedContent;

    /**
     * True if the page was loaded over HTTPS without certificate errors, and ran content such as scripts that were loaded with certificate errors.
     */
    public Boolean ranContentWithCertErrors;

    /**
     * True if the page was loaded over HTTPS without certificate errors, and displayed content such as images that were loaded with certificate errors.
     */
    public Boolean displayedContentWithCertErrors;

    /**
     * Security state representing a page that ran insecure content.
     */
    public String ranInsecureContentStyle;

    /**
     * Security state representing a page that displayed insecure content.
     */
    public String displayedInsecureContentStyle;

    public String toString() {
      return "InsecureContentStatus{ranMixedContent=" + ranMixedContent + ", displayedMixedContent=" + displayedMixedContent + ", ranContentWithCertErrors=" + ranContentWithCertErrors + ", displayedContentWithCertErrors=" + displayedContentWithCertErrors + ", ranInsecureContentStyle=" + ranInsecureContentStyle + ", displayedInsecureContentStyle=" + displayedInsecureContentStyle + "}";
    }
  }

  /**
   * The security state of the page changed.
   */
  public static class SecurityStateChanged {
    /**
     * Security state.
     */
    public String securityState;

    /**
     * True if the page was loaded over cryptographic transport such as HTTPS.
     */
    public Boolean schemeIsCryptographic;

    /**
     * List of explanations for the security state. If the overall security state is `insecure` or `warning`, at least one corresponding explanation should be included.
     */
    public List<SecurityStateExplanation> explanations;

    /**
     * Information about insecure content on the page.
     */
    public InsecureContentStatus insecureContentStatus;

    /**
     * Overrides user-visible description of the state.
     */
    public String summary;

    public String toString() {
      return "SecurityStateChanged{securityState=" + securityState + ", schemeIsCryptographic=" + schemeIsCryptographic + ", explanations=" + explanations + ", insecureContentStatus=" + insecureContentStatus + ", summary=" + summary + "}";
    }
  }
}
