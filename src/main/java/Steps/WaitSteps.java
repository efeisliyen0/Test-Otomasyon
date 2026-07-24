package Steps;

import com.thoughtworks.gauge.Step;
import helpers.waithelper;
import utils.AllureStepRunner;

public class WaitSteps {

    @Step("Wait until <locatorName> is visible")
    public void waitForElement(String locatorName) {
        AllureStepRunner.run(locatorName + " görünür olana kadar beklendi", () ->
                waithelper.waitForElement(locatorName)
        );
    }

    @Step("Wait until <locatorName> is clickable")
    public void waitForClickable(String locatorName) {
        AllureStepRunner.run(locatorName + " tıklanabilir olana kadar beklendi", () ->
                waithelper.waitForClickable(locatorName)
        );
    }

    @Step("Wait until <locatorName> disappears")
    public void waitForInvisible(String locatorName) {
        AllureStepRunner.run(locatorName + " kaybolana kadar beklendi", () ->
                waithelper.waitForInvisible(locatorName)
        );
    }

    @Step("Wait <seconds> seconds")
    public void waitSeconds(int seconds) {
        AllureStepRunner.run(seconds + " saniye beklendi", () ->
                waithelper.waitSeconds(seconds)
        );
    }
}