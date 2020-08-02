package com.bankguru.customer;

import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_Register;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageOjbect;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Cutomer_01_Validate_New_Customer extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		log.info("Pre-condition - Open Browser");
		driverManager = BrowserDriverFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver(url);

		log.info("Pre-condition - STEP 01: Open Login page");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);

		log.info("Pre-condition - STEP 02: Login with valid account");
		loginPage.loginWithValidAccount(Common_01_Register.userIDValue, Common_01_Register.passwordValue);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		

	}
	
	@BeforeMethod
	public void beforeMethod() {
		log.info("Pre-condition - STEP 03: Click to New Customer link");
		homePage.clickToDynamicLink(driver, "New Customer");
		//printBrowserConsoleLog(driver);
		newCustomerPage = PageGeneratorManager.getNewCustomerPageObject(driver);
		
	}

	@Test
	public void NC_01_Verify_Name_Field() {
		log.info("NC01 - STEP 01: Do not enter value into Name field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"Customer Name");

		log.info("NC01 - VP: Customer name must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Customer name must not be blank");

		log.info("NC01 - STEP 03: Enter numberic into Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", valueIncludeNumeric);

		log.info("NC01 - VP: Numbers are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Numbers are not allowed");

		log.info("NC01 - STEP 05: Enter special characters into Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", valueIncludeSpecialCharacters);

		log.info("NC01 - VP: Special characters are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Special characters are not allowed");

		log.info("NC01 - STEP 05: Enter first characters blank space into Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", valueIncludeFirstCharacterSpace);

		log.info("NC01 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "First character cannot be space");

	}

	@Test
	public void NC_02_Verify_Address_Field() {
		log.info("NC02 - STEP 01: Do not enter value into Address field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextAreaField(driver,"Address");

		log.info("NC02 - VP: ADDRESS cannot be empty messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Address"), "ADDRESS cannot be empty");

		log.info("NC02 - STEP 05: Enter first characters blank space into Address field");
		newCustomerPage.inputToDynamicTextarea(driver, "Address", valueIncludeFirstCharacterSpace);

		log.info("NC02 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Address"), "First character cannot be space");

	}
	
	@Test
	public void NC_03_Verify_City_Field() {
		log.info("NC03 - STEP 01: Do not enter value into City field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"City");
		
		log.info("NC03 - VP: City Field must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "City Field must not be blank");
		
		log.info("NC03 - STEP 03: Enter numberic into City field");
		newCustomerPage.inputToDynamicTextbox(driver, "City", valueIncludeNumeric);

		log.info("NC03 - VP: Numbers are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "Numbers are not allowed");

		log.info("NC03 - STEP 05: Enter special characters into City field");
		newCustomerPage.inputToDynamicTextbox(driver, "City", valueIncludeSpecialCharacters);

		log.info("NC03 - VP: Special characters are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "Special characters are not allowed");

		log.info("NC03 - STEP 05: Enter first characters blank space into City field");
		newCustomerPage.inputToDynamicTextbox(driver, "City", valueIncludeFirstCharacterSpace);

		log.info("NC03 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "First character cannot be space");

	}
	
	@Test
	public void NC_04_Verify_State_Field() {
		log.info("NC04 - STEP 01: Do not enter value into State field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"State");
		
		log.info("NC04 - VP: State must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "State must not be blank");
		
		log.info("NC04 - STEP 03: Enter numberic into State field");
		newCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeNumeric);

		log.info("NC04 - VP: Numbers are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "Numbers are not allowed");

		log.info("NC04 - STEP 05: Enter special characters into State field");
		newCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeSpecialCharacters);

		log.info("NC04 - VP: Special characters are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "Special characters are not allowed");

		log.info("NC04 - STEP 05: Enter first characters blank space into State field");
		newCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeFirstCharacterSpace);

		log.info("NC04 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "First character cannot be space");

	}
	
	@Test
	public void NC_05_Verify_PIN_Field() {
		
		log.info("NC05 - STEP 01: Enter characters value into PIN field");
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", valueIncludeCharacters);
		
		log.info("NC05 - VP: Characters are not allowed messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "Characters are not allowed");
		
		log.info("NC05 - STEP 03: Do not enter value into PIN field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"PIN");
		
		log.info("NC05 - VP: PIN code must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN code must not be blank");
		
		log.info("NC05 - STEP 05: Input more than 6 numberic into PIN field");
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueMoreThan6Chars);

		log.info("NC05 - VP: PIN Code must have 6 Digits message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN Code must have 6 Digits");
		
		log.info("NC05 - STEP 07: Input less than 6 numberic into PIN field");
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueLessThan6Chars);

		log.info("NC05 - VP: PIN Code must have 6 Digits message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN Code must have 6 Digits");
		
		log.info("NC05 - STEP 09: Input Specical Character into PIN Field");
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueIncludeSpecialChars);

		log.info("NC05 - VP: Special characters are not allowed message must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "Special characters are not allowed");

		log.info("NC05 - STEP 11: Enter first characters blank space into PIN field");
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueIncludeFirstSpaceChar);

		log.info("NC05 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "First character cannot be space");

	}
	
	@Test
	public void NC_06_Verify_Telephone_Field() {
		log.info("NC06 - STEP 01: Do not enter value into Telephone field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"Mobile Number");
		
		log.info("NC06 - VP: Mobile no must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Mobile Number"), "Mobile no must not be blank");
		
		log.info("NC06 - STEP 03: Enter first characters blank space into Telephone field");
		newCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", telehoneNoValueIncludeFirstSpaceChar);

		log.info("NC06 - VP: First character cannot be space message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Mobile Number"), "First character cannot be space");
		
		log.info("NC06 - STEP 05: Enter special characters into Mobile field");
		newCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", telehoneNoValueIncludeSpecialChars);

		log.info("NC06 - VP: Special characters are not allowed message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Mobile Number"), "Special characters are not allowed");
		
	}
	
	@Test
	public void NC_07_Verify_Email_Field() {
		log.info("NC07 - STEP 01: Do not enter value into Email field and Press Tab key to move to next field");
		newCustomerPage.releaseEmptyTextboxField(driver,"E-mail");
		
		log.info("NC07 - VP: Email ID must not be blank messaage must be shown");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "E-mail"), "Email ID must not be blank");
		
		log.info("NC07 - STEP 03: Input incorrect format Email");
		newCustomerPage.inputToDynamicTextbox(driver, "E-mail", "guru99@gmail");

		log.info("NC07 - VP: E-mail ID is not valid message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "E-mail"), "Email-ID is not valid");
		
		log.info("NC07 - STEP 05: Enter space into Email field");
		newCustomerPage.inputToDynamicTextbox(driver, "E-mail", " ");

		log.info("NC07 - VP: E-mail ID is not valid message display");
		verifyEquals(newCustomerPage.getDyNamicErrorMessageByColumnName(driver, "E-mail"), "Email-ID is not valid");
	}
	
	@Test
	public void NC_08_Verify_All_Label_Display_As_Requirement() {
		log.info("NC08 - VP: Field Names: Customer Name, Gender, Date of Birth, Address, City, State, Mobile Number, E-mail, Password are displayed as requirement");
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Customer Name"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Gender"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Date of Birth"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Address"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "City"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "State"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Mobile Number"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "E-mail"));
		verifyTrue(newCustomerPage.IsDyNamicLabelDisplay(driver, "Password"));
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	DriverManager driverManager;
	LoginPageOjbect loginPage;
	HomePageObject homePage;
	NewCustomerPageObject newCustomerPage;
	EditCustomerPageObject editCustomerPage;
	RegisterPageObject registerPage;
	
	public static String valueIncludeNumeric="Value1234";
	public static String valueIncludeCharacters="1234PI";
	public static String valueIncludeSpecialCharacters="Value@!";
	public static String valueIncludeFirstCharacterSpace=" Value";
	public static String pinValueMoreThan6Chars="1234567";
	public static String pinValueLessThan6Chars="12345";
	public static String pinValueIncludeSpecialChars="1234@!";
	public static String pinValueIncludeFirstSpaceChar=" 123456";
	public static String telehoneNoValueIncludeSpecialChars="1234@!";
	public static String telehoneNoValueIncludeFirstSpaceChar=" 123456";
	

}
