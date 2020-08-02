package pageObjects.bankguru;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class EditCustomerPageObject extends AbstractPage {
	public WebDriver driver;
	
	public EditCustomerPageObject(WebDriver driver) {
		this.driver=driver;
		closeAd(driver);
	}
	

}
