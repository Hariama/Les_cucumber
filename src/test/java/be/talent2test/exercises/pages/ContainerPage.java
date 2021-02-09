package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContainerPage extends BasePage {
    static String productPrice;

    @FindBy(css = ".product_list .product-container" )
    WebElement container;
    @FindBy(css = ".product_list .product-container" )
    List<WebElement> containerList;
    @FindBy(css = "[title='Proceed to checkout']" )
    WebElement checkoutButton;

    public WebElement getContainer(int index)
    {
        waiter.until(ExpectedConditions.elementToBeClickable(container));
        return containerList.get(index);
    }

    public ResultPage selectContainerElement(int index, String webelement)
    {
         getContainer(index).findElement(By.cssSelector(webelement)).click();
         return new ResultPage();
    }

    public ContainerPage mouseOverProductCard()
    {
        waiter.until(ExpectedConditions.elementToBeClickable(container));
        Actions actie = new Actions(driver);
        actie.moveToElement(containerList.get(1)).perform();
        return this;
    }

    public CheckoutPage addToCartAndGoToCheckout(int dataId) {
        driver.findElement(By.cssSelector(String.format("[data-id-product='%s']", dataId))).click();
        waiter.until(ExpectedConditions.visibilityOf(checkoutButton));
        checkoutButton.click();
        return new CheckoutPage();
    }
}
