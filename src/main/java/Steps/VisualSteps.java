package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ImageComparisonHelper;
import helpers.ScreenshotHelper;
import utils.AllureStepRunner;

public class VisualSteps {

    private static final String BASELINE_PATH =
            ".gauge/screenshots/visual/baseline/";

    private static final String ACTUAL_PATH =
            ".gauge/screenshots/visual/actual/";

    @Step("User takes baseline screenshot as <fileName>")
    public void takeBaselineScreenshot(String fileName) {
            ScreenshotHelper.takeScreenshot(BASELINE_PATH, fileName);
            ScreenshotHelper.attachToAllure("Baseline - " + fileName);;
    }

    @Step("User takes actual screenshot as <fileName>")
    public void takeActualScreenshot(String fileName) {
            ScreenshotHelper.takeScreenshot(ACTUAL_PATH, fileName);
            ScreenshotHelper.attachToAllure("Actual - " + fileName);;
    }

    @Step("User compares screenshot with baseline <fileName>")
    public void compareScreenshot(String fileName) {
                ImageComparisonHelper.compare(fileName);
    }
}