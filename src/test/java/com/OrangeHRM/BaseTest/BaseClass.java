package com.OrangeHRM.BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched");
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser is launched");
		} else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser is launched");
		} else {
			System.out.println("Please pass the value in testng.xml as Chrome / Edge / Firefox");
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			logger.info("Orange HRM application is launched");
		} else {
			logger.info("Orange HRM application is not launched");
		}
	}
	
	//4
	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("Browser closed successfully");
	}
	
	//Capturing Screenshot
	public void capturescreen(WebDriver driver, String testname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =  ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + testname + ".png");
		FileUtils.copyFile(source, target);
		logger.info("Screenshot captured successfully");
	}
	
}
