package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.Assert.*;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on square root page$")
    public void iAmOnSquareRootPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^Click submit button$")
    public void clickSubmitButton() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter value:$")
    public void iEnterValue(List<String> number) throws Throwable {
        for (String s : number) {
            driver.findElement(By.id("numb")).clear();
            driver.findElement(By.id("numb")).sendKeys((CharSequence) s);
        }
    }

    @And("^I click button$")
    public void iClickButton() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^Alert message occurs:$")
    public void alertMessage(List<String> text) throws Throwable {
        for (String s : text) {
            assertTrue(driver.switchTo().alert().getText().contains(s));
        }
    }


}