package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ResultPage extends ContainerPage {
    @FindBy(id = "our_price_display")
    WebElement priceDisplay;

    /*By searchBar = By.id("search_query_top");
    By submitButton = By.cssSelector("button[name='submit_search']");
    By productElement = By.cssSelector("[data-id-product='4']");
    By checkoutButton = By.cssSelector("[title='Proceed to checkout']");*/

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    public void validatePrices() {
        waiter.until(ExpectedConditions.visibilityOf(priceDisplay));
        String detailDressPrice = priceDisplay.getText();
        Assert.assertEquals(productPrice, detailDressPrice);
    }

    public void selectProduct()
    {
        mouseOverProductCard();
    }
}
