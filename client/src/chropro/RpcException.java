package chropro;

public class RpcException extends Exception {
    private final long code;
    private final String message;

    public RpcException(long code, String message) {
        super(message + " (" + code + ")");
        this.code = code;
        this.message = message;
    }
}
