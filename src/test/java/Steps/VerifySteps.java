package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.VerifyImp;
import helpers.elementhelper;
import locators.LocatorManager;
import locators.checkoutlocators;
import locators.inventorylocators;
import locators.loginlocators;
import org.openqa.selenium.By;
import org.testng.Assert;
import driverManager.Driver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerifySteps {

    private final VerifyImp verifyImplementation = new VerifyImp();

    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyText(String locatorName, String expectedText) {
        verifyImplementation.verifyText(locatorName, expectedText);
    }

    @Step("User verifies <locatorName> value is <expectedNumber>")
    public void verifyNumber(String locatorName, int expectedNumber) {
        verifyImplementation.verifyNumber(locatorName, expectedNumber);
    }

    @Step("User verifies <locatorName> is displayed")
    public void verifyDisplayed(String locatorName) {
        verifyImplementation.verifyDisplayed(locatorName);
    }

    @Step("User verifies <locatorName> is not displayed")
    public void verifyNotDisplayed(String locatorName) {
        verifyImplementation.verifyNotDisplayed(locatorName);
    }
    @Step("User should see products")
    public void verifyProductsDisplayed() {
        Assert.assertTrue(elementhelper.isDisplayed(inventorylocators.PRODUCTS_TITLE));
    }
    @Step("Order complete message should be <expectedMessage>")
    public void verifyOrderCompleteMessage(String expectedMessage) {
        String actualMessage = elementhelper.getText(checkoutlocators.COMPLETE_HEADER);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Step("Verify checkout error message is <expectedMessage>")
    public void verifyCheckoutErrorMessage(String expectedMessage) {
        String actualMessage = elementhelper.getText(checkoutlocators.ERROR_MESSAGE);
        Assert.assertEquals(actualMessage, expectedMessage);
    }
    @Step("User verifies products are sorted by price low to high")
    public void verifyProductsSortedLowToHigh() {
        List<WebElement> priceElements = Driver.getDriver().findElements(inventorylocators.PRODUCT_PRICES);
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price : priceElements) {actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));}
        List<Double> sortedPrices = new ArrayList<>(actualPrices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(actualPrices, sortedPrices);
    }
    @Step("User should see login page")
    public void verifyLoginPageDisplayed() {
        Assert.assertTrue(elementhelper.isDisplayed(loginlocators.USERNAME_INPUT));
    }
    private int savedCartBadgeCount;
    @Step("User saves cart badge count")
    public void saveCartBadgeCount() {
        String badgeText = elementhelper.getText(inventorylocators.CART_BADGE);
        savedCartBadgeCount = Integer.parseInt(badgeText);
    }
    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyTextValue(String locatorName, String expectedText) {

        By locator = LocatorManager.getLocator(locatorName);

        String actualText = elementhelper.getText(locator);

        Assert.assertEquals(actualText, expectedText);
    }
}