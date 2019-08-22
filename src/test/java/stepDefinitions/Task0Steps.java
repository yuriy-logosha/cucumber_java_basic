package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task0Steps {
    private WebDriver driver;

    public Task0Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the Google.com page$")
    public void iAmOnTheGoogleComPage() throws Throwable {
        driver.get("https://www.google.com");
    }

    @Then("^I should see the search box$")
    public void iShouldSeeTheSearchBox() throws Throwable {
        assertTrue(driver.findElement(By.name("q")).isDisplayed());
    }

    @And("^I should see the Im feeling lucky button$")
    public void iShouldSeetheImFeelingLuckyButton() throws Throwable {
        assertEquals("I'm Feeling Lucky", driver.findElement(By.xpath("//input[@value='I'm Feeling Lucky']")).getAttribute("value"));
    }

    @And("^I should see the Search button$")
    public void iShouldSeeTheSearchButton() throws Throwable {
        assertEquals("Google Search", driver.findElement(By.xpath("//input[@value='Google Search']")).getAttribute("value"));
    }
}
