package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_loginDDT(String username, String password, String result) {
		try {
			logger.info("Starting TC_003_LoginDDT");

			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			MyAccountPage myAcc = new MyAccountPage(driver);

			logger.info("Clicked on My Account");
			hp.clickMyAccount();
			logger.info("Clicked on Login link");
			hp.clickLoginLink();

			logger.info("Entered all details and clicked on login");
			lp.enterEmail(username);
			lp.enterPassword(password);
			lp.clickLogin();

			boolean targetPage = myAcc.myAccountPageExist();

			if (result.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (result.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {
					myAcc.clickLogout();
					Assert.assertTrue(false);
				} else {
					
					Assert.assertTrue(true);
				}
			}

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
		logger.info("Finished TC_003_LoginDDT");
	}

}
