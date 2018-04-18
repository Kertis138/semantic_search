package univek.com.semanticserver.server.responses.impl;

public class RequestCountStatusControllerResponse extends AbstractServerResponse {
    public enum Status {
        Running,
        Paused,
        Error
    }

    public int[] requestCount = new int[10];
}
