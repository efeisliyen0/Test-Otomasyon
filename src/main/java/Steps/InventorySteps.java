package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.JsonReader;

public class InventorySteps {

    @Step("User selects <option> from sort dropdown")
    public void selectSortDropdown(String option) {
        elementhelper.selectByVisibleText(JsonReader.getLocator("sort"), option);
    }
}
