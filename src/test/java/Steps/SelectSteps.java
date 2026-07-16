package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.SelectImp;

public class SelectSteps {

    private final SelectImp selectImplementation =
            new SelectImp();

    @Step("User selects <text> from <locatorName>")
    public void selectByVisibleText(String text, String locatorName) {
        selectImplementation.selectByVisibleText(locatorName, text);
    }

    @Step("User selects value <value> from <locatorName>")
    public void selectByValue(String value, String locatorName) {
        selectImplementation.selectByValue(locatorName, value);
    }

    @Step("User selects index <index> from <locatorName>")
    public void selectByIndex(int index, String locatorName) {
        selectImplementation.selectByIndex(locatorName, index);
    }
}
