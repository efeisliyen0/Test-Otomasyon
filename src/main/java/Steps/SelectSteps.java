package Steps;

import com.thoughtworks.gauge.Step;
import helpers.TestDataHelper;
import helpers.elementhelper;
import utils.AllureStepRunner;

public class SelectSteps {

    @Step("User selects <text> from <locatorName>")
    public void selectByVisibleText(String text, String locatorName) {
        AllureStepRunner.run(locatorName + " içinden seçildi: " + text, () ->
                elementhelper.selectByVisibleText(locatorName, TestDataHelper.getTestData(text))
        );
    }

    @Step("User selects value <value> from <locatorName>")
    public void selectByValue(String value, String locatorName) {
        AllureStepRunner.run(locatorName + " içinden değer seçildi: " + value, () ->
                elementhelper.selectByValue(locatorName, TestDataHelper.getTestData(value))
        );
    }

    @Step("User selects index <index> from <locatorName>")
    public void selectByIndex(int index, String locatorName) {
        AllureStepRunner.run(locatorName + " içinden index seçildi: " + index, () ->
                elementhelper.selectByIndex(locatorName, index)
        );
    }
}