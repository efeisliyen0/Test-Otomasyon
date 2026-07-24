package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyHelper {

    private static final Logger logger = LogManager.getLogger(VerifyHelper.class);

    public static void verifyText(String locatorName, String expectedText) {
        logger.info("Metin doğrulanıyor. Locator: " + locatorName + ", Beklenen Metin: " + expectedText);
        try {
            assertThat(elementhelper.getText(locatorName)).isEqualTo(expectedText);
            logger.info("Metin doğrulama başarılı.");
        } catch (AssertionError e) {
            logger.error("Metin doğrulama BAŞARISIZ! Hata: " + e.getMessage());
            throw e;
        }
    }

    public static void verifyMessage(String locatorName, String expectedMessage) {
        logger.info("Mesaj doğrulanıyor. Locator: " + locatorName + ", Beklenen Mesaj: " + expectedMessage);
        try {
            assertThat(elementhelper.getText(locatorName)).isEqualTo(expectedMessage);
            logger.info("Mesaj doğrulama başarılı.");
        } catch (AssertionError e) {
            logger.error("Mesaj doğrulama BAŞARISIZ! Hata: " + e.getMessage());
            throw e;
        }
    }

    public static void verifyNumber(String locatorName, int expectedNumber) {
        logger.info("Sayı doğrulanıyor. Locator: " + locatorName + ", Beklenen Sayı: " + expectedNumber);
        try {
            assertThat(elementhelper.getNumber(locatorName)).isEqualTo(expectedNumber);
            logger.info("Sayı doğrulama başarılı.");
        } catch (AssertionError e) {
            logger.error("Sayı doğrulama BAŞARISIZ! Hata: " + e.getMessage());
            throw e;
        }
    }

    public static void verifyDisplayed(String locatorName) {
        logger.info("Elementin görünür olduğu doğrulanıyor. Locator: " + locatorName);
        try {
            assertThat(elementhelper.isDisplayed(locatorName)).isTrue();
            logger.info("Element görünür.");
        } catch (AssertionError e) {
            logger.error("Element görünür DEĞİL! Hata: " + e.getMessage());
            throw e;
        }
    }

    public static void verifyNotDisplayed(String locatorName) {
        logger.info("Elementin görünmediği doğrulanıyor. Locator: " + locatorName);
        try {
            assertThat(elementhelper.isDisplayed(locatorName)).isFalse();
            logger.info("Element görünmüyor (Doğru).");
        } catch (AssertionError e) {
            logger.error("Element beklenirken göründü! Hata: " + e.getMessage());
            throw e;
        }
    }

    public static int getNumber(String locatorName) {
        logger.info("Sayı alınıyor. Locator: " + locatorName);
        return elementhelper.getNumber(locatorName);
    }

    public static void verifyProductsSortedLowToHigh(String locatorName) {
        logger.info("Ürünlerin düşükten yükseğe sıralı olduğu kontrol ediliyor. Locator: " + locatorName);
        try {
            List<WebElement> priceElements = DriverHelper.getElements(locatorName);
            List<Double> actualPrices = new ArrayList<>();
            for (WebElement price : priceElements) {
                actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
            }
            List<Double> sortedPrices = new ArrayList<>(actualPrices);
            Collections.sort(sortedPrices);
            assertThat(actualPrices).isEqualTo(sortedPrices);
            logger.info("Ürün sıralaması düşükten yükseğe olacak şekilde başarıyla doğrulandı.");
        } catch (AssertionError e) {
            logger.error("Ürün sıralama doğrulaması BAŞARISIZ! Hata: " + e.getMessage());
            throw e;
        }
    }
}