package univek.com.semanticserver.core.utils.impl;

import univek.com.semanticserver.core.models.defaultscript.WebDataType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class SelectorDataWebParserImpl extends SelectorWebParserImpl {

    public SelectorDataWebParserImpl(String url, String selector, WebDataType type, String attrName) {
        super(url,selector,type,attrName);
    }

    @Override
    public ArrayList<String> parseAllData() {
        try {
            ArrayList<String> data = new ArrayList<>();
            Document doc  = Jsoup.connect(url).get();
            //Elements elements = Xsoup.compile(selector).evaluate(doc).getElements();
            Elements elements = doc.select(selector);
            for (Element elem: elements) {
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

    @Override
    public String parseFirst() {
        try {
            String data = "";
            Document doc  = Jsoup.connect(url).get();
            Elements elements = doc.select(selector);
            if(elements.size() <= 0)
                return "";
            Element elem = elements.get(0);
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
