package locators;

import org.openqa.selenium.By;

public class inventorylocators {

    public static final By PRODUCTS_TITLE = By.className("title");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static final By ADD_TO_CART_BACKPACK = By.id("add-to-cart-sauce-labs-backpack");
    public static final By SHOPPING_CART_LINK = By.className("shopping_cart_link");
    public static final By SORT_DROPDOWN = By.className("product_sort_container");
    public static final By PRODUCT_PRICES = By.className("inventory_item_price");
    public static By getProduct(String productName) {
        return By.xpath("//a[.//div[text()='" + productName + "']]");
    }
    public static By getProductDetailTitle(String productName) {
        return By.xpath("//div[@class='inventory_details_name' and text()='" + productName + "']");
    }
    public static final By CART_BADGE = By.className("shopping_cart_badge");
}
