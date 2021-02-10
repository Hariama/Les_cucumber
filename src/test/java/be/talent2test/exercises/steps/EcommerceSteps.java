package be.talent2test.exercises.steps;

import be.talent2test.exercises.pages.CheckoutPage;
import be.talent2test.exercises.pages.ContainerPage;
import be.talent2test.exercises.pages.HomePage;
import be.talent2test.exercises.pages.ResultPage;
import be.talent2test.exercises.support.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EcommerceSteps {
    @When("I enter {string} in the searchbalk and click on the search button")
    public void iEnterDressInTheSearchbalkAndClickOnTheSearchButton(String product) {
        new HomePage().searchFor(product);
    }

    @When("I hover over the second product")
    public void iScrollDownToAProduct() {
        new ContainerPage().mouseOverProductCard();
    }

    @And("I click on product {int}")
    public void iClickOnAProduct(int index) {
        new HomePage()
                .getProductPrice(index)
                .selectContainerElement(index, "img");
    }

    @And("I click on the add to cart button of product {int} and I click on \"proceed to checkout\"")
    public void iClickOnTheButtonOfAProduct(int index) {
        new ContainerPage().addToCartAndGoToCheckout(index);
    }

    @Then("I should see the checkout page with the added products")
    public void iShouldSeeTheCheckoutPageWithTheAddedProducts() {
        new CheckoutPage().validateArrivalAtCheckoutPage();
    }


    @Then("I can see the the details of the product on the redirected site")
    public void iCanSeeTheTheDetailsOfTheProductOnTheRedirectedSite() {
        new ResultPage().validatePrices();
    }
}
