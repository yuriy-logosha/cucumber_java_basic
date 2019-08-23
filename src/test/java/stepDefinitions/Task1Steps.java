package stepDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;
    public Task1Steps() {
        this.driver = Hooks.driver;
    }
   @When("^I am on the enter a number page$")
    public void iAmOnTheEnterAnumberPage(){
       driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
   }
    @Then("^I enter number: (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));

    }
    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector("body > div.w3-row > div > div > div.w3-container.w3-card-4 > button")).click();
    }

    @Then("^I see message1: \"([^\"]*)\"$")
    public void iSeeMessage1(String message) {
        assertEquals(message, driver.findElement(By.id("ch1_error")));
    }

    @Then("^I see an alert with message: \"([^\"]*)\"$")
    public void iSeeAlertWithMessage(String message) {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }
}


