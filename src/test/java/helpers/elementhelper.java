package helpers;

import driverManager.Driver;
import org.openqa.selenium.By;

public class elementhelper {
    public static void click(By locator) {
        waithelper.waitForClickable(locator);
        Driver.getDriver().findElement(locator).click();
    }
    public static void sendKeys(By locator, String text) {
        waithelper.waitForElement(locator);
        Driver.getDriver().findElement(locator).sendKeys(text);
    }
    public static void clear(By locator) {
        waithelper.waitForElement(locator);
        Driver.getDriver().findElement(locator).clear();
    }
    public static String getText(By locator) {
        waithelper.waitForElement(locator);
        return Driver.getDriver().findElement(locator).getText();
    }
    public static boolean isDisplayed(By locator) {
        waithelper.waitForElement(locator);
        return Driver.getDriver().findElement(locator).isDisplayed();
    }
    public static int getNumber(By locator) {waithelper.waitForElement(locator);
        return Integer.parseInt(Driver.getDriver().findElement(locator).getText()
        );
    }
}