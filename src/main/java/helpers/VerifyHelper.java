package helpers;

import exceptions.VerificationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import utils.AllureStepRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyHelper {

    private static final Logger logger = LogManager.getLogger(VerifyHelper.class);
    private static final elementhelper element = new elementhelper();

    public static void verifyText(String locatorName, String expectedText) {
        AllureStepRunner.run("Metin doğrulanıyor: " + locatorName, () -> {
            try {
                assertThat(element.getText(locatorName)).isEqualTo(expectedText);
            } catch (AssertionError e) {
                logger.error("Text verification failed: {}", locatorName, e);
                throw new VerificationException("Text verification failed: " + locatorName, e);
            }
        });
    }

    public static void verifyMessage(String locatorName, String expectedMessage) {
        AllureStepRunner.run("Mesaj doğrulanıyor: " + locatorName, () -> {
            try {
                assertThat(element.getText(locatorName)).isEqualTo(expectedMessage);
            } catch (AssertionError e) {
                logger.error("Message verification failed: {}", locatorName, e);
                throw new VerificationException("Message verification failed: " + locatorName, e);
            }
        });
    }

    public static void verifyNumber(String locatorName, int expectedNumber) {
        AllureStepRunner.run("Sayı doğrulanıyor: " + locatorName, () -> {
            try {
                assertThat(element.getNumber(locatorName)).isEqualTo(expectedNumber);
            } catch (AssertionError e) {
                logger.error("Number verification failed: {}", locatorName, e);
                throw new VerificationException("Number verification failed: " + locatorName, e);
            }
        });
    }

    public static void verifyDisplayed(String locatorName) {
        AllureStepRunner.run("Element görünürlüğü doğrulanıyor: " + locatorName, () -> {
            try {
                assertThat(element.isDisplayed(locatorName)).isTrue();
            } catch (AssertionError e) {
                logger.error("Element display verification failed: {}", locatorName, e);
                throw new VerificationException("Element is not displayed: " + locatorName, e);
            }
        });
    }

    public static void verifyNotDisplayed(String locatorName) {
        AllureStepRunner.run("Element görünmezliği doğrulanıyor: " + locatorName, () -> {
            try {
                assertThat(element.isDisplayed(locatorName)).isFalse();
            } catch (AssertionError e) {
                logger.error("Element hidden verification failed: {}", locatorName, e);
                throw new VerificationException("Element is still displayed: " + locatorName, e);
            }
        });
    }

    public static int getNumber(String locatorName) {
        return element.getNumber(locatorName);
    }

    public static void verifyProductsSortedLowToHigh(String locatorName) {
        AllureStepRunner.run("Ürün sıralaması doğrulanıyor", () -> {
            try {
                List<WebElement> priceElements = DriverHelper.getElements(locatorName);
                List<Double> actualPrices = new ArrayList<>();
                for (WebElement price : priceElements) {
                    actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));}
                List<Double> sortedPrices = new ArrayList<>(actualPrices);
                Collections.sort(sortedPrices);
                assertThat(actualPrices).isEqualTo(sortedPrices);
            } catch (AssertionError e) {
                logger.error("Product sorting verification failed: {}", locatorName, e);
                throw new VerificationException("Product sorting verification failed: " + locatorName, e
                );
            }
        });
    }
}