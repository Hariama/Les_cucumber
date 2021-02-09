package be.talent2test.exercises.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class homePage extends basePage {
    By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='2']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    public homePage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }

    private void getContainerList()
    {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
    }

    private WebElement getContainer(int index)
    {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        return container.get(index);
    }

    public String getProductPrice(int index)
    {
        return getContainer(index).findElement(By.cssSelector(".right-block .price")).getText();
    }

    public void searchFor(String word)
    {
        driver.findElement(searchBar).sendKeys(word);
        driver.findElement(submitButton).click();
    }

}
