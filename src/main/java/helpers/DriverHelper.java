package helpers;

import driverManager.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JsonReader;

import java.util.List;

public class DriverHelper {

    private static final Logger logger = LogManager.getLogger(DriverHelper.class);

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

    public static void refresh() {
        try {
            logger.info("Refresh page");
            getDriver().navigate().refresh();
        } catch (Exception e) {
            logger.error("Refresh failed", e);
            throw e;
        }
    }

    public static void back() {
        try {
            logger.info("Navigate back");
            getDriver().navigate().back();
        } catch (Exception e) {
            logger.error("Back navigation failed", e);
            throw e;
        }
    }

    public static void forward() {
        try {
            logger.info("Navigate forward");
            getDriver().navigate().forward();
        } catch (Exception e) {
            logger.error("Forward navigation failed", e);
            throw e;
        }
    }

    public static void maximize() {
        try {
            logger.info("Maximize browser");
            getDriver().manage().window().maximize();
        } catch (Exception e) {
            logger.error("Maximize failed", e);
            throw e;
        }
    }

    public static void minimize() {
        try {
            logger.info("Minimize browser");
            getDriver().manage().window().minimize();
        } catch (Exception e) {
            logger.error("Minimize failed", e);
            throw e;
        }
    }

    public static void open(String url) {
        try {
            logger.info("Open URL: {}", url);
            getDriver().get(url);
        } catch (Exception e) {
            logger.error("Open URL failed: {}", url, e);
            throw e;
        }
    }
}