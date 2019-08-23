package pages_sample;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

/*
Individual Tasks: In Task2.feature create 1 scenario outline and create scenario or scenario outlines
for page https://kristinek.github.io/site/tasks/list_of_people or https://kristinek.github.io/site/tasks/list_of_people_with_jobs
in order to test that user can:
•    add a new person
•    edit a person
•    remove a person
•    reset original list after
•    adding a person
•    editing a person
•    removing a person
•    check that clear button on adding a user works correctly
*/

public class EmployeePage {
    @FindBy(how = How.XPATH, using = "//div[2]//button[1]") // By.id("name")
    private WebElement addPersonButton; // WebElement nameInput = driver.findElement(By.id("name"));

    @FindBy(how = How.XPATH, using = "//div[2]//button[2]") // By.name("age")
    private WebElement resetListButton;

    @FindBy(how = How.XPATH, using = "//li[@id='person0']//i[@class='fa fa-pencil']")
    private WebElement editFirstPerson;

    @FindBy(how = How.XPATH, using = "//li[@id='person0']//span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium'][contains(text(),'×')]") // By.className("error)
    private WebElement deleteFirstPerson;
}
