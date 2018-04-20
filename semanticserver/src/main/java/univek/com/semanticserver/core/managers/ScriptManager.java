package univek.com.semanticserver.core.managers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import univek.com.semanticserver.core.models.ScriptModel;
import univek.com.semanticserver.core.scripts.impl.DefaultScriptHandler;
import univek.com.semanticserver.core.scripts.ScriptHandler;

public class ScriptManager{

    public ScriptHandler getScriptModel(String data) {
        try {
            Gson gson = new Gson();
            ScriptModel script = gson.fromJson(data, ScriptModel.class);
            JsonElement element = script.getScript();
            //??DefaultScript
            DefaultScriptHandler handler = new DefaultScriptHandler(new ThreadManager());
            handler.handleToModel(element);
            return handler;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
