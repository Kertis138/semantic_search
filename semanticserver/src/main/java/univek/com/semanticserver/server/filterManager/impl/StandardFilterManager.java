package univek.com.semanticserver.server.filterManager.impl;

import univek.com.semanticserver.server.filterManager.filters.Filter;
import univek.com.semanticserver.server.filterManager.FilterManager;

import java.util.ArrayList;

public class StandardFilterManager implements FilterManager {
    ArrayList<Filter> filters = new ArrayList<>();
    Filter lastFilter;

    @Override
    public void addfilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean run() {
        for (Filter filter : filters) {
            boolean status = filter.run();
            if(!status) {
                lastFilter = filter;
                return false;
            }
        }
        return true;
    }

    @Override
    public Filter getLastFilter() {
        return lastFilter;
    }
}
