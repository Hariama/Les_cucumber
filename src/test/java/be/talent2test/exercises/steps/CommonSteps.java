package be.talent2test.exercises.steps;

import be.talent2test.exercises.pages.HomePage;
import be.talent2test.exercises.support.DriverProvider;
import be.talent2test.exercises.support.ScenarioManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import org.testng.annotations.BeforeTest;

public class CommonSteps {
    @Before
    public void initilize(Scenario scenario) {
        ScenarioManager.setScenario(scenario);
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
    public void finishTesting(Scenario scenario) {
        if (scenario.isFailed()) {
            ScenarioManager.takeScreenshot();
        }
        DriverProvider.destroyDriver();
    }
}
