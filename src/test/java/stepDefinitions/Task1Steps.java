package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages_sample.ListSample;
import pages_sample.FormSample;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Task1Steps {
    private WebDriver driver;
    static ListSample list;
    static FormSample form;

    public Task1Steps() {
        this.driver = Hooks.driver;

        list = PageFactory.initElements(driver, ListSample.class);
        form = PageFactory.initElements(driver, FormSample.class);
    }

    @Given("^I am on people list page$")
    public void iAmOnPeopleListPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }
    @When("^I click add new person button$")
    public void ClickNewPersonButton() throws Throwable {
        list.clickAddPerson1();
    }
    @And("^I enter person name: \"([^\"]*)\"$")
    public void EnterPersonName(String name) throws Throwable {
        form.enterName(name);
    }
    @And("^I enter person job: \"([^\"]*)\"$")
    public void EnterPersonJob(String job) throws Throwable {
        form.enterJob(job);
    }
    @And("^I click Add button$")
    public void ClickAddButton() throws Throwable {
        form.clickAddButton();
    }
    @And("^I see new person in list$")
    public void CheckPersonList() throws Throwable {
       assertEquals(list.getPersonListSize(),4);
    }
    @And("^I click Edit button$")
    public void ClickEditButton() throws Throwable {
        form.clickEditButton();
    }
    @When("^I click correct button$")
    public void ClickCorrectButton() throws Throwable {
        list.clickEditButton();
    }
    @Then("^Person name and job should be changed$")
    public void CheckEditingPerson() throws Throwable {
       assertEquals(list.checkFirstPersonJob(),"Test");
       assertEquals(list.checkFirstPersonName(),"Test");

    }



}