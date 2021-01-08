package pageObjects.mercury;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.alpaca.mercury.LoginPageUI;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void inputUserName(String userName) {
		waitElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, userName);
	}
	
	public void inputUserPassword(String userPassword) {
		waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, userPassword);
	}
	
	public void clickDangNhapButton() {
		waitElementVisible(driver, LoginPageUI.DANG_NHAP_BUTTON);
		clickToElement(driver, LoginPageUI.DANG_NHAP_BUTTON);
		sleepInSecond(2);
	}
	
	public String getBlankErrorMessageAtUsernameField() {
		waitElementVisible(driver, LoginPageUI.BLANK_USER_NAME_ERROR);
		return getElementText(driver, LoginPageUI.BLANK_USER_NAME_ERROR);
	}
	
	public String getBlankErrorMessageAtPasswordField() {
		waitElementVisible(driver, LoginPageUI.BLANK_PASSWORD_ERROR);
		return getElementText(driver, LoginPageUI.BLANK_PASSWORD_ERROR);
	}
	
	public String getInvalidLoginErrorMessage() {
		waitElementVisible(driver, LoginPageUI.INVALID_LOGIN_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_LOGIN_ERROR_MESSAGE);
	}

}
