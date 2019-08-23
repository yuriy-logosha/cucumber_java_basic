package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task2Steps {

    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the list with people and jobs page$")
    public void iAmOnListpage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }
///////////////////////////////////////////dding a new person
    @When("^I click Add person button$")
    public void iClickAddPersonButton() {
        driver.findElement(By.xpath("//button[@onclick='openModalForAddPersonWithJob()']")).click();
    }
    @And("^I enter values: \"([^\"]*)\"$")
    public void iEnterValues(Map<String, String> values) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(values.get("name"));
        driver.findElement(By.id("job")).sendKeys(values.get("job"));
    }
    @And("^I click Add button to add$")
    public void iClickAddButton() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }
    @Then("^I see that new person and job added$")
    public void iSeeNewPersonAdded(String error) throws Throwable {
        driver.findElement(By.id("person3"));
    }

//////////////////////////////////////////////////Edit a person
    @When("^I click on person Pencil button$")
    public void iClickPencilbutton() throws Throwable {
        driver.findElement(By.className("fa-pencil")).click();
    }
    @And("^I change name add letter A at the end for editing$")
    public void iChangeName() throws Throwable {
        driver.findElement(By.id("name")).sendKeys("A");
    }
    @And("^I click on Edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.id("modal_button"));
    }
    @Then("^I see changed Mike name$")
    public void iSeeChengedName() throws Throwable {
        driver.findElement(By.xpath("//span[contains(.,'MikeA')]"));//wrong path
    }

////////////////////////////////////////////////////Remove a person
    @When("^I click on zero person Delete button$")
    public void iClickDeleteButton() throws Throwable {
        driver.findElement(By.xpath("//span[@onclick='deletePerson(0)']")).click();
    }
    @Then("^I see zero person is deleted after remove$")
    public void iSeePersonDeleted(String error) throws Throwable {
        assertEquals(error, driver.findElement(By.xpath("//button[@onclick='deletePerson(0)']")).getText());
    }

/////////////////////////////////////////////////////Add and reset
    @When("^I click add person button for reset$")
    public void iClickAddPersonButtonForReset() {
        driver.findElement(By.xpath("//button[@onclick='openModalForAddPersonWithJob()']")).click();
    }
    @And("^I enter Irina name and Tester job for reset$")
    public void iEnterValuesForReset(Map<String, String> values) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(values.get("name"));
        driver.findElement(By.id("job")).sendKeys(values.get("job"));
    }
    @And("^I click add button to reset$")
    public void iClickAddButtonForReset() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }
    @And("^I click Reset List button after add$")
    public void iClickResetButton() throws Throwable {
        driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']")).click();
    }
    @Then("^I see list is reset after add$")
    public void iSeeListResetAfterAddind() throws Throwable {
        driver.findElement(By.id("person4"));
    }

/////////////////////////////////////////////////////Edit and reset
    @When("^I click on zero person pencil button$")
    public void iClickPencilbuttonForReset() throws Throwable {
        driver.findElement(By.className("fa-pencil")).click();
}
    @And("^I change name add letter A at the end before reset$")
    public void iChangeNameForReset() throws Throwable {
        driver.findElement(By.id("name")).sendKeys("A");
    }
    @And("^I click on edit button before reset$")
    public void iClickEditButtonForReset() throws Throwable {
        driver.findElement(By.id("modal_button"));
    }
    @And("^I see changed Mike name before reset$")
    public void iSeeChengedNameForReset() throws Throwable {
        driver.findElement(By.xpath("//span[contains(text(),'MikeA')]"));//wrong path
    }
    @And("^I click Reset List button after edit$")
    public void iClickResetButtonForReset2() throws Throwable {
        driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']")).click();
    }
    @Then("^I see list is reset after edit$")
    public void iSeeEditedListForReset(String error) throws Throwable {
        assertEquals(error, driver.findElement(By.xpath("//span[contains(text(),'MikeA')]")));
    }
////////////////////////////////////////////////////////Remove and reset
    @When("^I click on zero person delete button before reset$")
    public void iClickDeleteButtonForReset() throws Throwable {
        driver.findElement(By.xpath("//span[@onclick='deletePerson(0)']")).click();
}
    @And("^I see zero person is deleted before reset$")
    public void iSeePersonDeletedForReset(String error) throws Throwable {
        assertEquals(error, driver.findElement(By.xpath("//button[@onclick='deletePerson(0)']")).getText());
    }
    @And("^I click Reset List button after remove$")
    public void iClickResetButtonForReset3() throws Throwable {
        driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']")).click();
    }
    @Then("^I see list is reset after remove$")
    public void iSeeDeletedListForReset(String error) throws Throwable {
        String m = "Mike";
        WebElement persona = driver.findElement(By.id("person0"));
        assertTrue(persona.getText().equals(m));
    }
///////////////////////////////////////////////////Add and clear
    @When("^I click add person button for clear$")
    public void iClickAddPersonButtonForReset4() {
        driver.findElement(By.xpath("//button[@onclick='openModalForAddPersonWithJob()']")).click();
    }
    @And("^I enter Irina name and Tester job for clear$")
    public void iEnterValuesForReset4(Map<String, String> values) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(values.get("name"));
        driver.findElement(By.id("job")).sendKeys(values.get("job"));
    }
    @And("^I click Clear all fields button$")
    public void iClickClearButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }
    @Then("^I check fields are empty$")
    public void emptyField() throws Exception {
        WebElement NameArea = driver.findElement(By.id("name"));
        assertTrue((NameArea.getText().equals("")) || NameArea.getText().equals("null"));
        WebElement JobArea = driver.findElement(By.id("job"));
        assertTrue((JobArea.getText().equals("")) || JobArea.getText().equals("null"));
    }
}

