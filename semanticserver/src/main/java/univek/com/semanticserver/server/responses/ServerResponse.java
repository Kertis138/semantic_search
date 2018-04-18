package univek.com.semanticserver.server.responses;
import java.io.Serializable;

public interface ServerResponse extends Serializable {
    String getStatus();
    ServerResponse getWithStatus(String status);
    ServerResponse getWithStatus(Enum status);
    void setStatus(String status);
    void setStatus(Enum status);
}
