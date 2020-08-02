package pageFactory.liveguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.liveguru.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(how = How.XPATH, using = "//input[@id='firstname']")
	@FindBy(xpath= "//input[@id='firstname']")
	private WebElement firstNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='middlename']")
	private WebElement middleNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='lastname']")
	private WebElement lastNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='email_address']")
	private WebElement emailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	private WebElement passwordTextbox;

	@FindBy(how = How.XPATH, using = "//input[@id='confirmation']")
	private WebElement confirmPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//span[text()='Register']")
	private WebElement registerButton;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-required-entry-firstname']")
	private WebElement requireErrorMsgAtFirstNameTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-required-entry-lastname']")
	private WebElement requireErrorMsgAtLastNameTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-required-entry-email_address']")
	private WebElement requireErrorMsgAtEmailTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-email-email_address']")
	private WebElement invalidErrorMsgAtEmailTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-required-entry-password']")
	private WebElement requireErrorMsgAtPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-password-password']")
	private WebElement invalidErrorMsgAtPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-required-entry-confirmation']")
	private WebElement requireErrorMsgAtConfirmPasswordTextbox;

	@FindBy(how = How.XPATH, using = "//div[@id='advice-validate-cpassword-confirmation']")
	private WebElement invalidErrorMsgAtConfirmPasswordTextbox;

	public MyDashboardPageObject clickToRegisterButton() {
		waitElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		return new MyDashboardPageObject(driver);
	}

	public String getRequireErrorMessageAtFirstNameField() {
		waitElementVisible(driver, requireErrorMsgAtFirstNameTextbox);
		return getElementText(driver, requireErrorMsgAtFirstNameTextbox);
	}

	public String getRequireErrorMessageAttLastNameField() {
		waitElementVisible(driver, requireErrorMsgAtLastNameTextbox);
		return getElementText(driver, requireErrorMsgAtLastNameTextbox);
	}

	public String getRequireErrorMessageAtEmailField() {
		waitElementVisible(driver, requireErrorMsgAtEmailTextbox);
		return getElementText(driver, requireErrorMsgAtEmailTextbox);
	}

	public String getRequireErrorMessageAtPasswordField() {
		waitElementVisible(driver, requireErrorMsgAtPasswordTextbox);
		return getElementText(driver, requireErrorMsgAtPasswordTextbox);
	}

	public String getRequireErrorMessageAtConfirmPasswordField() {
		waitElementVisible(driver, requireErrorMsgAtConfirmPasswordTextbox);
		return getElementText(driver, requireErrorMsgAtConfirmPasswordTextbox);
	}

	public String getInvalidErrorMessageAtEmailField() {
		waitElementVisible(driver, invalidErrorMsgAtEmailTextbox);
		return getElementText(driver, invalidErrorMsgAtEmailTextbox);
	}

	public String getInvalidErrorMessageAtPasswordField() {
		waitElementVisible(driver, invalidErrorMsgAtPasswordTextbox);
		return getElementText(driver, invalidErrorMsgAtPasswordTextbox);
	}

	public String getInvalidErrorMessageAtConfirmPasswordField() {
		waitElementVisible(driver, invalidErrorMsgAtConfirmPasswordTextbox);
		return getElementText(driver, invalidErrorMsgAtConfirmPasswordTextbox);
	}

	public void inputToFirstNameField(String firstName) {
		waitElementVisible(driver, firstNameTextbox);
		sendKeyToElement(driver, firstNameTextbox, firstName);

	}

	public void inputToMiddleNameField(String middleName) {
		waitElementVisible(driver, middleNameTextbox);
		sendKeyToElement(driver, middleNameTextbox, middleName);

	}

	public void inputToLastNameField(String lastName) {
		waitElementVisible(driver, lastNameTextbox);
		sendKeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailField(String email) {
		waitElementVisible(driver, emailTextbox);
		sendKeyToElement(driver, emailTextbox, email);

	}

	public void inputToPasswordField(String password) {
		waitElementVisible(driver, passwordTextbox);
		sendKeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordField(String confirmPassword) {
		waitElementVisible(driver, confirmPasswordTextbox);
		sendKeyToElement(driver, confirmPasswordTextbox, confirmPassword);

	}

}
