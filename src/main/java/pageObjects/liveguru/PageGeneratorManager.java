package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static AccountInformationPageObject getAccountInforPage(WebDriver driver) {
		return new AccountInformationPageObject(driver);
	}
	
	public static AddresBookPageObject getAddressBookPage(WebDriver driver) {
		return new AddresBookPageObject(driver);
	}
	
	public static BillingAgreementsPageObject getBillingPage(WebDriver driver) {
		return new BillingAgreementsPageObject(driver);
	}
	
	public static MyApplicationsPageObject getMyApplicationsPage(WebDriver driver) {
		return new MyApplicationsPageObject(driver);
	}
	
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}

}
