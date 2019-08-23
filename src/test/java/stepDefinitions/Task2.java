package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import gherkin.formatter.model.Background;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Task2 {
    private WebDriver driver;

    public Task2() {
        this.driver = Hooks.driver;
    }

    // Background
    @Given ("^I am on the main job page$")
    public void mainPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @And("^I click button - add person$")
    public void ButtonAddPerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }
    //Scenario 1
    @When("^I Enter data in creating new person$")
    public void enterData(Map<String, String> valuesToEnter) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(valuesToEnter.get("name"));
        driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(valuesToEnter.get("surname"));
         //driver.findElement(By.xpath("//*[@id=\"job\"]")).sendKeys(valuesToEnter.get(("job")));
         //driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys(valuesToEnter.get("language"));
        //driver.findElement(By.xpath("//*[@id=\"english\"]")).isSelected();
        //driver.findElement(By.xpath("//*[@id=\"female\"]")).isSelected();
        //driver.findElement(By.xpath("//*[@id=\"status\"]/option[1]")).isSelected();
    }

    @And("^I press add$")
    public void add() throws Throwable {
        WebElement addButton = driver.findElement(By.id("modal_button"));
        addButton.click();
    }

    @And("^I press edit Button$")
    public void editButton() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person3\"]/span[2]/i")).click();
    }

    @And("^I change the name$")
    public void changeName() throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Diana");
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click(); // Press edit button
    }

    // @Then("^I see the changed data$")
    public void seeChangedName() throws Throwable {
        assertEquals("name ", driver.findElement(By.xpath("//*[@id=\"person4\"]/div/span[1]")).getAttribute("value"));
    }

    @When("^I remove the person$")
    public void removePerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @When("I press button reset list$")
    public void resetList() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @Then("^I see the original list$")
    public void originalList() throws Throwable {
        assertFalse(driver.findElement(By.xpath("//*[@id=\"listOfPeople\"]/div[4]")).isDisplayed());
    }

    // Scenario 2
    @When("^Enter data that I will change$")
        public void enterDataSecondTime(Map<String, String> valuesToEnter) throws Throwable {
            driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(valuesToEnter.get("name"));
            driver.findElement(By.xpath("//*[@id=\"surname\"]")).sendKeys(valuesToEnter.get("surname"));
        driver.findElement(By.id("job")).sendKeys(valuesToEnter.get(("job")));
       // driver.findElement(By.id("dob")).sendKeys();
       // driver.findElement(By.id("english")).isSelected();
        //driver.findElement(By.id("female")).isSelected();
        //driver.findElement(By.xpath("//*[@id=\"status\"]/option[1]")).isSelected();
    }

    @And("I press clear all field button$")
    public void clearAllFields() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
    }

    @Then("I see all fields are empty$")
    public void allFieldsAreEmpty() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("surname")).getText());
        //assertEquals("", driver.findElement(By.id("job")).getText());
       // assertEquals("", driver.findElement(By.id("dob")).getText());
       // assertTrue(driver.findElement(By.id("English")).isSelected());
      //  assertFalse(driver.findElement(By.id("female")).isSelected());
       // assertTrue(driver.findElement(By.xpath("//*[@id=\"status\"]")).isSelected());
    }


}