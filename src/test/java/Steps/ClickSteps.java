package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.LocatorManager;

public class ClickSteps {

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {

        elementhelper.click(
                LocatorManager.getLocator(locatorName)
        );
    }
}
