package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ListSample {
    @FindBy(how = How.XPATH, using = "//div[2]//button[1]")
    private WebElement addPersonButton1;
    @FindBy(how = How.XPATH, using = "//div[2]//button[2]")
    private WebElement ResetListButton1;
    @FindBy(how = How.XPATH, using = "//div[4]//button[1]")
    private WebElement addPersonButton2;
    @FindBy(how = How.XPATH, using = "//div[4]//button[2]")
    private WebElement ResetListButton2;
    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16")
    List<WebElement> PersonList;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[2]/i")
    private WebElement CorrectButton;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[3]/div[1]/div[1]/ul[1]/div[1]/li[1]/span[3]")
    private WebElement person0name;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[3]/div[1]/div[1]/ul[1]/div[1]/li[1]/span[4]")
    private WebElement person0job;


    public List<Person> getPersonList() {
        ArrayList<Person> Personlist = new ArrayList<>();
        for (WebElement PersonElement : PersonList) {
            Person person = new Person();
            person.setName(PersonElement.findElement(By.className("name")).getText());
            person.setSurname(PersonElement.findElement(By.className("surname")).getText());
            person.setJob(PersonElement.findElement(By.className("job")).getText());
            person.setDob(PersonElement.findElement(By.className("dob")).getText());
            person.setLanguage(PersonElement.findElement(By.className("language")).getText());
            person.setGender(PersonElement.findElement(By.className("gender")).getText());
            person.setGender(PersonElement.findElement(By.className("status")).getText());
            Personlist.add(person);
        }
        return Personlist;
    }

    public int getPersonListSize(){
       return PersonList.size();
    }

    public void clickAddPerson1() {
         addPersonButton1.click();
    }

    public void clickAddPerson2() {
        addPersonButton2.click();
    }

    public void clickResetList1() {
        ResetListButton1.click();
    }

    public void clickResetList2() {
        ResetListButton2.click();
    }

    public  void  clickEditButton(){
        CorrectButton.click();
    }
    public String checkFirstPersonName(){
      return person0name.getText();
    }
    public String checkFirstPersonJob(){
        return person0job.getText();
    }

}
