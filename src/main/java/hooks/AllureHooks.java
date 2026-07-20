package Hooks;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.ExecutionContext;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.TestResult;
import utils.AllureStatusHolder;

import java.util.UUID;

public class AllureHooks {

    private static final ThreadLocal<String> currentTestUuid = new ThreadLocal<>();

    @BeforeScenario
    public void startScenario(ExecutionContext context) {
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
    }

    @AfterScenario
    public void endScenario(ExecutionContext context) {
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