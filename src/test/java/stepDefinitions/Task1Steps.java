package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task1Steps {

    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the Enter a number page$")
    public void iAmOnTheEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter invalid number: \"([^\"]*)\"$")
        public void iEnterInvalidNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);

       }
    @And("^I click submit button")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();

    }

    @Then("^I see the message: \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) throws Throwable {

     assertEquals(message, driver.findElement(By.id("ch1_error")).getText());


    }


}