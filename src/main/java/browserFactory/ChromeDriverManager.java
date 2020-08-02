package browserFactory;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		
		//Set plugin for Chrome
		File file=new File(GlobalConstants.ROOT_FOLDER +"\\browserExtensions\\google_translate.crx");
		// DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocation");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		
		options.addExtensions(file);
		options.addArguments("--disable-extensions");
		
		//Set download
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", GlobalConstants.ROOT_FOLDER+"\\downloadFiles");
		options.setExperimentalOption("prefs", chromePrefs);
		
		// Chrone cu: options.addArguments("--disable-infobars");
	//	options.addArguments("--lang=vi");
		
		
		//options.addArguments("--incognito");
		// capabilities.setCapability(ChromeOptions.CAPABILITY,options);
		driver = new ChromeDriver(options);

	}

}
