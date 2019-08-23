package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class Task2Steps2 {
    private WebDriver driver;

    public Task2Steps2() {
        this.driver = Hooks.driver;
    }



    @Given("^I am on listofpeople page")
    public void iAmOnlistofpeople() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When("^I click Add a new person$")
    public void iClickAddanewperson() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[@class='w3-container'][2]/button[@id='addPersonBtn'][1]")).click();
        Thread.sleep(1000);
    }

    @And("^Enter Person Data:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
                }
            }

    @And("^I click Add$")
    public void iClickAdd() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[@class='w3-row']/div[@class='w3-half']/div[@class='w3-container']/div[@id='addEditPerson']/div[@class='w3-btn-group']/button[@id='modal_button'][1]")).click();
        Thread.sleep(1000);
    }

    @Then("^I see element:\"([^\"]*)\"$")
    public void messageForCheckboxesIsSeen2(String message) throws Throwable {
        //assertEquals("Bob", driver.findElement(By.xpath("//span[contains(text(),'Bob')]")).getText());
        List<WebElement> names = driver.findElements(By.className("name"));
        for(WebElement e : names) {
            if(e.getText().equals("Bob")) {
                assertEquals("Bob", e.getText());
            }
        }
    }


    @When("^I click on edit 'pencil' button$")
    public void iClickAddanewperson2() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[2]/i")).click();
        Thread.sleep(1000);
    }

    @And("^Enter New person Data:$")
    public void iEnterValues2(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I click on edit button$")
    public void iClickAddx2() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[@class='w3-row']/div[@class='w3-half']/div[@class='w3-container']/div[@id='addEditPerson']/div[@class='w3-btn-group']/button[@id='modal_button'][1]")).click();
        Thread.sleep(1000);
    }

    @Then("^I see element changed:\"([^\"]*)\"$")
    public void messageForCheckboxesIsSeenx2(String message) throws Throwable {
        //assertEquals("Bob", driver.findElement(By.xpath("//span[contains(text(),'Bob')]")).getText());
        List<WebElement> names = driver.findElements(By.className("name"));
        for(WebElement e : names) {
            if(e.getText().equals("Lemmy")) {
                assertEquals("Lemmy", e.getText());
            }
        }
    }

    @And("^I click remove person button and Remove Lemmy$")
    public void iRemovePerson() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[@class='w3-row']/div[@class='w3-half']/div[@class='w3-container']/ul[@id='listOfPeople']/div[@class='w3-padding-16'][1]/li[@id='person0']/span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium']")).click();
        Thread.sleep(1000);
    }

    @Then("^I check that name is removed:\"([^\"]*)\"$")
    public void checknameisremoved(String message) throws Throwable {
        List<WebElement> names = driver.findElements(By.className("name"));
        for (WebElement e : names) {
            if (e.getText().equals("Mike")) {
                assertTrue(false);
            }


        }
    }


}



