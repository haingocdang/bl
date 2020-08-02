package pageObjects.liveguru;


import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public MyDashboardPageObject clickToRegisterButton() {

		waitElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		//return new MyDashboardPageObject(driver);
		return PageGeneratorManager.getMyDashboardPage(driver);
	
	}
	
	public String getRequireErrorMessageAtFirstNameField() {

		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_FIRSTNAME_TEXTBOX);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_FIRSTNAME_TEXTBOX);
	}

	public String getRequireErrorMessageAttLastNameField() {

		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_LASTNAME_TEXTBOX);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_LASTNAME_TEXTBOX);
	}

	public String getRequireErrorMessageAtEmailField() {

		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_EMAIL_TEXTBOX);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_EMAIL_TEXTBOX);
	}

	public String getRequireErrorMessageAtPasswordField() {

		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_PASSWORD_TEXTBOX);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_PASSWORD_TEXTBOX);
	}

	public String getRequireErrorMessageAtConfirmPasswordField() {

		waitElementVisible(driver, RegisterPageUI.REQUIRED_ERROR_MSG_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, RegisterPageUI.REQUIRED_ERROR_MSG_CONFIRM_PASSWORD_TEXTBOX);
	}

	public String getInvalidErrorMessageAtEmailField() {

		waitElementVisible(driver, RegisterPageUI.INVALID_ERROR_MSG_EMAIL_TEXTBOX);
		return getElementText(driver, RegisterPageUI.INVALID_ERROR_MSG_EMAIL_TEXTBOX);
	}
	
	public String getInvalidErrorMessageAtPasswordField() {

		waitElementVisible(driver, RegisterPageUI.INVALID_ERROR_MSG_PASSWORD_TEXTBOX);
		return getElementText(driver, RegisterPageUI.INVALID_ERROR_MSG_PASSWORD_TEXTBOX);
	}

	public String getInvalidErrorMessageAtConfirmPasswordField() {

		waitElementVisible(driver, RegisterPageUI.INVALID_ERROR_MSG_CONFIRM_PASSWORD_TEXTBOX);
		return getElementText(driver, RegisterPageUI.INVALID_ERROR_MSG_CONFIRM_PASSWORD_TEXTBOX);
	}

	public void inputToFirstNameField(String firstName) {

		waitElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
		
	}

	public void inputToMiddleNameField(String middleName) {

		waitElementVisible(driver, RegisterPageUI.MIDDLENAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.MIDDLENAME_TEXTBOX, middleName);
		
	}

	public void inputToLastNameField(String lastName) {

		waitElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	
	public void inputToEmailField(String email) {

		waitElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void inputToPasswordField(String password) {

		waitElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordField(String confirmPassword) {

		waitElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
		
	}

}
