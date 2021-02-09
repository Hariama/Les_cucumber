package be.talent2test.exercises.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FirstTest extends BaseTest{
    public void openBrowser()
    {
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        waiter = new WebDriverWait(driver, 10);
    }

    public void findProductsContainer() {
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
        driver.findElement(By.cssSelector("[data-id-product='4']")).click();
        waiter.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("[title='Proceed to checkout']"))));
        driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cart_title"))));
        Assert.assertTrue(driver.findElement(By.id("cart_title")).isDisplayed());
    }

    @BeforeTest
    public void Initialize() {
        openBrowser();
    }

    //Exercise 4
    @Test
    public void detectElements()
    {
        WebElement headerlogo = driver.findElement(By.id("header_logo"));
        Assert.assertTrue(headerlogo.isDisplayed());
    }

    //Exercise 5
    @Test
    public void searchDresses()
    {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        WebElement selectedContainer = container.get(1);
        String dressPrice = selectedContainer.findElement(By.cssSelector(".right-block .price")).getText();
        selectedContainer.findElement(By.cssSelector("img")).click();
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("our_price_display"))));
        String detailDressPrice = driver.findElement(By.id("our_price_display")).getText();
        Assert.assertEquals(dressPrice, detailDressPrice);
    }

    //Exercise 6
    //Add something from front-page to cart
    @Test
    public void addFromFrontpageToCart() {
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        WebElement button = container.get(1).findElement(By.cssSelector(".button-container .button"));
        Actions a = new Actions(driver);
        a.moveToElement(button);
        a.click();
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2 > .icon-ok")));
        Assert.assertTrue(driver.findElement(By.cssSelector(".icon-ok")).isDisplayed());
    }

    //Add something from detail-page to cart
    @Test
    public void addFromDetailpageToCart() {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
        driver.findElement(By.cssSelector("[data-id-product='4']")).click();
        waiter.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("[title='Proceed to checkout']"))));
        driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cart_title"))));
        Assert.assertTrue(driver.findElement(By.id("cart_title")).isDisplayed());
    }

    @AfterTest
    public void CleanUp() {driver.quit();}
}
