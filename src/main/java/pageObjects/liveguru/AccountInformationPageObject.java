package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class AccountInformationPageObject extends AbstractPage {
	WebDriver driver;

	public AccountInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
