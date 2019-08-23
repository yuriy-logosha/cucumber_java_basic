package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:cucumber-report/html-report",
                "junit:cucumber-report/junit-report.xml",
                "json:cucumber-report/json-report.json"},


        features = "src/test/resources/features/Sample5.feature",
        tags = {"~@test", "~@bug"},
        glue = {"stepDefinitions"}
)
public class CucumberRunner {

}
