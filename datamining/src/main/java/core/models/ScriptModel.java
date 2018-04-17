package core.models;

import com.google.gson.JsonElement;

public class ScriptModel {
    private String type;
    private JsonElement script;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonElement getScript() {
        return script;
    }

    public void setScript(JsonElement script) {
        this.script = script;
    }
}
