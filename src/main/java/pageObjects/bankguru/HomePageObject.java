package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class HomePageObject extends AbstractPage {
	public WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
		closeAd(driver);
	}

}
