import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class Task2Steps {
    private WebDriver driver;

    @Given("^I am on People with jobs page$")

       public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When("I click add person button")
    public void Iclickaddpersonbutton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }
    @And("^I enter a name: \"([^\"]*)\"$")
    public void ienteraname(String name) throws Throwable {
       driver.findElement(By.className("w3-input")).clear();
       driver.findElement(By.className("w3-input")).sendKeys();
        }

    @And("^I enter a job: \"([^\"]*)\"$")
    public void iEnterAJob (String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys();

    }
    @And("I click add button")
    public void iClickAddButton (String button) throws Throwable {
        driver.findElement(By.id("modal_button")).click();

    }
    @Then("new person added")
    public void newPersonAdded() throws Throwable {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person4\"]/span[3]")).isDisplayed());

    }
    @When("I click edit button for IB")
    public void iEditAPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person4\"]/span[3]")).click();
    }
    @And("^I enter other name: \"([^\"]*)\"$")
    public void iEnterOtherName (String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys();

        }
    @And("I click edit button")
    public void iClickEditButton () throws Throwable {
        driver.findElement(By.id("modal_button")).click();
        }

     @Then("I see other name")
     public void iSeeOtherName () throws Throwable {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person4\"]/span[3]")).isDisplayed());
        }

}





