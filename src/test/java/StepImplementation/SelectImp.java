package StepImplementation;

import driverManager.Driver;
import locators.LocatorManager;
import org.openqa.selenium.support.ui.Select;

public class SelectImp {

    public void selectByVisibleText(String locatorName, String text) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)));

        select.selectByVisibleText(text);
    }

    public void selectByValue(String locatorName, String value) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)));

        select.selectByValue(value);
    }

    public void selectByIndex(String locatorName, int index) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)));

        select.selectByIndex(index);
    }
}
