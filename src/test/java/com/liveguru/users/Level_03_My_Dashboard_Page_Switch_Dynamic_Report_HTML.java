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

public class Level_03_My_Dashboard_Page_Switch_Dynamic_Report_HTML extends AbstractTest {
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
				
		log.info("Pre-condition - Open Browser");
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver=driverManager.getDriver(url);
		
		log.info("Pre-condition - STEP 01: Open Home page");
		homePage=PageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition - STEP 02: Click to Account link");
		loginPage = homePage.clickToMyAccountLink();


	}

	@BeforeMethod
	public void BeforeMethod() {

		log.info("Pre-condition - STEP 03: Login with valid Addcount and Pass");
		myDashboardPage=loginPage.loginWithValidEmailAndPassword("hai25252589@yopmail.com", "123456");
	}

//	@Test
	public void Testcase_01_Switch_Less_Pages() {
		
		
		log.info("Testcase_01_Switch_Less_Pages - STEP 01: Click To Account Information menu ");
		accountInforPage=(AccountInformationPageObject) myDashboardPage.clickToLessDynamicPagesMenu(driver, "Account Information");
		
		log.info("Testcase_01_Switch_Less_Pages - STEP 02: Click To Address Book menu ");
		addressBookPage=(AddresBookPageObject) accountInforPage.clickToLessDynamicPagesMenu(driver, "Address Book");
		
		log.info("Testcase_01_Switch_Less_Pages - STEP 03: Click To Account Dashboard menu ");
		myDashboardPage=(MyDashboardPageObject) addressBookPage.clickToLessDynamicPagesMenu(driver, "Account Dashboard");
		
		log.info("Testcase_01_Switch_Less_Pages - STEP 04: Click To Billing Agreements menu ");
		billingPage=(BillingAgreementsPageObject) myDashboardPage.clickToLessDynamicPagesMenu(driver, "Billing Agreements");
		
		log.info("Testcase_01_Switch_Less_Pages - STEP 05: Click To My Application menu ");
		myApplicationPage=(MyApplicationsPageObject) billingPage.clickToLessDynamicPagesMenu(driver, "My Applications");

	}
	
	@Test
	public void Testcase_01_Switch_More_Pages() {
		
		log.info("Testcase_01_Switch_Less_Pages-STEP 01: Click To Account Information menu ");
		myDashboardPage.clickToMoreDynamicPagesMenu(driver, "Account Information");
		accountInforPage= PageGeneratorManager.getAccountInforPage(driver);
		
		log.info("Testcase_01_Switch_Less_Pages-STEP 02: Click To Address Book menu ");
		accountInforPage.clickToMoreDynamicPagesMenu(driver, "Address Book");
		addressBookPage=PageGeneratorManager.getAddressBookPage(driver);
		
		log.info("Testcase_01_Switch_Less_Pages-STEP 03: Click To Account Dashboard menu ");
		addressBookPage.clickToMoreDynamicPagesMenu(driver, "Account Dashboard");
		myDashboardPage= PageGeneratorManager.getMyDashboardPage(driver);
		
		log.info("Testcase_01_Switch_Less_Pages-STEP 04: Click To Billing Agreements menu ");
		myDashboardPage.clickToMoreDynamicPagesMenu(driver, "Billing Agreements");
		billingPage= PageGeneratorManager.getBillingPage(driver);
		
		log.info("Testcase_01_Switch_Less_Pages-STEP 05: Click To My Application menu ");
		billingPage.clickToMoreDynamicPagesMenu(driver, "My Applications");
		myApplicationPage=PageGeneratorManager.getMyApplicationsPage(driver);

	}
	
	@AfterClass
	public void afterClass() {
		log.info("Post-condition - Close Browser");
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
