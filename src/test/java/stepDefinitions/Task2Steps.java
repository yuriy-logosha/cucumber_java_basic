package stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import classes.Person;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages_sample.FormPage;
import pages_sample.ListPage;
import sun.awt.SunHints.Value;

public class Task2Steps {
	static enum Action { ADDED, EDITED, DELETED };
	private WebDriver driver;
    static FormPage formPage;
    static ListPage listPage;
    static List<Person> preList;
    static List<Person> postList;
    static Person comparisonPerson;
    static List<Person> defaultPersons;
    Action actionPerformed;
    
    public Task2Steps() {
        this.driver = Hooks.driver;
        //formPage = PageFactory.initElements(Hooks.driver, FormPage.class);
        //listPage = PageFactory.initElements(Hooks.driver, ListPage.class);
        formPage = new FormPage(this.driver);
        listPage = new ListPage(this.driver);
    }
    
    @Given("^I am on person list page$")
    public void onPersonListPage() {
    	driver.get("https://kristinek.github.io/site/tasks/list_of_people.html");
    }
    
    @When("^(?:Add a new|Adding a) person$")
    public void addPerson(Map<String, String> values) {
    	preList = listPage.getPersonList();
    	listPage.clickAddPerson();
    	
    	formPage.setName(values.get("name"));
    	formPage.setSurname(values.get("surname"));
    	formPage.setJob(values.get("job"));
    	formPage.setDobByString(values.get("dob"));
    	formPage.setLanguageByList(values.get("language"));
    	formPage.setGenderById(values.get("genderId"));
    	formPage.setStatusByValue(values.get("statusValue"));
    	
    	comparisonPerson = new Person();
    	comparisonPerson.setName(values.get("name"));
    	comparisonPerson.setSurname(values.get("surname"));
    	comparisonPerson.setJob(values.get("job"));
    	comparisonPerson.setDob(values.get("dob"));
    	comparisonPerson.setLanguageString(values.get("language"));
    	comparisonPerson.setGender(values.get("genderId"));
    	comparisonPerson.setStatus(values.get("statusValue"));
    	
    	formPage.clickAdd();
    	
    	postList = listPage.getPersonList();
    	
    	actionPerformed = Action.ADDED;
    }
    
    @When("^(?:Edit|Editing) a person$")
    public void editPerson(Map<String, String> values) throws Exception {
    	preList = listPage.getPersonList();
    	comparisonPerson = listPage.getPerson(values.get("personId"));
    	
    	listPage.clickEditPerson(values.get("personId"));
    	formPage.setName(values.get("name"));
    	formPage.setSurname(values.get("surname"));
    	formPage.setJob(values.get("job"));
    	formPage.setLanguageByList(values.get("language"));
    	formPage.clickEdit();
    	
    	postList = listPage.getPersonList();
    	
    	actionPerformed = Action.EDITED;
    }
    
    @When("^(?:Remove|Removing) a person \"([^\"]*)\"$")
    public void removePerson(String personId) {
    	preList = listPage.getPersonList();
    	listPage.clickDeletePerson(personId);
    	postList = listPage.getPersonList();
    	
    	actionPerformed = Action.DELETED;
    }
    
    @Then("^a new user shall be added to the list$")
    public void newUserCreated() {
    	assertEquals(preList.size()+1, postList.size());
    }
    
    @And("^the new user has the information I entered$")
    public void newUserInfoCheck() {
    	boolean matchFound = false;
    	for(Person p : postList) {
    		if(p.equals(comparisonPerson)) {
    			matchFound = true;
    			break;
    		}
    	}
    	// after adding a person, a spare comma is found after languages
    	assertTrue("Expected list to have exact match for new person", matchFound);
    }
    
    @And("^no other persons were changed$")
    public void noOtherPersonChanged() {
    	int matchingPersons = 0;
    	for(Person p : postList) {
    		for(Person p2 : preList) {
    			if(p.equals(p2)) {
    				matchingPersons++;
    			}
    		}
    	}
    	int toCompareTo = preList.size();
    	// if person added - we expect all elements in prelist to have a match in postlist
    	// if person edited or deleted - we expect prelist-1 elements to have a match in postlist
    	switch(actionPerformed) {
	    	case EDITED:
	    	case DELETED:
	    		toCompareTo--;
    	}
    	assertEquals(matchingPersons, toCompareTo);
    }
    
    @Then("^the information of person with personid \"([^\"]*)\" shall change$")
    public void personChanged(String personId) {
    	Person editedPerson = listPage.getPerson(personId);
    	
    	assertFalse(editedPerson.equals(comparisonPerson));
    }
    
    @Then("^the person with personid \"([^\"]*)\" shall not be on the list$")
    public void personNotOnList(String personId) {
    	Person person = listPage.getPerson(personId);
    	assertNull("Person with id:" + personId + " should not be in the list, but was found", person);
    }
    
    @Given("^a list of initial persons$")
    public void initialPersons() {
    	defaultPersons = new ArrayList<Person>();
    	defaultPersons.add(new Person(
    			"Mike",
    			"Kid",
    			"Web Designer",
    			"12/25/1986",
    			"English",
    			"male",
    			"contractor"));
    	defaultPersons.add(new Person(
    			"Jill",
    			"Watson",
    			"Support",
    			"06/06/1966",
    			"Spanish",
    			"female",
    			"intern"));
    	defaultPersons.add(new Person(
    			"Jane",
    			"Doe",
    			"Accountant",
    			"04/01/2001",
    			"English, French",
    			"female",
    			"employee"));
    }
    
    @And("^reset original list$")
    public void resetList() {
    	listPage.clickReset();
    }
    
    @And("^list shall contain only initial persons$")
    public void listContainsOnlyInitialPersons() {
    	postList = listPage.getPersonList();
    	for(Person p : postList) {
    		boolean matchFound = false;
    		for(Person j : defaultPersons) {
    			if(p.equals(j)) {
    				matchFound = true;
    				break;
    			}
    		}
    		assertTrue("Non default person found in list", matchFound);
    	}
    }
    
    @Given("^I am on new person form$")
    public void iAmOnNewPersonForm() {
    	listPage.clickAddPerson();
    }
    
    @And("^fill the form$")
    public void fillForm(Map<String, String> values) {
    	String name = values.get("name");
    	String surname = values.get("surname");
    	String job = values.get("job");
    	String dob = values.get("dob");
    	String[] language = values.get("language").split("\\p{javaSpaceChar}*,\\p{javaSpaceChar}*");
    	String genderId = values.get("genderId");
    	String statusValue = values.get("statusValue");
    	
    	formPage.setName(name);
    	formPage.setSurname(surname);
    	formPage.setJob(job);
    	formPage.setDobByString(dob);
    	formPage.setLanguageById(language);
    	formPage.setGenderById(genderId);
    	formPage.setStatusByValue(statusValue);
    	
    	assertEquals(name, formPage.getName());
    	assertEquals(surname, formPage.getSurname());
    	assertEquals(job, formPage.getJob());
    	assertEquals(dob, formPage.getDob());
    	assertEquals(genderId, formPage.getGenderId());
    	assertEquals(statusValue, formPage.getStatusValue());
    	
    	List<String> formList = formPage.getSelectedLang();
    	
    	assertEquals(language.length, formList.size());
    	
    	int matches = 0;
    	for(String s : language) {
    		for(String j : formList) {
    			if(s.equalsIgnoreCase(j)) {
    				matches++;
    			}
    		}
    	}
    	
    	assertEquals(language.length, matches);
    }
    
    @And("^click clear all fields$")
    public void clearAll() {
    	formPage.clickClear();
    }
    
    @Then("^known language shall be \"([^\"]*)\"$")
    public void languageCheck(String language) {
    	List<String> langs = formPage.getSelectedLang();
    	assertEquals(1, langs.size());
    	assertTrue("The language set should be " + language, language.equalsIgnoreCase(langs.get(0)));
    }
    
    @And("^employee status shall be \"([^\"]*)\"$")
    public void statusCheck(String status) {
    	String formStatus = formPage.getStatusValue();
    	assertTrue("Status should be " + status, status.equalsIgnoreCase(formStatus));
    }
    
    @And("^non-default fields shall be empty$")
    public void nonDefaultEmpty() {
    	assertEquals("", formPage.getName());
    	assertEquals("", formPage.getSurname());
    	assertEquals("", formPage.getDob());
    	assertEquals("", formPage.getJob());
    	assertEquals("", formPage.getGenderId());
    }
}
