package univek.com.semanticserver.core.outputs;


import java.util.ArrayList;

public class DefaultScriptOutput {
    private ArrayList<DefaultScriptOutputBox> nodes = new ArrayList<>();

    public ArrayList<DefaultScriptOutputBox> getNodes() {
        return nodes;
    }

    public DefaultScriptOutputBox addNode(String url) {
        DefaultScriptOutputBox obj = new DefaultScriptOutputBox();
        obj.setUrl(url);
        nodes.add(obj);
        return obj;
    }
}
