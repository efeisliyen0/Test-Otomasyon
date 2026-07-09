package locators;

import org.openqa.selenium.By;

public class inventorylocators {

    public static final By PRODUCTS_TITLE = By.className("title");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static By getProduct(String productName)
    {return By.xpath("//a[.//div[text()='" + productName + "']]");}
    public static By getProductDetailTitle(String productName) {
        return By.xpath("//div[@class='inventory_details_name' and text()='" + productName + "']");
    }
}
