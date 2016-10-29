package chropro;

import java.util.Map;

public class RpcRequest {
    final long id;
    final String method;
    final Map<String, Object> params;

    RpcRequest(long id, String method, Map<String, Object> params) {
        this.id = id;
        this.method = method;
        this.params = params;
    }
}
