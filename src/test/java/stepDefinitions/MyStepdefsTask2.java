package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class MyStepdefsTask2 {
    public WebDriver driver;

    public MyStepdefsTask2() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with job page$")
    public void iAmOnPeopleWithJobPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click Add person button$")
    public void iClickAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

/*    @And("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }*/

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^new person displays on the list$")
    public void newPersonDisplaysOnTheList() throws Throwable {
        driver.findElement(By.id("person3")).getText();
    }

    @When("^I click edit icon$")
    public void iClickEditIcon() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
    }

    @And("^I enter another name: \"([^\"]*)\"$")
    public void iEnterAnotherName(String anname) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(anname);
    }

    @And("^I enter another job: \"([^\"]*)\"$")
    public void iEnterAnotherJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @Then("^edited person displays on the list$")
    public void editedPersonDisplaysOnTheList() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[3]")).getText();
    }

    @When("^I click removing icon$")
    public void iClickRemovingIcons() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();
    }

    @Then("^selected person is deleted$")
    public void selectedPersonIsDeleted() throws Throwable {
        //assertFalse(driver.findElement(By.id("person0")).isDisplayed());
        assertEquals(2, driver.findElements(By.className("w3-padding-16")).size());
    }

}
