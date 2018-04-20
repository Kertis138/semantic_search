package univek.com.semanticserver.core.scripts;

import com.google.gson.JsonElement;

public interface ScriptHandler {
    void handleToModel(JsonElement element);
    void start();
}
