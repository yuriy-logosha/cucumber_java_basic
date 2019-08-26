package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @And("^Click submit button$")
    public void clickSubmitButton() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("^Assert result error: \"([^\"]*)\"$")
    public void assertResult (String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^Open webpage$")
    public void openWebpage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^Number: \"(.*)\" is entered$")
    public void whenNumberIsEntered(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @Then("^Assert correct result \"([^\"]*)\"$")
    public void assertCorrectResult(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

}