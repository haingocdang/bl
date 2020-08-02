package browserFactory;

import commons.Browser;

public class BrowserDriverFactory {
	public static DriverManager getBrowserDriver(String browserName) {
		DriverManager driverManager;
		Browser browser=Browser.valueOf(browserName.toUpperCase());
		
		switch (browser) {
		case CHROME:
			driverManager=new ChromeDriverManager();
			break;
		case CHROME_HEADKESS:
			driverManager=new ChromeHeadlessDriverManager();
			break;
		case FIREFOX:
			driverManager=new FireFoxDriverManager();
			break;
		case FIREFOX_HEADLESS:
			driverManager=new FireFoxHeadlessDriverManager();
			break;	
		case EDGE:
			driverManager=new EdgeManagerDriver();
			break;
		case IE:
			driverManager=new IEDriverManager();
			break;
		default:
			driverManager=new ChromeHeadlessDriverManager();
			break;
		}
		return driverManager;
	}

}
