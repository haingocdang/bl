package pageObjects.liveguru;

import org.apache.commons.exec.Watchdog;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.liveguru.MyDashboardPageUI;

public class MyDashboardPageObject extends AbstractPage {
	WebDriver driver;
	
	public MyDashboardPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public String getWelcomeSucessMessage() {
		waitElementVisible(driver, MyDashboardPageUI.WELCOME_MESSAGE_TEXT);
		return getElementText(driver, MyDashboardPageUI.WELCOME_MESSAGE_TEXT);
	}

	public boolean isSucessMessageDisplayed() {
		return false;
	}
	
	

}
