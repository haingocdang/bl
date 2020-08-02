package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class RecurrringProfilesPageObject extends AbstractPage {
	WebDriver driver;

	public RecurrringProfilesPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
