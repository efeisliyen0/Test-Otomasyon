package utils;

import helpers.ScreenshotHelper;
import io.qameta.allure.Allure;

public class AllureStepRunner {

    public static void run(String stepName, Runnable action) {
        try {
            Allure.step(stepName, () -> action.run());
        } catch (Throwable t) {
            AllureStatusHolder.markFailed();
            ScreenshotHelper.attachToAllure("Başarısız adım: " + stepName);
            throw t;
        }
    }
}