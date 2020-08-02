package com.wordpress.login;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.wordpress.HomePageObject;
import pageObjects.wordpress.LoginPageObject;
import pageObjects.wordpress.MediaPageObject;
import pageObjects.wordpress.PageGeneratorManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_11_Assert_Verify extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		
		log.info("Pre-condition - Open Browser");
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver(url);
		
		log.info("Pre-condition - STEP 01: Open Logim page");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		log.info("Pre-condition - STEP 01: Login with valid account and to to HOme page");
		loginPage.LoginWithValidAccount("automationeditor", "automationfc");
		homePage = PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Element_Undislpay_In_Dom() {
		log.info("TC_01_Element_Undislpay_In_Dom - STEP 01: Close Screen Options menu");
		homePage.clickToScreenOption();
		// button[@id='show-settings-link']

		log.info("TC_01_Element_Undislpay_In_Dom - VP: Check Activity Checkbox is displayed");
		verifyFalse(homePage.isActivityCheckBoxDisplayed());

		// input[@id='dashboard_activity-hide']

		// Click To Screen Options: closed / Inactive
		log.info("TC_01_Element_Undislpay_In_Dom - STEP 03: Close Screen Options menu");
		homePage.clickToScreenOption();

		log.info("TC_01_Element_Undislpay_In_Dom - VP: Check Activity Checkbox is NOT displayed");
		verifyFalse(homePage.isActivityCheckBoxNotDisplayed());

		verifyFalse(homePage.IsAllPostsSubMenuNotDisplayed());

	}

	@Test
	public void TC_02_Element_Undislpay_Is_Not_In_Dom() {

		log.info("TC_02_Element_Undislpay_Is_Not_In_Dom - VP: Check Plans menu is NOT displayed");
		verifyFalse(homePage.isPlansMenuNotDisplayed("Plans"));

	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

	WebDriver driver;
	DriverManager driverManager;
	LoginPageObject loginPage;
	HomePageObject homePage;
	MediaPageObject mediaPage;
}
