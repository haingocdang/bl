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
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Cutomer_02_Validate_Edit_Customer extends AbstractTest {

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

		log.info("Pre-condition - STEP 03: Click to New Customer link");
		homePage.clickToDynamicLink(driver, "New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPageObject(driver);

		log.info("Pre-condition - STEP 04: Create an New Customer");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", customerName);
		newCustomerPage.clickToDynamicRadioButton(driver, gender);
		newCustomerPage.inputToDynamicTextbox(driver, "Date of Birth", dateOfBirth);
		newCustomerPage.inputToDynamicTextarea(driver, "Address", address);
		newCustomerPage.inputToDynamicTextbox(driver, "City", city);
		newCustomerPage.inputToDynamicTextbox(driver, "State", state);
		newCustomerPage.inputToDynamicTextbox(driver, "PIN", pinNo);
		newCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", mobileNumber);
		newCustomerPage.inputToDynamicTextbox(driver, "E-mail", emailAddress);
		newCustomerPage.inputToDynamicTextbox(driver, "Password", password);
		newCustomerPage.clickToDynamicButton(driver, "Submit");
		
		newCustomerID = newCustomerPage.getDyNamicValueByColumnName(driver, "Customer ID");
		
		log.info("Pre-condition - STEP 05: Click To Continue links");
		newCustomerPage.clickToDynamicLink(driver, "Continue");
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		log.info("Pre-condition - STEP 06: Click To Edit Customer");
		homePage.clickToDynamicLink(driver, "Edit Customer");
		editCustomerPage=PageGeneratorManager.getEditCustomerPageObject(driver);

	}

	@Test
	public void EC_01_Customer_ID_Field() {
		log.info("EC_01 - STEP 01: Do not enter value into Cutomer ID field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"Customer ID");

		log.info("EC_01 - VP: Customer ID is required messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer ID"), "Customer ID is required");

		log.info("EC_01 - STEP 03: Enter character into Customer ID field");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer ID", "1234N");

		log.info("EC_01 - VP: Characters are not allowed message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer ID"), "Characters are not allowed");

		log.info("EC_01 - STEP 05: Enter special characters into Customer ID field");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer ID", "124@!");

		log.info("EC_01 - VP: Special characters are not allowed message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer ID"), "Special characters are not allowed");

		log.info("EC_01 - STEP 07: Input valid Cutomer ID");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer ID", newCustomerID);

		log.info("EC_01 - STEP 08: Click Submit");
		editCustomerPage.clickToDynamicButton(driver, "Submit");

		log.info("EC_01 - VP: Edit Customer page display");
		verifyTrue(editCustomerPage.IsDyNamicMessageDisplay(driver, "Edit Customer"));
	}

	@Test
	public void EC_02_Verify_Name_Field() {
		log.info("EC_02 - STEP 01: Do not enter value into Name field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"Customer Name");

		log.info("EC_02 - VP: Name cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Name cannot be empty");

		log.info("EC_02 - STEP 03: Enter numberic into Name field");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer Name", valueIncludeNumeric);

		log.info("EC_02 - VP: Name cannot contain numbers message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Name cannot contain numbers");

		log.info("EC_02 - STEP 05: Enter special characters into Name field");
		editCustomerPage.inputToDynamicTextbox(driver, "Customer Name", valueIncludeSpecialCharacters);

		log.info("EC_02 - VP: Name cannot contain Special Character message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Customer Name"), "Name cannot contain Special Character");

	}

	@Test
	public void EC_03_Verify_Address_Field() {
		log.info("EC_03 - STEP 01: Do not enter value into Address field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextAreaField(driver,"Address");

		log.info("EC_03 - VP: ADDRESS cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Address"), "ADDRESS cannot be empty");

	}

	@Test
	public void EC_04_Verify_City_Field() {
		log.info("EC_04 - STEP 01: Do not enter value into City field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"City");

		log.info("EC_04 - VP: CITY cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "CITY cannot be empty");

		log.info("EC_04 - STEP 03: Enter numberic into City field");
		editCustomerPage.inputToDynamicTextbox(driver, "City", valueIncludeNumeric);

		log.info("EC_04 - VP: City cannot contain Number message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "City cannot contain Number");

		log.info("EC_04 - STEP 05: Enter special characters into City field");
		editCustomerPage.inputToDynamicTextbox(driver, "City", valueIncludeSpecialCharacters);

		log.info("EC_04 - VP: City cannot contain Special Characters message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "City"), "City cannot contain Special Characters");
	}

	@Test
	public void EC_05_Verify_State_Field() {
		log.info("EC_05 - STEP 01: Do not enter value into State field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"State");

		log.info("EC_05 - VP: STATE cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "STATE cannot be empty");

		log.info("EC_05 - STEP 03: Enter numberic into State field");
		editCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeNumeric);

		log.info("EC_05 - VP: Numbers are not allowed message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "Numbers are not allowed");

		log.info("EC_05 - STEP 05: Enter special characters into State field");
		editCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeSpecialCharacters);

		log.info("EC_05 - VP: State cannot contain Special Characters message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "State cannot contain Special Characters");

		log.info("EC_05 - STEP 05: Enter first characters blank space into State field");
		editCustomerPage.inputToDynamicTextbox(driver, "State", valueIncludeFirstCharacterSpace);

		log.info("EC_05 - VP: First character cannot be space message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "State"), "First character cannot be space");

	}

	@Test
	public void EC_06_Verify_PIN_Field() {

		log.info("EC_06 - STEP 01: Enter characters value into PIN field");
		editCustomerPage.inputToDynamicTextbox(driver, "PIN", valueIncludeCharacters);

		log.info("EC_06 - VP: PIN cannot contain character messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN cannot contain character");

		log.info("EC_06 - STEP 03: Do not enter value into PIN field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"PIN");

		log.info("EC_06 - VP: PIN cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN cannot be empty");

		log.info("EC_06 - STEP 05: Input more than 6 numberic into PIN field");
		editCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueMoreThan6Chars);

		log.info("EC_06 - VP: PIN Code must contain 6 digits message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN Code must contain 6 digits");

		log.info("EC_06 - STEP 07: Input less than 6 numberic into PIN field");
		editCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueLessThan6Chars);

		log.info("EC_06 - VP: PIN Code must contain 6 digits message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN Code must contain 6 digits");

		log.info("EC_06 - STEP 09: Input Specical Character into PIN Field");
		editCustomerPage.inputToDynamicTextbox(driver, "PIN", pinValueIncludeSpecialChars);

		log.info("EC_06 - VP: PIN cannot contain Special Characters message must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "PIN"), "PIN cannot contain Special Characters");

	}

	@Test
	public void EC_07_Verify_Telephone_Field() {
		log.info("EC_07 - STEP 01: Do not enter value into Telephone field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"Mobile Number");

		log.info("EC_07 - VP: Telephone cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Mobile Number"), "Telephone cannot be empty");

		log.info("EC_07 - STEP 03: Enter special characters into Telephone field");
		editCustomerPage.inputToDynamicTextbox(driver, "Mobile Number", telehoneNoValueIncludeSpecialChars);

		log.info("EC_07 - VP: Telephone cannot contain Special Characters message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "Mobile Number"), "Telephone cannot contain Special Characters");

	}

	@Test
	public void EC_08_Verify_Email_Field() {
		log.info("EC_08 - STEP 01: Do not enter value into Email field and Press Tab key to move to next field");
		editCustomerPage.releaseEmptyTextboxField(driver,"E-mail");

		log.info("EC_08 - VP: Email cannot be empty messaage must be shown");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "E-mail"), "Email cannot be empty");

		log.info("EC_08 - STEP 03: Input incorrect format Email");
		editCustomerPage.inputToDynamicTextbox(driver, "E-mail", "guru99@gmail");

		log.info("EC_08 - VP: Email must be in format example@example.com message display");
		verifyEquals(editCustomerPage.getDyNamicErrorMessageByColumnName(driver, "E-mail"), "Email must be in format example@example.com");

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
	
	public String newCustomerID;
	public String customerName = "Hai Ngoc Dang";
	public String gender = "f";
	public String dateOfBirth = "05/26/1984";
	public String address = "1A Phan Xich Long";
	public String city = "Sai Gon";
	public String state = "Phuu Nhuan";
	public String pinNo = "123456";
	public String mobileNumber = "0911111111";
	public String emailAddress = "haidang" + randomNumber() + "@yopmail.com";
	public String password = "123456";
		
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
