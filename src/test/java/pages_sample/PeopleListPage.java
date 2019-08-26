package pages_sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PeopleListPage {
    @FindBy(how = How.CSS, using = "[id*='person']")
    private List<WebElement> listOfPeople;

    @FindBy(how = How.CSS, using = "#addPersonBtn[onclick='openModalForAddPerson()']")
    private WebElement addPersonButton;

    @FindBy(how = How.CSS, using = "#addPersonBtn[onclick='resetListOfPeople()']")
    private WebElement resetListButton;

    private String selectedPersonData;

    public void clickAddButton() {
        addPersonButton.click();
    }

    public void clickResetButton() {
        resetListButton.click();
    }

    public String getNewPersonData(){
        return listOfPeople.get(listOfPeople.size() - 1).getText();
    }

    public String getPersonData(int index){
        return listOfPeople.get(index).getText();
    }

    public void selectPerson(int index) {
        selectedPersonData = listOfPeople.get(index).getText();
    }

    public String getSelectedPerson() {
        return selectedPersonData;
    }

    public List<WebElement> getListOfPeople() {
        return listOfPeople;
    }

    public void clickEditPerson(int index) {
        listOfPeople.get(index).findElement(By.className("editbtn")).click();
    }

    public void clickDeletePerson(int index) {
        listOfPeople.get(index).findElement(By.className("closebtn")).click();
    }

    public boolean selectedPersonInList() {
        for (WebElement person : listOfPeople) {
            if(person.getText().equalsIgnoreCase(selectedPersonData)) {
                return true;
            }
        }
        return false;
    }

}
