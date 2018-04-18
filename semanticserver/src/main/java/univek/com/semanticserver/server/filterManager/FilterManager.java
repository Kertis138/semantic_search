package univek.com.semanticserver.server.filterManager;

import univek.com.semanticserver.server.filterManager.filters.Filter;
import univek.com.semanticserver.server.filterManager.filters.Filter;

public interface FilterManager {
    void addfilter(Filter filter);
    boolean run();
    Filter getLastFilter();
}
