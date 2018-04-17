package core.scripts;

import com.google.gson.JsonElement;

public abstract class ScriptHandler {
    abstract void handleToModel(JsonElement element);
    abstract void start();
}
