package univek.com.semanticserver;

import org.apache.log4j.Logger;
import univek.com.semanticserver.server.starter.ServerStarter;
import univek.com.semanticserver.server.starter.impl.JettyServerStarter;
import univek.com.semanticserver.utilities.propertyWorker.PropertyWorker;
import univek.com.semanticserver.server.starter.ServerStarter;
import univek.com.semanticserver.server.starter.impl.JettyServerStarter;

public class AppStarter
{
    private static Logger log = Logger.getLogger(AppStarter.class);

	public static void main(String[] args)
    {
        runServer(args);
    }

    private static void runServer(String[] args) {
        String contextPath = PropertyWorker.getString("server.contextPath", "/api");
        int port = PropertyWorker.getInt("server.port", 8000);
        if (args.length >= 1) {
            try {
                port = Integer.parseInt(args[0]);
            }
            catch (Exception e) {
                log.error("Args[0] with port has incorrect format. Uses value by default.");
            }
        }

        ServerStarter serverStarter = new JettyServerStarter(port);
        serverStarter.setContextPath(contextPath);
        serverStarter.startAndJoin();
    }
}
