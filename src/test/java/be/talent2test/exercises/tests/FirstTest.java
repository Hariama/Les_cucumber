package be.talent2test.exercises.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest extends BaseTest{
    public void openBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\OpenJDK\\jdk-15.0.2\\webdrivers\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\Webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @BeforeTest
    public void Initialize() {
        openBrowser();
    }


    @Test
    public void detectElements()
    {
        WebElement headerlogo = driver.findElement(By.id("header_logo"));
        Assert.assertTrue(headerlogo.isDisplayed());
    }

    @Test
    public void searchDresses()
    {
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.cssSelector("button[name='submit_search']")).click();
        String dressPrice = driver.findElement(By.cssSelector("#center_column .product_list > li:nth-child(2)")).getText();
        driver.findElement(By.cssSelector("#center_column .product_list > li:nth-child(2)")).click();
        String detailDressPrice = driver.findElement(By.id("our_price_display")).getText();
        Assert.assertEquals(dressPrice, detailDressPrice);
    }

    @AfterTest
    public void CleanUp() {driver.quit();}
}
