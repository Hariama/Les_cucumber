package be.talent2test.exercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContainerPage extends BasePage {
    static String productPrice;

    public ContainerPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getContainer(int index)
    {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        return container.get(index);
    }

    public ResultPage selectContainerElement(int index, String webelement)
    {
         getContainer(index).findElement(By.cssSelector(webelement)).click();
         return new ResultPage();
    }

    public ContainerPage mouseOverProductCard()
    {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        Actions actie = new Actions(driver);
        actie.moveToElement(container.get(1)).perform();
        return this;
    }

    public CheckoutPage addToCartAndGoToCheckout(int dataId) {
        driver.findElement(By.cssSelector(String.format("[data-id-product='%s']", dataId))).click();
        waiter.until(ExpectedConditions.visibilityOf( driver.findElement(By.cssSelector("[title='Proceed to checkout']"))));
        driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();
        return new CheckoutPage();
    }
}
