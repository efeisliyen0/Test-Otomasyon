package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.JsonReader;
import utils.TestDataReader;

public class WriteSteps {


    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {

        String value;

        if (text.equals("")) {
            value = "";
        }
        else if (text.contains(".")) {

            String[] data = text.split("\\.");

            value = TestDataReader.getValue(
                    data[0],
                    data[1]
            );

        }
        else {
            value = text;
        }


        elementhelper.sendKeys(
                JsonReader.getLocator(locatorName),
                value
        );
    }


    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {

        elementhelper.clear(
                JsonReader.getLocator(locatorName)
        );
    }
}