package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver=driver;
	}

	public LoginPageObject clickToMyAccountLink() {
		waitElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);		
		//return new LoginPageObject(driver);
		return PageGeneratorManager.getLoginPage(driver);
	}

	
	
	
}
