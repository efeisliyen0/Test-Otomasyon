package helpers;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyHelper {

    public static void verifyText(String locatorName, String expectedText) {
        assertThat(elementhelper.getText(locatorName)).isEqualTo(expectedText);
    }

    public static void verifyMessage(String locatorName, String expectedMessage) {
        assertThat(elementhelper.getText(locatorName)).isEqualTo(expectedMessage);
    }

    public static void verifyNumber(String locatorName, int expectedNumber) {
        assertThat(elementhelper.getNumber(locatorName)).isEqualTo(expectedNumber);
    }

    public static void verifyDisplayed(String locatorName) {
        assertThat(elementhelper.isDisplayed(locatorName)).isTrue();
    }

    public static void verifyNotDisplayed(String locatorName) {
        assertThat(elementhelper.isDisplayed(locatorName)).isFalse();
    }

    public static int getNumber(String locatorName) {
        return elementhelper.getNumber(locatorName);
    }

    public static void verifyProductsSortedLowToHigh(String locatorName) {
        List<WebElement> priceElements = DriverHelper.getElements(locatorName);
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : priceElements) {actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));}
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);
        assertThat(actualPrices).isEqualTo(sortedPrices);
    }
}