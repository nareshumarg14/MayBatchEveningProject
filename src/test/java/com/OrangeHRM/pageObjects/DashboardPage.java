package com.OrangeHRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.utilities.JavaScriptUtil;

public class DashboardPage {
	
	//1
	public WebDriver driver;
	JavaScriptUtil ju = new JavaScriptUtil();
	
	//2. Constructor
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Locator for Dashboard Link
	@FindBy(id="menu_dashboard_index")
	WebElement lnkDashboard;
	
	//4. Method for Dashboard Link Status
	public boolean dashboardLinkDisplayed() {
		boolean status;
		ju.flash(lnkDashboard, driver);
		status = lnkDashboard.isDisplayed();
		return status;
	}

}
