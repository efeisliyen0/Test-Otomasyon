package driverManager;

import helpers.ScreenshotHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getenv("BROWSER") != null
                    ? System.getenv("BROWSER").toLowerCase()
                    : "chrome";

            WebDriver rawDriver;

            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("-private");
                    rawDriver = new FirefoxDriver(firefoxOptions);
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--incognito");
                    chromeOptions.addArguments("--disable-features=PasswordLeakDetection");
                    chromeOptions.addArguments("--disable-save-password-bubble");
                    rawDriver = new ChromeDriver(chromeOptions);
                    break;
            }

            driver = wrapWithAllureListener(rawDriver);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    private static WebDriver wrapWithAllureListener(WebDriver original) {
        WebDriverListener listener = new WebDriverListener() {
            @Override
            public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
                ScreenshotHelper.attachToAllure("Selenium hatası - " + method.getName());
            }
        };
        return new EventFiringDecorator<>(listener).decorate(original);
    }
}