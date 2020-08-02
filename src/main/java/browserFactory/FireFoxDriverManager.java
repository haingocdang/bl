package browserFactory;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxDriverManager extends DriverManager{
	
	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, GlobalConstants.ROOT_FOLDER+"\\browserLog\\Firefoxlog.txt");
		
		
		//Set Plugin for Firefox
		FirefoxProfile profile=new FirefoxProfile();
		File file=new File(GlobalConstants.ROOT_FOLDER +"\\browserExtensions\\firefox_translate.xpi");
		profile.addExtension(file);
		profile.setPreference("intl.accept_languages", "vi-VI");
			
		FirefoxOptions options=new FirefoxOptions();
		options.setProfile(profile);
	//	options.addArguments("window-size=1920x1080");
		
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", GlobalConstants.ROOT_FOLDER+"\\downloadFiles");
		options.addPreference("browser.download.useDownloadDir", true);
		options.addPreference("browser.helperApps.nerverAsk.saveToDisk", "application/pdf");
		options.addPreference("pdfjs.disabled", true);
		
		//An danh
		//options.addArguments("-private");
		
		//options.addArguments("--headless");

		//Set Lanaguage
		//options.addPreference("intl.accept_languages", "vi");
		driver=new FirefoxDriver(options);
	}
	

}
