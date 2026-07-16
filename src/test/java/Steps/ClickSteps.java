package Steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.ClickImp;

public class ClickSteps {

    private final ClickImp clickImplementation =
            new ClickImp();

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
        clickImplementation.click(locatorName);
    }
}
