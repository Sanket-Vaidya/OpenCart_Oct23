package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() {

		logger.info("****** Starting TC__001_AccountRegistrationTest ******");
		try {

			HomePage hp = new HomePage(driver);
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);

			String password = randomAlphaNumeric();

			hp.clickMyAccount();
			logger.info("Clicked on My Account link");

			hp.clickRegister();
			logger.info("Clicked on registration link");

			logger.info("Providing Customer data");
			regPage.enterFirstName(randomString().toUpperCase());
			regPage.enterLastName(randomString().toUpperCase());
			regPage.enterEmail(randomString() + "@gmail.com");
			regPage.enterTelephone(randomNumber());
			regPage.enterPassword(password);
			regPage.enterConfirmPassword(password);
			regPage.clickCheckbox();

			logger.info("Clicking on continue button");
			regPage.clickBtnContinue();

			String ConfMsg = regPage.successfullResgistration();
			logger.info("Validating message");
			Assert.assertEquals(ConfMsg, "Your Account Has Been Created!", "Not getting expected Message!");
		} catch (Exception e) {
			e.getMessage();
			logger.error("Test Failed");
			Assert.fail();
		}
		logger.info("****** Finished TC__001_AccountRegistrationTest ******");
		
	}

}
