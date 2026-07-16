package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.ClickImp;

public class ClickSteps {

    private final ClickImp clickImplementation =
            new ClickImp();

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
        clickImplementation.click(locatorName);
    }
}
