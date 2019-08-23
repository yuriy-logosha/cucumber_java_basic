package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FormSample {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
    private WebElement AddButton;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Edit')]")
    private WebElement EditButton;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob(String jobTitle) {
        jobInput.clear();
        jobInput.sendKeys(jobTitle);
    }
    public  void  clickAddButton(){
        AddButton.click();
    }
    public  void  clickEditButton(){
        EditButton.click();
    }



}
