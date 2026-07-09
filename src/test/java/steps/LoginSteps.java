package steps;

import com.thoughtworks.gauge.Step;
import stepimplementation.LoginStepsİmplementation;

public class LoginSteps {

    LoginStepsİmplementation login = new LoginStepsİmplementation();

    @Step("User enters <username> into username field")
    public void enterUsername(String username) {
        login.enterUsername(username);
    }

    @Step("User enters <password> into password field")
    public void enterPassword(String password) {
        login.enterPassword(password);
    }

    @Step("User clicks login button")
    public void clickLoginButton() {
        login.clickLoginButton();
    }

    @Step("User should see products")
    public void verifyProductsPage() {
        login.verifyProductsPage();
    }
}

