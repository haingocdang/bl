package alpaca.baolong.users;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObjects.alpaca.LoginPageObject;

import commons.PageGeneratorManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Authentication_Login extends AbstractTest {
	
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
			
		log.info("Pre-condition - Open Browser");
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
	
	}

	@Parameters({"url"})
	@BeforeMethod
	public void beforeMethod(String url) {
		driver=driverManager.getDriver(url);
		setDriver(driver);
		log.info("Pre-condition - STEP 01: Open Login page");
		loginPage=PageGeneratorManager.getLoginPage(driver);
	}
	
	  @Test 
	  public void Testcase_01_Sign_In_Successfully() {
	  log.info("Testcase_01_Sign_In_Successfully - STEP 01: Enter corect user name and password"); 
	  loginPage.inputUserName(username);
	  loginPage.inputUserPassword(password);
	  
	  log.info("Testcase_01_Sign_In_Successfully - STEP 02: Click on [Đăng Nhập] button"); 
	  loginPage.clickDangNhapButton();
	  }
	  
	  @Test 
	  public void Testcase_02_Sign_In_Failed_Missing_All_Fields() {
	  log.info("Testcase_02_Sign_In_Failed_Missing_All_Fields - STEP 01: Click on [Đăng Nhập] button"); 
	  loginPage.clickDangNhapButton();
	  
	  log.info("Testcase_02_Sign_In_Failed_Missing_All_Fields - VP: [Trường thông tin bắt buộc] error displays on User Name field"); 
	  verifyEquals(loginPage.getBlankErrorMessageAtUsernameField(), "Trường thông tin bắt buộc");
	  
	  log.info("Testcase_02_Sign_In_Failed_Missing_All_Fields - VP: [Trường thông tin bắt buộc] error displays on Password field"); 
	  verifyEquals(loginPage.getBlankErrorMessageAtPasswordField(), "Trường thông tin bắt buộc");
	  }
	  
	  @Test 
	  public void Testcase_03_Sign_In_Wrong_User_Name() {
	  log.info("Testcase_03_Sign_In_Wrong_User_Name - STEP 01: Input wrong User Name"); 
	  loginPage.inputUserName("InvalidUser");
	  
	  log.info("Testcase_03_Sign_In_Wrong_User_Name - STEP 02: Input Password"); 
	  loginPage.inputUserPassword("9a20079916a65567e57545cdb946b9be");
	  
	  log.info("Testcase_03_Sign_In_Wrong_User_Name - STEP 03: Click on [Đăng Nhập] button"); 
	  loginPage.clickDangNhapButton();
	  
	  log.info("Testcase_03_Sign_In_Wrong_User_Name - VP: [The user credentials were incorrect.] error displays"); 
	  verifyEquals(loginPage.getInvalidLoginErrorMessage(), "The user credentials were incorrect.");
	  }
	  
	  @Test 
	  public void Testcase_04_Sign_In_Wrong_Password() {
	  log.info("Testcase_04_Sign_In_Wrong_Password - STEP 01: Input User Name"); 
	  loginPage.inputUserName(username);
	  
	  log.info("Testcase_04_Sign_In_Wrong_Password - STEP 02: Input Password"); 
	  loginPage.inputUserPassword("Invalid Password");
	  
	  log.info("Testcase_04_Sign_In_Wrong_Password - STEP 03: Click on [Đăng Nhập] button"); 
	  loginPage.clickDangNhapButton();
	  
	  log.info("Testcase_04_Sign_In_Wrong_Password - VP: [The user credentials were incorrect.] error displays"); 
	  verifyEquals(loginPage.getInvalidLoginErrorMessage(), "The user credentials were incorrect.");
	  }
	 
	@AfterMethod
	public void afterMethod() {
		driverManager.quitDriver();
	}
	  
	@AfterClass
	public void afterClass() {
		log.info("Post-condition - Close Browser");
		driverManager.quitDriver();
	}

	DriverManager driverManager;
	WebDriver driver;
	LoginPageObject loginPage;
	String username="haidang11601";
	String password="12341234";
	

}
