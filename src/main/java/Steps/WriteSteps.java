package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.AllureStepRunner;
import utils.TestDataReader;

public class WriteSteps {

    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {
        AllureStepRunner.run(locatorName + " alanına yazıldı: " + text, () -> {
            String value;
            if (text.equals("")) {
                value = "";
            } else if (text.contains(".")) {
                String[] data = text.split("\\.");
                value = TestDataReader.getValue(data[0], data[1]);
            } else {
                value = text;
            }
            elementhelper.sendKeys(locatorName, value);
        });
    }

    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {
        AllureStepRunner.run(locatorName + " alanı temizlendi", () ->
                elementhelper.clear(locatorName)
        );
    }
}