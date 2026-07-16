package locators;

import org.openqa.selenium.By;

public class LocatorManager {
    public static By getLocator(String locatorName) {
        switch (locatorName.toLowerCase()) {
            case "username": return loginlocators.USERNAME_INPUT;
            case "password": return loginlocators.PASSWORD_INPUT;
            case "login": return loginlocators.LOGIN_BUTTON;
            case "menu": return loginlocators.MENU_BUTTON;
            case "logout": return loginlocators.LOGOUT_BUTTON;
            case "reset app state": return loginlocators.RESET_BUTTON;
            case "all items": return loginlocators.ALLITEMS_BUTTON;
            case "login error": return loginlocators.ERROR_MESSAGE;
            case "products": return inventorylocators.PRODUCTS_TITLE;
            case "shopping cart": return inventorylocators.SHOPPING_CART_LINK;
            case "sort": return inventorylocators.SORT_DROPDOWN;
            case "add to cart backpack": return inventorylocators.ADD_TO_CART_BACKPACK;
            case "cart title": return cartlocators.CART_TITLE;
            case "cart badge": return cartlocators.SHOPPING_CART_BADGE;
            case "cart item": return cartlocators.INVENTORY_ITEM_NAME;
            case "remove backpack": return cartlocators.REMOVE_BACKPACK_BUTTON;
            case "checkout": return cartlocators.CHECKOUT_BUTTON;
            case "first name": return checkoutlocators.FIRST_NAME_INPUT;
            case "last name": return checkoutlocators.LAST_NAME_INPUT;
            case "postal code": return checkoutlocators.POSTAL_CODE_INPUT;
            case "continue": return checkoutlocators.CONTINUE_BUTTON;
            case "finish": return checkoutlocators.FINISH_BUTTON;
            case "complete message": return checkoutlocators.COMPLETE_HEADER;
            case "checkout error": return checkoutlocators.ERROR_MESSAGE;
            case "inventory item name": return cartlocators.INVENTORY_ITEM_NAME;
            case "shopping cart badge": return cartlocators.SHOPPING_CART_BADGE;
            default: throw new IllegalArgumentException("Locator bulunamadı: " + locatorName);
        }
    }
}
