package Steps;

import org.testng.Assert;
import com.thoughtworks.gauge.Step;

import driverManager.Driver;
import helpers.AssertionHelper;
import helpers.elementhelper;
import locators.LocatorManager;
import locators.checkoutlocators;
import locators.inventorylocators;
import locators.loginlocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerifySteps {

    private int savedCartBadgeCount;

    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyText(String locatorName, String expectedText) {
        // BURAYA BUNU EKLE:
        System.out.println("Şu anki URL: " + Driver.getDriver().getCurrentUrl());

        String actualText = elementhelper.getText(
                LocatorManager.getLocator(locatorName)
        );
        // ...
    }

    @Step("User verifies <locatorName> value is <expectedNumber>")
    public void verifyNumber(String locatorName, String expectedNumber) {

        int actualNumber = elementhelper.getNumber(
                LocatorManager.getLocator(locatorName)
        );

        AssertionHelper.assertEquals(
                actualNumber,
                Integer.parseInt(expectedNumber)
        );
    }

    @Step("User verifies <locatorName> is displayed")
    public void verifyDisplayed(String locatorName) {

        AssertionHelper.assertTrue(
                elementhelper.isDisplayed(
                        LocatorManager.getLocator(locatorName)
                )
        );
    }

    @Step("User verifies <locatorName> is not displayed")
    public void verifyNotDisplayed(String locatorName) {

        boolean exists = Driver.getDriver()
                .findElements(LocatorManager.getLocator(locatorName))
                .size() > 0;

        AssertionHelper.assertFalse(exists);
    }

    @Step("User should see products")
    public void verifyProductsDisplayed() {

        AssertionHelper.assertTrue(
                elementhelper.isDisplayed(
                        inventorylocators.PRODUCTS_TITLE
                )
        );
    }

    @Step("Order complete message should be <expectedMessage>")
    public void verifyOrderCompleteMessage(String expectedMessage) {

        String actualMessage =
                elementhelper.getText(checkoutlocators.COMPLETE_HEADER);

        AssertionHelper.assertEquals(actualMessage, expectedMessage);
    }

    @Step("Verify checkout error message is <expectedMessage>")
    public void verifyCheckoutErrorMessage(String expectedMessage) {

        String actualMessage =
                elementhelper.getText(checkoutlocators.ERROR_MESSAGE);

        AssertionHelper.assertEquals(actualMessage, expectedMessage);
    }

    @Step("User verifies products are sorted by price low to high")
    public void verifyProductsSortedLowToHigh() {

        List<WebElement> priceElements =
                Driver.getDriver().findElements(inventorylocators.PRODUCT_PRICES);

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : priceElements) {
            actualPrices.add(
                    Double.parseDouble(
                            price.getText().replace("$", "")
                    )
            );
        }

        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(actualPrices, sortedPrices);
    }

    @Step("User should see login page")
    public void verifyLoginPageDisplayed() {

        AssertionHelper.assertTrue(
                elementhelper.isDisplayed(
                        loginlocators.USERNAME_INPUT
                )
        );
    }

    @Step("User saves cart badge count")
    public void saveCartBadgeCount() {

        String badgeText =
                elementhelper.getText(inventorylocators.CART_BADGE);

        savedCartBadgeCount = Integer.parseInt(badgeText);
    }

    @Step("Cart badge should decrease by one")
    public void verifyCartBadgeDecrease() {

        int currentBadgeCount = elementhelper.getNumber(
                inventorylocators.CART_BADGE
        );

        AssertionHelper.assertEquals(
                currentBadgeCount,
                savedCartBadgeCount - 1
        );
    }
}