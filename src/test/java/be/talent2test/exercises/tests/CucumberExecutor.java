package be.talent2test.exercises.tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue = "be.talent2test.exercises.steps",
        plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" })
public class CucumberExecutor extends AbstractTestNGCucumberTests {

}
