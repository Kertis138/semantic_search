import core.managers.ScriptManager;
import core.managers.ThreadManager;
import core.scripts.DefaultScriptHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.*;
import java.util.Scanner;


public class App {

    public static void main(String[] args) throws IOException {
        InputStream inputStream =  App.class.getResourceAsStream("query2.json");
        Scanner s = new Scanner(inputStream).useDelimiter("\\A");
        String scriptText = s.hasNext() ? s.next() : "";

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ScriptManager scriptManager = context.getBean(ScriptManager.class);
        ThreadManager threadManager = context.getBean(ThreadManager.class);
        DefaultScriptHandler defaultScriptHandler = (DefaultScriptHandler) scriptManager.getScriptModel(scriptText);
        defaultScriptHandler.start();

        System.out.println(threadManager.getLastThreadsCount());
        System.out.println(threadManager.getLastThreadsTime());
    }
}
