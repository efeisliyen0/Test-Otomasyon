package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waithelper {

    private static final Logger logger = LogManager.getLogger(waithelper.class);

    public static void waitForElement(String locatorName) {
        try {
            new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(DriverHelper.getLocator(locatorName)));
        } catch (Exception e) {
            logger.error("Element wait failed: {}", locatorName, e);
            throw e;
        }
    }

    public static void waitForClickable(String locatorName) {
        try {
            new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(DriverHelper.getLocator(locatorName)));
        } catch (Exception e) {
            logger.error("Clickable wait failed: {}", locatorName, e);
            throw e;
        }
    }

    public static void waitForInvisible(String locatorName) {
        try {
            new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(DriverHelper.getLocator(locatorName)));
        } catch (Exception e) {
            logger.error("Invisible wait failed: {}", locatorName, e);
            throw e;
        }
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            logger.error("Wait interrupted: {} seconds", seconds, e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Wait interrupted", e);
        }
    }
}