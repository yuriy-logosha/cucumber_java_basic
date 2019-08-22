package pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NumberPage {
	
	public NumberPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "numb")
	WebElement input;
	@FindBy(how = How.CLASS_NAME, using = "w3-btn")
	WebElement button;
	@FindBy(how = How.ID, using = "ch1_error")
	WebElement errorArea;
	
	public void clickSubmit() {
		button.click();
	}
	
	public void setInput(String input) {
		this.input.clear();
		this.input.sendKeys(input);
	}
	
	public String getErrorText() {
		return errorArea.getText();
	}
}
