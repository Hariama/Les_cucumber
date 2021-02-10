package be.talent2test.exercises.support;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager implements DriverManager{
    URL url;
    BROWSERS browser;

    public RemoteDriverManager(String url, BROWSERS browser) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.browser = browser;
    }
    @Override
    public WebDriver returnDriver() {
        return new RemoteWebDriver(url, new DesiredCapabilities(browser.name(),"", Platform.ANY));
    }
}
