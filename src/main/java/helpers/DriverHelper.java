package helpers;

import driverManager.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JsonReader;
import java.util.List;


public class DriverHelper {

    public static WebDriver getDriver() {
        return Driver.getDriver();
    }

    public static WebElement getElement(String locatorName) {
        return getDriver().findElement(JsonReader.getLocator(locatorName));
    }

    public static By getLocator(String locatorName) {
        return JsonReader.getLocator(locatorName);
    }

    public static List<WebElement> getElements(String locatorName) {
        return getDriver().findElements(JsonReader.getLocator(locatorName));
    }
}