package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the main page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter wrong number or symbols: \"<number>\"$")
    public void tooSmall() throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("<number>");
    }

    @And("^I click on submit button$")
    public void submitButton() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^I see: \"<error message>\"$")
    public void errorMessageSmall() throws Throwable {
        assertEquals("<error message>", driver.findElement(By.id("ch1_error")).getText());
    }


    @When("^I enter correct number: \"66\"$")
    public void correctNumber() throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("66");
    }

    @And("^I click on submit button1$")
    public void submitButton3() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^there is no error displayed$")
    public void noError() throws Throwable {
        assertEquals("Square root of 66 is 8.12", driver.switchTo().alert().getText());
    }

    @And("^I enter age: \\(\\d\\+\\) using PO$")
    public void iEnterAgeDUsingPO() {
        
    }

    @When("^I enter wrong number or symbols: \"([^\"]*)\"$")
    public void iEnterWrongNumberOrSymbols(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I see: \"([^\"]*)\"$")
    public void iSee(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}