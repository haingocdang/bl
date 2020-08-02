package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageObjects.liveguru.LoginPageObject;
import pageUIs.liveguru.HomePageUI;

public class MyDownloadAbleProductsPageObject extends AbstractPage {
	WebDriver driver;

	public MyDownloadAbleProductsPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
