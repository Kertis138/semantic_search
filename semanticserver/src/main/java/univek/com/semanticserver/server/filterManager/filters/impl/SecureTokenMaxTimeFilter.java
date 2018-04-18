package univek.com.semanticserver.server.filterManager.filters.impl;

import univek.com.semanticserver.utilities.propertyWorker.PropertyWorker;

import java.util.Date;

public class SecureTokenMaxTimeFilter extends AbstractFilter {

    private static final Integer maxTimeSec;
    static {
        maxTimeSec =  PropertyWorker.getInt("secureToken.maxTimeMin", 21600)*60;
    }

    private Date secureTokenUpdatedAt;

    public SecureTokenMaxTimeFilter(Date secureTokenUpdatedAt) {
        this.secureTokenUpdatedAt = secureTokenUpdatedAt;
    }

    @Override
    public boolean run() {
        long diffs_sec = Math.abs(secureTokenUpdatedAt.getTime() - new Date().getTime())/1000;
        if(diffs_sec > maxTimeSec) {
            setStatus("SecureTokenIsOverdue");
            return false;
        }
        return true;
    }
}
