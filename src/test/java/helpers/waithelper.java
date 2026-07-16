package helpers;

import helperimplementation.WaitHelperImplementation;
import org.openqa.selenium.By;

public class waithelper {

    private static final WaitHelperImplementation implementation = new WaitHelperImplementation();

    public static void waitForElement(By locator) {
        implementation.waitForElement(locator);
    }
    public static void waitForClickable(By locator) {
        implementation.waitForClickable(locator);
    }
    public static void waitForInvisible(By locator) {
        implementation.waitForInvisible(locator);
    }
}