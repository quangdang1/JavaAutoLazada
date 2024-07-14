package pages;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import core.Constants;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//div[@class='loginWrap']//div[contains(@class,'loginName')]//input")
	private WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//div[@class='loginWrap']//div[contains(@class,'loginName')]//span")
	private WebElement emailValidationMsg;

	@FindBy(how = How.XPATH, using = "//div[@class='loginWrap']//div[contains(@class,'password')]//input")
	private WebElement passwordTextbox;

	@FindBy(how = How.XPATH, using = "//div[@class='loginWrap']//div[contains(@class,'password')]//span")
	private WebElement passwordValidationMsg;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Facebook']/..")
	private WebElement facbookButton;

	@FindBy(how = How.ID, using = "nc")
	private WebElement slider;

	@FindBy(how = How.CLASS_NAME, using = "next-feedback-content")
	private WebElement messageContent;

	public void navigateToLoginPage() {
		driver.navigate().to(Constants.LOGIN_PAGE_URL);
	}

	public boolean isEmailTextboxDisplay() {
		return this.isElementVisibility(emailTextbox);
	}

	public boolean isPasswordTextboxDisplay() {
		return this.isElementVisibility(passwordTextbox);
	}

	public boolean isLoginBtnDisplay() {
		return this.isElementVisibility(loginButton);
	}

	public String getMessage() {
		return this.getText(messageContent);
	}

	public String getEmailValidationMsg() {
		return this.getText(emailValidationMsg);
	}

	public String getPasswordValidationMsg() {
		return this.getText(passwordValidationMsg);
	}

	public void login(String email, String password) {
		this.enterText(emailTextbox, email);
		this.enterText(passwordTextbox, password);
		
		//nếu ko tìm thấy slider thì nhấn vào nút login
		if (this.isElementVisibility(slider, 3)) {
			int width = slider.getSize().getWidth();

			Actions actions = new Actions(driver);
			// Kéo và thả
			actions.clickAndHold(slider).moveByOffset(width, 0).release().build().perform();
		} else {
			this.clickElement(loginButton);
		}
	}

	public void loginWithFacebook(String email, String password) {
		this.clickElement(facbookButton);
		Set<String> windowHandles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		// Chuyển đổi sang cửa sổ mới
		String newWindowHandle = (String) windowHandles.toArray()[1];
		driver.switchTo().window(newWindowHandle);

		FacebookLoginPage fbLoginPage = new FacebookLoginPage(driver);
		fbLoginPage.Login(email, password);
		// tro ve cua so chinh
		driver.switchTo().window(currentWindowHandle);
	}

}
