package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;


public class ListPage {
    private WebDriver driver;


    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16") //
            List<WebElement> persons; //
    @FindBy(how = How.XPATH, using = "//div[4]//button[1]")
    WebElement addBtn;
    @FindBy(how = How.XPATH, using = "//li[@id='person2']//span[@class='w3-closebtn editbtn w3-padding w3-margin-right w3-medium']")
    WebElement editBtn;
    @FindBy(how = How.XPATH, using = "//li[@id='person2']//span[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium'][contains(text(),'×')]")
    WebElement removeBtn;
    @FindBy(how = How.XPATH, using = "//div[2]//button[2]")

    WebElement resetBtn;
    @FindBy(how = How.CLASS_NAME, using = "surname")
    private List<WebElement> personSurname;
    @FindBy(how = How.CLASS_NAME, using = "name")
    private List<WebElement> personName;
    int peopleQty;


    public List<Person> getPersons() {

        ArrayList<Person> personList = new ArrayList<>();
        for (WebElement personElement : persons) {
            Person person = new Person();
            person.setName(personElement.findElement(By.className("name")).getText());
            person.setSurname(personElement.findElement(By.className("surname")).getText());
            person.setJob(personElement.findElement(By.className("job")).getText());
            person.setDob(personElement.findElement(By.className("dob")).getText());
            person.setLanguages(personElement.findElement(By.className("language")).getText());
            person.setGender(personElement.findElement(By.className("gender")).getText());
            person.setStatus(personElement.findElement(By.className("status")).getText());
            personList.add(person);


        }

        return personList;


    }

    public void clickAddPerson() {
        peopleQty = persons.size();
        addBtn.click();


    }

    public void clickEdit() {
        editBtn.click();

    }

    public void clickRemove() {
        peopleQty = persons.size();
        removeBtn.click();

    }

    public void clickReset() {
        peopleQty = persons.size();
        resetBtn.click();

    }


    public String getListPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void checkAdded() {
        assertEquals(peopleQty + 1, persons.size());



    }

    public void checkRemoved() {
        assertEquals(peopleQty - 1, persons.size());

    }

    public void checkDeleted(String name, String surname) {


        assertFalse(personName.get(2).getText().equals(name));
        assertFalse(personSurname.get(2).getText().equals(surname));
    }

    public void checkEdited(String name, String surname) {
        assertEquals(name, personName.get(2).getText());
        assertEquals(surname, personSurname.get(2).getText());
    }

}
