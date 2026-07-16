package StepImplementation;

import helpers.ScreenshotHelper;
import helpers.ScreenshotHelperImplementation;

public class ScreenshotImp {
    private ScreenshotHelper screenshotHelper;

    public ScreenshotImp() {
        this.screenshotHelper = new ScreenshotHelperImplementation();
    }

    public void takeBaseline(String name) {
        screenshotHelper.takeScreenshot(name, "baseline");
    }

    public void takeActual(String name) {
        screenshotHelper.takeScreenshot(name, "actual");
    }
}
