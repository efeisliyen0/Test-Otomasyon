package helpers;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waithelper {

    public static void waitForElement(String locatorName) {
        new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        DriverHelper.getLocator(locatorName)));
    }

    public static void waitForClickable(String locatorName) {
        new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        DriverHelper.getLocator(locatorName)));
    }

    public static void waitForInvisible(String locatorName) {
        new WebDriverWait(DriverHelper.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(
                        DriverHelper.getLocator(locatorName)));
    }

    public static void waitSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}