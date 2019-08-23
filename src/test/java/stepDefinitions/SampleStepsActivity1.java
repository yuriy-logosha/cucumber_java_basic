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

public class SampleStepsActivity1 {
    private WebDriver driver;

    public SampleStepsActivity1() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on Google page$")
    public void iAmOnGooglePage() throws Throwable {
        driver.get("https://www.google.com/");
    }

    @Then("^I should see input field$")
    public void iShouldSeeInputField() throws Throwable {
        driver.findElement(By.className("RNNXgb"));
    }

    @And("^I should see Search button$")
    public void iShouldSeeSearchButton() throws Throwable {
        driver.findElement(By.className("gNO89b"));
    }
    @And("^I should see Lucky button$")
    public void iShouldSeeLuckyButton() throws Throwable {
        driver.findElement(By.className("RNmpXc"));
    }

    @Then("^new <person> displays on the list$")
    public void newPersonDisplaysOnTheList() {
    }
}
