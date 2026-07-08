package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import driverManager.Driver;

public class ScreenshotUtils {
    public static void takeScreenshot(String fileName){
        try {
            TakesScreenshot screenshot = (TakesScreenshot) Driver.getDriver();
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File target = new File("screenshots/" + fileName + ".png");
            FileUtils.copyFile(source, target);
        } catch (IOException hata) {
            System.out.println("ScreenShot Alınamadı.");
        }
    }
}