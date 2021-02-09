package be.talent2test.exercises.steps;

import org.openqa.selenium.WebDriver;

public class FirstTest {
    WebDriver driver;

    @Given("I am on the site {String}")
    public void i_am_on_the_site(String url) {
        driver.get(url);
    }
    @When
    @And
    @Then
}
