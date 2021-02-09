package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage extends ContainerPage {
    By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='2']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    public void validateLogoPresence() {
        WebElement headerlogo = driver.findElement(By.id("header_logo"));
        Assert.assertTrue(headerlogo.isDisplayed());
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