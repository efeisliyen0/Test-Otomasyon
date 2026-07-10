package steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.CheckOutStepsImplementation;

public class CheckOutSteps {

    CheckOutStepsImplementation checkOutImpl = new CheckOutStepsImplementation();

    @Step("Click the checkout button")
    public void clickCheckout() {
        checkOutImpl.clickCheckoutButton();
    }

    @Step("Fill customer information as <firstName>, <lastName>, <postalCode>")
    public void fillInformation(String firstName, String lastName, String postalCode) {
        checkOutImpl.fillCustomerInformation(firstName, lastName, postalCode);
    }


    @Step("Verify order completion message is <expectedMessage>")
    public void verifyOrderComplete(String expectedMessage) {
        checkOutImpl.verifyOrderCompleteMessage(expectedMessage);
    }
    @Step("Verify checkout error message is <expectedMessage>")
    public void verifyCheckoutError(String expectedMessage) {
        checkOutImpl.verifyCheckoutErrorMessage(expectedMessage);
    }
}
