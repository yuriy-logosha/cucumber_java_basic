import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import static org.junit.Assert.*;

public class Task2MyStepdefs {
    private WebDriver driver;

    public Task2MyStepdefs() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on people with jobs page$")
    public void iAmOnPeopleWithJobsPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");

    }

    @When("^I click add person$")
    public void iClickAddPerson() {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I am on adding page$")
    public void iAmOnAddingPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }

    @And("^I enter \"([^\"]*)\" in name field$")
    public void iEnterInNameField(String arg0) throws Throwable {
        driver.findElement(By.id("name")).sendKeys("Name");
    }

    @And("^I enter \"([^\"]*)\" in job field$")
    public void iEnterInJobField(String arg0) throws Throwable {
        driver.findElement(By.id("job")).sendKeys("Job");
    }

    @And("^I click add$")
    public void iClickAdd() {
        driver.findElement(By.xpath("//a[text()='Add']")).click();
    }

    @Then("^I see a new person$")
    public void iSeeANewPerson() {
        assertEquals("Zina",driver.findElement(By.id("person3")).getText());
    }

    @When("^I click edit$")
    public void iClickEdit() {
        driver.findElement(By.className("fa fa-pencil")).click();
    }

    @And("^I am on editing page$")
    public void iAmOnEditingPage() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=3");
    }


    @And("^I enter another \"([^\"]*)\" in name field$")
    public void iEnterAnotherInNameField(String arg0) throws Throwable {
        driver.findElement(By.id("name")).sendKeys("Name");
    }

    @And("^I click edit again$")
    public void iClickEditAgain() {
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
    }

    @And("^I see edited person$")
    public void iSeeEditedPerson() {
        assertEquals("Masha",driver.findElement(By.id("person3")).getText());
    }


    @And("^I click on delete first person from the list$")
    public void iClickOnDeleteFirstPersonFromTheList() {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }


    @Then("^I see edited person is removed$")
    public void iSeeEditedPersonIsRemoved() {
        assertFalse(driver.findElement(By.id("person3")).isDisplayed());
    }

    @When("^I click on reset$")
    public void iClickOnReset() {
        driver.findElement(By.xpath("//a[text()='Reset List']")).click();
    }

    @Then("^I see the same list of persons$")
    public void iSeeTheSameListOfPersons() {
        
    }


    @And("^I enter another \"([^\"]*)\" in job field$")
    public void iEnterAnotherInJobField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I click clear all fields$")
    public void iClickClearAllFields() {
        
    }

    @Then("^I see all fields are cleared$")
    public void iSeeAllFieldsAreCleared() {
    }


}
