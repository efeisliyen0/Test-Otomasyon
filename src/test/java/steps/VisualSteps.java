package steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.VisualStepsImplementation;

public class VisualSteps {
    VisualStepsImplementation visualStepsImplementation = new VisualStepsImplementation();
    @Step("User takes baseline screenshot as <fileName>")
    public void takeBaselineScreenshot(String fileName){visualStepsImplementation.takeBaselineScreenshot(fileName);}
    @Step("User takes actual screenshot as <fileName>")
    public void takeActualScreenshot(String fileName){visualStepsImplementation.takeActualScreenshot(fileName);}
    @Step("User compares screenshot with baseline <fileName>")
    public void compareScreenshot(String fileName){visualStepsImplementation.compareScreenshot(fileName);}
}