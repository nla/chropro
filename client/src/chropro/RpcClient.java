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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class RpcClient implements Closeable {
    static Gson gson = new Gson();

    final AtomicLong idSeq = new AtomicLong(0);
    final RpcSocket socket;
    final ConcurrentHashMap<Long, CompletableFuture<JsonElement>> methodFutures = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, List<CompletableFuture<JsonElement>>> eventFutures = new ConcurrentHashMap<>();
    final ConcurrentHashMap<String, List<Consumer<JsonElement>>> eventListeners = new ConcurrentHashMap<>();
    Exception closeReason = null;
    volatile Thread connectingThread = null;

    public RpcClient(URI webSocketDebuggerUrl) throws IOException {

        System.out.println("connecting to " + webSocketDebuggerUrl);
        socket = new RpcSocket(webSocketDebuggerUrl);
        try {
            socket.connectBlocking();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("connected");
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
        CompletableFuture<JsonElement> future = new CompletableFuture<>();
        methodFutures.put(request.id, future);
        String text = gson.toJson(request);
        socket.send(text);
        return future;
    }

    public <T> CompletableFuture<T> call(String method, Map<String,Object> params, Class<T> resultType) {
        return call(method, params).thenApply(result -> gson.fromJson(result, resultType));
    }

    public synchronized void addEventListener(String method, Consumer<JsonElement> listener) {
        List<Consumer<JsonElement>> list = eventListeners.get(method);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList<>());
            eventListeners.put(method, list);
        }
        list.add(listener);
    }

    public <T> void addEventListener(String method, Consumer<T> listener, Class<T> eventType) {
        addEventListener(method, el -> listener.accept(gson.fromJson(el, eventType)));
    }

    public synchronized <T> CompletableFuture<T> eventFuture(String method, Class<T> eventType) {
        CompletableFuture<JsonElement> future = new CompletableFuture<>();
        List<CompletableFuture<JsonElement>> list = eventFutures.get(method);
        if (list == null) {
            list = Collections.synchronizedList(new ArrayList<>());
            eventFutures.put(method, list);
        }
        list.add(future);
        return future.thenApply(el -> gson.fromJson(el, eventType));
    }

    @Override
    public void close() throws IOException {
        close(new ClosedChannelException());
    }

    synchronized void dispatchEvent(String method, JsonElement event) {
        List<CompletableFuture<JsonElement>> futures = eventFutures.remove(method);
        if (futures != null) {
            for (CompletableFuture<JsonElement> future : futures) {
                future.complete(event);
            }
        }

        for (Consumer<JsonElement> listener: eventListeners.getOrDefault(method, Collections.emptyList())) {
            listener.accept(event);
        }
    }

    synchronized void dispatchResponse(RpcResponse response) {
        CompletableFuture future = methodFutures.remove(response.id);
        if (future != null) {
            if (response.error != null) {
                future.completeExceptionally(new RpcException(response.error.code, response.error.message));
            }
            future.complete(response.result);
        }
    }

    private void close(Exception reason) {
        if (closeReason == null) {
            closeReason = reason;
            socket.close();
        }
    }

    private synchronized void cleanup() {
        for (CompletableFuture<JsonElement> future : methodFutures.values()) {
            future.completeExceptionally(closeReason);
        }
        methodFutures.clear();

        for (List<CompletableFuture<JsonElement>> futures : eventFutures.values()) {
            for (CompletableFuture<JsonElement> future : methodFutures.values()) {
                future.completeExceptionally(closeReason);
            }
        }
        eventFutures.clear();
    }

    class RpcSocket extends WebSocketClient {

        public RpcSocket(URI serverURI) {
            super(serverURI, new Draft_17());
        }

        public void onMessage(String s) {
            System.out.println("Message: " + s.substring(0, Math.min(s.length(), 2048)));
            RpcResponse response = gson.fromJson(s, RpcResponse.class);

            if (response.method == null) {
                dispatchResponse(response);
            } else {
                dispatchEvent(response.method, response.params);
            }
        }

        @Override
        public void onClose(int code, String reason, boolean remote) {
            if (closeReason != null) {
                closeReason = new RpcException(code, reason);
                cleanup();
            }
        }
        public void onError(Exception e) {
            e.printStackTrace();
            RpcClient.this.close(e);
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {

        }
    }
}
