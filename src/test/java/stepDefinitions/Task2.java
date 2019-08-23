package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class Task2 {
    private WebDriver driver;

    public Task2() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePagetask2() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");

    }

    @When("^add a new person$")
    public void iClickAddperson(Map<String, String> valuesToEnter) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"addPersonBtn\"]")).click();
        WebElement nameButton = driver.findElement(By.id("name"));
        nameButton.clear();
        nameButton.sendKeys(valuesToEnter.get("name"));
        WebElement surnameButton = driver.findElement(By.id("surname"));
        surnameButton.clear();
        surnameButton.sendKeys(valuesToEnter.get("surname"));
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();
    }

    @Then("^I see person on list$")
    public void iSeePersonOnList() throws Throwable {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"person3\"]")).isDisplayed());
    }

    @When("^i edit persons job: \"([^\"]*)\"$")
    public void editPerson(String job) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person3\"]/span[2]/i")).click();
        WebElement jobBox = driver.findElement(By.id("job"));
        jobBox.clear();
        jobBox.sendKeys(job);
        driver.findElement(By.xpath("//*[@id=\"modal_button\"]")).click();

  //      System.out.println("");
    }
    @Then("^i see persons job in list$")
    public void iSeePersonsJobOnList() throws Throwable {
        TestCase.assertEquals("engineer", driver.findElement(By.xpath("//*[@id=\"person3\"]/span[3]")));
    }

    @When("^i remove person$")
    public void removePerson() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"person0\"]/span[1]")).click();

    }

}
