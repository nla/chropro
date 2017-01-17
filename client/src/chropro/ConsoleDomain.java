package chropro;

import java.lang.Integer;
import java.lang.String;
import java.lang.Void;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import javax.annotation.Generated;

@Generated(
    value = "chropro.Codegen",
    date = "2016-12-20T03:33:59.982Z"
)
public class ConsoleDomain {
  private RpcClient rpcClient;

  public ConsoleDomain(RpcClient rpcClient) {
    this.rpcClient = rpcClient;
  }

  /**
   * Enables console domain, sends the messages collected so far to the client by means of the <code>messageAdded</code> notification.
   */
  public CompletableFuture<Void> enable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Console.enable", params, Void.class);
  }

  /**
   * Disables console domain, prevents further console messages from being reported to the client.
   */
  public CompletableFuture<Void> disable() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Console.disable", params, Void.class);
  }

  /**
   * Does nothing.
   */
  public CompletableFuture<Void> clearMessages() {
    Map<String,Object> params = new HashMap<>();
    return rpcClient.call("Console.clearMessages", params, Void.class);
  }

  /**
   * Issued when new console message is added.
   */
  public void onMessageAdded(Consumer<MessageAdded> listener) {
    rpcClient.addEventListener("Console.messageAdded", listener, MessageAdded.class);
  }

  /**
   * Issued when new console message is added.
   */
  public CompletableFuture<MessageAdded> onMessageAdded() {
    return rpcClient.eventFuture("Console.messageAdded", MessageAdded.class);
  }

  /**
   * Console message.
   */
  public static class ConsoleMessage {
    /**
     * Message source.
     */
    public String source;

    /**
     * Message severity.
     */
    public String level;

    /**
     * Message text.
     */
    public String text;

    /**
     * URL of the message origin.
     */
    public String url;

    /**
     * Line number in the resource that generated this message (1-based).
     */
    public Integer line;

    /**
     * Column number in the resource that generated this message (1-based).
     */
    public Integer column;

    public String toString() {
      return "ConsoleMessage{source=" + source + ", level=" + level + ", text=" + text + ", url=" + url + ", line=" + line + ", column=" + column + "}";
    }
  }

  /**
   * Issued when new console message is added.
   */
  public static class MessageAdded {
    /**
     * Console message that has been added.
     */
    public ConsoleMessage message;

    public String toString() {
      return "MessageAdded{message=" + message + "}";
    }
  }
}
