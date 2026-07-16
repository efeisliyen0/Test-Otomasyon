package StepImplementation;

import helpers.waithelper;
import locators.LocatorManager;

public class WaitImp {

    public void waitForElement(String locatorName) {
        waithelper.waitForElement(
                LocatorManager.getLocator(locatorName));
    }

    public void waitForClickable(String locatorName) {
        waithelper.waitForClickable(
                LocatorManager.getLocator(locatorName));
    }

    public void waitForInvisible(String locatorName) {
        waithelper.waitForInvisible(
                LocatorManager.getLocator(locatorName));
    }

    public void waitSeconds(int seconds) {
        waithelper.waitSeconds(seconds);
    }
}
