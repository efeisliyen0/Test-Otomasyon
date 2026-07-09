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
    public void verifyProductsPage() {String title = elementhelper.getText(inventorylocators.PRODUCTS_TITLE);assert title.equals("Products");
    }
        @Step("User clicks <productName> product")
        public void clickProduct(String productName) {
        elementhelper.click(inventorylocators.getProduct(productName));}
        @Step("User should see product detail page")
        public void verifyProductDetailPage() { assert elementhelper.isDisplayed(inventorylocators.PRODUCT_DETAIL_TITLE);
        }
    }




