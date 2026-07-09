package steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.InventoryStepsImplementation;

public class InventorySteps {

    private final InventoryStepsImplementation inventoryStepsImplementation = new InventoryStepsImplementation();

    @Step("User should see products page")
    public void verifyProductsPage() {inventoryStepsImplementation.verifyProductsPage();
    }
    @Step("User clicks menu button")
    public void clickMenuButton() {inventoryStepsImplementation.clickMenuButton();
    }
    @Step("User clicks logout button")
    public void clickLogoutButton() {inventoryStepsImplementation.clickLogoutButton();
    }
    @Step("User should see login page")
    public void verifyLoginPage() {inventoryStepsImplementation.verifyLoginPage();
    }
    @Step("User clicks <productName> product")
    public void clickProduct(String productName) {inventoryStepsImplementation.clickProduct(productName);
    }
    @Step("User should see <productName> product detail page")
    public void verifyProductDetailPage(String productName) {inventoryStepsImplementation.verifyProductDetailPage(productName);
    }
}




