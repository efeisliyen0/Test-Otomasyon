package Steps;

import com.thoughtworks.gauge.Step;
import helpers.TestDataHelper;
import helpers.VerifyHelper;
import utils.AllureStepRunner;

public class VerifySteps {

    private int savedCartBadgeCount;

    @Step("User verifies message <locatorName> matches <expectedMessage>")
    public void verifyMessage(String locatorName, String expectedMessage) {
        AllureStepRunner.run("Mesaj doğrulanıyor", () ->
                VerifyHelper.verifyMessage(
                        locatorName,
                        TestDataHelper.getTestData(expectedMessage)
                )
        );
    }

    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyText(String locatorName, String expectedText) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " metni = " + expectedText, () ->
                VerifyHelper.verifyText(
                        locatorName,
                        TestDataHelper.getTestData(expectedText)
                )
        );
    }

    @Step("User verifies <locatorName> value is <expectedNumber>")
    public void verifyNumber(String locatorName, String expectedNumber) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " değeri = " + expectedNumber, () ->
                VerifyHelper.verifyNumber(
                        locatorName,
                        Integer.parseInt(TestDataHelper.getTestData(expectedNumber))
                )
        );
    }

    @Step("User verifies <locatorName> is displayed")
    public void verifyDisplayed(String locatorName) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " görünüyor", () ->
                VerifyHelper.verifyDisplayed(locatorName)
        );
    }

    @Step("User verifies <locatorName> is not displayed")
    public void verifyNotDisplayed(String locatorName) {
        AllureStepRunner.run("Doğrulama: " + locatorName + " görünmüyor", () ->
                VerifyHelper.verifyNotDisplayed(locatorName)
        );
    }

    @Step("User should see products")
    public void verifyProductsDisplayed() {
        AllureStepRunner.run("Doğrulama: ürünler görünüyor", () ->
                VerifyHelper.verifyDisplayed("products")
        );
    }

    @Step("User verifies products are sorted by price low to high")
    public void verifyProductsSortedLowToHigh() {
        AllureStepRunner.run("Doğrulama: ürünler fiyata göre sıralı (düşükten yükseğe)", () ->
                VerifyHelper.verifyProductsSortedLowToHigh("product prices")
        );
    }

    @Step("User should see login page")
    public void verifyLoginPageDisplayed() {
        AllureStepRunner.run("Doğrulama: login sayfası görünüyor", () ->
                VerifyHelper.verifyDisplayed("username")
        );
    }

    @Step("User saves cart badge count")
    public void saveCartBadgeCount() {
        AllureStepRunner.run("Sepet badge sayısı kaydedildi", () ->
                savedCartBadgeCount = VerifyHelper.getNumber("shopping cart badge")
        );
    }

    @Step("Cart badge should decrease by one")
    public void verifyCartBadgeDecrease() {
        AllureStepRunner.run("Doğrulama: sepet badge sayısı 1 azaldı", () ->
                VerifyHelper.verifyNumber("shopping cart badge", savedCartBadgeCount - 1)
        );
    }
}