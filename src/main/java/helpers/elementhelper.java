package helpers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;

public class elementhelper {

    public static void click(String locatorName) {
        waithelper.waitForClickable(locatorName);
        DriverHelper.getElement(locatorName).click();
    }

    public static void sendKeys(String locatorName, String text) {
        waithelper.waitForElement(locatorName);
        DriverHelper.getElement(locatorName).sendKeys(text);
    }

    public static void clear(String locatorName) {
        waithelper.waitForElement(locatorName);
        DriverHelper.getElement(locatorName).clear();
    }

    public static String getText(String locatorName) {
        waithelper.waitForElement(locatorName);
        return DriverHelper.getElement(locatorName).getText();
    }

    public static boolean isDisplayed(String locatorName) {
        try {
            return DriverHelper.getElement(locatorName).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static int getNumber(String locatorName) {
        waithelper.waitForElement(locatorName);
        return Integer.parseInt(DriverHelper.getElement(locatorName).getText());
    }

    public static void selectByVisibleText(String locatorName, String text) {
        waithelper.waitForElement(locatorName);
        Select select = new Select(DriverHelper.getElement(locatorName));
        select.selectByVisibleText(text);
    }

    public static void selectByValue(String locatorName, String value) {
        waithelper.waitForElement(locatorName);
        Select select = new Select(DriverHelper.getElement(locatorName));
        select.selectByValue(value);
    }

    public static void selectByIndex(String locatorName, int index) {
        waithelper.waitForElement(locatorName);
        Select select = new Select(DriverHelper.getElement(locatorName));
        select.selectByIndex(index);
    }
}