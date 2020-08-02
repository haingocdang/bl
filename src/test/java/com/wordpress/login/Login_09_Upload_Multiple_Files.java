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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Login_09_Upload_Multiple_Files extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver=driverManager.getDriver(url);
		loginPage=PageGeneratorManager.getLoginPageObject(driver);

	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage.LoginWithValidAccount("automationeditor","automationfc");
		homePage=PageGeneratorManager.getHomePageObject(driver);
	}

	@Test
	public void TC_01_Upload_Media() {
		homePage.clickToMoreDynamicPagesMenu(driver, "Media");
		mediaPage=PageGeneratorManager.getMediaPageObject(driver);
		mediaPage.clickToAddNewButton();
		mediaPage.uploadMultipleFiles(driver, "File1.png","File2.jpg","File3.jpg","File4.jpg");
		
		Assert.assertTrue(mediaPage.areFilesUploadedSuccess(driver, "File1.png","File2.jpg","File3.jpg","File4.jpg"));
		
		
	}
	
	@AfterMethod
	public void AfterMethod() {
		mediaPage.deletedUploadedFiles("File1.png","File2.jpg","File3.jpg","File4.jpg");
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
