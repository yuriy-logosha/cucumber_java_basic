package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import static org.junit.Assert.assertEquals;

public class MyStepdefsSample {
    private WebDriver driver;

    public MyStepdefsSample() {this.driver = Hooks.driver; }

    @Given("^I am on sample page$")
    public void iAmOnSamplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^enter \"([^\"]*)\"$")
    public void enter(String numb) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(numb));

    }

    @And("^I click submit$")
    public void iClickSubmit() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']")).click();
    }

    @Then("^I see message \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see accepted message \"([^\"]*)\"$")
    public void iSeeAcceptedMessage(String okmsg) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(okmsg, driver.switchTo().alert().getText());
    }
}

