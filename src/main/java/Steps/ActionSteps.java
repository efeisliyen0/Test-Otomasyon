package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import utils.AllureStepRunner;
import helpers.DriverHelper;

public class ActionSteps {

    @Step("User refreshes the page")
    public void refreshPage() {
        DriverHelper.refresh();
    }

    @Step("User goes back")
    public void goBack() {
        DriverHelper.back();
    }

    @Step("User goes forward")
    public void goForward() {
        DriverHelper.forward();
    }

    @Step("User maximizes the browser")
    public void maximizeWindow() {
        DriverHelper.maximize();
    }

    @Step("User minimizes the browser")
    public void minimizeWindow() {
        DriverHelper.minimize();
    }

    @Step("User opens <url>")
    public void openUrl(String url) {
        DriverHelper.open(url);
    }
}