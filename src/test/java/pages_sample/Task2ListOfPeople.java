package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;


public class Task2ListOfPeople {
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Add person')]")
    public WebElement addPerson;
    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Reset List')]")
    public WebElement resetList;
    @FindBy(how = How.CLASS_NAME, using = "//span[contains(@class, 'name')]")
    public WebElement name;
    @FindBy(how = How.CLASS_NAME, using = "//span[contains(@class, 'surname')]")
    public WebElement surname;

    public void clickAddPerson() {
        addPerson.click();
    }

    public List<WebElement> getNameList () {
        List<WebElement> currentList = new ArrayList<>();
        name.getText();
        return null;
    }

}
