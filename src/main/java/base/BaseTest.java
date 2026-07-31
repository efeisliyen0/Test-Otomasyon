package base;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.ExecutionContext;
import driverManager.Driver;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import utils.AllureStatusHolder;
import utils.ConfigReader;

import java.util.UUID;

public class BaseTest {

    private static final ThreadLocal<String> currentTestUuid = new ThreadLocal<>();

    @BeforeScenario
    public void setUp(ExecutionContext context) {
        // 1) Önce Allure test case'i başlat
        String uuid = UUID.randomUUID().toString();
        currentTestUuid.set(uuid);
        AllureStatusHolder.reset();

        AllureLifecycle lifecycle = Allure.getLifecycle();

        String specName = context.getCurrentSpecification() != null
                ? context.getCurrentSpecification().getName()
                : "";
        String scenarioName = context.getCurrentScenario().getName();

        TestResult result = new TestResult()
                .setUuid(uuid)
                .setName(scenarioName)
                .setFullName(specName + " - " + scenarioName);

        lifecycle.scheduleTestCase(result);
        lifecycle.startTestCase(uuid);

        // 2) Sonra driver'ı ayağa kaldır ve sayfaya git
        Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterScenario
    public void quit(ExecutionContext context) {
        // 1) Önce driver'ı kapat
        Driver.quitDriver();

        // 2) Sonra Allure test case'i sonlandır
        String uuid = currentTestUuid.get();
        if (uuid == null) return;

        AllureLifecycle lifecycle = Allure.getLifecycle();
        Status status = AllureStatusHolder.isFailed() ? Status.FAILED : Status.PASSED;

        lifecycle.updateTestCase(uuid, tr -> tr.setStatus(status));
        lifecycle.stopTestCase(uuid);
        lifecycle.writeTestCase(uuid);

        currentTestUuid.remove();
    }
}