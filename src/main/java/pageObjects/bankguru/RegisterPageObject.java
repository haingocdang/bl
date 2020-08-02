package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.bankguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	
	public WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
		closeAd(driver);
	}
	
	public void inputToEmailTextbox(String emailAddress) {
		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}
	
	public void clickToSubmitButton() {
		waitElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	
	public String getUserIDText() {
		waitElementVisible(driver, RegisterPageUI.USER_ID_LABEL);
		return getElementText(driver, RegisterPageUI.USER_ID_LABEL);
	
	}
	
	public String getPasswordText() {
		waitElementVisible(driver, RegisterPageUI.PASSWORD_LABEL);
		return getElementText(driver, RegisterPageUI.PASSWORD_LABEL);
	}
	
	public void openLoginPage(String loginPageUrl) {
		openPageUrl(driver, loginPageUrl);
	}
	

}
