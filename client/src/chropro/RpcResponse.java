package chropro;

import com.google.gson.JsonElement;

public class RpcResponse {
    long id;
    JsonElement result;
    RpcError error;
    String method;
    JsonElement params;
}
