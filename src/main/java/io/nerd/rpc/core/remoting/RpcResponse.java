package io.nerd.rpc.core.remoting;

import java.io.Serializable;

public class RpcResponse implements Serializable {

    private static final long serialVersionUID = 7434645506405732621L;
    private String requestId;
    private Throwable error;
    private Object result;

    public RpcResponse() {}

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isError() {
        return error != null;
    }
}