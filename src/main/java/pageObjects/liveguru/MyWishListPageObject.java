package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class MyWishListPageObject extends AbstractPage {
	WebDriver driver;

	public MyWishListPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
