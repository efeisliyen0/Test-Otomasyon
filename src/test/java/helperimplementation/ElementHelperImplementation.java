package helperimplementation;

import driverManager.Driver;
import helpers.waithelper;
import org.openqa.selenium.By;

public class ElementHelperImplementation {

    public void click(By locator) {
        waithelper.waitForClickable(locator);
        Driver.getDriver().findElement(locator).click();
    }
    public void sendKeys(By locator, String text) {
        waithelper.waitForElement(locator);
        Driver.getDriver().findElement(locator).sendKeys(text);
    }
    public void clear(By locator) {
        waithelper.waitForElement(locator);
        Driver.getDriver().findElement(locator).clear();
    }
    public String getText(By locator) {
        waithelper.waitForElement(locator);
        return Driver.getDriver().findElement(locator).getText();
    }
    public boolean isDisplayed(By locator) {
        waithelper.waitForElement(locator);
        return Driver.getDriver().findElement(locator).isDisplayed();
    }
    public int getNumber(By locator) {
        waithelper.waitForElement(locator);
        return Integer.parseInt(Driver.getDriver().findElement(locator).getText());
    }
}
