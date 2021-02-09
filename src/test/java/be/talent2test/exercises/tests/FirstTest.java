package be.talent2test.exercises.tests;

import be.talent2test.exercises.tests.pages.homePage;
import be.talent2test.exercises.tests.pages.resultPage;
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

public class FirstTest {

    WebDriver driver;
    WebDriverWait waiter;

    @BeforeTest
    public void Initialize() {
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        waiter = new WebDriverWait(driver, 10);
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
        homePage hp = new homePage(driver, waiter);
        resultPage rp = new resultPage(driver, waiter);

        hp.searchFor("dress");
        String dressPrice = hp.getProductPrice(1);
        hp.getContainerElement(1).findElement(By.cssSelector("img")).click();
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("our_price_display"))));
        String detailDressPrice = driver.findElement(By.id("our_price_display")).getText();
        Assert.assertEquals(dressPrice, detailDressPrice);
    }

    //Exercise 6
    //Add something from front-page to cart
    @Test
    public void addFromFrontpageToCart() {
        getContainerList();
        driver.findElement(By.cssSelector("[data-id-product='2']")).click();
        waiter.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("[title='Proceed to checkout']"))));
        driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cart_title"))));
        Assert.assertTrue(driver.findElement(By.id("cart_title")).isDisplayed());
    }

    //Add something from detail-page to cart
    @Test
    public void addFromDetailpageToCart() {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        getContainerList();
        driver.findElement(By.cssSelector("[data-id-product='4']")).click();
        waiter.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("[title='Proceed to checkout']"))));
        driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("cart_title"))));
        Assert.assertTrue(driver.findElement(By.id("cart_title")).isDisplayed());
    }

    @AfterTest
    public void CleanUp() {driver.quit();}
}
