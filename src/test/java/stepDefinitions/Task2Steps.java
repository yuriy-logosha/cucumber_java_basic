package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleListPage;
import pages_sample.PersonDataPage;

import java.util.List;

import static org.junit.Assert.*;

public class Task2Steps{

    private WebDriver driver;
    private static PeopleListPage listPage;
    private static PersonDataPage dataPage;

    public Task2Steps() throws InterruptedException {
        this.driver = Hooks.driver;
        listPage = PageFactory.initElements(driver, PeopleListPage.class);
        dataPage = PageFactory.initElements(driver, PersonDataPage.class);
    }

    @Given("^Open list of people page$")
    public void openListOfPeoplePage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^click on 'add person' button$")
    public void clickOnAddPersonButton() {
        listPage.clickAddButton();
    }

    @And("^set name as \"([^\"]*)\"$")
    public void setNameAs(String name) throws Throwable {
        dataPage.setName(name);

    }

    @And("^set surname \"([^\"]*)\"$")
    public void setSurname(String surname) throws Throwable {
        dataPage.setSurname(surname);
    }

    @And("^set job \"([^\"]*)\"$")
    public void setJob(String job) throws Throwable {
        dataPage.setJob(job);
    }

    @And("^set date of birth \"([^\"]*)\"$")
    public void setDateOfBirth(String dateOfBirth) throws Throwable {
        dataPage.setDateOfBirth(dateOfBirth);

    }

    @And("^set language \"([^\"]*)\"$")
    public void setLanguage(String language) throws Throwable {
        dataPage.setLanguage(language);
    }

    @And("^set gender \"([^\"]*)\"$")
    public void setGender(String gender) throws Throwable {
       dataPage.setGender(gender);
    }

    @And("^set employee status \"([^\"]*)\"$")
    public void setEmployeeStatus(String status) throws Throwable {
       dataPage.setStatus(status);
    }

    @Then("^click on add button$")
    public void clickOnAddButton() {
        dataPage.clickAddButton();
    }

    @Then("^assert new person was added with name \"([^\"]*)\" \"([^\"]*)\" and job \"([^\"]*)\" and status \"([^\"]*)\"$")
    public void assertNewPersonWasAddedWithNameAndJob(String name, String surname, String job, String status) throws Throwable {
        assertTrue(listPage.getNewPersonData().contains(name + " " + surname));
        assertTrue(listPage.getNewPersonData().contains("Job: " + job));
        assertTrue(listPage.getNewPersonData().contains(status));
    }

    @And("^assert new person date of birth \"([^\"]*)\", language \"([^\"]*)\" and gender \"([^\"]*)\"$")
    public void assertNewPersonDateOfBirthLanguageAndGender(String dateOfBirth, String language, String gender) throws Throwable {
        assertTrue(listPage.getNewPersonData().contains(dateOfBirth));
        assertTrue(listPage.getNewPersonData().contains(language));
        assertTrue(listPage.getNewPersonData().contains(gender));
    }

    @When("^click on edit person \"([^\"]*)\"$")
    public void clickOnEditPerson(int index) throws Throwable {
        listPage.clickEditPerson(index - 1);
    }

    @Then("^click on edit button$")
    public void clickOnEditButton() {
        dataPage.clickEditButton();
    }

    @And("^assert person \"([^\"]*)\" have name \"([^\"]*)\" and \"([^\"]*)\"$")
    public void assertPersonHaveNameAnd(int index, String name, String surname) throws Throwable {
        String personData = listPage.getPersonData(index - 1);
        assertTrue(personData.contains(name + " " + surname));
    }

    @Then("^click on delete person (\\d+)$")
    public void clickOnDeletePerson(int index) throws Throwable {
        listPage.clickDeletePerson(index - 1);
    }

    @When("^select person (\\d+)$")
    public void selectPerson(int index) throws Throwable {
        listPage.selectPerson(index - 1);
    }

    @And("^assert selected person was removed$")
    public void assertSelectedPersonWasRemoved() {
        List<WebElement> listOfPeople = listPage.getListOfPeople();
        for (WebElement listOfPerson : listOfPeople) {
            assertFalse(listOfPerson.getText().equalsIgnoreCase(listPage.getSelectedPerson()));
        }
    }

    @Then("^click on reset list$")
    public void clickOnResetList() {
        listPage.clickResetButton();
    }

    @And("^assert person list is of size (\\d+)$")
    public void assertPersonListIsOfSize(int size) {
        assertEquals(listPage.getListOfPeople().size(), size);
    }

    @And("^assert selected person was not removed$")
    public void assertSelectedPersonWasNotRemoved() {
        assertTrue(listPage.selectedPersonInList());
    }
}
