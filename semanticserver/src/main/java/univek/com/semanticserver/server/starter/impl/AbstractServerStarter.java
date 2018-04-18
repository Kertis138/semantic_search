package univek.com.semanticserver.server.starter.impl;

import univek.com.semanticserver.server.starter.ServerStarter;

public abstract class AbstractServerStarter implements ServerStarter {

    static final String LOG_PATH = "./log/server/yyyy_mm_dd.request.log";
    static final String WEB_XML = "WEB-INF/web.xml";
    int port = 8080;
    String contextPath = "/";

    AbstractServerStarter(int port) {
        this.port = port;
    }

    AbstractServerStarter() {
    }

    public void setContextPath(String url) {
        contextPath = url;
    }
}
