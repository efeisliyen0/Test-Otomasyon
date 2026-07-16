package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.WaitImp;

public class WaitSteps {

    private final WaitImp waitImplementation =
            new WaitImp();

    @Step("Wait until <locatorName> is visible")
    public void waitForElement(String locatorName) {
        waitImplementation.waitForElement(locatorName);
    }

    @Step("Wait until <locatorName> is clickable")
    public void waitForClickable(String locatorName) {
        waitImplementation.waitForClickable(locatorName);
    }

    @Step("Wait until <locatorName> disappears")
    public void waitForInvisible(String locatorName) {
        waitImplementation.waitForInvisible(locatorName);
    }

    @Step("Wait <seconds> seconds")
    public void waitSeconds(int seconds) {
        waitImplementation.waitSeconds(seconds);
    }
}
