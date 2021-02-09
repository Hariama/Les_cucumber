package be.talent2test.exercises.tests;

import be.talent2test.exercises.pages.CheckoutPage;
import be.talent2test.exercises.pages.HomePage;
import be.talent2test.exercises.pages.ResultPage;
import be.talent2test.exercises.support.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Driver;

public class FirstTest {
    @BeforeTest
    public void Initialize() {
        DriverProvider.createDriver();
        DriverProvider.navigateTo("http://automationpractice.com/index.php");
    }

    //Exercise 4
    @Test
    public void detectElements()
    {
        HomePage hp = new HomePage();
        hp.validateLogoPresence();
    }

    //Exercise 5
    @Test
    public void searchDresses()
    {
        HomePage hp = new HomePage();
        ResultPage rp = new ResultPage();

        hp.searchFor("dress");
        String dressPrice = hp.getProductPrice(1);
        hp.selectContainerElement(1, "img");
        rp.validatePrices(dressPrice);
    }

    //Exercise 6
    //Add something from front-page to cart
    @Test
    public void addFromFrontpageToCart() {
        HomePage hp = new HomePage();
        CheckoutPage cp = new CheckoutPage();

        hp.getContainerList();
        hp.addToCartAndGoToCheckout(2);
        cp.validateArrivalAtCheckoutPage();
    }

    //Add something from detail-page to cart
    @Test
    public void addFromDetailpageToCart() {
        HomePage hp = new HomePage();
        ResultPage rp = new ResultPage();
        CheckoutPage cp = new CheckoutPage();

        hp.searchFor("dress");
        rp.getContainerList();
        rp.addToCartAndGoToCheckout(4);
        cp.validateArrivalAtCheckoutPage();
    }

    @AfterTest
    public void CleanUp() {
        DriverProvider.destroyDriver();
    }
}
