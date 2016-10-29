package chropro;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class RpcClient implements Closeable {
    static Gson gson = new Gson();

    final AtomicLong idSeq = new AtomicLong(0);
    final RpcSocket socket;
    final ConcurrentHashMap<Long, CompletableFuture<JsonElement>> futures = new ConcurrentHashMap<>();
    Exception closeReason = null;
    volatile Thread connectingThread = null;

    public RpcClient(int port) throws IOException {
        socket = new RpcSocket(port);
        try {
            socket.connectBlocking();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (closeReason != null) {
            if (closeReason instanceof IOException) {
                throw (IOException)closeReason;
            } else {
                throw new IOException(closeReason);
            }
        }
    }

    public CompletableFuture<JsonElement> call(String method, Map<String,Object> params) {
        if (closeReason != null) {
            throw new IllegalStateException("closed", closeReason);
        }
        RpcRequest request = new RpcRequest(idSeq.getAndIncrement(), method, params);
        String text = gson.toJson(request);
        System.out.println("Send: " + text);
        socket.send(text);
        CompletableFuture<JsonElement> future = new CompletableFuture<>();
        futures.put(request.id, future);
        return future;
    }

    public <T> CompletableFuture<T> call(String method, Map<String,Object> params, Class<T> resultType) {
        return call(method, params).thenApply(result -> gson.fromJson(result, resultType));
    }

    @Override
    public void close() throws IOException {
        close(new ClosedChannelException());
    }

    private synchronized void close(Exception reason) {
        if (closeReason == null) {
            closeReason = reason;
            socket.close();
            for (CompletableFuture<JsonElement> future : futures.values()) {
                future.completeExceptionally(reason);
            }
        }
    }

    class RpcSocket extends WebSocketClient {

        public RpcSocket(int port) {
            super(URI.create("ws://127.0.0.1:" + port + "/devtools/browser"), new Draft_17());
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {

            System.out.println("Open " + serverHandshake);
        }

        @Override
        public void onMessage(String s) {
            System.out.println("Message: " + s);
            RpcResponse response = gson.fromJson(s, RpcResponse.class);
            CompletableFuture future = futures.remove(response.id);
            if (future != null) {
                if (response.error != null) {
                    future.completeExceptionally(new RpcException(response.error.code, response.error.message));
                }
                future.complete(response.result);
            }

        }

        @Override
        public void onClose(int code, String reason, boolean remote) {
            if (closeReason != null) {
                RpcClient.this.close(new RpcException(code, reason));
            }
        }

        @Override
        public void onError(Exception e) {
            RpcClient.this.close(e);
        }
    }
}
