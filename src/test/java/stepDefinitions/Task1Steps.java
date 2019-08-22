package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    //Scenario:  Enter a too small number
    @Given("^I am on enter a number0 page$")
    public void iAmOnEnterNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I should see enter a number0 Tab window$")
    public void iShouldSeeEnterNumberTab1() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/h2")).getText());
    }

    @And("^I click on enter number0 window$")
    public void iClickEnterNumber() throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).click();
    }

    @When("^I enter number too small:$")
    public void iEnterSmallNumber(String name) throws Throwable {
        driver.findElement(By.id("input")).sendKeys("1");
    }

    @And("^I click on Submit$")
    public void iClickButton() throws Throwable {
        driver.findElement(By.id("button")).click();
    }

    @Then("^I see message Number is too small$")
    public void iShouldSeeNumberTooSmall1() throws Throwable {
        assertEquals("Number is too small",
                driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText());
    }

}
//Scenario:  Enter a too big number

//Scenario: Enter text

//Scenario: Enter correct number




