package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.ScreenshotImp;

public class ScreenshotSteps {

    private final ScreenshotImp screenshotImplementation =
            new ScreenshotImp();

    @Step("User takes baseline screenshot as <fileName>")
    public void takeBaselineScreenshot(String fileName) {
        screenshotImplementation.takeBaselineScreenshot(fileName);
    }

    @Step("User takes actual screenshot as <fileName>")
    public void takeActualScreenshot(String fileName) {
        screenshotImplementation.takeActualScreenshot(fileName);
    }
}
