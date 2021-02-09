package be.talent2test.exercises.tests.pages;

import be.talent2test.exercises.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.List;

public class homePage extends basePage {
    By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='2']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    private void getContainerList() {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
    }
}
