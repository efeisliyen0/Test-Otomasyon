package stepimplementation;

import driverManager.Driver;
import helpers.ImageComparisonHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class VisualStepsImplementation {
    private final String baselinePath = ".gauge/screenshots/visual/baseline/";
    private final String actualPath = ".gauge/screenshots/visual/actual/";
    public void takeBaselineScreenshot(String fileName) {takeScreenshot(baselinePath, fileName);}
    public void takeActualScreenshot(String fileName) {takeScreenshot(actualPath, fileName);}
    public void compareScreenshot(String fileName) {ImageComparisonHelper.compare(fileName);}
    private void takeScreenshot(String path, String fileName) {
        try {File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            File directory = new File(path);if(!directory.exists()){directory.mkdirs();}
            File destination = new File(path + fileName + ".png");
            Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved : " + destination.getPath();
        } catch(Exception e){throw new RuntimeException("Screenshot alınamadı : " + e.getMessage());
        }
    }

}