package StepImplementation;

import helpers.ScreenshotHelper;

public class ScreenshotImp {

    private static final String BASELINE_PATH =
            ".gauge/screenshots/visual/baseline/";

    private static final String ACTUAL_PATH =
            ".gauge/screenshots/visual/actual/";

    public void takeBaselineScreenshot(String fileName) {
        ScreenshotHelper.takeScreenshot(BASELINE_PATH, fileName);
    }

    public void takeActualScreenshot(String fileName) {
        ScreenshotHelper.takeScreenshot(ACTUAL_PATH, fileName);
    }
}
