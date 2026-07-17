package Steps;

import com.thoughtworks.gauge.Step;
import helpers.elementhelper;
import utils.JsonReader;
import utils.TestDataReader;

public class InventorySteps {

    @Step("User selects <option> from sort dropdown")
    public void selectSortDropdown(String option) {

        String value = getTestData(option);

        elementhelper.selectByVisibleText(
                JsonReader.getLocator("sort"),
                value
        );
    }


    private String getTestData(String value) {

        if (value.contains(".")) {

            String[] parts = value.split("\\.");

            return TestDataReader.getValue(
                    parts[0],
                    parts[1]
            );
        }

        return value;
    }
}
