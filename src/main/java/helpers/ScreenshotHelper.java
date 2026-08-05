package helpers;

import exceptions.ScreenshotException;
import driverManager.Driver;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotHelper {

    private static final Logger logger = LogManager.getLogger(ScreenshotHelper.class);

    public static void takeScreenshot(String path, String fileName) {
        try {
            File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            File directory = new File(path);
            if (!directory.exists()) {directory.mkdirs();}
            File destination = new File(path + fileName + ".png");
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING
            );
        } catch (Exception e) {
            logger.error("Screenshot failed: {}", fileName, e);
            throw new ScreenshotException("Screenshot could not be taken: " + fileName, e
            );
        }
    }

    public static void attachToAllure(String label) {
        try {
            byte[] png = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment(label, "image/png", "png", new ByteArrayInputStream(png)
            );
        } catch (Exception e) {
            logger.error("Allure screenshot attachment failed: {}", label, e);
            throw new ScreenshotException("Allure screenshot attachment failed: " + label, e
            );
        }
    }
}