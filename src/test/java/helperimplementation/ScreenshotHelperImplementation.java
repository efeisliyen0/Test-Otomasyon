package helpers;

import driverManager.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

public class ScreenshotHelperImplementation implements ScreenshotHelper {

    @Override
    public void takeScreenshot(String screenshotName, String folderType) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        // Proje dizininde screenshots klasörü altına baseline veya actual olarak kaydeder
        String path = "screenshots/" + folderType + "/" + screenshotName + ".png";
        File destination = new File(path);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            System.out.println("Ekran görüntüsü kaydedilemedi: " + e.getMessage());
        }
    }
}