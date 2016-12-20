package chropro;

import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class SchemaDomain {
  private RpcClient rpcClient;

  public SchemaDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Returns supported domains.
   */
  public CompletableFuture<GetDomains> getDomains() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Schema.getDomains", params, GetDomains.class);
  }

  /**
   * Description of the protocol domain.
   */
  public static class Domain {
    /**
     * Domain name.
     */
    public String name;

    /**
     * Domain version.
     */
    public String version;

    public String toString() {
      return "Domain{name=" + name + ", version=" + version + "}";
    }
  }

  public static class GetDomains {
    /**
     * List of supported domains.
     */
    public List<Domain> domains;

    public String toString() {
      return "GetDomains{domains=" + domains + "}";
    }
  }
}
