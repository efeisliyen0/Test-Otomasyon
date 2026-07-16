package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.VisualStepsImp;

public class VisualSteps {

    private final VisualStepsImp visualStepsImplementation =
            new VisualStepsImp();
    @Step("User takes screenshot and saves as <name>")
    public void takeScreenshot(String name) {
        visualStepsImplementation.takeScreenshot(name);
    }
    @Step("User compares screenshot <actual> with <baseline>")
    public void compareScreenshots(String actual, String baseline) {
        visualStepsImplementation.compareScreenshots(actual, baseline);
    }
}
