package stepimplementation;

import locators.checkoutlocators;
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

    public void clickContinueButton() {
        Driver.getDriver().findElement(checkoutlocators.CONTINUE_BUTTON).click();
    }

    public void clickFinishButton() {
        Driver.getDriver().findElement(checkoutlocators.FINISH_BUTTON).click();
    }

    public void verifyOrderCompleteMessage(String expectedMessage) {
        String actualMessage = Driver.getDriver().findElement(checkoutlocators.COMPLETE_HEADER).getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Sipariş tamamlama mesajı beklenen ile uyuşmuyor!");
    }
}