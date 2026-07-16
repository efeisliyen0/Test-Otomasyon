package locators;

import org.openqa.selenium.By;

public class loginlocators {
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By MENU_BUTTON = By.id("react-burger-menu-btn");
    public static final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    public static final By RESET_BUTTON = By.id("reset_sidebar_link");
    public static final By ALLITEMS_BUTTON = By.id("inventory_sidebar_link");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");
}