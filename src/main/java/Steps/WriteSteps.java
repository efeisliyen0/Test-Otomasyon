package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.AllureStepRunner;
import utils.TestDataReader;

public class WriteSteps extends elementhelper {

    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {
            String value;
            if (text.equals("")) {
                value = "";
            } else if (text.contains(".")) {
                String[] data = text.split("\\.");
                value = TestDataReader.getValue(data[0], data[1]);
            } else {
                value = text;
            }
            super.sendKeys(locatorName, value);;
    }

    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {
                super.clear(locatorName);
    }
}