package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.CLASS_NAME, using = "card-categories-ul")
	private WebElement categoryMenu;
	
	public void navigateToHomePage() {
		this.navigateToPage();
	}
	
	public boolean isCategoryMenuDisplay() {
		return this.isElementVisibility(categoryMenu);
	}
	
}
