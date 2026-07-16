package helpers;

import helperimplementation.ScreenshotHelperImplementation;

public class ScreenshotHelper {

    private static final ScreenshotHelperImplementation implementation =
            new ScreenshotHelperImplementation();

    public static void takeScreenshot(String path, String fileName) {
        implementation.takeScreenshot(path, fileName);
    }
}
