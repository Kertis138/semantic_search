package univek.com.semanticserver;

import org.apache.log4j.Logger;
import univek.com.semanticserver.core.managers.ScriptManager;
import univek.com.semanticserver.core.scripts.ScriptHandler;
import univek.com.semanticserver.server.controllers.impl.ExecuteController;
import univek.com.semanticserver.server.starter.ServerStarter;
import univek.com.semanticserver.server.starter.impl.JettyServerStarter;
import univek.com.semanticserver.utilities.propertyWorker.PropertyWorker;
import univek.com.semanticserver.server.starter.ServerStarter;
import univek.com.semanticserver.server.starter.impl.JettyServerStarter;

import java.io.*;

public class AppStarter
{
    private static Logger log = Logger.getLogger(AppStarter.class);

	public static void main(String[] args) throws IOException {
//        File file = new File("/home/univek/Development/Big/datamining/semanticserver/src/main/resources/query2.json");
//        FileInputStream fis = new FileInputStream(file);
//        byte[] data = new byte[(int) file.length()];
//        fis.read(data);
//        fis.close();
//
//        String scriptText = new String(data, "UTF-8");
//
//        ScriptManager scriptManager = new ScriptManager();
//        ScriptHandler scriptHandler = scriptManager.getScriptModel(scriptText);
//        scriptHandler.start();


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
