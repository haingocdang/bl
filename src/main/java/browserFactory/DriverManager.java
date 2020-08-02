package browserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import commons.GlobalConstants;

public abstract class DriverManager {
	protected WebDriver driver;
	
	protected abstract void createDriver();
	
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
			driver=null;
		}
	}
	
	public WebDriver getDriver(String url) {
		//Singleton Pattern
		if(driver==null){
			createDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;
	}

}
