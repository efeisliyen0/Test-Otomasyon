package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.CompareImp;

public class CompareSteps {

    private final CompareImp compareImplementation =
            new CompareImp();

    @Step("User compares screenshot with baseline <fileName>")
    public void compareScreenshot(String fileName) {
        compareImplementation.compareScreenshot(fileName);
    }

}