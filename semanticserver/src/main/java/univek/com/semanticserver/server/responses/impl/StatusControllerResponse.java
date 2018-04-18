package univek.com.semanticserver.server.responses.impl;

public class StatusControllerResponse extends AbstractServerResponse {
    public enum Status {
        Running,
        Paused,
        Error
    }
}
