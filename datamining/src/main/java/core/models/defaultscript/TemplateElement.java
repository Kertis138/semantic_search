package core.models.defaultscript;

import java.util.ArrayList;

public class TemplateElement {
    private String selector;
    private ArrayList<WebVar> vars = new ArrayList<>();

    public String getSelector() {
        return selector;
    }

    public ArrayList<WebVar> getVars() {
        return vars;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public WebVar addVar() {
        WebVar var = new WebVar();
        vars.add(var);
        return var;
    }

    public WebVar addVar(WebVar cvar) {
        WebVar var = new WebVar();
        var.setAttrName(cvar.getAttrName());
        var.setName(cvar.getName());
        var.setSelector(cvar.getSelector());
        var.setType(cvar.getType());
        var.setValue(cvar.getValue());
        vars.add(var);
        return var;
    }
}
