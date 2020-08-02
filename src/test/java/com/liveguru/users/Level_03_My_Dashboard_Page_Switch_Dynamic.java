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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Level_03_My_Dashboard_Page_Switch_Dynamic extends AbstractTest {
	
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
	public void Testcase_01_Switch_Less_Pages() {
		
		//Switch My Dashboard==> Account Information
		accountInforPage=(AccountInformationPageObject) myDashboardPage.clickToLessDynamicPagesMenu(driver, "Account Information");
		
		//Switch Account Info ===>Address book
		addressBookPage=(AddresBookPageObject) accountInforPage.clickToLessDynamicPagesMenu(driver, "Address Book");
		
		//Switch Address Book ==> My Dashboard
		myDashboardPage=(MyDashboardPageObject) addressBookPage.clickToLessDynamicPagesMenu(driver, "Account Dashboard");
		
		//Switch My Dashboard===> Billing Page
		billingPage=(BillingAgreementsPageObject) myDashboardPage.clickToLessDynamicPagesMenu(driver, "Billing Agreements");
		
		//Swtich Billing page==> My APplication
		myApplicationPage=(MyApplicationsPageObject) billingPage.clickToLessDynamicPagesMenu(driver, "My Applications");

	}
	
//	@Test
	public void Testcase_01_Switch_More_Pages() {
		
		//Switch My Dashboard==> Account Information
		myDashboardPage.clickToMoreDynamicPagesMenu(driver, "Account Information");
		accountInforPage= PageGeneratorManager.getAccountInforPage(driver);
		
		//Switch Account Info ===>Address book
		accountInforPage.clickToMoreDynamicPagesMenu(driver, "Address Book");
		addressBookPage=PageGeneratorManager.getAddressBookPage(driver);
		
		//Switch Address Book ==> My Dashboard
		addressBookPage.clickToMoreDynamicPagesMenu(driver, "Account Dashboard");
		myDashboardPage= PageGeneratorManager.getMyDashboardPage(driver);
		
		//Switch My Dashboard===> Billing Page
		myDashboardPage.clickToMoreDynamicPagesMenu(driver, "Billing Agreements");
		billingPage= PageGeneratorManager.getBillingPage(driver);
		
		//Swtich Billing page==> My APplication
		billingPage.clickToMoreDynamicPagesMenu(driver, "My Applications");
		myApplicationPage=PageGeneratorManager.getMyApplicationsPage(driver);

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
