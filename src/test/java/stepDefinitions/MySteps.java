package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MySteps {
        private WebDriver driver;

        public MySteps () {
        this.driver=Hooks.driver;
        }

    @Given("^I am on the Google page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://google.com");
    }

    @Then("^I should see that input field is present$")
    public void iShouldSeeInputField() throws Throwable {
        assertEquals("",driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input")).getText());
    }

    @And("^I should see Search button$")
    public void iShouldSeeSearch() throws Throwable {
        assertTrue(driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.FPdoLc.VlcLAe > center > input.gNO89b")).isDisplayed());
    }

    @When("^I should see \"I'm feeling Lucky\" button$")
    public void iEnterName(String name) throws Throwable {
        assertTrue(driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div > div.FPdoLc.VlcLAe > center > input.RNmpXc")).isDisplayed());
    }
}