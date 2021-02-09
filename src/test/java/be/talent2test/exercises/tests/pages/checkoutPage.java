package be.talent2test.exercises.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage extends basePage {
    By cartElement = By.id("cart_tittle");

    public checkoutPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }
}
