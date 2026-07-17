package Steps;

import com.thoughtworks.gauge.Step;
import helpers.waithelper;
import utils.JsonReader;

public class WaitSteps {

    @Step("Wait until <locatorName> is visible")
    public void waitForElement(String locatorName) {
        waithelper.waitForElement(JsonReader.getLocator(locatorName));
    }

    @Step("Wait until <locatorName> is clickable")
    public void waitForClickable(String locatorName) {
        waithelper.waitForClickable(JsonReader.getLocator(locatorName));
    }

    @Step("Wait until <locatorName> disappears")
    public void waitForInvisible(String locatorName) {
        waithelper.waitForInvisible(JsonReader.getLocator(locatorName));
    }

    @Step("Wait <seconds> seconds")
    public void waitSeconds(int seconds) {
        waithelper.waitSeconds(seconds);
    }
}
