package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void LoginWithValidAccount(String emailOrUserName, String password) {
		waitElementVisible(driver, LoginPageUI.EMAIL_USERNAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_USERNAME_TEXTBOX, emailOrUserName);
		
		waitElementClickable(driver, LoginPageUI.CONTINUE_BUTTON);
		clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
		
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
		waitElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
		
	}

}
