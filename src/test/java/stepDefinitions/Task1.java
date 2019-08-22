package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1 {
    private WebDriver driver;

    public Task1() {
        this.driver = Hooks.driver;
    }

    @Given("^i am on page$")
    public void iAmOnPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^i enter number too small$")
    public void enterNumberTooSmall(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("10");
    }

    @Then("^error$")
    public void error() throws Throwable {
        assertEquals("Number is too small", driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText());

    }

    @When("^i enter number too big$")
    public void numberTooBig(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("200");
    }

    @Then("^error2$")
    public void error2() throws Throwable {
        assertEquals("Number is too big", driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText());

    }

    @When("^i enter text$")
    public void enterText(String text) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("abc");
    }

    @Then("^error3$")
    public void error3() throws Throwable {
        assertEquals("Please enter a number", driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText());

    }

    @When("^i enter correct number$")
    public void correctNumber(double number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys("81");
    }

    @Then("^result$")
    public void result() throws Throwable {
        assertEquals("Square root of 81 is 9.00", driver.switchTo().alert().getText());

    }



}
