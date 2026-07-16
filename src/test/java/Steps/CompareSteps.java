package steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.CompareImp;

public class CompareSteps {
    private CompareImp compareImpl;

    public CompareSteps() {
        this.compareImpl = new CompareImp();
    }

    @Step("User compares screenshot with baseline <imageName>")
    public void compareScreenshots(String imageName) {
        compareImpl.doComparison(imageName);
    }
}