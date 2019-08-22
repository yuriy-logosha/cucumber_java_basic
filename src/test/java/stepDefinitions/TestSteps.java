package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages_sample.GooglePage;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestSteps {
	WebDriver driver;
	static GooglePage page;
	
	public TestSteps() {
		this.driver = Hooks.driver;
		page = new GooglePage(this.driver);
	}
	
	@Given("^I am on google webpage$")
	public void iAmOnGoogleWebpage() {
		driver.get("https://www.google.lv");
	}
	
	@When("^I enter word \"([^\"]*)\" in the search bar$")
	public void iEnterWorkInSearchBar(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page.enterSearchTerm(arg1);
	}

	@When("^press search button$")
	public void press_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		page.clickSearch();
	}

	@Then("^I should see some results$")
	public void i_should_see_some_apples_found() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(page.getResultCount() > 0);
	}
}
