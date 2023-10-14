package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
		try {
			logger.info("Starting TC_002_LoginTest");

			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			MyAccountPage myAcc = new MyAccountPage(driver);

			logger.info("Clicked on My Account");
			hp.clickMyAccount();
			logger.info("Clicked on Login link");
			hp.clickLoginLink();

			logger.info("Entered all details and clicked on login");
			lp.enterEmail(rb.getString("email"));
			lp.enterPassword(rb.getString("password"));
			lp.clickLogin();

			boolean targetPage = myAcc.myAccountPageExist();

			Assert.assertEquals(targetPage, true);
		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
		logger.info("Finished TC_002_LoginTest");

	}

}
