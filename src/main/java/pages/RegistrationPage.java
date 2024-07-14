package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import core.BasePage;
import core.Constants;

public class RegistrationPage extends BasePage {
	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mod-input-phone')]/input")
	private WebElement phoneTextbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mod-input-name')]/input")
	private WebElement nameTextbox;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mod-input-password')]/input")
	private WebElement smsTextbox;

	@FindBy(how = How.ID, using = "month")
	private WebElement month;

	@FindBy(how = How.XPATH, using = "//label[contains(@class,'next-checkbox')]")
	private WebElement enableSmsNewsletterCheckbox;

	@FindBy(how = How.XPATH, using = "//div[@class='mod-login-btn']/button")
	private WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Facebook']")
	private WebElement facebookBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Google']")
	private WebElement googleBtn;

	public void NavigateToRegisterPage() {
		driver.navigate().to(Constants.REGISTER_PAGE_URL);
	}

	public boolean isPhoneTextboxDisplay() {
		return this.isElementVisibility(phoneTextbox);
	}

	public boolean isNameTextboxDisplay() {
		return this.isElementVisibility(nameTextbox);
	}

	public boolean isSmsTextboxDisplay() {
		return this.isElementVisibility(smsTextbox);
	}

	public boolean isEnableSmsNewsletterCheckboxDisplay() {
		return this.isElementVisibility(enableSmsNewsletterCheckbox);
	}

	public boolean isSubmitBtnDisplay() {
		return this.isElementVisibility(submitBtn);
	}

	public boolean isFacebookBtnDisplay() {
		return this.isElementVisibility(facebookBtn);
	}

	public boolean isGoogleBtnDisplay() {
		return this.isElementVisibility(googleBtn);
	}

}
