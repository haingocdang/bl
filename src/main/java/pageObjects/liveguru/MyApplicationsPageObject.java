package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class MyApplicationsPageObject extends AbstractPage {
	WebDriver driver;

	public MyApplicationsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
