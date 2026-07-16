package Steps;

import com.thoughtworks.gauge.Step;
import helpers.waithelper;
import locators.LocatorManager;

public class WaitSteps {

    @Step("Wait until <locatorName> is visible")
    public void waitForElement(String locatorName) {
        waithelper.waitForElement(
                LocatorManager.getLocator(locatorName));
    }

    @Step("Wait until <locatorName> is clickable")
    public void waitForClickable(String locatorName) {
        waithelper.waitForClickable(
                LocatorManager.getLocator(locatorName));
    }

    @Step("Wait until <locatorName> disappears")
    public void waitForInvisible(String locatorName) {
        waithelper.waitForInvisible(
                LocatorManager.getLocator(locatorName));
    }

    @Step("Wait <seconds> seconds")
    public void waitSeconds(int seconds) {
        waithelper.waitSeconds(seconds);
    }
}
