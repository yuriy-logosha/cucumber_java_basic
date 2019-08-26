package pages_sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PersonDataPage {

    @FindBy(how = How.CSS, using = "button[onclick='openModalForAddPerson()']")
    private WebElement clearButton;

    @FindBy(how = How.ID, using = "name")
    private WebElement name;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surname;

    @FindBy(how = How.ID, using = "job")
    private WebElement job;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOfBirth;

    @FindBy(how = How.NAME, using = "language")
    private List<WebElement> languages;

    @FindBy(how = How.NAME, using = "gender")
    private List<WebElement> genders;

    @FindBy(how = How.ID, using = "status")
    private WebElement status;

    @FindBy(how = How.CSS, using = "button[onclick='addPersonToList()']")
    private WebElement addButton;

    @FindBy(how = How.CSS, using = "button[onclick='window.history.back()']")
    private WebElement cancelButton;

    @FindBy(how = How.CSS, using = "button[onclick^='editPerson']")
    private WebElement editButton;

    public void setName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
    }

    public String getName() {
        return name.getAttribute("value");
    }

    public void setSurname(String surname) {
        this.surname.clear();
        this.surname.sendKeys(surname);
    }

    public String getSurname() {
        return surname.getAttribute("value");
    }

    public void setJob(String job) {
        this.job.clear();
        this.job.sendKeys(job);
    }

    public String getJob() {
        return job.getAttribute("value");
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth.clear();
        this.dateOfBirth.sendKeys(dateOfBirth);
    }

    public String getDateOfBirth() {
        return dateOfBirth.getAttribute("value");
    }

    public void setLanguage(String lang) {
        for (WebElement language : languages) {
            if (language.getAttribute("id").equalsIgnoreCase(lang) && !language.isSelected()) {
                language.click();
            } else if (!language.getAttribute("id").equalsIgnoreCase(lang) && language.isSelected()) {
                language.click();
            }
        }
    }

    public String getLanguage() {
        for (WebElement language : languages) {
            if (language.isSelected()){
                return language.getAttribute("id");
            }
        }
        return null;
    }

    public void setGender(String gender) {
        for (WebElement gen : genders) {
            if(gen.getAttribute("id").equalsIgnoreCase(gender)){
                gen.click();
            }
        }

    }

    public String getGender() {
        for (WebElement gender : genders) {
            if(gender.isSelected()){
                return gender.getAttribute("id");
            }
        }
        return null;
    }

    public void setStatus(String status) {
        Select select = new Select(this.status);
        select.selectByValue(status);
    }

    public String getStatus() {
        Select select = new Select(status);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickClearButton() {
        clearButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

}
