package pages_sample;

import org.apache.bcel.generic.Select;
import org.apache.bcel.generic.Visitor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.BitSet;
import java.util.List;


public class ListPage {
    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private static List<WebElement> checkBoxes;
    @FindBy(how = How.CLASS_NAME, using = "w3-radio")
    private static List<WebElement> radioButtons;
    @FindBy(how = How.CLASS_NAME, using = "w3-select")
    private static List<WebElement> employeeStatus;


    public static void selectLanguage(List<String> language) {
        for (String s : language) {
            if (s.equals("English")) {
                checkBoxes.get(0).click();
            }
            if (s.equals("French")) {
                checkBoxes.get(1).click();
            }
            if (s.equals("Spanish")) {
                checkBoxes.get(2).click();
            }
        }
    }

    public static void clearLanguage() {
        if(checkBoxes.get(0).isSelected()) {
            checkBoxes.get(0).click();
        }
        if(checkBoxes.get(1).isSelected()) {
            checkBoxes.get(1).click();
        }
        if(checkBoxes.get(2).isSelected()) {
            checkBoxes.get(2).click();
        }
    }

    public static void chooseGender(String gender) {
        if (gender.equals("female")) {
            radioButtons.get(1).click();
        } else radioButtons.get(0).click();
    }


    public static void chooseStatus(String status) {
        if (status.equals("Employeee")) {
            employeeStatus.get(0).click();
        }
        if (status.equals("Intern")) {
            employeeStatus.get(0).click();
        }
        if (status.equals("Contractor"))
            employeeStatus.get(0).click();
    }
}
