package helperimplementation;

import driverManager.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotHelperImplementation {

    public void takeScreenshot(String path, String fileName) {

        try {

            File screenshot = ((TakesScreenshot) Driver.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            File directory = new File(path);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File destination = new File(path + fileName + ".png");

            Files.copy(
                    screenshot.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println("Screenshot saved: " + destination.getAbsolutePath());

        } catch (Exception e) {
            throw new RuntimeException("Screenshot alınamadı : " + e.getMessage());
        }
    }
}