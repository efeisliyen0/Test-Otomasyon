package Steps;

import com.thoughtworks.gauge.Step;
import helpers.TestDataHelper;
import helpers.VerifyHelper;

public class VerifySteps extends VerifyHelper {

    private int savedCartBadgeCount;

    @Step("User verifies message <locatorName> matches <expectedMessage>")
    public void verifyMessageStep(String locatorName, String expectedMessage) {
        verifyMessage(locatorName, TestDataHelper.getTestData(expectedMessage));
    }

    @Step("User verifies <locatorName> text is <expectedText>")
    public void verifyTextStep(String locatorName, String expectedText) {
        verifyText(locatorName, TestDataHelper.getTestData(expectedText));
    }

    @Step("User verifies <locatorName> value is <expectedNumber>")
    public void verifyNumberStep(String locatorName, String expectedNumber) {
        verifyNumber(locatorName, Integer.parseInt(TestDataHelper.getTestData(expectedNumber)));
    }

    @Step("User verifies <locatorName> is displayed")
    public void verifyDisplayedStep(String locatorName) {
        verifyDisplayed(locatorName);
    }

    @Step("User verifies <locatorName> is not displayed")
    public void verifyNotDisplayedStep(String locatorName) {
        verifyNotDisplayed(locatorName);
    }

    @Step("User verifies products are sorted by price low to high using <locatorName>")
    public void verifyProductsSortedLowToHighStep(String locatorName) {
        verifyProductsSortedLowToHigh(locatorName);
    }

    @Step("User saves <locatorName> count")
    public void saveCartBadgeCount(String locatorName) {
        savedCartBadgeCount = getNumber(locatorName);
    }

    @Step("User verifies <firstLocator> is less than <secondLocator>")
    public void verifyFirstNumberIsLessThanSecond(String firstLocator, String secondLocator) {
        super.verifyFirstNumberIsLessThanSecond(firstLocator, secondLocator);
    }
}