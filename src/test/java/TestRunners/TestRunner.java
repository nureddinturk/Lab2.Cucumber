package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Feature", glue = "StepDefinitions",
        monochrome = true,
        plugin =
                {"pretty",
                        "rerun:target/rerun.txt",
                        "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})
public class TestRunner {
}
