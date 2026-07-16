package Steps;

import com.thoughtworks.gauge.Step;

public class VisualSteps {

    @Step("User takes screenshot and saves as <name>")
    public void takeScreenshot(String name) {
    }

    @Step("User compares screenshot <actual> with <baseline>")
    public void compareScreenshots(String actual, String baseline) {
    }
}
