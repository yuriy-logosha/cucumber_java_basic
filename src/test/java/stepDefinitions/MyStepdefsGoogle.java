package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import stepDefinitions.Hooks;

import static org.junit.Assert.assertEquals;

public class MyStepdefsGoogle {
     private WebDriver driver;

    public MyStepdefsGoogle()   {this.driver = Hooks.driver;  }


    @When("^I open goolge page$")
    public void iOpenGoolgePage() throws Throwable {
        driver.get("https://www.google.com/");
    }



    @Then("^I see Es ticu veiksmei!$")
    public void iSee() throws Throwable {
        assertEquals("Es ticu veiksmei!",
                driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnI']")).getAttribute("value"));
    }

    @Given("^I am on google page$")
    public void iAmOnGooglePage() throws Throwable {
        driver.get("https://www.google.com/");
    }

    @And("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String item) throws Throwable {
        driver.findElement(By.className("gNO89b")).sendKeys(item);

    }

    @And("^I click search$")
    public void iClickSearch() {
        driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
    }
}
