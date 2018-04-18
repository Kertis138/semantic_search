package univek.com.semanticserver.server.responses.impl;

import univek.com.semanticserver.server.responses.ServerResponse;

public abstract class AbstractServerResponse implements ServerResponse {
    String status = "Unknown Error";

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public ServerResponse getWithStatus(String status) {
        setStatus(status);
        return this;
    }

    @Override
    public ServerResponse getWithStatus(Enum status) {
        setStatus(status);
        return this;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void setStatus(Enum status) {
        this.status = status.toString();
    }
}
