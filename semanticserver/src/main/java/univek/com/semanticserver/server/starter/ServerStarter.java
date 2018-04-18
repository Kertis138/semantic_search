package univek.com.semanticserver.server.starter;

public interface ServerStarter {
    void startAsync();
    void startAndJoin();
    void join();
    void stop();
    void destroy();
    void setContextPath(String url);
}
