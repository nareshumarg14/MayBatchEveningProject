package com.OrangeHRM.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.BaseTest.BaseClass;
import com.OrangeHRM.pageObjects.DashboardPage;
import com.OrangeHRM.pageObjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_UserLogin extends BaseClass {
	//3
	@Test
	public void loginTest() throws IOException {
		LoginPage lp = new LoginPage(driver);
		//1.Enter username
			lp.setUsername(prop.getProperty("username"));
		//2. enter Password
			lp.setPassword(prop.getProperty("password"));
		//3. Click Login button
			lp.clickLoginButton();
		//4. Check user logged in
		DashboardPage dp = new DashboardPage(driver);
		boolean retVal = dp.dashboardLinkDisplayed();
		Assert.assertEquals(retVal, true,"User login failed");
		capturescreen(driver, "TC001_UserLogin");
		logger.info("User logged into application");
	}
}
