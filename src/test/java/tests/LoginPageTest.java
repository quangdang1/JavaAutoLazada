package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import core.Constants;
import core.DataProviderUtils;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

	 @Test
	public void VerifyEmailPasswordLoginButtonDisplay() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateToLoginPage();
		Assert.assertTrue(loginPage.isEmailTextboxDisplay(), "Email Textbox" + Constants.IS_NOT_DISPLAYED);
		Assert.assertTrue(loginPage.isPasswordTextboxDisplay(), "Password Textbox" + Constants.IS_NOT_DISPLAYED);
		Assert.assertTrue(loginPage.isLoginBtnDisplay(), "Login Btn" + Constants.IS_NOT_DISPLAYED);
	}

	@Test(dataProviderClass = DataProviderUtils.class, dataProvider = "TestData")
	public void VerifyUserCanNotLoginWithInvalidEmailPassword(String email, String password) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateToLoginPage();
		loginPage.login(email, password);
		Assert.assertEquals(loginPage.getMessage(), Constants.INVALID_ACC_PASS_MSG);
		//Verify thẻ Account không hiển thị khi đăng nhập thất bại
		Assert.assertFalse(loginPage.isAccountSpanDisplay(3), "Account " + Constants.IS_DISPLAYED);
	}

	 @Test
	public void VerifyUserCannotLoginWithBlankEmailPassword() {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateToLoginPage();
		loginPage.login("", "");
		Assert.assertEquals(loginPage.getEmailValidationMsg(), Constants.NO_BLANK);
		Assert.assertEquals(loginPage.getPasswordValidationMsg(), Constants.NO_BLANK);
		Assert.assertFalse(loginPage.isAccountSpanDisplay(3), "Account " + Constants.IS_DISPLAYED);

	}

	 @Test(dataProvider = "LoginData")
	public void VerifyUserCannotLoginWhenCharacterMoreThan60(String email, String password) {
		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.navigateToLoginPage();
		loginPage.login(email, password);
		Assert.assertEquals(loginPage.getEmailValidationMsg(), Constants.CHARACTER_LENGTH_MSG);
		Assert.assertFalse(loginPage.isAccountSpanDisplay(3), "Account " + Constants.IS_DISPLAYED);
	}

}
