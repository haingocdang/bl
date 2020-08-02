package browserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxHeadlessDriverManager extends DriverManager{
	
	@Override
	protected void createDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--headless");
		options.addArguments("window-size=1920x1080");
		driver=new FirefoxDriver(options);
	}
	

}
