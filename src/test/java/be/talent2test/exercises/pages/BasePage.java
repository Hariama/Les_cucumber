package be.talent2test.exercises.pages;

import be.talent2test.exercises.support.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    WebDriver driver = DriverProvider.getDriver();
    WebDriverWait waiter = DriverProvider.getWaiter();
//
//    public BasePage(WebDriver driver, WebDriverWait waiter) {
//        this.driver = driver;
//        this.waiter = waiter;
//    }
}
