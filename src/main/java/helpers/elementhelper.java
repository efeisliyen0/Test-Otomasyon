package helpers;

import driverManager.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
// Eğer waithelper başka bir paketteyse (örneğin helpers) buraya import etmeyi unutma:
// import helpers.waithelper;

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
        try {
            return Driver.getDriver().findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false; // Element sayfada hiç yoksa hata verme, false dön
        }
    }

    public static int getNumber(By locator) {
        waithelper.waitForElement(locator);
        return Integer.parseInt(Driver.getDriver().findElement(locator).getText());
    }

    public static void selectByVisibleText(By locator, String text) {
        // Seçim yapmadan önce elementin yüklenmesini beklemek otomasyonu daha kararlı yapar
        waithelper.waitForElement(locator);
        Select select = new Select(Driver.getDriver().findElement(locator));
        select.selectByVisibleText(text);
    }
}
