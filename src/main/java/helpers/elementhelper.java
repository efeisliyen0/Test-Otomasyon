package helpers;

import exceptions.ElementOperationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import utils.AllureStepRunner;

public class elementhelper {

    private static final Logger logger = LogManager.getLogger(elementhelper.class);

    public void click(String locatorName) {
        AllureStepRunner.run("Tıklandı: " + locatorName, () -> {
            try {waithelper.waitForClickable(locatorName);
                DriverHelper.getElement(locatorName).click();
            } catch (Exception e) {logger.error("Click failed: {}", locatorName, e);
                throw new ElementOperationException("Click failed: " + locatorName, e);
            }
        });
    }

    public void sendKeys(String locatorName, String text) {
        AllureStepRunner.run(locatorName + " alanına yazıldı", () -> {
            try {waithelper.waitForElement(locatorName);
                DriverHelper.getElement(locatorName).sendKeys(text);
            } catch (Exception e) {
                logger.error("Send keys failed: {}", locatorName, e);
                throw new ElementOperationException("Send keys failed: " + locatorName, e);
            }
        });
    }

    public void clear(String locatorName) {
        AllureStepRunner.run(locatorName + " alanı temizlendi", () -> {
            try {
                waithelper.waitForElement(locatorName);
                DriverHelper.getElement(locatorName).clear();
            } catch (Exception e) {
                logger.error("Clear failed: {}", locatorName, e);
                throw new ElementOperationException("Clear failed: " + locatorName, e);
            }
        });
    }

    public String getText(String locatorName) {
        return AllureStepRunner.run(locatorName + " metni alındı", () -> {
            try {
                waithelper.waitForElement(locatorName);
                return DriverHelper.getElement(locatorName).getText();
            } catch (Exception e) {
                logger.error("Get text failed: {}", locatorName, e);
                throw new ElementOperationException("Get text failed: " + locatorName, e);
            }
        });
    }

    public boolean isDisplayed(String locatorName) {
        return AllureStepRunner.run(locatorName + " görünürlüğü kontrol edildi", () -> {
            try {return DriverHelper.getElement(locatorName).isDisplayed();
            } catch (NoSuchElementException e) {return false;
            } catch (Exception e) {
                logger.error("Display check failed: {}", locatorName, e);
                throw new ElementOperationException("Display check failed: " + locatorName, e);
            }
        });
    }

    public int getNumber(String locatorName) {
        return AllureStepRunner.run(locatorName + " sayısı alındı", () -> {
            try {
                waithelper.waitForElement(locatorName);
                return Integer.parseInt(DriverHelper.getElement(locatorName).getText());
            } catch (Exception e) {
                logger.error("Get number failed: {}", locatorName, e);
                throw new ElementOperationException("Get number failed: " + locatorName, e);
            }
        });
    }

    public void selectByVisibleText(String locatorName, String text) {
        AllureStepRunner.run(locatorName + " içinden '" + text + "' seçildi", () -> {
            try {
                waithelper.waitForElement(locatorName);
                Select select = new Select(DriverHelper.getElement(locatorName));
                select.selectByVisibleText(text);
            } catch (Exception e) {
                logger.error("Select by text failed: {}", locatorName, e);
                throw new ElementOperationException("Select by text failed: " + locatorName, e);
            }
        });
    }

    public void selectByValue(String locatorName, String value) {
        AllureStepRunner.run(locatorName + " içinden value seçildi: " + value, () -> {
            try {
                waithelper.waitForElement(locatorName);
                Select select = new Select(DriverHelper.getElement(locatorName));
                select.selectByValue(value);
            } catch (Exception e) {
                logger.error("Select by value failed: {}", locatorName, e);
                throw new ElementOperationException("Select by value failed: " + locatorName, e);
            }
        });
    }

    public void selectByIndex(String locatorName, int index) {
        AllureStepRunner.run(locatorName + " içinden index seçildi: " + index, () -> {
            try {
                waithelper.waitForElement(locatorName);
                Select select = new Select(DriverHelper.getElement(locatorName));
                select.selectByIndex(index);
            } catch (Exception e) {
                logger.error("Select by index failed: {}", locatorName, e);
                throw new ElementOperationException("Select by index failed: " + locatorName, e);
            }
        });
    }
}