package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the google home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://www.google.com/?hl=ru");
    }

    @Then("^I should see search button$")
    public void iShouldSeeSearchButton() throws Throwable {
        assertEquals("Поиск в Google",
                driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).getAttribute("value"));
    }

    /*@And("^I should see home page's input field for search$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }
    @When("^I enter search request: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @When("^I enter search request$")
    public void iEnterSearchRequest(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }*/
}
