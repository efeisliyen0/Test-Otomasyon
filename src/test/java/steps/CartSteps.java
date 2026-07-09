package steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.CartStepsİmplementation;

public class CartSteps {

    CartStepsİmplementation cartImpl = new CartStepsİmplementation();

    @Step("User enters <text> into <locatorName> field")
    public void enterText(String text, String locatorName) {
        cartImpl.writeText(text, locatorName);
    }

    @Step("User clicks <locatorName> button")
    public void click(String locatorName) {
        cartImpl.clickElement(locatorName);
    }

    @Step("User should see <text> in the cart")
    public void verifyCart(String expectedText) {
        cartImpl.verifyItem(expectedText);
    }
}
