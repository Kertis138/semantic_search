package univek.com.semanticserver.server.filterManager.filters;

public interface Filter {
    boolean run();
    String getStatus();
}
