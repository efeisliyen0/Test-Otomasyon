package steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.ScreenshotImp;

public class ScreenshotSteps {
    private ScreenshotImp screenshotImp;

    public ScreenshotSteps() {
        this.screenshotImp = new ScreenshotImp();
    }

    @Step("User takes baseline screenshot as <imageName>")
    public void captureBaseline(String imageName) {
        screenshotImp.takeBaseline(imageName);
    }

    @Step("User takes actual screenshot as <imageName>")
    public void captureActual(String imageName) {
        screenshotImp.takeActual(imageName);
    }
}
