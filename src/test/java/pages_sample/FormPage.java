package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FormPage {

    @FindBy(how = How.ID, using = "name") // By.id("name")
    private WebElement nameInput; // WebElement nameInput = driver.findElement(By.id("name"));
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dobInput;
    @FindBy(how = How.ID, using = "english")
    private WebElement optionEnglish;
    @FindBy(how = How.ID, using = "french")
    private WebElement optionFrench;
    @FindBy(how = How.ID, using = "spanish")
    private WebElement optionSpanish;
    @FindBy(how = How.ID, using = "male")
    private WebElement radioMale;
    @FindBy(how = How.ID, using = "female")
    private WebElement radioFemale;

    @FindBy(how = How.ID, using = "status")
    private WebElement statusDropdown;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    private WebElement addBtn;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
    private WebElement cancelBtn;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Edit')]")
    private WebElement editBtn;

    @FindBy(how = How.XPATH, using = "//button[@id='addPersonBtn']")
    private WebElement clearAllBtn;
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private List<WebElement> checkboxes;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void enterDob(String dob) {
        dobInput.clear();
        dobInput.sendKeys(dob);
    }

    public void checkEnglish() {
        if (optionEnglish.isSelected()) {
            return;
        } else {
            optionEnglish.click();
        }

    }

    public void checkFrench() {
        if (optionFrench.isSelected()) {
            return;
        } else {
            optionFrench.click();
        }

    }

    public void checkSpanish() {
        if (optionSpanish.isSelected()) {
            return;
        } else {
            optionSpanish.click();
        }

    }

    public void selectFemale() {
        radioFemale.click();
    }

    public void selectMale() {
        radioMale.click();
    }

    public void selectStatusEmployee() {
        Select s = new Select(statusDropdown);
        s.selectByValue("employee");
    }

    public void selectStatusIntern() {
        Select s = new Select(statusDropdown);
        s.selectByValue("intern");
    }

    public void selectStatusContractor() {
        Select s = new Select(statusDropdown);
        s.selectByValue("contractor");
    }

    public void clickAdd() {
        addBtn.click();


    }

    public void clickEdit() {
        editBtn.click();
    }

    public void clickCancel() {
        cancelBtn.click();
    }

    public void clickClearAll() {
        clearAllBtn.click();
    }

    public void checkAllCleared() {
        assertEquals("", nameInput.getAttribute("value"));
        assertEquals("", surnameInput.getAttribute("value"));
        assertEquals("", jobInput.getAttribute("value"));
        assertEquals("", dobInput.getAttribute("value"));
//        assertTrue(!optionEnglish.isSelected());
//        assertTrue(!optionSpanish.isSelected());
//        assertTrue(!optionFrench.isSelected());
//        assertTrue(!radioMale.isSelected());
//        assertTrue(!radioFemale.isSelected());
//        Select s = new Select(statusDropdown);
//        assertEquals("Employee", s.getFirstSelectedOption().getText());
    }

    public void enterUserInformation(String jobTitle, String status) {
        jobInput.clear();
        jobInput.sendKeys(jobTitle);

        Select statusSelect = new Select(statusDropdown);
        statusSelect.selectByVisibleText(status);
    }

    public void enterUserName(String name, String surname) {
        nameInput.clear();
        nameInput.sendKeys(name);
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        dobInput.clear();
        dobInput.sendKeys(dateOfBirth);
    }

    public void enterGender(String gender) {
        if (gender.equals("female")) {
            radioFemale.click();
        } else radioMale.click();
    }

    public void chooseLanguages(List<String> languages) {
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }

        for (String language : languages) {
            if (language.equals("English")) {
                checkboxes.get(0).click();
            }
            if (language.equals("French")) {
                checkboxes.get(1).click();
            }
            if (language.equals("Spanish")) {
                checkboxes.get(2).click();
            }
        }
    }
}

