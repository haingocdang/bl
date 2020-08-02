package pageObjects.wordpress;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commons.AbstractPage;
import pageUI.wordpress.LoginPageUI;
import pageUI.wordpress.MediaPageUI;
import pageUIs.liveguru.AbstractLiveGuruPageUI;

public class MediaPageObject extends AbstractPage {
	WebDriver driver;
	
	public MediaPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToAddNewButton() {
		waitElementClickable(driver, MediaPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, MediaPageUI.ADD_NEW_BUTTON);
	}
	
	public void deletedUploadedFiles(String...fileNames) {
		String uploadedImageXpath;
		waitElementClickable(driver, MediaPageUI.BULK_SELECT_BUTTON);
		clickToElement(driver, MediaPageUI.BULK_SELECT_BUTTON);
		
		for (String fileName : fileNames) {
			String [] files=fileName.split("\\.");
			uploadedImageXpath = castToObject(AbstractLiveGuruPageUI.UPLOADED_IMAGES, files[0].toLowerCase());
			System.out.println(uploadedImageXpath);
			waitElementClickable(driver, uploadedImageXpath);
			clickToElementByJS(driver, uploadedImageXpath);
		}
		
		waitElementClickable(driver, MediaPageUI.DELETE_PERMANNENTLY_BUTTON);
		clickToElement(driver, MediaPageUI.DELETE_PERMANNENTLY_BUTTON);
		
		acceptAlert(driver);
		
	}

}
