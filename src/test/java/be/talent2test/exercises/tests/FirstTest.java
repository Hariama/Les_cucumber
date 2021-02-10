/*package be.talent2test.exercises.tests;

import be.talent2test.exercises.pages.CheckoutPage;
import be.talent2test.exercises.pages.HomePage;
import be.talent2test.exercises.pages.ResultPage;
import be.talent2test.exercises.support.DriverProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
    @BeforeTest
    public void Initialize() {
        DriverProvider.createDriver();
        DriverProvider.navigateTo("http://automationpractice.com/index.php");
    }

    //Exercise 4
    @Test
    public void detectElements() {
        HomePage hp = new HomePage();
        hp.validateLogoPresence();
    }

    //Exercise 5
    @Test
    public void searchDresses() {
        new HomePage()
                .searchFor("Dress")
                .getProductPrice(1)
                .selectContainerElement(1, "img")
                .validatePrices();

//        HomePage hp = new HomePage();
//        ResultPage rp = new ResultPage();
//
//        hp.searchFor("dress");
//        hp.getProductPrice(1);
//        hp.selectContainerElement(1, "img");
//        rp.validatePrices();
    }

    //Exercise 6
    //Add something from front-page to cart
    @Test
    public void addFromFrontpageToCart() {
        new HomePage()
                .mouseOverProductCard()
                .addToCartAndGoToCheckout(2)
                .validateArrivalAtCheckoutPage();

//        HomePage hp = new HomePage();
//        CheckoutPage cp = new CheckoutPage();
//
//        hp.getContainerList();
//        hp.addToCartAndGoToCheckout(2);
//        cp.validateArrivalAtCheckoutPage();
    }

    //Add something from detail-page to cart
    @Test
    public void addFromDetailpageToCart() {
        new HomePage().searchFor("dress")
                .mouseOverProductCard()
                .addToCartAndGoToCheckout(4)
                .validateArrivalAtCheckoutPage();

//        HomePage hp = new HomePage();
//        ResultPage rp = new ResultPage();
//        CheckoutPage cp = new CheckoutPage();
//
//        hp.searchFor("dress");
//        rp.mouseOverProductCard();
//        rp.addToCartAndGoToCheckout(4);
//        cp.validateArrivalAtCheckoutPage();
    }

    @AfterTest
    public void CleanUp() {
        DriverProvider.destroyDriver();
    }
}
*/
