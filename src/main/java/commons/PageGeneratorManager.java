package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.alpaca.LoginPageObject;

public class PageGeneratorManager {
	
	  public static LoginPageObject getLoginPage(WebDriver driver) { 
		  return new  LoginPageObject(driver); 
		  
	}
	 
}
