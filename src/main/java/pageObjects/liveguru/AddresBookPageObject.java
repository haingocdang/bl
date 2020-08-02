package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class AddresBookPageObject extends AbstractPage {
	WebDriver driver;

	public AddresBookPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
