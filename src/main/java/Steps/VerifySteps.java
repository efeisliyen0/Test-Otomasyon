package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import helpers.AssertionHelper;
import helpers.elementhelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.AllureStepRunner;
import utils.JsonReader;
import utils.TestDataReader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerifySteps {

    private int savedCartBadgeCount;

    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyText(String locatorName, String expectedText) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " metni = " + expectedText, () -> {
            String expectedValue = getTestData(expectedText);

            String actualText = elementhelper.getText(
                    JsonReader.getLocator(locatorName)
            );

            AssertionHelper.assertEquals(actualText, expectedValue);
        });
    }


    @Step("User verifies <locatorName> value is <expectedNumber>")
    public void verifyNumber(String locatorName, String expectedNumber) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " değeri = " + expectedNumber, () -> {
            String expectedValue = getTestData(expectedNumber);

            int actualNumber = elementhelper.getNumber(
                    JsonReader.getLocator(locatorName)
            );

            AssertionHelper.assertEquals(
                    actualNumber,
                    Integer.parseInt(expectedValue)
            );
        });
    }


    @Step("User verifies <locatorName> is displayed")
    public void verifyDisplayed(String locatorName) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " görünüyor", () ->
                AssertionHelper.assertTrue(
                        elementhelper.isDisplayed(
                                JsonReader.getLocator(locatorName)
                        )
                )
        );
    }


    @Step("User verifies <locatorName> is not displayed")
    public void verifyNotDisplayed(String locatorName) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " görünmüyor", () -> {
            boolean exists =
                    Driver.getDriver()
                            .findElements(JsonReader.getLocator(locatorName))
                            .size() > 0;

            AssertionHelper.assertFalse(exists);
        });
    }


    @Step("User should see products")
    public void verifyProductsDisplayed() {
        AllureStepRunner.run("Doğrulama: ürünler görünüyor", () ->
                AssertionHelper.assertTrue(
                        elementhelper.isDisplayed(
                                JsonReader.getLocator("products")
                        )
                )
        );
    }


    @Step("Order complete message should be <expectedMessage>")
    public void verifyOrderCompleteMessage(String expectedMessage) {
        AllureStepRunner.run("Doğrulama: sipariş tamamlama mesajı = " + expectedMessage, () -> {
            String expectedValue = getTestData(expectedMessage);

            String actualMessage =
                    elementhelper.getText(
                            JsonReader.getLocator("complete message")
                    );

            AssertionHelper.assertEquals(
                    actualMessage,
                    expectedValue
            );
        });
    }


    @Step("Verify checkout error message is <expectedMessage>")
    public void verifyCheckoutErrorMessage(String expectedMessage) {
        AllureStepRunner.run("Doğrulama: checkout hata mesajı = " + expectedMessage, () -> {
            String expectedValue = getTestData(expectedMessage);

            String actualMessage =
                    elementhelper.getText(
                            JsonReader.getLocator("checkout error")
                    );

            AssertionHelper.assertEquals(
                    actualMessage,
                    expectedValue
            );
        });
    }


    @Step("User verifies products are sorted by price low to high")
    public void verifyProductsSortedLowToHigh() {
        AllureStepRunner.run("Doğrulama: ürünler fiyata göre sıralı (düşükten yükseğe)", () -> {
            List<WebElement> priceElements =
                    Driver.getDriver()
                            .findElements(
                                    JsonReader.getLocator("product prices")
                            );

            List<Double> actualPrices = new ArrayList<>();

            for (WebElement price : priceElements) {
                actualPrices.add(
                        Double.parseDouble(
                                price.getText().replace("$", "")
                        )
                );
            }

            List<Double> sortedPrices =
                    new ArrayList<>(actualPrices);

            Collections.sort(sortedPrices);

            Assert.assertEquals(
                    actualPrices,
                    sortedPrices
            );
        });
    }


    @Step("User should see login page")
    public void verifyLoginPageDisplayed() {
        AllureStepRunner.run("Doğrulama: login sayfası görünüyor", () ->
                AssertionHelper.assertTrue(
                        elementhelper.isDisplayed(
                                JsonReader.getLocator("username")
                        )
                )
        );
    }


    @Step("User saves cart badge count")
    public void saveCartBadgeCount() {
        AllureStepRunner.run("Sepet badge sayısı kaydedildi", () -> {
            String badgeText =
                    elementhelper.getText(
                            JsonReader.getLocator("shopping cart badge")
                    );

            savedCartBadgeCount =
                    Integer.parseInt(badgeText);
        });
    }


    @Step("Cart badge should decrease by one")
    public void verifyCartBadgeDecrease() {
        AllureStepRunner.run("Doğrulama: sepet badge sayısı 1 azaldı", () -> {
            int currentBadgeCount =
                    elementhelper.getNumber(
                            JsonReader.getLocator("shopping cart badge")
                    );

            AssertionHelper.assertEquals(
                    currentBadgeCount,
                    savedCartBadgeCount - 1
            );
        });
    }


    private String getTestData(String value) {

        if (value.contains(".")) {

            String[] parts = value.split("\\.");

            return TestDataReader.getValue(
                    parts[0],
                    parts[1]
            );
        }

        return value;
    }
}