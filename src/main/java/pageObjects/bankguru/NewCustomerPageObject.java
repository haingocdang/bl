package pageObjects.bankguru;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.bankguru.AbstractBankGuruPageUI;

public class NewCustomerPageObject extends AbstractPage {
	public WebDriver driver;
	Keys key;
	
	public NewCustomerPageObject(WebDriver driver) {
		this.driver=driver;
		closeAd(driver);
	}
	
	/*public void releaseEmptyTextboxField(String fieldName) {
		waitElementClickable(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX,fieldName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, fieldName);
		sendKeyBoardToDynamicBankGuruTextbox(driver,fieldName,key.TAB);

	}
	
	public void releaseEmptyTextAreaField(String fieldName) {
		waitElementClickable(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA,fieldName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, fieldName);
		sendKeyBoardToDynamicBankGuruTextArea(driver,fieldName,key.TAB);

	}
	*/

}
