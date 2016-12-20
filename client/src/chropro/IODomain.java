package chropro;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Generated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class IODomain {
  private RpcClient rpcClient;

  public IODomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Read a chunk of the stream
   * @param handle Handle of the stream to read.
   * @param offset Seek to the specified offset before reading (if not specificed, proceed with offset following the last read).
   * @param size Maximum number of bytes to read (left upon the agent discretion if not specified).
   */
  public CompletableFuture<Read> read(@NotNull String handle, @Nullable Integer offset, @Nullable Integer size) {
    Map<String,Object> params = new HashMap<>();
    params.put("handle", handle);
    params.put("offset", offset);
    params.put("size", size);
    return rpcClient.call("IO.read", params, Read.class);
  }

  /**
   * Close the stream, discard any temporary backing storage.
   * @param handle Handle of the stream to close.
   */
  public CompletableFuture<Void> close(@NotNull String handle) {
    Map<String,Object> params = new HashMap<>();
    params.put("handle", handle);
    return rpcClient.call("IO.close", params, Void.class);
  }

  public static class Read {
    /**
     * Data that were read.
     */
    public String data;

    /**
     * Set if the end-of-file condition occured while reading.
     */
    public Boolean eof;

    public String toString() {
      return "Read{data=" + data + ", eof=" + eof + "}";
    }
  }
}
