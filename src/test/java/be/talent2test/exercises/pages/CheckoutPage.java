package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    //By cartElement = By.id("cart_title");
    @FindBy(id = "cart_title")
    WebElement cartElement;

    public void validateArrivalAtCheckoutPage() {
        waiter.until(ExpectedConditions.elementToBeClickable(cartElement));
        Assert.assertTrue(cartElement.isDisplayed());
    }
}
