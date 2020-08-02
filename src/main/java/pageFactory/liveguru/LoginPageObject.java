package pageFactory.liveguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageFactory.liveguru.AbstractPage;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

//	@FindBy (how=How.XPATH, using="//span[text()='Create an Account']")
	@FindBy (xpath="//span[text()='Create an Account']")
	private WebElement createAnAccountButton;
	
	@FindBy (how=How.ID_OR_NAME, using="email")
	private WebElement emailAddressTextbox;
	
	@FindBy(how=How.ID_OR_NAME, using="pass")
	private WebElement passwordTextbox;
	
	@FindBy(how=How.ID_OR_NAME, using="send2")
	private WebElement loginButton;
	
	public RegisterPageObject clickToCreateAnAccoutButton() {
		waitElementClickable(driver,createAnAccountButton);
		clickToElement(driver, createAnAccountButton);
		return new RegisterPageObject(driver);
		
	}

}
