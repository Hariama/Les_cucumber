package be.talent2test.exercises.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager implements DriverManager{

    @Override
    public WebDriver returnDriver() {
        return new ChromeDriver();
    }
}
