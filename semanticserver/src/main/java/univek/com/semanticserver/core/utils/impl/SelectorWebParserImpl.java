package univek.com.semanticserver.core.utils.impl;

import univek.com.semanticserver.core.models.defaultscript.WebDataType;
import univek.com.semanticserver.core.utils.SelectorWebParser;

import java.util.ArrayList;

public abstract class SelectorWebParserImpl implements SelectorWebParser {
    protected String url;
    protected String selector;
    protected WebDataType type;
    protected String attrName;

    public SelectorWebParserImpl(String url, String selector, WebDataType type, String attrName) {
        this.url = url;
        this.selector = selector;
        this.type = type;
        this.attrName = attrName;
    }

    public abstract ArrayList<String> parseAllData();
    public abstract String parseFirst();
}
