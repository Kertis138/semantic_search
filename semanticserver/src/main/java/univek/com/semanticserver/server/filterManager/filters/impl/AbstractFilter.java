package univek.com.semanticserver.server.filterManager.filters.impl;

import univek.com.semanticserver.server.filterManager.filters.Filter;

public abstract class AbstractFilter implements Filter {

    String status = null;

    @Override
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
