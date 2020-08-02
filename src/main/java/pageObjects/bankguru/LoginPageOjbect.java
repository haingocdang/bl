package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import commons.GlobalConstants;
import pageUIs.bankguru.LoginPageUI;

public class LoginPageOjbect extends AbstractPage {

	public WebDriver driver;

	public LoginPageOjbect(WebDriver driver) {
		this.driver = driver;
		closeAd(driver);
	}
	

	public void clickToHereLink() {
		waitElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}
	
	public void openLoginPage() {
		driver.get(GlobalConstants.LOGIN_BANKGURU_URL);
	}
	
	
	public void loginWithValidAccount(String userIDValue, String passwordValue) {
		waitElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userIDValue);

		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passwordValue);

		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}
}
