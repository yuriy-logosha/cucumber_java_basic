package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;


public class Task2AddUserForm {
    @FindBy(how = How.ID, using = "name")
    public WebElement name;
    @FindBy(how = How.ID, using = "surname")
    public WebElement surname;
    @FindBy(how = How.ID, using = "job")
    public WebElement job;
    @FindBy(how = How.ID, using = "dob")
    public WebElement dob;
    @FindBy(how = How.ID, using = "english")
    public WebElement english;
    @FindBy(how = How.ID, using = "french")
    public WebElement french;
    @FindBy(how = How.ID, using = "spanish")
    public WebElement spanish;
    @FindBy(how = How.ID, using = "male")
    public WebElement male;
    @FindBy(how = How.ID, using = "female")
    public WebElement female;
    @FindBy(how = How.ID, using = "status")
    public WebElement status;
    @FindBy(how = How.ID, using = "addPersonBtn")
    public WebElement clearAllFields;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    public WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Cancel')]")
    public WebElement cancelButton;



}
