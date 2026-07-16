package StepImplementation;

import helpers.elementhelper;
import locators.LocatorManager;

public class WriteImp {

    public void write(String text, String locatorName) {
        elementhelper.sendKeys(LocatorManager.getLocator(locatorName), text);
    }
    public void clear(String locatorName) {
        elementhelper.clear(LocatorManager.getLocator(locatorName));
    }
}
