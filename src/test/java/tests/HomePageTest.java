package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseTest;
import core.Constants;
import pages.HomePage;

public class HomePageTest extends BaseTest {

	@Test
	public void VerifyItemsDisplay() {
		HomePage homePage = new HomePage(getDriver());
		homePage.navigateToHomePage();

		Assert.assertTrue(homePage.isCategoryMenuDisplay(), "Category" + Constants.IS_NOT_DISPLAYED);
		Assert.assertTrue(homePage.isCartIconDisplay(), "CartIcon" + Constants.IS_NOT_DISPLAYED);
		Assert.assertTrue(homePage.isSearchBoxDisplay(), "Search" + Constants.IS_NOT_DISPLAYED);
	}

}
