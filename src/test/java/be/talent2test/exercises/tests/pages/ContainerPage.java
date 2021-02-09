package be.talent2test.exercises.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContainerPage extends basePage {
    public ContainerPage(WebDriver driver, WebDriverWait waiter) {
        super(driver, waiter);
    }


    private WebElement getContainer(int index)
    {
        waiter.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".product_list .product-container"))));
        List<WebElement> container = driver.findElements(By.cssSelector(".product_list .product-container"));
        return container.get(index);
    }
}
