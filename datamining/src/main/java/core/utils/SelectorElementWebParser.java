package core.utils;

import core.models.defaultscript.WebDataType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class SelectorElementWebParser extends SelectorWebParser {
    private Element element;

    public SelectorElementWebParser(Element element, String url, String selector, WebDataType type, String attrName) {
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
