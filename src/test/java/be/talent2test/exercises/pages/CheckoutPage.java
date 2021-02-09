package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    By cartElement = By.id("cart_title");

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void validateArrivalAtCheckoutPage() {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(cartElement)));
        Assert.assertTrue(driver.findElement(cartElement).isDisplayed());
    }
}
