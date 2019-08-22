package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the google home page")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://www.google.com/?hl=en");
    }
    @Then("^I should see Feeling Lucky button$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("I'm Feeling Lucky",
                driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[2]")).getAttribute("value"));
    }
}
