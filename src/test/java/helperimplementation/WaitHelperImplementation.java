package helperimplementation;

import driverManager.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelperImplementation {

    private final WebDriverWait wait =
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
