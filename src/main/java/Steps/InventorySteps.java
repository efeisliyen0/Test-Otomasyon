package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import helpers.TestDataHelper;
import utils.AllureStepRunner;

public class InventorySteps {

    @Step("User selects <option> from sort dropdown")
    public void selectSortDropdown(String option) {
        AllureStepRunner.run("Sıralama seçildi: " + option, () -> {
            String value = TestDataHelper.getTestData(option);
            elementhelper.selectByVisibleText("sort", value);
        });
    }
}