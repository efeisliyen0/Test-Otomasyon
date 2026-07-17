package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.JsonReader;

public class WriteSteps {

    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {
        elementhelper.sendKeys(JsonReader.getLocator(locatorName), text);
    }

    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {
        elementhelper.clear(JsonReader.getLocator(locatorName));
    }
}
