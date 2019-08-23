package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class EmployeeSteps {

    private WebDriver driver;
    static EmployeePage employeePage;

    public EmployeeSteps() {
        this.driver = Hooks.driver;
        employeePage = PageFactory.initElements(Hooks.driver, EmployeePage.class);
    }


    public static String getEmployeePageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs";
    }

    @Given("^I am on kristinek Employee page$")
    public void iAmOnEmployeePage() throws Throwable {
        driver.get(getEmployeePageUrl());
    }

    @When("^I click on add person button using PO$")
    public void iAddNewEmployee() throws Throwable {
        employeePage.clickSubmit();
    }

    @And("^I enter Employee \"([^\"]*)\" using PO$")
    public void iEnterEmloployeeName(String name) throws Throwable {
        employeePage.enterEmployeeName(name);
    }

    @And("^I enter Employee job \"([^\"]*)\" using PO$")
    public void iEnterEmployeeJobUsingPO(String jobTitle) throws Throwable {
        employeePage.enterJobTitle(jobTitle);
    }

    @Then("^New Employee is added to the database using PO$")
    public void newEmployeeIsAddedToTheDatabaseUsingPO() {
        employeePage.clickToaddEmployeeToTheList();
    }

    @And("^I check does new Employee exists using PO$")
    public void iCheckDoesNewEmployeeExistsUsingPO() {
        assertEquals(employeePage.employeeListSize(),4);
    }

    @When("^I click on edit person button using PO$")
    public void iClickOnEditPersonButtonUsingPO() {
        employeePage.editIconClick();
    }
}
