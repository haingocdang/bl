package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public abstract class PageGeneratorManager {
	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static MediaPageObject getMediaPageObject(WebDriver driver) {
		return new MediaPageObject(driver);
	}
	
	public static HomePageObject getHomePageObject(WebDriver driver) {
		return new HomePageObject(driver);
	}
	

}
