package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import core.Constants;
import pages.RegistrationPage;

public class RegistrationPageTest extends BaseTest{
  @Test
  public void VerifyAllSpecifiedFieldPresent() {
	  RegistrationPage registrationPage=new RegistrationPage(getDriver());
	  registrationPage.NavigateToRegisterPage();
	  Assert.assertTrue(registrationPage.isPhoneTextboxDisplay(),"Phone textbox"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isNameTextboxDisplay(), "Name textbox"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isSmsTextboxDisplay(), "Sms textbox"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isEnableSmsNewsletterCheckboxDisplay(), "Enable Sms Newsletter Checkbox"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isSubmitBtnDisplay(), "Submit btn"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isFacebookBtnDisplay(), "Facebook btn"+ Constants.IS_NOT_DISPLAYED);
	  Assert.assertTrue(registrationPage.isGoogleBtnDisplay(), "Google btn"+ Constants.IS_NOT_DISPLAYED);
  }
}
