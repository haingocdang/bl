package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class NewsletterSubcriptionsPageObject extends AbstractPage {
	WebDriver driver;

	public NewsletterSubcriptionsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
