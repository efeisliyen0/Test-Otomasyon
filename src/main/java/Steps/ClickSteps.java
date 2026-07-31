package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.AllureStepRunner;

public class ClickSteps extends elementhelper {

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
                super.click(locatorName);
    }
}