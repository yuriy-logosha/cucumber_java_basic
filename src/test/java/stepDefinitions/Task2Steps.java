package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages_sample.Task2AddUserForm;
import pages_sample.Task2ListOfPeople;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task2Steps {
    private WebDriver driver;
    static Task2AddUserForm addUserForm;
    static Task2ListOfPeople listOfPeople;

    public Task2Steps() {
        this.driver = Hooks.driver;
        addUserForm = PageFactory.initElements(Hooks.driver, Task2AddUserForm.class);
        listOfPeople = PageFactory.initElements(Hooks.driver, Task2ListOfPeople.class);
    }

    @Given("^I am on List of People page$")
    public void iAmOnListOfPeoplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^I check current list$")
    public void iCheckCurrentList() throws Throwable {
        List<WebElement> initList = new ArrayList(listOfPeople.getNameList());
        /*for (WebElement e : listOfPeople.nameList) {
            e.getText();
        }*/
        Thread.sleep(3000);
    }
    @And("^I click Add Person button$")
    public void iClickAddPersonButton() throws Throwable {
        listOfPeople.addPerson.click();
    }

    @And("^I fill the input fields:$")
    public void iFillTheInputFields(Map<String, String> values) throws Throwable {
        for (Map.Entry<String, String> el : values.entrySet()) {
            switch (el.getKey()) {
                case "name":
                    addUserForm.name.sendKeys(el.getValue());
                    break;
                case "surname":
                    addUserForm.surname.sendKeys(el.getValue());
                    break;
                case "job":
                    addUserForm.job.sendKeys(el.getValue());
                    break;
                case "dob":
                    addUserForm.dob.sendKeys(el.getValue());
                    break;
                case "language":
                    List<WebElement> cBox = driver.findElements(By.xpath("//input[contains(@class, 'w3-check')]"));
                    for (WebElement we : cBox) {
                        if(we.isSelected()) {
                            we.click();
                        }
                    }
                    switch (el.getValue()) {
                        case "english":
                            addUserForm.english.click();
                            break;
                        case "french":
                            addUserForm.french.click();
                            break;
                        case "spanish":
                            addUserForm.spanish.click();
                            break;
                    }
                    break;
                case "gender":
                    switch (el.getValue()) {
                        case "male":
                            addUserForm.male.click();
                            break;
                        case "female":
                            addUserForm.female.click();
                            break;
                    }
                    break;
                case "status":
                    Select sel = new Select(addUserForm.status);
                    sel.selectByValue(el.getValue());
                    break;
            }
        }
    }
    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        addUserForm.addButton.click();
    }
}
