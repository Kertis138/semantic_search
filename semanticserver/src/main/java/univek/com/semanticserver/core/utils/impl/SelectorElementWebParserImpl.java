package univek.com.semanticserver.core.utils.impl;

import univek.com.semanticserver.core.models.defaultscript.WebDataType;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class SelectorElementWebParserImpl extends SelectorWebParserImpl {
    private Element element;

    public SelectorElementWebParserImpl(Element element, String url, String selector, WebDataType type, String attrName) {
        super(url,selector,type,attrName);
        this.element = element;
    }

    @Override
    public ArrayList<String> parseAllData() {
        try {
            ArrayList<String> data = new ArrayList<>();
            Elements elements = element.select(selector);
            for (org.jsoup.nodes.Element elem: elements) {
                String value = null;
                if (type == WebDataType.text)
                    value = elem.text();
                else if(type == WebDataType.attr)
                    value = elem.attr(attrName);
                data.add(value);
            }
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public String parseFirst() {
        try {
            String data = "";
            Elements elements = element.select(selector);
            if(elements.size() <= 0)
                return "";
            org.jsoup.nodes.Element elem = elements.get(0);
            if (type == WebDataType.text)
                data = elem.text();
            else if(type == WebDataType.attr)
                data = elem.attr(attrName);
            return data;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
