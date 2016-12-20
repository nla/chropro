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
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:00:26.964Z"
)
public class IndexedDBDomain {
  private RpcClient rpcClient;

  public IndexedDBDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables events from backend.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("IndexedDB.enable", params, Void.class);
  }

  /**
   * Disables events from backend.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("IndexedDB.disable", params, Void.class);
  }

  /**
   * Requests database names for given security origin.
   * @param securityOrigin Security origin.
   */
  public CompletableFuture<RequestDatabaseNames> requestDatabaseNames(@NotNull String securityOrigin) {
    Map<String,Object> params = new HashMap<>();
    params.put("securityOrigin", securityOrigin);
    return rpcClient.call("IndexedDB.requestDatabaseNames", params, RequestDatabaseNames.class);
  }

  /**
   * Requests database with given name in given frame.
   * @param securityOrigin Security origin.
   * @param databaseName Database name.
   */
  public CompletableFuture<RequestDatabase> requestDatabase(@NotNull String securityOrigin, @NotNull String databaseName) {
    Map<String,Object> params = new HashMap<>();
    params.put("securityOrigin", securityOrigin);
    params.put("databaseName", databaseName);
    return rpcClient.call("IndexedDB.requestDatabase", params, RequestDatabase.class);
  }

  /**
   * Requests data from object store or index.
   * @param securityOrigin Security origin.
   * @param databaseName Database name.
   * @param objectStoreName Object store name.
   * @param indexName Index name, empty string for object store data requests.
   * @param skipCount Number of records to skip.
   * @param pageSize Number of records to fetch.
   * @param keyRange Key range.
   */
  public CompletableFuture<RequestData> requestData(@NotNull String securityOrigin, @NotNull String databaseName, @NotNull String objectStoreName, @NotNull String indexName, @NotNull Integer skipCount, @NotNull Integer pageSize, @Nullable KeyRange keyRange) {
    Map<String,Object> params = new HashMap<>();
    params.put("securityOrigin", securityOrigin);
    params.put("databaseName", databaseName);
    params.put("objectStoreName", objectStoreName);
    params.put("indexName", indexName);
    params.put("skipCount", skipCount);
    params.put("pageSize", pageSize);
    params.put("keyRange", keyRange);
    return rpcClient.call("IndexedDB.requestData", params, RequestData.class);
  }

  /**
   * Clears all entries from an object store.
   * @param securityOrigin Security origin.
   * @param databaseName Database name.
   * @param objectStoreName Object store name.
   */
  public CompletableFuture<Void> clearObjectStore(@NotNull String securityOrigin, @NotNull String databaseName, @NotNull String objectStoreName) {
    Map<String,Object> params = new HashMap<>();
    params.put("securityOrigin", securityOrigin);
    params.put("databaseName", databaseName);
    params.put("objectStoreName", objectStoreName);
    return rpcClient.call("IndexedDB.clearObjectStore", params, Void.class);
  }

  public static class RequestDatabaseNames {
    /**
     * Database names for origin.
     */
    public List<String> databaseNames;

    public String toString() {
      return "RequestDatabaseNames{databaseNames=" + databaseNames + "}";
    }
  }

  /**
   * Key path.
   */
  public static class KeyPath {
    /**
     * Key path type.
     */
    public String type;

    /**
     * String value.
     */
    public String string;

    /**
     * Array value.
     */
    public List<String> array;

    public String toString() {
      return "KeyPath{type=" + type + ", string=" + string + ", array=" + array + "}";
    }
  }

  /**
   * Object store index.
   */
  public static class ObjectStoreIndex {
    /**
     * Index name.
     */
    public String name;

    /**
     * Index key path.
     */
    public KeyPath keyPath;

    /**
     * If true, index is unique.
     */
    public Boolean unique;

    /**
     * If true, index allows multiple entries for a key.
     */
    public Boolean multiEntry;

    public String toString() {
      return "ObjectStoreIndex{name=" + name + ", keyPath=" + keyPath + ", unique=" + unique + ", multiEntry=" + multiEntry + "}";
    }
  }

  /**
   * Object store.
   */
  public static class ObjectStore {
    /**
     * Object store name.
     */
    public String name;

    /**
     * Object store key path.
     */
    public KeyPath keyPath;

    /**
     * If true, object store has auto increment flag set.
     */
    public Boolean autoIncrement;

    /**
     * Indexes in this object store.
     */
    public List<ObjectStoreIndex> indexes;

    public String toString() {
      return "ObjectStore{name=" + name + ", keyPath=" + keyPath + ", autoIncrement=" + autoIncrement + ", indexes=" + indexes + "}";
    }
  }

  /**
   * Database with an array of object stores.
   */
  public static class DatabaseWithObjectStores {
    /**
     * Database name.
     */
    public String name;

    /**
     * Database version.
     */
    public Integer version;

    /**
     * Object stores in this database.
     */
    public List<ObjectStore> objectStores;

    public String toString() {
      return "DatabaseWithObjectStores{name=" + name + ", version=" + version + ", objectStores=" + objectStores + "}";
    }
  }

  public static class RequestDatabase {
    /**
     * Database with an array of object stores.
     */
    public DatabaseWithObjectStores databaseWithObjectStores;

    public String toString() {
      return "RequestDatabase{databaseWithObjectStores=" + databaseWithObjectStores + "}";
    }
  }

  /**
   * Data entry.
   */
  public static class DataEntry {
    /**
     * Key object.
     */
    public RuntimeDomain.RemoteObject key;

    /**
     * Primary key object.
     */
    public RuntimeDomain.RemoteObject primaryKey;

    /**
     * Value object.
     */
    public RuntimeDomain.RemoteObject value;

    public String toString() {
      return "DataEntry{key=" + key + ", primaryKey=" + primaryKey + ", value=" + value + "}";
    }
  }

  public static class RequestData {
    /**
     * Array of object store data entries.
     */
    public List<DataEntry> objectStoreDataEntries;

    /**
     * If true, there are more entries to fetch in the given range.
     */
    public Boolean hasMore;

    public String toString() {
      return "RequestData{objectStoreDataEntries=" + objectStoreDataEntries + ", hasMore=" + hasMore + "}";
    }
  }

  /**
   * Key.
   */
  public static class Key {
    /**
     * Key type.
     */
    public String type;

    /**
     * Number value.
     */
    public Double number;

    /**
     * String value.
     */
    public String string;

    /**
     * Date value.
     */
    public Double date;

    /**
     * Array value.
     */
    public List<Key> array;

    public String toString() {
      return "Key{type=" + type + ", number=" + number + ", string=" + string + ", date=" + date + ", array=" + array + "}";
    }
  }

  /**
   * Key range.
   */
  public static class KeyRange {
    /**
     * Lower bound.
     */
    public Key lower;

    /**
     * Upper bound.
     */
    public Key upper;

    /**
     * If true lower bound is open.
     */
    public Boolean lowerOpen;

    /**
     * If true upper bound is open.
     */
    public Boolean upperOpen;

    public String toString() {
      return "KeyRange{lower=" + lower + ", upper=" + upper + ", lowerOpen=" + lowerOpen + ", upperOpen=" + upperOpen + "}";
    }
  }
}
