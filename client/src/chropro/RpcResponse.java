package chropro;

import com.google.gson.JsonElement;

class RpcResponse {
    long id;
    JsonElement result;
    RpcError error;
}
