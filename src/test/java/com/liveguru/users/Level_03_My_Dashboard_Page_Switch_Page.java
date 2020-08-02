package com.liveguru.users;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.AddresBookPageObject;
import pageObjects.liveguru.BillingAgreementsPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyApplicationsPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;
import pageUIs.liveguru.MyApplicationaPageUI;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_03_My_Dashboard_Page_Switch_Page extends AbstractTest {
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName, String url) {
				
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver=driverManager.getDriver(url);
		
		homePage=PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToMyAccountLink();


	}

	@BeforeMethod
	public void BeforeMethod() {

		myDashboardPage=loginPage.loginWithValidEmailAndPassword("hai25252589@yopmail.com", "123456");
	}

	@Test
	public void Testcase_01_Switch_Pages() {
		
		//Switch My Dashboard==> Account Information
		accountInforPage=myDashboardPage.clickToAccountInforLink(driver);
		
		//Switch Account Info ===>Address book
		addressBookPage=accountInforPage.clickToAddressBookLink(driver);
		
		//Switch Address Book ==> My Dashboard
		myDashboardPage=addressBookPage.clickToAccountDashboardLink(driver);
		
		//Switch My Dashboard===> Billing Page
		billingPage=myDashboardPage.clickToBillingAgreementsLink(driver);
		
		//Swtich Billing page==> My APplication
		myApplicationPage=billingPage.clickToMyApplicationLink(driver);

	}
	
	@AfterClass
	public void afterClass() {
		driverManager.quitDriver();
	}

	DriverManager driverManager;
	WebDriver driver;
	
	AccountInformationPageObject accountInforPage;
	AddresBookPageObject addressBookPage;
	BillingAgreementsPageObject billingPage;
	MyApplicationsPageObject myApplicationPage;
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyDashboardPageObject myDashboardPage;

}
