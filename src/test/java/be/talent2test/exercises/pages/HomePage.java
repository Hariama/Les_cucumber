package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ContainerPage {

   // By searchBar = By.id("search_query_top");
   // By submitButton = By.cssSelector("button[name='submit_search']");

    @FindBy(id = "search_query_top")
    WebElement searchBar;

    @FindBy(css = "button[name='submit_search']")
    WebElement submitButton;

    public void validateLogoPresence() {
        WebElement headerlogo = driver.findElement(By.id("header_logo"));
        Assert.assertTrue(headerlogo.isDisplayed());
    }

    public String getProductPrice(int index)
    {
        return getContainer(index).findElement(By.cssSelector(".right-block .price")).getText();
    }

    public HomePage searchFor(String word)
    {
        searchBar.sendKeys(word);
        submitButton.click();
        return this;
    }

}