package stepimplementation;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.cartlocators;
import locators.loginlocators;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;

public class CartStepsİmplementation {

    private By getLocator(String locatorName) {
        switch (locatorName.toLowerCase()) {
            case "username": return loginlocators.USERNAME_INPUT;
            case "password": return loginlocators.PASSWORD_INPUT;
            case "login": return loginlocators.LOGIN_BUTTON;

            case "add to cart backpack": return cartlocators.ADD_TO_CART_BACKPACK;
            case "shopping cart": return cartlocators.SHOPPING_CART_LINK;
            case "cart title": return cartlocators.CART_TITLE;

            default: throw new IllegalArgumentException("Locator bulunamadi veya yanlis yazildi: " + locatorName);
        }
    }

    @Step("User enters <text> into <locatorName> field")
    public void enterTextIntoField(String text, String locatorName) {
        By locator = getLocator(locatorName);
        elementhelper.sendKeys(locator, text);
    }

    @Step("User clicks <locatorName> button")
    public void clickButton(String locatorName) {
        By locator = getLocator(locatorName);
        elementhelper.click(locator);
    }

    @Step("User should see <text> in the cart")
    public void verifyItemInCart(String expectedText) {
        String actualText = elementhelper.getText(cartlocators.INVENTORY_ITEM_NAME);
        Assertions.assertThat(actualText)
                .withFailMessage("Sepetteki urun ismi eslesmedi! Beklenen: " + expectedText + " ama sayfada gorunen: " + actualText)
                .isEqualTo(expectedText);
    }
}