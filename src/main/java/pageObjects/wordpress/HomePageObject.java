package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.wordpress.HomePageUI;
import pageUI.wordpress.LoginPageUI;
import pageUI.wordpress.MediaPageUI;
import pageUIs.liveguru.AbstractLiveGuruPageUI;

public class HomePageObject extends AbstractPage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}

	public void clickToScreenOption() {
		waitElementClickable(driver, HomePageUI.SCREEN_OPTION_MENU);
		clickToElement(driver, HomePageUI.SCREEN_OPTION_MENU);
		
	}

	public boolean isActivityCheckBoxDisplayed() {
		waitElementVisible(driver, HomePageUI.ACTIVITY_CHECKBOX);
		return isElementDisplay(driver, HomePageUI.ACTIVITY_CHECKBOX);
	}
	
	public boolean isActivityCheckBoxNotDisplayed() {
		//waitElementInVisible(driver, HomePageUI.ACTIVITY_CHECKBOX);
		return isElementNotDisplay(driver, HomePageUI.ACTIVITY_CHECKBOX);
	}


	public boolean IsAllPostsSubMenuNotDisplayed() {
		//waitElementInVisible(driver, HomePageUI.ALL_POSTS_SUB_MENU);
		return isElementNotDisplay(driver, HomePageUI.ALL_POSTS_SUB_MENU);
	}

	public boolean isPlansMenuNotDisplayed(String pageName) {
		//waitElementInVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK,pageName);
		return isElementNotDisplay(driver,AbstractLiveGuruPageUI.DYNAMIC_PAGE_LINK,pageName);
		
	}
	
	

	
		
		


}
