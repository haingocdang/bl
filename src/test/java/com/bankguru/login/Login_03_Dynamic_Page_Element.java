package com.bankguru.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_Register;
import com.bankguru.data.Payment;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import commons.DataHelper;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageOjbect;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;

public class Login_03_Dynamic_Page_Element extends AbstractTest {
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		customerName = "Hai Dang";
		gender = "f";
		dateOfBirth = "05/16/1984";
		address = "1A Dien Bien Phu";
		city = "Gia Dinh";
		state = "Binh Thanh";
		pin = "123654";
		mobileNumber = "0919999999";
		emailAddress = "hai.dang" + randomNumber() + "@yopmail.com";
		password = "123654";
		
		updatedAddress = "1A Phan Xich Long";
		updatedCity = "Ho Chi Minh";
		updatedState = "Phu Nhuan";
		updatedPIN = "96325874";
		updatedMobileNumber = "0911111111";
		updatedEmailAddress = "hai.dang" + randomNumber() + "@yopmail.com";
		
		data=DataHelper.getData();
		
		log.info("Pre-condition - Open Browser");
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver(url);

		log.info("Pre-condition - STEP 01: Open Login page");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);

		log.info("Pre-condition - STEP 02: Login with valid account");
		loginPage.loginWithValidAccount(Common_01_Register.userIDValue, Common_01_Register.passwordValue);
		homePage = PageGeneratorManager.getHomePageObject(driver);

	}

	@Test
	public void TC_01_New_Customer() {

		log.info("TC_01_New_Customer - STEP 01: Click to New Customer link");
		homePage.clickToDynamicLink(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPageObject(driver);

		log.info("TC_01_New_Customer - STEP 02: Input all valid values");
		/*newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", customerName);
		newCustomerPage.clickToDynamicRadioButton(driver, gender);
		newCustomerPage.inputToDynamicTextbox(driver, "Date of Birth", dateOfBirth);
		newCustomerPage.inputToDynamicTextarea(driver, "Address", address);
		newCustomerPage.inputToDynamicTextbox(driver, "City", city);
		newCustomerPage.inputToDynamicTextbox(driver, "State", state);*/
		
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", data.getFullName());
		newCustomerPage.clickToDynamicRadioButton(driver, Payment.NewCustomer.GENER);
		newCustomerPage.inputToDynamicTextbox(driver, "Date of Birth", data.getBirthDate());
		newCustomerPage.inputToDynamicTextarea(driver, "Address", data.getAddress());
		newCustomerPage.inputToDynamicTextbox(driver, "City", Payment.NewCustomer.CITY);
		newCustomerPage.inputToDynamicTextbox(driver, "State", data.getState());
	
		
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", data.getPIN());
		newCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", data.getPhone());
		newCustomerPage.inputToDynamicTextbox(driver, "E-mail", data.getEmailAddress());
		newCustomerPage.inputToDynamicTextbox(driver, "Password", data.getPassword());

		log.info("TC_01_New_Customer - STEP 03: Click Submit button");
		newCustomerPage.clickToDynamicButton(driver, "Submit");

		/*log.info("TC_01_New_Customer - VP: Customer Registered Successfully messaage appears");
		verifyTrue(newCustomerPage.IsDyNamicMessageDisplay(driver, "Customer Registered Successfully!!!"));
		
		log.info("TC_01_New_Customer - VP: all customer's info displays correctly");
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Customer Name"), customerName);
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Gender"), "female");
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Birthdate"), "1984-05-16");
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Address"), address);
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "City"), city);
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "State"), state);
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Mobile No."), mobileNumber);
		verifyEquals(newCustomerPage.getDyNamicValueByColumnName(driver, "Email"), emailAddress);
		
		newCustomerID=newCustomerPage.getDyNamicValueByColumnName(driver, "Customer ID");

		log.info("TC_01_New_Customer - Step 06: Click To Continue links");
		newCustomerPage.clickToDynamicLink(driver, "Continue");
		homePage = PageGeneratorManager.getHomePageObject(driver);*/

	}
	
	//@Test
	public void TC_02_Edit_Customer() {
		
		log.info("TC_02_Edit_Customer - STEP 01: Click to Edit Customer link");
		homePage.clickToDynamicLink(driver, "Edit Customer");
		editCustomerPage=PageGeneratorManager.getEditCustomerPageObject(driver);

		log.info("TC_02_Edit_Customer - STEP 02: Input Customer ID from TC 01");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer ID", newCustomerID);
		
		log.info("TC_02_Edit_Customer - STEP 03: Click to Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");
		
		log.info("TC_02_Edit_Customer - STEP 04: Update following info: Address, City, State, PIN No, Mobile Number and Email Address");
		editCustomerPage.inputToDynamicTextarea(driver, "Address", updatedAddress);
		editCustomerPage.inputToDynamicTextbox(driver, "City", updatedCity);
		editCustomerPage.inputToDynamicTextbox(driver, "State", updatedState);
		editCustomerPage.inputToDynamicTextbox(driver, "PIN", updatedPIN);
		editCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", updatedMobileNumber);
		editCustomerPage.inputToDynamicTextbox(driver, "E-mail", updatedEmailAddress);
				
		log.info("TC_02_Edit_Customer - STEP 05: Click Submit button");
		editCustomerPage.clickToDynamicButton(driver, "Submit");
		
		log.info("TC_02_Edit_Customer - VP: all customer's info is updated correctly");
		verifyTrue(editCustomerPage.IsDyNamicMessageDisplay(driver, "Customer details updated Successfully!!!"));
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Customer ID"), newCustomerID);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Customer Name"), customerName);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Gender"), "female");
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Birthdate"), "1984-05-16");
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Address"), updatedAddress);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "City"), updatedCity);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "State"), updatedState);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Mobile No."), updatedMobileNumber);
		verifyEquals(editCustomerPage.getDyNamicValueByColumnName(driver, "Email"), updatedEmailAddress);

		log.info("TC_02_Edit_Customer - Step 07: Click To Continue links");
		editCustomerPage.clickToDynamicLink(driver, "Continue");
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		//closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	DriverManager driverManager;
	LoginPageOjbect loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	DataHelper data;
	
	
	RegisterPageObject registerPage;
	String customerName, gender, dateOfBirth, address, city, state, pin, mobileNumber, emailAddress, password, newCustomerID;
	String updatedAddress, updatedCity, updatedState, updatedPIN, updatedMobileNumber, updatedEmailAddress;
}
