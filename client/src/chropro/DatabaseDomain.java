package chropro;

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

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class DatabaseDomain {
  private RpcClient rpcClient;

  public DatabaseDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables database tracking, database events will now be delivered to the client.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Database.enable", params, Void.class);
  }

  /**
   * Disables database tracking, prevents database events from being sent to the client.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Database.disable", params, Void.class);
  }

  public CompletableFuture<GetDatabaseTableNames> getDatabaseTableNames(@NotNull String databaseId) {
    Map<String,Object> params = new HashMap<>();
    params.put("databaseId", databaseId);
    return rpcClient.call("Database.getDatabaseTableNames", params, GetDatabaseTableNames.class);
  }

  public CompletableFuture<ExecuteSQL> executeSQL(@NotNull String databaseId, @NotNull String query) {
    Map<String,Object> params = new HashMap<>();
    params.put("databaseId", databaseId);
    params.put("query", query);
    return rpcClient.call("Database.executeSQL", params, ExecuteSQL.class);
  }

  public void onAddDatabase(Consumer<AddDatabase> listener) {
    rpcClient.addEventListener("Database.addDatabase", listener, AddDatabase.class);
  }

  public CompletableFuture<AddDatabase> onAddDatabase() {
    return rpcClient.eventFuture("Database.addDatabase", AddDatabase.class);
  }

  public static class GetDatabaseTableNames {
    public List<String> tableNames;

    public String toString() {
      return "GetDatabaseTableNames{tableNames=" + tableNames + "}";
    }
  }

  /**
   * Database error.
   */
  public static class Error {
    /**
     * Error message.
     */
    public String message;

    /**
     * Error code.
     */
    public Integer code;

    public String toString() {
      return "Error{message=" + message + ", code=" + code + "}";
    }
  }

  public static class ExecuteSQL {
    public List<String> columnNames;

    public List<Object> values;

    public Error sqlError;

    public String toString() {
      return "ExecuteSQL{columnNames=" + columnNames + ", values=" + values + ", sqlError=" + sqlError + "}";
    }
  }

  /**
   * Database object.
   */
  public static class Database {
    /**
     * Database ID.
     */
    public String id;

    /**
     * Database domain.
     */
    public String domain;

    /**
     * Database name.
     */
    public String name;

    /**
     * Database version.
     */
    public String version;

    public String toString() {
      return "Database{id=" + id + ", domain=" + domain + ", name=" + name + ", version=" + version + "}";
    }
  }

  public static class AddDatabase {
    public Database database;

    public String toString() {
      return "AddDatabase{database=" + database + "}";
    }
  }
}
