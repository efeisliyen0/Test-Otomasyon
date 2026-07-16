package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import locators.inventorylocators;

public class InventorySteps {

    @Step("User selects <option> from sort dropdown")
    public void selectSortDropdown(String option) {
        elementhelper.selectByVisibleText(inventorylocators.SORT_DROPDOWN, option);
    }
}
