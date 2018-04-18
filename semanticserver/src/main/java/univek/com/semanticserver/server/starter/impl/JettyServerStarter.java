package univek.com.semanticserver.server.starter.impl;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.RequestLogHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JettyServerStarter extends AbstractServerStarter{

    private static final Logger log = Logger.getLogger(JettyServerStarter.class);
    private Server server;

    public JettyServerStarter(int port) {
        super(port);
    }

    public JettyServerStarter() {
    }

    public void startAsync() {
        try {
            starter();
        } catch (Exception e) {
            log.error("Jetty startAsync error");
        }
    }

    public void startAndJoin() {
        try {
            starter();
            log.info("Starting Jetty successfully server on port "+port);
            server.join();
        } catch (Exception e) {
            log.error("Jetty startAndJoin error");
        }
        finally {
            destroy();
        }
    }

    public void join() {
        try {
            server.join();
        } catch (InterruptedException e) {
            log.error("Jetty join error");
        }
    }

    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error("Jetty stop error");
        }
    }

    public void destroy() {
        log.info("Destroyed Jetty server");
    }

    private void starter() throws Exception {
        log.info("Starting Jetty server on port "+port);
        server = new Server(createThreadPool());

        NetworkTrafficServerConnector connector = createConnector();
        server.addConnector(connector);

        server.setHandler(createHandlers());
        server.setStopAtShutdown(true);

        server.start();
    }

    //ToDo: Need to configure these
    private ThreadPool createThreadPool()
    {
        QueuedThreadPool _threadPool = new QueuedThreadPool();
        _threadPool.setMinThreads(10);
        _threadPool.setMaxThreads(100);
        return _threadPool;
    }

    private NetworkTrafficServerConnector createConnector()
    {
        NetworkTrafficServerConnector _connector = new NetworkTrafficServerConnector(server);
        _connector.setPort(port);
        _connector.setHost(null);
        return _connector;
    }

    private HandlerCollection createHandlers()
    {
        WebAppContext _ctx = new WebAppContext();
        _ctx.setContextPath(contextPath);
        _ctx.setWar(getWarUrl());


        List<Handler> _handlers = new ArrayList<Handler>();

        _handlers.add(_ctx);

        HandlerList _contexts = new HandlerList();
        _contexts.setHandlers(_handlers.toArray(new Handler[0]));

        RequestLogHandler _log = new RequestLogHandler();
        _log.setRequestLog(createRequestLog());

        HandlerCollection _result = new HandlerCollection();
        _result.setHandlers(new Handler[] {_contexts, _log});

        return _result;
    }

    private RequestLog createRequestLog()
    {
        NCSARequestLog _log = new NCSARequestLog();

        File _logPath = new File(LOG_PATH);
        _log.setFilename(_logPath.getPath());
        _log.setRetainDays(90);
        _log.setExtended(false);
        _log.setAppend(true);
        _log.setLogTimeZone("GMT");
        _log.setLogLatency(true);
        return _log;
    }

    private String getWarUrl()
    {
        URL resourceURL = Thread.currentThread().getContextClassLoader().getResource(WEB_XML);
        assert resourceURL != null;
        String _urlStr = resourceURL.toString();
        return _urlStr.substring(0, _urlStr.length() - WEB_XML.length());
    }
}
