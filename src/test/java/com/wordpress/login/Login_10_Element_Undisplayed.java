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

public class Login_10_Element_Undisplayed extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver=driverManager.getDriver(url);
		loginPage=PageGeneratorManager.getLoginPageObject(driver);
		loginPage.LoginWithValidAccount("automationeditor","automationfc");
		homePage=PageGeneratorManager.getHomePageObject(driver);
	}

	
	@Test
	public void TC_01_Element_Undislpay_In_Dom() {
		homePage.clickToScreenOption();
		//button[@id='show-settings-link']
		
		System.out.println("START check Activity Checkbox is displayed:"+getDateTimeNow());
		Assert.assertTrue(homePage.isActivityCheckBoxDisplayed());
		System.out.println("END check Activity Checkbox is displayed:"+getDateTimeNow());

		//input[@id='dashboard_activity-hide']
		
		//Click To Screen Options: closed / Inactive
		homePage.clickToScreenOption();
		
		System.out.println("START check Activity Checkbox is not displayed:"+getDateTimeNow());
		Assert.assertTrue(homePage.isActivityCheckBoxNotDisplayed());
		System.out.println("END check Activity Checkbox is not displayed:"+getDateTimeNow());

		System.out.println("START check Post Sub Menu is not displayed:"+getDateTimeNow());
		Assert.assertTrue(homePage.IsAllPostsSubMenuNotDisplayed());
		System.out.println("END check Post Sub Menu is not displayed:"+getDateTimeNow());

	}
	
	@Test
	public void TC_02_Element_Undislpay_Is_Not_In_Dom() {
		System.out.println("START check Plans Menu is not displayed:"+getDateTimeNow());
		Assert.assertTrue(homePage.isPlansMenuNotDisplayed("Plans"));
		System.out.println("END check Plans Menu is not displayed:"+getDateTimeNow());
		
		
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
