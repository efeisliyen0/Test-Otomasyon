package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.ActionImp;

public class ActionSteps {

    private final ActionImp actionImplementation =
            new ActionImp();

    @Step("User refreshes the page")
    public void refreshPage() {
        actionImplementation.refreshPage();
    }

    @Step("User goes back")
    public void goBack() {
        actionImplementation.goBack();
    }

    @Step("User goes forward")
    public void goForward() {
        actionImplementation.goForward();
    }

    @Step("User maximizes the browser")
    public void maximizeWindow() {
        actionImplementation.maximizeWindow();
    }

    @Step("User minimizes the browser")
    public void minimizeWindow() {
        actionImplementation.minimizeWindow();
    }

    @Step("User opens <url>")
    public void openUrl(String url) {
        actionImplementation.openUrl(url);
    }
}
