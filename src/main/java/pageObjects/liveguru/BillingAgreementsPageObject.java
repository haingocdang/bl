package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class BillingAgreementsPageObject extends AbstractPage {
	WebDriver driver;

	public BillingAgreementsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
