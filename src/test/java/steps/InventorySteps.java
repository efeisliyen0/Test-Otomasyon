package steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.inventorylocators;

public class InventorySteps {
    @Step("User clicks menu button")
    public void clickMenuButton() {
        elementhelper.click(inventorylocators.MENU_BUTTON);
    }
    @Step("User clicks logout button")
    public void clickLogoutButton() {
        elementhelper.click(inventorylocators.LOGOUT_BUTTON);
    }
    @Step("User should see products page")
    public void verifyProductsPage() {
        String title = elementhelper.getText(inventorylocators.PRODUCTS_TITLE);
        assert title.equals("Products");
    }
}
