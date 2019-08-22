package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en_tx.Givenyall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task1Steps {

    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Givenyall("^I am on Enter a number page$")
    public void iAmOnTheEnteranumberpage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @And("^I enter value: (\\d+)$")
    public void iEnterValue(int value) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(value));

    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

}