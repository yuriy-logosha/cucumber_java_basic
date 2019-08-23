package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on kristinek page")
    public void iAmOnThekristinekPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }
    @When("^When I enter number \"([^\"]*)\"$")
    public void EnterNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
    }
    @And("^I click submit button$")
    public void iClickSubmitbutton() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }
    @Then("^I see result in alert: \"([^\"]*)\"$")
    public void iSeeresult(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
        // assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

     @Then("^I see result error: \"([^\"]*)\"$")
     public void iSeeErr(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
      }





}
