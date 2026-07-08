package helpers;

import driverManager.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

public class screenshothelper {
    public static void takeScreenshot(String fileName) {
        File source = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File target = new File("screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}