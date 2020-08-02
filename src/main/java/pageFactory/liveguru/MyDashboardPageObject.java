package pageFactory.liveguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPageObject extends AbstractPage {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//li[@class='success-msg']//span")
	private WebElement sucessMessage;

	public String getWelcomeSucessMessage() {
		waitElementVisible(driver, sucessMessage);
		return getElementText(driver, sucessMessage);
	}

	public boolean isSucessMessageDisplayed() {
		return false;
	}

}
