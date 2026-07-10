package stepimplementation;

import helpers.elementhelper;
import locators.checkoutlocators;
import org.openqa.selenium.By;
import org.testng.Assert;
import driverManager.Driver;

public class CheckOutStepsImplementation {

    public void clickCheckoutButton() {
        Driver.getDriver().findElement(checkoutlocators.CHECKOUT_BUTTON).click();
    }

    public void fillCustomerInformation(String firstName, String lastName, String postalCode) {
        Driver.getDriver().findElement(checkoutlocators.FIRST_NAME_INPUT).sendKeys(firstName);
        Driver.getDriver().findElement(checkoutlocators.LAST_NAME_INPUT).sendKeys(lastName);
        Driver.getDriver().findElement(checkoutlocators.POSTAL_CODE_INPUT).sendKeys(postalCode);
    }
    public void verifyOrderCompleteMessage(String expectedMessage) {
        String actualMessage = Driver.getDriver().findElement(checkoutlocators.COMPLETE_HEADER).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Sipariş tamamlama mesajı beklenen ile uyuşmuyor!");
    }
    public void verifyCheckoutErrorMessage(String expectedMessage) {
        String actualMessage = Driver.getDriver().findElement(checkoutlocators.ERROR_MESSAGE).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Checkout hata mesajı beklenen ile uyuşmuyor!");
    }
    private By getLocator(String locatorName) {
        switch (locatorName.toLowerCase()) {
            case "checkout": return checkoutlocators.CHECKOUT_BUTTON;
            case "continue": return checkoutlocators.CONTINUE_BUTTON;
            case "finish": return checkoutlocators.FINISH_BUTTON;
            default: throw new IllegalArgumentException("Locator bulunamadı: " + locatorName);

        }
    }
    public void clickElement(String locatorName) {
        elementhelper.click(getLocator(locatorName));
    }
}