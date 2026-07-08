package steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.loginlocators;

public class LoginSteps {

    @Step("User enters <username> into username field")
    public void enterUsername(String username) {
        elementhelper.sendKeys(
                loginlocators.USERNAME_INPUT,
                username
        );
    }
    @Step("User enters <password> into password field")
    public void enterPassword(String password) {
        elementhelper.sendKeys(
                loginlocators.PASSWORD_INPUT,
                password
        );
    }
    @Step("User clicks login button")
    public void clickLoginButton() {
        elementhelper.click(
                loginlocators.LOGIN_BUTTON
        );
    }
    @Step("User should see login page")
    public void verifyLoginPage() {
        assert elementhelper.isDisplayed(loginlocators.LOGIN_BUTTON);
    }
}
