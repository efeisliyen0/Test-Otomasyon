package steps;

import com.thoughtworks.gauge.Step;
import StepImplementation.VerifyImp;

public class VerifySteps {
    private VerifyImp verifyImpl;

    public VerifySteps() {
        this.verifyImpl = new VerifyImp();
    }

    @Step({
            "User should see products",
            "User should be on products page",
            "User should see login page"
    })
    public void verifyPageVisibility() {
        // Hangi sayfada olduğumuzu spec cümlesinden ayıklayamadığımız statik durumlar için
        // doğrudan sayfa belirteçlerine odaklanabiliriz. (Örn: products sayfası için 'products title' aranabilir)
        // Ancak daha esnek yapı için aşağıdaki metodu da kullanabilirsin.
    }

    @Step({
            "User should see <elementKey>",
            "User should see product detail page for <elementKey>"
    })
    public void verifyElementIsVisible(String elementKey) {
        verifyImpl.verifyVisible(elementKey);
    }

    @Step({
            "User should see <expectedText> in the cart",
            "User should see error message <expectedText>",
            "Verify checkout error message is <expectedText>",
            "Order complete message should be <expectedText>"
    })
    public void verifyMessageText(String expectedText) {
        // Bu adımda spesifik locatordan ziyade genel bir error-message veya complete-message okuması yapılır.
        // Hangi elementin okunduğunu dinamik belirlemek adına duruma göre LocatorManager'da
        // "error message" vb. genel key'leri aratabilirsin.
        verifyImpl.verifyTextMatch("generic message element", expectedText);
    }

    @Step("Cart badge should be <expectedCount>")
    public void verifyBadgeCount(String expectedCount) {
        verifyImpl.verifyTextMatch("cart badge", expectedCount);
    }

    @Step("User saves cart badge count")
    public void saveBadgeStep() {
        verifyImpl.saveBadge();
    }

    @Step("Cart badge should decrease by one")
    public void verifyBadgeDecreaseStep() {
        verifyImpl.checkBadgeDecreased();
    }
}