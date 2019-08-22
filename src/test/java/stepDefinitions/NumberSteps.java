package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages_sample.NumberPage;

public class NumberSteps {
	private WebDriver driver;
	private NumberPage page;
	private Alert alert;
	
	public NumberSteps() {
		this.driver = Hooks.driver;
		page = new NumberPage(driver);
	}
	
	@Given("^I am on the number entering page$")
	public void iAmOnPage() {
		driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
	}
	
	@When("^I enter input: \"([^\"]*)\"$")
	public void iEnterInput(String input) {
		page.setInput(input);
	}
	
	@And("^click submit$")
	public void clickSubmit() {
		page.clickSubmit();
	}
	
	@Then("^I should see error: \"([^\"]*)\"$")
	public void iShouldSeeMessage(String error) {
		assertEquals(error, page.getErrorText());
	}
	
	@Then("^I should receive an alert$")
	public void iShouldReceiveAlert() {
		try {
			alert = driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			fail("Alert expected, but not found");
		}
	}
	
	@Then("^the alert should say: \"([^\"]*)\"$")
	public void theAlertShouldSay(String message) {
		if(alert != null) {
			assertEquals(message, alert.getText());
		} else {
			fail("Expected alert message, but no alert found");
		}
	}
}
