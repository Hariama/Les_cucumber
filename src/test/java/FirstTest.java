import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
    @Test
    public void openBrowser()
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\OpenJDK\\jdk-15.0.2\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://automationpractice.com/index.php");
        driver.quit();
    }
}
