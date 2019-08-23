package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.BitSet;

public class MyStepdefsTask1 {
    private Webdriver driver;

    @Given("^I am on age page$")
    public void iAmOnTheAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }


    @When("^I enter value: \"<value>'$")
    public void iEnterValueValue() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I enter age: \"([^\"]*)\"$")
    public void iEnterAge(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private class Webdriver {
        public void get(String s) {
        }
    }
}
