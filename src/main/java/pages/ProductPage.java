package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import core.BasePage;
import core.Constants;

public class ProductPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'sku-variable-img-wrap')]")
	private List<WebElement> productColors;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'sku-variable-size')]")
	private List<WebElement> productSizes;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'add-to-cart-buy-now-btn')][2]")
	private WebElement addToCartbutton;

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ClickAddToCart() {
		this.clickElement(addToCartbutton);
	}

	public void navigateToProductPage(String productUrl) {
		this.navigateToPage(productUrl);
	}

	public void VerifyUserCanSelectProductColor() {
		//lập qua các product color trong product colors list
		for (WebElement element : productColors) {
			//nếu product color chưa được chọn thì click vào
			if (!element.getAttribute("class").contains("selected")) {
				this.clickElement(element);
			}
			//Verify trong thuộc tính class có chứa 'selected'
			Assert.assertTrue(element.getAttribute("class").contains("selected"),
					"Product Color" + Constants.CAN_NOT_SELECTED);
			//Verify border color là màu cam
			Assert.assertTrue(element.getCssValue("border-color").equals("rgb(245, 114, 36)"),
					"Product Color, border-color " + Constants.IS_NOT_CORRECT);
		}
	}

	public void VerifyUserCanSelectProductSize() {
		for (WebElement element : productSizes) {
			if (!element.getAttribute("class").contains("selected")) {
				this.clickElement(element);
			}
			Assert.assertTrue(element.getAttribute("class").contains("selected"),
					"Product Size" + Constants.CAN_NOT_SELECTED);
			String a = element.getCssValue("border");
			Assert.assertTrue(element.getCssValue("border").contains("rgb(245, 114, 36)"),
					"Product Size, border-color " + Constants.IS_NOT_CORRECT);
		}
	}

}
