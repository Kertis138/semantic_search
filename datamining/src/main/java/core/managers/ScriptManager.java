package core.managers;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import core.models.ScriptModel;
import core.scripts.DefaultScriptHandler;
import core.scripts.ScriptHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ScriptManager implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public ScriptHandler getScriptModel(String data) {
        try {
            Gson gson = new Gson();
            ScriptModel script = gson.fromJson(data, ScriptModel.class);
            JsonElement element = script.getScript();
            //??DefaultScript
            DefaultScriptHandler handler = new DefaultScriptHandler(context.getBean(ThreadManager.class));
            handler.handleToModel(element);
            return handler;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
