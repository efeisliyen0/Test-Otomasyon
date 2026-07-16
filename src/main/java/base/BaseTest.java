package base;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.AfterScenario;
import driverManager.Driver;
import utils.ConfigReader;

public class BaseTest {
    @BeforeScenario
    public void setUp() {
        Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @AfterScenario
    public void quit() {
        Driver.quitDriver();
    }
}
