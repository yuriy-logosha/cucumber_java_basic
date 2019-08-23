package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import pages_sample.ListPage;

import java.util.List;


public class Task2Steps {
    private WebDriver driver;
    private ListPage listPage;

    public Task2Steps() {
        this.driver = Hooks.driver;
        PageFactory.initElements(this.driver, ListPage.class);
    }

    @Given("^I am on the people with jobs$")
    public void iAmOnThePeopleWithJob() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^I click on add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        driver.findElement(By.cssSelector("#addPersonBtn")).click();
    }

    @And("^I enter user name: \"([^\"]*)\"$")
    public void iEnterUserName(String name) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

    }

    @And("^I enter user surname: \"([^\"]*)\"$")
    public void iEnterUserSurname(String surname) {
        driver.findElement(By.id("surname")).clear();
        driver.findElement(By.id("surname")).sendKeys(surname);


    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);


    }

    @And("^I enter date of birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String dateOfBirth) {
        driver.findElement(By.id("dob")).clear();
        driver.findElement(By.id("dob")).sendKeys(dateOfBirth);

    }

    @And("^I tick language: \"([^\"]*)\"$")
    public void iTickLanguage(List<String> language) {
        ListPage.clearLanguage();
        ListPage.selectLanguage(language);
    }

    @And("^I choose gender: \"([^\"]*)\"$")
    public void iChooseGender(String gender) {
        ListPage.chooseGender(gender);

    }

    @And("^I choose status: \"([^\"]*)\"$")
    public void iChooseStatus(String status) {
        ListPage.chooseStatus(status);
    }

    @And("^I click add button$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.cssSelector("#modal_button")).click();
    }

    @When("^I click edit person button$")
    public void iClickEditPersonButton() throws Throwable {
        driver.findElement(By.cssSelector("#person1 > span.w3-closebtn.editbtn.w3-padding.w3-margin-right.w3-medium > i")).click();
    }

    @And("^I click edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.cssSelector("#modal_button")).click();

    }

    @And("^I click remove button$")
    public void iClickRemoveButton() throws Throwable {
        driver.findElement(By.cssSelector("#person0 > span.w3-closebtn.closebtn.w3-padding.w3-margin-right.w3-medium")).click();
    }

    @And("^I reset list$")
    public void iResetList() throws Throwable {
        driver.findElement(By.cssSelector("#addPersonBtn")).click();
    }

    @And("^I clear all fields$")
    public void iClearAllFields() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();

    }
}

