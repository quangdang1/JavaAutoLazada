package core;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private WebDriverWait wait;
	private WebDriverWait waitWithSpecificTimeout;

	@FindBy(how = How.ID, using = "myAccountTrigger")
	protected WebElement accountSpan;

	@FindBy(how = How.ID, using = "q")
	protected WebElement searchTextBox;

	@FindBy(how = How.CLASS_NAME, using = "cart-icon")
	protected WebElement cartIcon;

	@FindBy(how = How.ID, using = "topActionCartNumber")
	protected WebElement cartNum;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		waitWithSpecificTimeout = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		PageFactory.initElements(driver, this);
	}

	public boolean isElementVisibility(WebElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public boolean isElementVisibility(WebElement element, int timeout) {
		// chờ với thời gian truyền vào (giay)
		waitWithSpecificTimeout = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			waitWithSpecificTimeout.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (TimeoutException ex) {
			return false;
		}
	}

	public boolean isAccountSpanDisplay(int timeout) {
		return isElementVisibility(accountSpan, timeout);
	}

	public boolean isSearchBoxDisplay() {
		return isElementVisibility(searchTextBox);
	}

	public boolean isCartIconDisplay() {
		return isElementVisibility(cartIcon);
	}

	public void navigateToPage(String subURL) {
		driver.navigate().to(Constants.BASEURL + "/" + subURL);
	}

	public void navigateToPage() {
		driver.navigate().to(Constants.BASEURL);
	}

	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);
	}

	public void clickElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public String getText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}

	public int getCartNum(int timeOut) {
		this.isElementVisibility(cartNum, timeOut);
		int cartNum = Integer.parseInt(this.cartNum.getText());
		return cartNum;

	}

}
