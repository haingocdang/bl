package com.bankguru.user;

import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_Register;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageOjbect;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_03_Edit_User extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		
		log.info("Pre-condition - Open Browser");
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver(url);
		
		log.info("Pre-condition - STEP 01: Open Login page");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		
		log.info("Pre-condition - STEP 02: Login with valid account");
		loginPage.loginWithValidAccount(Common_01_Register.userIDValue,Common_01_Register.passwordValue);
		homePage=PageGeneratorManager.getHomePageObject(driver);
		
		
		
	}

	@Test
	public void TC_01_Edit_Name() {
		
	}
	
	@Test
	public void TC_02_Edit_Address() {
		
	}
	
	@Test
	public void TC_03_Edit_Phone() {
		
	}
	
	
	@Test
	public void TC_04_Edit_City() {
		
	}
	
	

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	DriverManager driverManager;
	LoginPageOjbect loginPage;
	HomePageObject homePage;	
	RegisterPageObject registerPage;
	

}
