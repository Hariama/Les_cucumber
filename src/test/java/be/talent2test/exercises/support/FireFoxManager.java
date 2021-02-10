package be.talent2test.exercises.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxManager implements DriverManager{
    @Override
    public WebDriver returnDriver() {
        return new FirefoxDriver();
    }
}
