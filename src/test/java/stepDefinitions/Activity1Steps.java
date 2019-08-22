package stepDefinitions;

import cucumber.api.PendingException;
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

public class Activity1Steps {
    private WebDriver driver;

    public Activity1Steps() {
    this.driver = Hooks.driver;
    }

    @Given("^I am on the \"google.lv\" page$")
    public void iAmOnThePage() throws Throwable {
        driver.get("https://google.lv");
             driver.get("https://www.google.lv");
    }

    @Then("^I should see header logo$")
    public void iShouldSeeHeaderLogo() throws Throwable {
        driver.findElement(By.id("hplogo"));
    }

    @And("^I should see \"Es ticu veiksmei!\" button$")
    public void iShouldSeeButton() throws Throwable {
        driver.findElement(By.className("RNmpXc"));
    }

    @And("^I press \"Es ticu veiksmei!\" button$")
    public void iClickbutton() throws Throwable {
        driver.findElement(By.className("gLFyf")).click();
    }
}
