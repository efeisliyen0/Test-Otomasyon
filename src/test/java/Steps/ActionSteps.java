package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;

public class ActionSteps {

    @Step("User refreshes the page")
    public void refreshPage() {
        Driver.getDriver().navigate().refresh();
    }

    @Step("User goes back")
    public void goBack() {
        Driver.getDriver().navigate().back();
    }

    @Step("User goes forward")
    public void goForward() {
        Driver.getDriver().navigate().forward();
    }

    @Step("User maximizes the browser")
    public void maximizeWindow() {
        Driver.getDriver().manage().window().maximize();
    }

    @Step("User minimizes the browser")
    public void minimizeWindow() {
        Driver.getDriver().manage().window().minimize();
    }

    @Step("User opens <url>")
    public void openUrl(String url) {
        Driver.getDriver().get(url);
    }
}