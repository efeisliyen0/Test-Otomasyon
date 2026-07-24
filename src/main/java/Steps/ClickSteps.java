package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.AllureStepRunner;

public class ClickSteps {

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
        AllureStepRunner.run("Tıklandı: " + locatorName, () ->
                elementhelper.click(locatorName)
        );
    }
}