package chropro;

import com.google.gson.Gson;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

public class Client {
    static Gson gson = new Gson();

    static class Request {
        final long id;
        final String method;
        final Map<String, Object> params;

        Request(long id, String method, Map<String, Object> params) {
            this.id = id;
            this.method = method;
            this.params = params;
        }
    }

    static class Response {
        long id;
        Object result;
    }

    AtomicLong idSeq = new AtomicLong(0);
    WsClient ws;
    ConcurrentHashMap<Long, CompletableFuture> futures = new ConcurrentHashMap<>();

    public Future call(String method, Map<String,Object> params) {
        Request request = new Request(idSeq.getAndIncrement(), method, params);
        ws.send(gson.toJson(request));
        CompletableFuture future = new CompletableFuture();
        futures.put(request.id, future);
        return future;
    }

    public class WsClient extends WebSocketClient {


        public WsClient(int port) {
            super(URI.create("ws://127.0.0.1:" + port + "/devtools/browser"), new Draft_17());
        }

        @Override
        public void onOpen(ServerHandshake serverHandshake) {

            System.out.println("Open " + serverHandshake);
        }

        @Override
        public void onMessage(String s) {
            System.out.println("Message: " + s);
            Response response = gson.fromJson(s, Response.class);
            CompletableFuture future = futures.remove(response.id);
            if (future != null) {
                future.complete(response.result);
            }

        }

        @Override
        public void onClose(int i, String s, boolean b) {

            System.out.println("close");
        }

        @Override
        public void onError(Exception e) {
            e.printStackTrace();

        }
    }
}
