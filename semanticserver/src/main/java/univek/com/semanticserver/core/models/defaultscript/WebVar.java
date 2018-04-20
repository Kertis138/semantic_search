package univek.com.semanticserver.core.models.defaultscript;

public class WebVar {
    private String name;
    private WebDataType type;
    private String selector;
    private String attrName;
    private String value;

    public String getName() {
        return name;
    }

    public WebDataType getType() {
        return type;
    }

    public String getSelector() {
        return selector;
    }

    public String getAttrName() {
        return attrName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(WebDataType type) {
        this.type = type;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
}
