package be.talent2test.exercises.pages;

import be.talent2test.exercises.support.DriverProvider;
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
    @FindBy(id="search_query_top") WebElement searchBar;
    @FindBy(css="button[name='submit_search']") WebElement submitButton;
    By productElement = By.cssSelector("[data-id-product='2']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void validateLogoPresence() {
        WebElement headerlogo = driver.findElement(By.id("header_logo"));
        Assert.assertTrue(headerlogo.isDisplayed());
    }

    public HomePage getProductPrice(int index)
    {
        productPrice = getContainer(index).findElement(By.cssSelector(".right-block .price")).getText();
        return this;
    }

    public HomePage searchFor(String word)
    {
        searchBar.sendKeys(word);
        submitButton.click();
        return this;
    }

}