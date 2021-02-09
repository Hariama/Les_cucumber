package be.talent2test.exercises.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class basePage {
    WebDriver driver;
    WebDriverWait waiter;

    public basePage(WebDriver driver, WebDriverWait waiter) {
        this.driver = driver;
        this.waiter = waiter;
    }
}
