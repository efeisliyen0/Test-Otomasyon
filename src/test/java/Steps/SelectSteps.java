package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import locators.LocatorManager;
import org.openqa.selenium.support.ui.Select;

public class SelectSteps {

    @Step("User selects <text> from <locatorName>")
    public void selectByVisibleText(String text, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)
                )
        );

        select.selectByVisibleText(text);
    }

    @Step("User selects value <value> from <locatorName>")
    public void selectByValue(String value, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)
                )
        );

        select.selectByValue(value);
    }

    @Step("User selects index <index> from <locatorName>")
    public void selectByIndex(int index, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        LocatorManager.getLocator(locatorName)
                )
        );

        select.selectByIndex(index);
    }
}
