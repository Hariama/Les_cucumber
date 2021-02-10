package be.talent2test.exercises.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DriverProvider {
    static EventFiringWebDriver driver;
    static WebDriverWait waiter;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWaiter() {
        return waiter;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void createDriver() {
        WebDriver localDriver = new FirefoxDriver();
        driver = new EventFiringWebDriver(localDriver);
        EventHandler eventHandler = new EventHandler();
        driver.register(eventHandler);
        waiter = new WebDriverWait(driver, 10);
    }

    public static void destroyDriver() {
        driver.quit();
        waiter = null;
    }
}
