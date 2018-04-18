package univek.com.semanticserver.server.filterManager.filters.impl;

import univek.com.semanticserver.utilities.propertyWorker.PropertyWorker;

import java.util.Date;

public class RequestFrequencyFilter extends AbstractFilter {

    private static final Integer maxRequestFrequencySec;
    static {
        maxRequestFrequencySec =  PropertyWorker.getInt("secureToken.maxRequestFrequencySec", 3);
    }

    private Date updatedAt;

    public RequestFrequencyFilter(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean run() {
        long diffs_sec = Math.abs(updatedAt.getTime() - new Date().getTime())/1000;
        if(diffs_sec < maxRequestFrequencySec) {
            setStatus("TooFrequentRequest");
            return false;
        }
        return true;
    }
}
