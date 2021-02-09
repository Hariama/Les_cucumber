package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ResultPage extends ContainerPage {
    By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='4']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    public void validatePrices(String price) {
        waiter.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("our_price_display"))));
        String detailDressPrice = driver.findElement(By.id("our_price_display")).getText();
        Assert.assertEquals(price, detailDressPrice);
    }

    public void selectProduct()
    {
        getContainerList();
    }
}
