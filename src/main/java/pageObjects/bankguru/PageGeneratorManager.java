package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

public abstract class PageGeneratorManager {
	
	public static LoginPageOjbect getLoginPageObject(WebDriver driver) {
		return new LoginPageOjbect(driver);
	}
	
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static NewCustomerPageObject getNewCustomerPageObject(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	
	public static EditCustomerPageObject getEditCustomerPageObject(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	
}
