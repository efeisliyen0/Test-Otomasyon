package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ScreenshotHelper;

public class ScreenshotSteps {

    private static final String BASELINE_PATH =
            ".gauge/screenshots/visual/baseline/";

    private static final String ACTUAL_PATH =
            ".gauge/screenshots/visual/actual/";

    @Step("User takes baseline screenshot as <fileName>")
    public void takeBaselineScreenshot(String fileName) {
        ScreenshotHelper.takeScreenshot(BASELINE_PATH, fileName);
    }

    @Step("User takes actual screenshot as <fileName>")
    public void takeActualScreenshot(String fileName) {
        ScreenshotHelper.takeScreenshot(ACTUAL_PATH, fileName);
    }
}
