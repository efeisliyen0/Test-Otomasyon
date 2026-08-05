package locators;

import org.openqa.selenium.By;
import utils.JsonReader;

public class LocatorManager {

    public static By getLocator(String locatorName) {
        String type = JsonReader.getType(locatorName);
        String value = JsonReader.getValue(locatorName);
        switch (type.toLowerCase()) {
            case "id": return By.id(value);
            case "classname": return By.className(value);
            case "name": return By.name(value);
            case "css": return By.cssSelector(value);
            case "xpath": return By.xpath(value);
            case "tag": return By.tagName(value);
            case "linktext": return By.linkText(value);
            case "partiallinktext": return By.partialLinkText(value);
            default: throw new IllegalArgumentException("Desteklenmeyen locator tipi : " + type);
        }
    }
}