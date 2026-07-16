package StepImplementation;

import helpers.elementhelper;
import locators.LocatorManager;

public class ClickImp {

    public void click(String locatorName) {
        elementhelper.click(
                LocatorManager.getLocator(locatorName)
        );
    }
}