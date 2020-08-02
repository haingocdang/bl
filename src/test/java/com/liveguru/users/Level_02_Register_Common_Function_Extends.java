/*package com.liveguru.users;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



import java.util.Random;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_02_Register_Common_Function_Extends extends AbstractPage {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", ".\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		openPageUrl(driver, "http://live.demoguru99.com/");
		driver.manage().window().maximize();
		setImcplicitWait(driver, 30);
	}

	@BeforeMethod
	public void BeforeMethod() {
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		clickToElement(driver, "//a[@title='Create an Account']");
	}

	@Test
	public void Register_01_With_Empty_Data() {
		clickToElement(driver, "//button[@title='Register']");
		
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-firstname']"), "This is a required field.");
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-lastname']"), "This is a required field.");
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-email_address']"), "This is a required field.");
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-password']"), "This is a required field.");
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-required-entry-confirmation']"), "This is a required field.");
	}

	@Test
	public void Register_02_With_Invalid_Email() {
		sendKeyToElement(driver, "//input[@id='email_address']", "123@123.456");
		clickToElement(driver, "//button[@title='Register']");
		
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-validate-email-email_address']"), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_With_Password_Less_Than_6Chars() {
		sendKeyToElement(driver, "//input[@id='password']", "123");
		clickToElement(driver, "//button[@title='Register']");

		Assert.assertEquals(getElementText(driver, "//div[@id='advice-validate-password-password']"), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_04_With_ConfirmPassword_Not_Matching() {
		sendKeyToElement(driver, "//input[@id='password']", "123456");
		sendKeyToElement(driver, "//input[@id='confirmation']", "456321");
		clickToElement(driver, "//button[@title='Register']");
		
		Assert.assertEquals(getElementText(driver, "//div[@id='advice-validate-cpassword-confirmation']"), "Please make sure your passwords match.");

	}

	@Test
	public void Register_05_With_All_Valid_Data() {
		String emailAddress = "hai.dang" + randomNumber() + "@yopmail.com";

		sendKeyToElement(driver, "//input[@id='firstname']", "Hai");
		sendKeyToElement(driver, "//input[@id='middlename']", "Ngoc");
		sendKeyToElement(driver, "//input[@id='lastname']", "Dang");
		sendKeyToElement(driver, "//input[@id='email_address']", emailAddress);
		sendKeyToElement(driver, "//input[@id='password']", "123456");
		sendKeyToElement(driver, "//input[@id='confirmation']", "123456");
		clickToElement(driver, "//button[@title='Register']");

		isElementDisplay(driver, "//span[contains(text(),'Thank you for registering with Main Website Store.')]");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(100000);
		return number;
	}

}
*/