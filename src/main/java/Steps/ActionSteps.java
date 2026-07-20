package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import utils.AllureStepRunner;

public class ActionSteps {

    @Step("User refreshes the page")
    public void refreshPage() {
        AllureStepRunner.run("Sayfa yenilendi", () ->
                Driver.getDriver().navigate().refresh()
        );
    }

    @Step("User goes back")
    public void goBack() {
        AllureStepRunner.run("Geri gidildi", () ->
                Driver.getDriver().navigate().back()
        );
    }

    @Step("User goes forward")
    public void goForward() {
        AllureStepRunner.run("İleri gidildi", () ->
                Driver.getDriver().navigate().forward()
        );
    }

    @Step("User maximizes the browser")
    public void maximizeWindow() {
        AllureStepRunner.run("Pencere büyütüldü", () ->
                Driver.getDriver().manage().window().maximize()
        );
    }

    @Step("User minimizes the browser")
    public void minimizeWindow() {
        AllureStepRunner.run("Pencere küçültüldü", () ->
                Driver.getDriver().manage().window().minimize()
        );
    }

    @Step("User opens <url>")
    public void openUrl(String url) {
        AllureStepRunner.run("URL açıldı: " + url, () ->
                Driver.getDriver().get(url)
        );
    }
}