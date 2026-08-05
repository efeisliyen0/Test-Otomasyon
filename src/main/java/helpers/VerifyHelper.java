package helpers;

import exceptions.VerificationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyHelper {

    private static final Logger logger = LogManager.getLogger(VerifyHelper.class);
    protected final elementhelper element = new elementhelper();

    public void verifyText(String locatorName, String expectedText) {
        try {
            assertThat(element.getText(locatorName)).isEqualTo(expectedText);
        } catch (AssertionError e) {
            logger.error("Text verification failed: {}", locatorName, e);
            throw new VerificationException("Text verification failed: " + locatorName, e);
        }
    }

    public void verifyMessage(String locatorName, String expectedMessage) {
        try {
            assertThat(element.getText(locatorName)).isEqualTo(expectedMessage);
        } catch (AssertionError e) {
            logger.error("Message verification failed: {}", locatorName, e);
            throw new VerificationException("Message verification failed: " + locatorName, e);
        }
    }

    public void verifyNumber(String locatorName, int expectedNumber) {
        try {
            assertThat(element.getNumber(locatorName)).isEqualTo(expectedNumber);
        } catch (AssertionError e) {
            logger.error("Number verification failed: {}", locatorName, e);
            throw new VerificationException("Number verification failed: " + locatorName, e);
        }
    }

    public void verifyDisplayed(String locatorName) {
        try {
            assertThat(element.isDisplayed(locatorName)).isTrue();
        } catch (AssertionError e) {
            logger.error("Element display verification failed: {}", locatorName, e);
            throw new VerificationException("Element is not displayed: " + locatorName, e);
        }
    }

    public void verifyNotDisplayed(String locatorName) {
        try {
            assertThat(element.isDisplayed(locatorName)).isFalse();
        } catch (AssertionError e) {
            logger.error("Element hidden verification failed: {}", locatorName, e);
            throw new VerificationException("Element is still displayed: " + locatorName, e);
        }
    }

    public int getNumber(String locatorName) {
        return element.getNumber(locatorName);
    }

    public void verifyProductsSortedLowToHigh(String locatorName) {
        try {
            List<WebElement> priceElements = DriverHelper.getElements(locatorName);
            List<Double> actualPrices = new ArrayList<>();

            for (WebElement price : priceElements) {
                actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
            }

            List<Double> sortedPrices = new ArrayList<>(actualPrices);
            Collections.sort(sortedPrices);

            assertThat(actualPrices).isEqualTo(sortedPrices);
        } catch (AssertionError e) {
            logger.error("Product sorting verification failed: {}", locatorName, e);
            throw new VerificationException("Product sorting verification failed: " + locatorName, e);
        }
    }
    public void verifyFirstNumberIsLessThanSecond(String firstLocator, String secondLocator) {
        try {
            double firstValue = Double.parseDouble(
                    element.getText(firstLocator).replaceAll("[^0-9.]", "")
            );

            double secondValue = Double.parseDouble(
                    element.getText(secondLocator).replaceAll("[^0-9.]", "")
            );

            assertThat(firstValue).isLessThan(secondValue);

        } catch (AssertionError e) {
            logger.error("Comparison failed: {} should be less than {}", firstLocator, secondLocator, e);
            throw new VerificationException(
                    firstLocator + " is not less than " + secondLocator, e);
        }
    }
}