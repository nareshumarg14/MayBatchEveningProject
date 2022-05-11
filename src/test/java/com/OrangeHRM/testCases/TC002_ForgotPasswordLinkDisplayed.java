package com.OrangeHRM.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.BaseTest.BaseClass;
import com.OrangeHRM.pageObjects.LoginPage;

public class TC002_ForgotPasswordLinkDisplayed extends BaseClass{
	@Test
	public void forgotPasswordLinkTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		String val = lp.forgotPasswordLink();
		Assert.assertEquals(val, "Forgot your password?", "Forgot your password? link is not existing");
		capturescreen(driver, "TC002_ForgotPasswordLinkDisplayed");
		//System.out.println("Forgot your password? link is existing");
		logger.info("Forgot your password? link is existing");
	}
}
