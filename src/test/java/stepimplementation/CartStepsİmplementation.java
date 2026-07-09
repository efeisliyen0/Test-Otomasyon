package stepimplementation;

import helpers.elementhelper;
import locators.cartlocators;
import locators.loginlocators;
import org.openqa.selenium.By;
import org.assertj.core.api.Assertions;
import driverManager.Driver;

public class CartStepsİmplementation {

    public void writeText(String text, String locatorName) {
        By locator = getLocator(locatorName);
        elementhelper.sendKeys(locator, text);
    }

    public void clickElement(String locatorName) {
        By locator = getLocator(locatorName);
        elementhelper.click(locator);
    }

    public void verifyItem(String expectedText) {
        String actualText = elementhelper.getText(cartlocators.INVENTORY_ITEM_NAME);
        Assertions.assertThat(actualText)
                .withFailMessage("Sepetteki urun ismi eslesmedi! Beklenen: " + expectedText + " ama sayfada gorunen: " + actualText)
                .isEqualTo(expectedText);
    }
    private int oldBadgeCount;
    public void saveCartBadgeCount() {oldBadgeCount = elementhelper.getNumber(
            cartlocators.SHOPPING_CART_BADGE);
    }
    public void verifyCartBadgeDecreased() {
        boolean badgeVisible = !Driver.getDriver().findElements(cartlocators.SHOPPING_CART_BADGE).isEmpty();
        Assertions.assertThat(badgeVisible).withFailMessage("Sepet rozeti hala görünüyor!")
                .isFalse();
    }
    public void verifyCartBadgeCount(int expectedCount) {
        int actualCount = elementhelper.getNumber(cartlocators.SHOPPING_CART_BADGE);
        Assertions.assertThat(actualCount).isEqualTo(expectedCount);
    }

    private By getLocator(String locatorName) {
        switch (locatorName.toLowerCase()) {
            case "username": return loginlocators.USERNAME_INPUT;
            case "password": return loginlocators.PASSWORD_INPUT;
            case "login": return loginlocators.LOGIN_BUTTON;
            case "add to cart backpack": return cartlocators.ADD_TO_CART_BACKPACK;
            case "shopping cart": return cartlocators.SHOPPING_CART_LINK;
            case "cart title": return cartlocators.CART_TITLE;
            case "remove backpack": return cartlocators.REMOVE_BACKPACK_BUTTON;
            default: throw new IllegalArgumentException("Locator bulunamadi veya yanlis yazildi: " + locatorName);
        }
    }
}