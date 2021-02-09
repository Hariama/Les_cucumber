package be.talent2test.exercises.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class resultPage extends basePage {
    By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='4']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    public resultPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }

    private void getContainerList() {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
    }

    public void selectProduct()
    {
        getContainerList()
    }
}
