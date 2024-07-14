package tests;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import core.Constants;
import core.DataProviderUtils;
import pages.AddCartPopup;
import pages.LoginPage;
import pages.ProductPage;

public class ProductPageTest extends BaseTest {
	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "TestData")
	public void VerifyUserCanSelectDesiredAttribute(String productLink) {
		ProductPage productPage = new ProductPage(getDriver());
		productPage.navigateToPage(productLink);
			
		productPage.VerifyUserCanSelectProductColor();
		productPage.VerifyUserCanSelectProductSize();
	}

	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "TestData")
	public void VerifyUsercanAddProduct(String productLink) {
		ProductPage productPage = new ProductPage(getDriver());
		LoginPage loginPage = new LoginPage(getDriver());
		AddCartPopup addCartPopup = new AddCartPopup(getDriver());
		loginPage.navigateToLoginPage();

		loginPage.login(Constants.EMAIL, Constants.PASSWORD);
		Assert.assertTrue(productPage.isAccountSpanDisplay(60), Constants.LOGIN_UNSUCCESS);
		productPage.navigateToPage(productLink);

		int cartNum;
		try {
			cartNum = productPage.getCartNum(2);
		} catch (TimeoutException ex) {
			cartNum = 0;
		}

		productPage.ClickAddToCart();

		Assert.assertEquals(addCartPopup.getCartMsg(), Constants.ADD_CART_SUCCESS_MSG);
		addCartPopup.clickClose();
		Assert.assertEquals(productPage.getCartNum(3), cartNum + 1);

	}

}
