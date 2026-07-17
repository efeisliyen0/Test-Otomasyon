package Steps;

import com.thoughtworks.gauge.Step;
import driverManager.Driver;
import org.openqa.selenium.support.ui.Select;
import utils.JsonReader;
import utils.TestDataReader;

public class SelectSteps {

    @Step("User selects <text> from <locatorName>")
    public void selectByVisibleText(String text, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        JsonReader.getLocator(locatorName)
                )
        );

        select.selectByVisibleText(
                getTestData(text)
        );
    }


    @Step("User selects value <value> from <locatorName>")
    public void selectByValue(String value, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        JsonReader.getLocator(locatorName)
                )
        );

        select.selectByValue(
                getTestData(value)
        );
    }


    @Step("User selects index <index> from <locatorName>")
    public void selectByIndex(int index, String locatorName) {

        Select select = new Select(
                Driver.getDriver().findElement(
                        JsonReader.getLocator(locatorName)
                )
        );

        select.selectByIndex(index);
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
