package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task1 {
    private WebDriver driver;

    public Task1() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see message$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter value: \"([^\"]*)\"$")
    public void iEnterValue(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And ("^I click button$")
    public void iClickButton() throws  Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I do not see any error message$")
    public void iDoNotSeeAnyErrorMessage() throws Throwable {
        assertFalse(driver.findElement(By.id("ch1_error")).isDisplayed());
    }

}