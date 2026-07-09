package stepimplementation;

import helpers.elementhelper;
import locators.inventorylocators;
import locators.loginlocators;

public class LoginStepsİmplementation {

    public void enterUsername(String username) {
        elementhelper.sendKeys(loginlocators.USERNAME_INPUT, username);
    }

    public void enterPassword(String password) {
        elementhelper.sendKeys(loginlocators.PASSWORD_INPUT, password);
    }

    public void clickLoginButton() {
        elementhelper.click(loginlocators.LOGIN_BUTTON);
    }

    public void verifyProductsPage() {
        assert elementhelper.isDisplayed(inventorylocators.PRODUCTS_TITLE);
    }

    public void verifyLoginPage() {
        assert elementhelper.isDisplayed(loginlocators.LOGIN_BUTTON);
    }
}
