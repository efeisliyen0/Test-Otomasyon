package utils;

import helpers.ScreenshotHelper;
import io.qameta.allure.Allure;

import java.util.function.Supplier;

public class AllureStepRunner {

    public static void run(String stepName, Runnable action) {
        try {
            Allure.step(stepName, action::run);
        } catch (Throwable t) {
            AllureStatusHolder.markFailed();
            ScreenshotHelper.attachToAllure("Başarısız adım: " + stepName);
            throw t;
        }
    }

    public static <T> T run(String stepName, Supplier<T> action) {
        try {
            return Allure.step(stepName, action::get);
        } catch (Throwable t) {
            AllureStatusHolder.markFailed();
            ScreenshotHelper.attachToAllure("Başarısız adım: " + stepName);
            throw t;
        }
    }
}