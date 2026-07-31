package Steps;

import com.thoughtworks.gauge.Step;
import helpers.TestDataHelper;
import helpers.elementhelper;
import utils.AllureStepRunner;

public class SelectSteps extends elementhelper{

    @Step("User selects <text> from <locatorName>")
    public void selectByVisibleText(String text, String locatorName) {
                super.selectByVisibleText(locatorName, TestDataHelper.getTestData(text));
    }

    @Step("User selects value <value> from <locatorName>")
    public void selectByValue(String value, String locatorName) {
                super.selectByValue(locatorName, TestDataHelper.getTestData(value));
    }

    @Step("User selects index <index> from <locatorName>")
    public void selectByIndex(int index, String locatorName) {
               super.selectByIndex(locatorName, index);
    }
}