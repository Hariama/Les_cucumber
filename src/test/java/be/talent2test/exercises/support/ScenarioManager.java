package be.talent2test.exercises.support;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public abstract class ScenarioManager {
    static Scenario scenario;

    public static Scenario getSecenario(){
        return scenario;
    }

    public static void setScenario(Scenario importedScenario) {
        scenario = importedScenario;
    }

    public static void takeScreenshot() {
        final byte[] screenshot = ((TakesScreenshot) DriverProvider.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png","Taking screenshot"); //stick it in the report
    }
}
