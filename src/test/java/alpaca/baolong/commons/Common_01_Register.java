package alpaca.baolong.commons;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import commons.PageGeneratorManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Common_01_Register extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String url) {

		/*
		 * log.info("Pre-condition - Open Browser"); driverManager =
		 * BrowserDriverFactory.getBrowserDriver(browserName); driver =
		 * driverManager.getDriver(url); loginPage =
		 * PageGeneratorManager.getLoginPageObject(driver);
		 * 
		 * log.info("Pre-condition - STEP 01: Click Here Link");
		 * loginPage.clickToHereLink(); registerPage =
		 * PageGeneratorManager.getRegisterPageObject(driver);
		 * 
		 * log.info("Pre-condition - STEP 02: Input Email Address");
		 * registerPage.inputToEmailTextbox("haidang" + randomNumber() +
		 * "@yopmail.com");
		 * 
		 * log.info("Pre-condition - STEP 03: Click Submit button");
		 * registerPage.clickToSubmitButton();
		 * 
		 * log.info("Pre-condition - STEP 04: Get User ID"); userIDValue =
		 * registerPage.getUserIDText();
		 * 
		 * log.info("Pre-condition - STEP 05: Get Password"); passwordValue =
		 * registerPage.getPasswordText();
		 * 
		 * driver.quit();
		 */

	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	WebDriver driver;
	DriverManager driverManager;
	public static String userIDValue, passwordValue;
}
