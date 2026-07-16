package Steps;

import com.thoughtworks.gauge.Step;
import helpers.ImageComparisonHelper;

public class CompareSteps {

    @Step("User compares screenshot with baseline <fileName>")
    public void compareScreenshot(String fileName) {
        ImageComparisonHelper.compare(fileName);
    }
}