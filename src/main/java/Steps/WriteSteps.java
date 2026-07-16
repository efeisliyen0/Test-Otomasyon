package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.LocatorManager;

public class WriteSteps {

    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {
        elementhelper.sendKeys(
                LocatorManager.getLocator(locatorName),
                text
        );
    }

    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {
        elementhelper.clear(
                LocatorManager.getLocator(locatorName)
        );
    }
}
