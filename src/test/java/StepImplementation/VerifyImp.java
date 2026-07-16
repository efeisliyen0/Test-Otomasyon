package StepImplementation;

import helpers.AssertionHelper;
import helpers.AssertionHelperImplementation;

public class VerifyImp {
    private AssertionHelper assertionHelper;

    public VerifyImp() {
        this.assertionHelper = new AssertionHelperImplementation();
    }

    public void verifyVisible(String elementKey) {
        assertionHelper.verifyElementIsDisplayed(elementKey);
    }

    public void verifyTextMatch(String elementKey, String expectedText) {
        assertionHelper.verifyElementTextEquals(elementKey, expectedText);
    }

    public void verifyTextContains(String elementKey, String expectedText) {
        assertionHelper.verifyElementTextContains(elementKey, expectedText);
    }

    public void saveBadge() {
        assertionHelper.saveCartBadgeCount();
    }

    public void checkBadgeDecreased() {
        assertionHelper.verifyCartBadgeDecreased();
    }
}