package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class Task2steps {
    private WebDriver driver;

    public Task2steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on page people with jobs$")
    public void iAmOnPagePeopleWithJobs() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }

    @When("^I click add a person$")
    public void iClickAddAPerson() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }
    @And("^I am on page Add Person$")
    public void iAmOnPageAddPerson() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }
    @And("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }
    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }
    @And("^I click button Add$")
    public void iClickButtonAdd() throws Throwable {
        driver.findElement(By.xpath("//button[contains(.,'Add')]"));
    }
    @Then("^I see new person Bob$")
    public void iSeeNewPersonBob() throws Throwable {
        assertEquals("Bob",
                driver.findElement(By.xpath("//p[text()='Bob']")));
    }
    @When("^I click on edit a person Mike$")
    public void iClickOnEditAPersonMike() throws Throwable {
        driver.findElement(By.xpath("//button[contains(.,'openModalForEditPersonWithJob(0)')]"));
    }
    @And("^I am on page edit Mike$")
    public void iAmOnPageEditMike() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=0");
    }
    @Then("^I see person Michael instead of Mike$")
    public void iSeePersonMichaelInsteadOfMike() throws Throwable {
        assertEquals("Michael",
                driver.findElement(By.xpath("//a[text()='Michael']")));
    }
    @And("^I click button Edit$")
    public void iClickButtonEdit() throws Throwable {
        driver.findElement(By.xpath("//a[text()='Edit']")).click();
    }
    @When("^I click on remove a person Jill$")
    public void iClickOnRemoveAPersonJill() throws Throwable {
        driver.findElement(By.xpath("//div[contains(@onclick, 'deletePerson(1)']")).click();
    }
    @Then("^There is no Jill in the list anymore$")
    public void thereIsNoJillInTheListAnymore() throws Throwable {
        assertEquals("",
                driver.findElement(By.xpath("//a[text()='Jill']")));
    }
    @When("^I click on Reset List$")
    public void iClickOnResetList() throws Throwable {
        driver.findElement(By.xpath("//a[text()='Reset']")).click();
    }
    @Then("^I see Jill again$")
    public void iSeeJillAgain() throws Throwable {
        assertEquals("Jill",
                driver.findElement(By.xpath("//a[text()='Jill']")));

    }
    @Then("^I see new person Jack$")
    public void iSeeNewPersonJack() throws Throwable {
        assertEquals("Jack",
                driver.findElement(By.xpath("//a[text()='Jack']")));
    }
    @When("^I click on edit a person Jack$")
    public void iClickOnEditAPersonJack() throws Throwable {
        driver.findElement(By.xpath("//a[contains(@onclick, 'openModalForEditPersonWithJob(3)']")).click();
    }
    @Then("^I see new person Richard$")
    public void iSeeNewPersonRichard() throws Throwable {
        assertEquals("Richard",
                driver.findElement(By.xpath("//a[text()='Richard']")));
    }
    @When("^I click on remove a person Richard$")
    public void iClickOnRemoveAPersonRichard() throws Throwable {
        driver.findElement(By.xpath("//a[contains(@onclick, 'deletePerson(3)']")).click();
    }
    @Then("^there is no Richard anymore$")
    public void thereIsNoRichardAnymore() throws Throwable {
        assertEquals("",
                driver.findElement(By.xpath("//a[text()='Richard']")));
    }
    @And("^I click Clear all fields$")
    public void iClickClearAllFields() throws Throwable {
        driver.findElement(By.xpath("//a[text()='Clear all fields']")).click();
    }
    @Then("^name and job fields are clear again$")
    public void nameAndJobFieldsAreClearAgain() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")));
        assertEquals("", driver.findElement(By.id("job")));
    }

    @And("^I am on page edit Jack$")
    public void iAmOnPageEditJack()  throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=3");
    }
    }


