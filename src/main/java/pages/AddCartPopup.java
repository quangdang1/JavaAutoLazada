package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;

public class AddCartPopup extends BasePage{

	public AddCartPopup(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(how = How.CLASS_NAME, using = "cart-message-text")
	private WebElement cartMsg;
	
	@FindBy(how = How.CLASS_NAME, using = "next-dialog-close")
	private WebElement closeButton;
	
	public String getCartMsg() {
		return this.getText(cartMsg);
	}
	
	public void clickClose() {
		this.clickElement(closeButton);
	}

}
