package helpers;

public interface AssertionHelper {
    void verifyElementIsDisplayed(String elementKey);
    void verifyElementTextContains(String elementKey, String expectedText);
    void verifyElementTextEquals(String elementKey, String expectedText);
    void saveCartBadgeCount();
    void verifyCartBadgeDecreased();
}