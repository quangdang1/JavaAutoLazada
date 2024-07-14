package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class FacebookLoginPage extends BasePage{
	
	@FindBy(how=How.ID,using="email")
	private WebElement email;
	
	@FindBy(how=How.ID,using="pass")
	private WebElement pass;
	
	@FindBy(how=How.NAME,using="login")
	private WebElement loginButton;

	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void Login(String email,String password) {
		this.enterText(this.email, email);
		this.enterText(this.pass, password);
		this.clickElement(loginButton);
	}

}
