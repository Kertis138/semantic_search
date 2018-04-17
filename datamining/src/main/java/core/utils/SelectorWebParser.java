package core.utils;

import core.models.defaultscript.WebDataType;

import java.util.ArrayList;

public abstract class SelectorWebParser {
    protected String url;
    protected String selector;
    protected WebDataType type;
    protected String attrName;

    public SelectorWebParser(String url, String selector, WebDataType type, String attrName) {
        this.url = url;
        this.selector = selector;
        this.type = type;
        this.attrName = attrName;
    }

    public abstract ArrayList<String> parseAllData();
    public abstract String parseFirst();
}
