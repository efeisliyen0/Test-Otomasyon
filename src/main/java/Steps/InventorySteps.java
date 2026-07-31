package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import helpers.TestDataHelper;
import utils.AllureStepRunner;

public class InventorySteps extends elementhelper {

    @Step("User selects <option> from sort dropdown")
    public void selectSortDropdown(String option) {
            String value = TestDataHelper.getTestData(option);
            super.selectByVisibleText("sort", value);;
    }
}