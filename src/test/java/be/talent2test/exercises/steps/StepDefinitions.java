package be.talent2test.exercises.steps;

import be.talent2test.exercises.pages.HomePage;
import be.talent2test.exercises.support.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import org.testng.annotations.BeforeTest;


public class StepDefinitions {
    @Before
    public void initilize() {
        DriverProvider.createDriver();
    }

    @Given("I navigate to the site {string}")
    public void userIsOnSite(String url) {
        DriverProvider.navigateTo(url);
    }

    @Then("I am on the homepage")
    public void iAmOnTheHomepage() {
        new HomePage().validateLogoPresence();
    }

    @After
    public void finishTesting() {
        DriverProvider.destroyDriver();
    }
}
