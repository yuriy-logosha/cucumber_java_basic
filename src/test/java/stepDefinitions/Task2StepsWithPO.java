package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.FormPage;
import pages_sample.ListPage;


import java.util.List;

public class Task2StepsWithPO {

    private WebDriver driver;
    static ListPage listPage;
    static FormPage formPage;


    public Task2StepsWithPO() {
        this.driver = Hooks.driver;
        listPage = PageFactory.initElements(Hooks.driver, ListPage.class);
        formPage = PageFactory.initElements(Hooks.driver, FormPage.class);
    }

    @Given("^I am on ListPage$")
    public void iAmOnListPage() {
        driver.get(listPage.getListPageUrl());
    }

    @When("^I click Add person button$")
    public void iPressAddPersonButton() {
        listPage.clickAddPerson();
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws InterruptedException {
        Thread.sleep(5000);
        formPage.clickAdd();
        Thread.sleep(5000);
    }

    @When("^I click edit person button$")
    public void iClickEditPersonButton() {
        listPage.clickEdit();
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() {
        formPage.clickEdit();
    }

    @Then("^I click remove person button$")
    public void iClickRemovePersonButton() {
        listPage.clickRemove();
    }

    @Then("^I click reset button$")
    public void iClickResetButton() {
        listPage.clickReset();
    }

    @And("^I click clear fields button$")
    public void iClickClearFieldsButton() {
        formPage.clickClearAll();
    }

    @Then("^I check fields cleared$")
    public void iCheckFieldsCleared() {
        formPage.checkAllCleared();
    }

    @And("^I enter user information: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserInformation(String jobTitle, List<String> languages, String status) {
        formPage.enterUserInformation(jobTitle, status);
    }

    @And("^I enter user data: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserData(String name, String surname) {
        formPage.enterUserName(name, surname);
    }

    @And("^I enter date of birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String dateOfBirth) {
        formPage.enterDateOfBirth(dateOfBirth);
    }

    @And("^I enter user gender: \"([^\"]*)\"$")
    public void iEnterUserGender(String gender) {
        formPage.enterGender(gender);
    }

    @And("^I enter user information: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserInformation(String jobTitle, String status) {
        formPage.enterUserInformation(jobTitle, status);
    }

    @And("^I enter languages: \"([^\"]*)\"$")
    public void iEnterLanguages(List<String> languages) {
        formPage.chooseLanguages(languages);
    }


    @Then("^I check if person added: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCheckIfPersonAdded(String name, String surname) {
        listPage.checkAdded(name, surname);
    }

    @Then("^I check if person removed$")
    public void iCheckIfPersonRemoved() {
        listPage.checkRemoved();
    }

    @Then("^I check person name changed to: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCheckPersonNameChangedTo(String name, String surname) {
        listPage.checkEdited(name, surname);

    }

    @Then("^I check person \"([^\"]*)\" \"([^\"]*)\" removed$")
    public void iCheckPersonRemoved(String name, String surname) {
        listPage.checkDeleted(name, surname);
    }
}