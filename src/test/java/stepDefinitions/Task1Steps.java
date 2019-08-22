package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
       // this.driver = Hooks.driver;
    }

    @Given("^I am on the Enter a Number form$")
    public void iAmOnTheEnterANumberForm() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }
/*
    @When("^I enter an invalid input:$")
    public void iEnterAnInvalidInput(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(value);
        }
    }
    @And("^I click Submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("^I want to see an error message$")
    public void iWantToSeeAnErrorMessage() throws Throwable {
        assertTrue(driver.findElement(By.id("ch1_error")).isDisplayed());
    }
    @When("^I enter a valid input:$")
    public void iEnterAValidInput(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(value);
        }
    }
    @Then("^I want to see the result$")
    public void iWantToSeeTheResult() throws Throwable {
        assertFalse(driver.switchTo().alert().getText().equals(""));
    }*/
}
