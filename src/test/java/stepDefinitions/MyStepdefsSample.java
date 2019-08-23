package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class MyStepdefsSample {
    private WebDriver driver;
    private String removedId;

    public MyStepdefsSample() {this.driver = Hooks.driver; }

    @Given("^I am on sample page$")
    public void iAmOnSamplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^enter \"([^\"]*)\"$")
    public void enter(String numb) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(numb));

    }

    @And("^I click submit$")
    public void iClickSubmit() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']")).click();
    }

    @Then("^I see message \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^I see accepted message \"([^\"]*)\"$")
    public void iSeeAcceptedMessage(String okmsg) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(okmsg, driver.switchTo().alert().getText());
    }


    @Given("^I am on task page$")
    public void iAmOnTaskPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When("^I click add person$")
    public void iClickAddPerson()throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @Then("^I see new page$")
    public void iSeeNewPage() throws Throwable {
    assertEquals("", driver.findElement(By.id("name")).getAttribute("value"));
    }

    @When("^I click edit person$")
    public void iClickEditPerson() throws Throwable {
        driver.findElement(By.xpath("//li[@id='person0']//span[@class='w3-closebtn editbtn w3-padding w3-margin-right w3-medium']")).click();
    }

    @Then("^I see new edit page$")
    public void iSeeNewEditPage() throws Throwable {
        assertEquals("Edit", driver.findElement(By.id("modal_button")).getText());
    }

    @When("^I click remove person$")
    public void iClickRemovePerson() throws Throwable {
        driver.findElement(By.xpath("//li[@id='person0']//span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium'][contains(text(),'×')]")).click();
        removedId = "person0";
    }

    @Then("^I see new remove page$")
    public void iSeeNewRemovePage() throws Throwable {
        assertEquals(0, driver.findElements(By.id(removedId)).size());
    }

    @When("^I click reset list$")
    public void iClickResetList()throws Throwable {
        driver.findElement(By.xpath("//div[2]//button[2]")).click();

    }

    @Then("^I see reset page$")
    public void iSeeResetPage() throws Throwable {
        assertEquals(1, driver.findElements(By.id(removedId)).size());
    }

    @And("^I enter person values$")
    public void iEnterPersonValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I click add$")
    public void iClickAdd() throws Throwable {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^I see person$")
    public void iSeePerson() throws Throwable {
        assertTrue(driver.findElement(By.id("person3")).isDisplayed());
    }

    @When("^I click edit new person$")
    public void iClickEditNewPerson() throws Throwable {
        driver.findElement(By.xpath("//li[@id='person3']//span[@class='w3-closebtn editbtn w3-padding w3-margin-right w3-medium']")).click();
    }

    @And("^I enter person new values$")
    public void iEnterPersoneditValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
}

    @And("^I click remove new person$")
    public void iClickRemoveNewPerson() throws Throwable {
        driver.findElement(By.xpath("//li[@id='person3']//span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium'][contains(text(),'×')]")).click();
    }

    @Then("^I see person removed$")
    public void iSeePersonRemoved() throws Throwable {
        assertEquals(0, driver.findElements(By.id("person3")).size());
    }

    @And("^I check fields$")
    public void iCheckFields() throws Throwable {
        assertEquals("Ann", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("QA", driver.findElement(By.id("job")).getAttribute("value"));
    }

    @And("^I click clear button$")
    public void iClickClearButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
        
    }

    @Then("^I see empty fields$")
    public void iSeeEmptyFields() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("", driver.findElement(By.id("job")).getAttribute("value"));
    }
}

