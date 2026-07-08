package base;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import driverManager.Driver;

public class BaseTest {
    @BeforeScenario
    public void setUp() {
        Driver.getDriver();
    }

    @AfterScenario
    public void quit() {
        Driver.quitDriver();
    }
}
