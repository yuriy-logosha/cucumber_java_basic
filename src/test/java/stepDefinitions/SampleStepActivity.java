/*package stepDefinitions;

// Scenario: IBfile
//    When I am on the home page.
//    Then I should see Search button
//    And I should see “I’m feeling Lucky” "button"

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class SampleStepActivity {
    private WebDriver driver;

    public SampleStepsActivity() {
        this.driver = Hooks.driver;
    }
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://www.google.com");
    }

    @Then("^I should see Search button")
    public void iShouldSeeSearchButton() throws Throwable {
    assertTrue(driver.findElement(By.className("gLFyf gsfi")).isDisplayed());
}



    }
*/