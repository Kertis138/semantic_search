package core.outputs;

import core.models.defaultscript.TemplateElement;

import java.util.ArrayList;

public class DefaultScriptOutputBox {
    private String url = "";
    private ArrayList<TemplateElement> elements = new ArrayList<>();

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<TemplateElement> getElements() {
        return elements;
    }

    public TemplateElement addElement(String selector) {
        TemplateElement elem = new TemplateElement();
        elem.setSelector(selector);
        elements.add(elem);
        return elem;
    }
}
