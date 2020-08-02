package com.liveguru.users;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_Register_Page_Object_Multiple_Browser_Factory_Pattern extends AbstractTest {
	DriverManager driverManager;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String url) {
				
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver=driverManager.getDriver(url);
		//driver.get("http://live.demoguru99.com/");
		//driver=driveBrowser.getDriver();
		homePage=PageGeneratorManager.getHomePage(driver);
		homePage.isPageLoaded(driver,"demoguru99");

	}

	@BeforeMethod
	public void BeforeMethod() {

		loginPage = homePage.clickToMyAccountLink();
		loginPage.isPageLoaded(driver,"customer/account/login/");
		// loginPage = new LoginPageObject(driver);
		registerPage = loginPage.clickToCreateAnAccoutButton();
		registerPage.isPageLoaded(driver,"customer/account/create/");
		// registerPage = new RegisterPageObject(driver);
	}

	@Test
	public void Register_01_With_Empty_Data() {
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRequireErrorMessageAtFirstNameField(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequireErrorMessageAttLastNameField(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequireErrorMessageAtEmailField(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequireErrorMessageAtPasswordField(), "This is a required field.");
		Assert.assertEquals(registerPage.getRequireErrorMessageAtConfirmPasswordField(), "This is a required field.");

	}

	@Test
	public void Register_02_With_Invalid_Email() {

		registerPage.inputToEmailField("123@123.456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getInvalidErrorMessageAtEmailField(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_With_Password_Less_Than_6Chars() {

		registerPage.inputToPasswordField("123");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getInvalidErrorMessageAtPasswordField(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_04_With_ConfirmPassword_Not_Matching() {

		registerPage.inputToPasswordField("123456");
		registerPage.inputToConfirmPasswordField("456321");
		registerPage.clickToRegisterButton();

		// Ham verify data
		Assert.assertEquals(registerPage.getInvalidErrorMessageAtConfirmPasswordField(), "Please make sure your passwords match.");
	}

	@Test
	public void Register_05_With_All_Valid_Data() {
		String emailAddress = "hai.dang" + randomNumber() + "@yopmail.com";

		registerPage.inputToFirstNameField("Hai");
		registerPage.inputToMiddleNameField("Ngoc");
		registerPage.inputToLastNameField("Ngoc");
		registerPage.inputToEmailField(emailAddress);
		registerPage.inputToPasswordField("123456");
		registerPage.inputToConfirmPasswordField("123456");
		myDashboardPage=registerPage.clickToRegisterButton();
		myDashboardPage.isPageLoaded(driver,"customer/account/index/");

		//myDashboardPage = new MyDashboardPageObject(driver);

		// Ham verify data
		Assert.assertEquals(myDashboardPage.getWelcomeSucessMessage(), "Thank you for registering with Main Website Store.");

		// Assert.assertTrue(myDashboardPage.isSucessMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyDashboardPageObject myDashboardPage;

}
