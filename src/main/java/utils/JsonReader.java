package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import java.io.File;

public class JsonReader {
    private static JsonNode json;
    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            json = mapper.readTree(new File("src/test/resources/locators.json"));
        } catch (Exception e) {
            throw new RuntimeException("locators.json okunamadı!");
        }
    }

    public static String getType(String locatorName) {return json.get(locatorName).get("type").asText();}
    public static String getValue(String locatorName) {return json.get(locatorName).get("value").asText();}
    public static By getLocator(String locatorName) {
        String type = getType(locatorName);
        String value = getValue(locatorName);
        switch (type.toLowerCase()) {
            case "id": return By.id(value);
            case "name": return By.name(value);
            case "classname": return By.className(value);
            case "css":
            case "cssselector": return By.cssSelector(value);
            case "xpath": return By.xpath(value);
            case "tagname": return By.tagName(value);
            case "linktext": return By.linkText(value);
            case "partiallinktext": return By.partialLinkText(value);
            default: throw new IllegalArgumentException("Desteklenmeyen locator type: " + type);
        }
    }
}
