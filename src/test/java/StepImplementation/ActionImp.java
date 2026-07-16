package StepImplementation;

import driverManager.Driver;

public class ActionImp {

    public void refreshPage() {
        Driver.getDriver().navigate().refresh();
    }

    public void goBack() {
        Driver.getDriver().navigate().back();
    }

    public void goForward() {
        Driver.getDriver().navigate().forward();
    }

    public void maximizeWindow() {
        Driver.getDriver().manage().window().maximize();
    }

    public void minimizeWindow() {
        Driver.getDriver().manage().window().minimize();
    }

    public void openUrl(String url) {
        Driver.getDriver().get(url);
    }
}
