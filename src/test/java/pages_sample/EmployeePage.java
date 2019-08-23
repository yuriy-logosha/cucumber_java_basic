package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

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

public class EmployeePage<persons> {
    //Extracted add button
    @FindBy(how = How.XPATH, using = "//div[2]//button[1]") // By.id("name")
    private WebElement addPersonButton; // WebElement nameInput = driver.findElement(By.id("name"));

    //Extracted reset button
    @FindBy(how = How.XPATH, using = "//div[2]//button[2]") // By.name("age")
    private WebElement resetListButton;

    //Extracted edit button
    @FindBy(how = How.XPATH, using = "//li[@id='person0']//i[@class='fa fa-pencil']")
    private WebElement editFirstPerson;

    //Extracted delete button
    @FindBy(how = How.XPATH, using = "//li[@id='person0']//span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium'][contains(text(),'×')]") // By.className("error)
    private WebElement deleteFirstPerson;

    //Created method to click on the add button to insert a new employee in the list
    public void clickSubmit() {
        addPersonButton.click();
    }

    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement nameInputField;

    public void enterEmployeeName(String name) {
        nameInputField.clear();
        nameInputField.sendKeys(name);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='job']")
    private WebElement jobInputField;

    public void enterJobTitle(String jobTitle) {
        jobInputField.clear();
        jobInputField.sendKeys(jobTitle);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    private WebElement addEmployeeApprovalButton;

    public void clickToaddEmployeeToTheList () {
        addEmployeeApprovalButton.click();
    }

    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16")
    List<WebElement> EmployeeList;

    public int employeeListSize () {
        return EmployeeList.size();
    }

    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-pencil']")
    List<WebElement> editIconList;

    public void editIconClick () {
        editIconList.get(3).click();
    }
}
