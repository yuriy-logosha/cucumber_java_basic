import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import static org.junit.Assert.assertTrue;

public class MyStepdefsGoogleTest1 {

    private WebDriver driver;

    public MyStepdefsGoogleTest1 () {
        this.driver = Hooks.driver;
    }

    @When("^I am on the Google homepage$")
    public void iAmOnTheGoogleHomepage() throws Throwable {
            driver.get("https://www.google.com/");
        }

    @Then("^I should see Google button - search$")
    public void iShouldSeeGoogleButtonSearch() throws Throwable {
        assertTrue(driver.findElement(By.name("btnK")).isDisplayed());

    }

    @And("^I should see button I'm Feeling Lucky$")
    public void iShouldSeeButtonIMFeelingLucky() throws Throwable {
        assertTrue(driver.findElement(By.name("btnI")).isDisplayed());

    }

    @And("^I should see input field$")
    public void iShouldSeeInputField() {
        assertTrue(driver.findElement(By.name("q")).isDisplayed());

    }
}
