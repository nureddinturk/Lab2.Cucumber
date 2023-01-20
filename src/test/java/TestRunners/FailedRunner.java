package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt", glue = "StepDefinitions",
        monochrome = true, plugin = {"pretty",
        "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})
public class FailedRunner {
}
