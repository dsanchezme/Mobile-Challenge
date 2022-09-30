package core;

public class MobileElement {

    public By by;
    public String element;
    public String elementDescription;

    public MobileElement(By by, String element, String elementDescription) {
        this.by = by;
        this.element = element;
        this.elementDescription = elementDescription;
    }
}
