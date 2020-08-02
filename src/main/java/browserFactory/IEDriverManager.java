package browserFactory;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IEDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();

	}

}
