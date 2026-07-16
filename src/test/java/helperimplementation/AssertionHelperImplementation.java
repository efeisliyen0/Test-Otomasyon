package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert; // TestNG kullanıyorsan. JUnit kullanıyorsan org.junit.Assert olarak değiştir
import utils.LocatorManager;

public class AssertionHelperImplementation implements AssertionHelper {

    private WaitHelper waitHelper = new WaitHelperImplementation();
    private static int savedBadgeCount = 0; // Sepet sayısını geçici olarak tutmak için

    @Override
    public void verifyElementIsDisplayed(String elementKey) {
        By locator = LocatorManager.getLocator(elementKey);
        WebElement element = waitHelper.waitForElementVisible(locator, 10);
        Assert.assertTrue(element.isDisplayed(), elementKey + " elementi ekranda görünmüyor!");
    }

    @Override
    public void verifyElementTextContains(String elementKey, String expectedText) {
        By locator = LocatorManager.getLocator(elementKey);
        WebElement element = waitHelper.waitForElementVisible(locator, 10);
        Assert.assertTrue(element.getText().contains(expectedText), "Beklenen metin eşleşmedi! Gelen: " + element.getText());
    }

    @Override
    public void verifyElementTextEquals(String elementKey, String expectedText) {
        By locator = LocatorManager.getLocator(elementKey);
        WebElement element = waitHelper.waitForElementVisible(locator, 10);
        Assert.assertEquals(element.getText(), expectedText, "Metinler birebir eşleşmiyor!");
    }

    @Override
    public void saveCartBadgeCount() {
        By locator = LocatorManager.getLocator("cart badge");
        WebElement element = waitHelper.waitForElementVisible(locator, 5);
        savedBadgeCount = Integer.parseInt(element.getText());
    }

    @Override
    public void verifyCartBadgeDecreased() {
        By locator = LocatorManager.getLocator("cart badge");
        int currentCount = 0;
        try {
            // Eğer sepet tamamen boşalırsa badge elementi kaybolabilir, bunu try-catch ile kontrol ediyoruz
            WebElement element = waitHelper.waitForElementVisible(locator, 3);
            currentCount = Integer.parseInt(element.getText());
        } catch (Exception e) {
            currentCount = 0;
        }
        Assert.assertTrue(currentCount < savedBadgeCount, "Sepet simgesindeki sayı azalmadı!");
    }
}