package core.scripts;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import core.managers.ThreadManager;
import core.models.defaultscript.DefaultScript;
import core.models.defaultscript.ScriptRule;
import core.models.defaultscript.TemplateElement;
import core.models.defaultscript.WebVar;
import core.outputs.DefaultScriptOutput;
import core.outputs.DefaultScriptOutputBox;
import core.utils.SelectorElementWebParser;
import core.utils.SelectorWebParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class DefaultScriptHandler extends ScriptHandler{

    private ThreadManager threadManager = null;
    private DefaultScript script = null;
    private DefaultScriptOutput output = null;

    public DefaultScriptHandler(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    @Override
    public void handleToModel(JsonElement element) {
        Gson gson = new Gson();
        script = gson.fromJson(element, DefaultScript.class);
    }

    @Override
    public void start() {
        if (script == null)
            return;

        try {
            output= new DefaultScriptOutput();
            ArrayList<Thread> threads = new ArrayList<>();
            for (ScriptRule node : script.getNodes()) {
                node.getResources().createUrls();
                ArrayList<String> urls = node.getResources().getUrls();

                for (String url : urls) {

                    Runnable task = () -> {
                        try {
                            DefaultScriptOutputBox box = output.addNode(url);
                            for (TemplateElement telem : node.getTemplate().getElements()) {
                                Document doc = Jsoup.connect(url).get();
                                Elements elements = doc.select(telem.getSelector());
                                for (Element elem : elements) {
                                    TemplateElement oelement = box.addElement(telem.getSelector());
                                    for (WebVar var : telem.getVars()) {
                                        SelectorWebParser parser = new SelectorElementWebParser(elem, url, var.getSelector(), var.getType(), var.getAttrName());
                                        var.setValue(parser.parseFirst());
                                        oelement.addVar(var);
                                    }
                                }
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    };
                    threadManager.addNewTask(task);
                }
            }
            threadManager.runAllAndJoin();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
