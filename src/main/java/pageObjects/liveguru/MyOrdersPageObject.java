package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class MyOrdersPageObject extends AbstractPage {
	WebDriver driver;

	public MyOrdersPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
