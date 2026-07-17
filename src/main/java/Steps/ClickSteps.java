package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.JsonReader;

public class ClickSteps {

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
        elementhelper.click(JsonReader.getLocator(locatorName)
        );
    }
}
