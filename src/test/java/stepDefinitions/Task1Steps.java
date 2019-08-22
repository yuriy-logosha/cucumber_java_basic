package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.*;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the Enter a Number form$")
    public void iAmOnTheEnterANumberForm() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter value:$")
    public void iEnterValue(List<String> input) throws Throwable {
        for (String value : input) {
            System.out.println(value);
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys(value);
        }
    }
    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }
    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String message) throws Throwable {
        assertTrue(driver.findElement(By.id("ch1_error")).getText().equals(message));
    }
    @Then("^I see alert with result:$")
    public void iSeeAlertWithResult(List<String> message) throws Throwable {
        for (String value : message) {
            Alert alert = driver.switchTo().alert();
            assertTrue(alert.getText().equals(value));
            alert.accept();
        }
    }
}
