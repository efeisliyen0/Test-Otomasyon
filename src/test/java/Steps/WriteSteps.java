package Steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.WriteImp;

public class WriteSteps {

    private final WriteImp writeImplementation = new WriteImp();

    @Step("User enters <text> into <locatorName> field")
    public void write(String text, String locatorName) {
        writeImplementation.write(text, locatorName);
    }

    @Step("User clears <locatorName> field")
    public void clear(String locatorName) {
        writeImplementation.clear(locatorName);
    }
}
