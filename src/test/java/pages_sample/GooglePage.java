package pages_sample;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
	public GooglePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using = "input[name='q']")
	WebElement searchInput;
	@FindBy(how = How.CSS, using = "input[name='btnK']")
	WebElement searchButton;
	@FindBy(how = How.CSS, using = "input[name='btnI']")
	WebElement luckyButton;
	@FindBy(how = How.CSS, using = "div[data-hveid]")
	List<WebElement> searchResults;
	
	public void clickSearch() {
		searchButton.click();
	}
	
	public void clickLucky() {
		luckyButton.click();
	}
	
	public int getResultCount() {
		return searchResults.size();
	}
	
	public void enterSearchTerm(String term) {
		searchInput.clear();
		searchInput.sendKeys(term);
	}
}
