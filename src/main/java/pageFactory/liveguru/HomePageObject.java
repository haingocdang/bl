package pageFactory.liveguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='footer']//a[text()='My Account']")
	private WebElement myAccountLink;

	public LoginPageObject clickToMyAccountLink() {
		waitElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);	
		return new LoginPageObject(driver);
	}
	
}
