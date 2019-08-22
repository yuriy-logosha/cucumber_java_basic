package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("I am on the calculator home page$")
    public void iAmOnTheCalculatorHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I enter number too small and press Submit button$")
    public void iEnterTooSmallNumber() throws Throwable {
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']"));

        inputField.sendKeys("5");
        submitButton.click();
    }

    @And("^I see error message that number is too small$")
    public void iSeeErrorMessageSmall() throws Throwable {
        WebElement errorMessage = driver.findElement(By.xpath("//p[@id='ch1_error']"));
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));

        assertEquals("Number is too small", errorMessage.getText());
        inputField.clear();
    }

    @Then("^I enter number too big and press Submit button$")
    public void iEnterTooBigNumber() throws Throwable {
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']"));

        inputField.sendKeys("111");
        submitButton.click();
    }

    @And("^I see error message that number is too big$")
    public void iSeeErrorMessageBig() throws Throwable {
        WebElement errorMessage = driver.findElement(By.xpath("//p[@id='ch1_error']"));
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));

        assertEquals("Number is too big", errorMessage.getText());
        inputField.clear();
    }

    @Then("^I enter text and press Submit button$")
    public void iEnterText() throws Throwable {
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']"));

        inputField.sendKeys("ACCENTURE");
        submitButton.click();
    }

    @And("^I see error message that we need number to be entered$")
    public void iSeeErrorMessageText() throws Throwable {
        WebElement errorMessage = driver.findElement(By.xpath("//p[@id='ch1_error']"));
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));

        assertEquals("Please enter a number", errorMessage.getText());
        inputField.clear();
    }

    @Then("^I enter correct number and press Submit button$")
    public void iEnter81() throws Throwable {
        WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']"));

        inputField.sendKeys("81");
        submitButton.click();
    }

    @And("^I see square root calculations results$")
    public void iSeeSquareRoot() throws Throwable {
        //WebElement inputField = driver.findElement(By.xpath("//input[@id='numb']"));

        Alert alert = driver.switchTo().alert();

        assertEquals("Square root of 81 is 9.00", alert.getText());
        //alert.accept();
        //inputField.clear();
    }
}
