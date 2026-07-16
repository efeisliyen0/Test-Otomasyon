package stepimplementation;

import helpers.elementhelper;
import locators.inventorylocators;
import locators.loginlocators;
import org.openqa.selenium.support.ui.Select;
import driverManager.Driver;

public class InventoryStepsImplementation {

    public void verifyProductsPage() {
        assert elementhelper.isDisplayed(inventorylocators.PRODUCTS_TITLE);
    }

    public void clickMenuButton() {
        elementhelper.click(inventorylocators.MENU_BUTTON);
    }

    public void clickLogoutButton() {
        elementhelper.click(inventorylocators.LOGOUT_BUTTON);
    }

    public void verifyLoginPage() {
        assert elementhelper.isDisplayed(loginlocators.LOGIN_BUTTON);
    }

    public void clickProduct(String productName) {
        elementhelper.click(inventorylocators.getProduct(productName));
    }

    public void verifyProductDetailPage(String productName) {
        assert elementhelper.isDisplayed(inventorylocators.getProductDetailTitle(productName));
    }

    public void selectFilterOption(String optionText) {
        Select select = new Select(Driver.getDriver().findElement(inventorylocators.SORT_DROPDOWN));
        select.selectByVisibleText(optionText);
    }
}
