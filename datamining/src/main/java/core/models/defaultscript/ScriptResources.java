package core.models.defaultscript;

import core.utils.SelectorDataWebParser;

import java.util.ArrayList;

public class ScriptResources {
    private ArrayList<String> staticData;
    private ArrayList<ScriptResourcesDynamicData> dynamicData;
    private ArrayList<String> urls = new ArrayList<>();

    public ArrayList<String> getStaticData() {
        return staticData;
    }

    public ArrayList<ScriptResourcesDynamicData> getDynamicData() {
        return dynamicData;
    }

    public void createUrls() {
        urls.addAll(staticData);
        for (ScriptResourcesDynamicData item: dynamicData) {
            SelectorDataWebParser parser = new SelectorDataWebParser(item.getUrl(), item.getSelector(),
                                                                     item.getType(),item.getAttrName());
            ArrayList<String> dynamicUrls = parser.parseAllData();
            urls.addAll(dynamicUrls);
        }
    }

    public ArrayList<String> getUrls() {
        return urls;
    }
}
