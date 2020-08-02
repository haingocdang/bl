package commons;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class AbstractTest extends AbstractPage {
//	public static WebDriver driver;
	protected static ThreadLocal<WebDriver> threadLocalDriver= new ThreadLocal<WebDriver>();
	
	protected Log log;

	protected AbstractTest() {
		this.log=Logger.initLog();
	}
	
	protected void printBrowserConsoleLog(WebDriver driver) {
		LogEntries logs=driver.manage().logs().get("browser");
		List<LogEntry> logList=logs.getAll();
		for(LogEntry logging:logList) {
			log.info("-----------------------"+ logging.getLevel().toString()+"-----------------------\n"+logging.getMessage());
		}
	}
	

	protected WebDriver getBrowserDriver(String browserName, String appURL) {
/*		if (browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver", ".\\browserDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
//			System.setProperty("webdriver.edge.driver", ".\\browserDriver\\msedgedriver.exe");
			WebDriverManager.edgedriver().arch64().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please choose a browser");
		}
*/
		Browser browser=Browser.valueOf(browserName.toUpperCase());
		if(browser==Browser.CHROME) {
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			setDriver(new ChromeDriver());
		}else if (browser==Browser.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			setDriver(new FirefoxDriver());
		}else if (browser==Browser.EDGE) {
			WebDriverManager.edgedriver().arch64().setup();
			//driver=new EdgeDriver();
			setDriver(new EdgeDriver());
		}else {
			System.out.println("Please choose a browser");
		}
		System.out.println("Driver in Abstract Test"+ getDriver().toString());
		getDriver().get(appURL);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return getDriver();
	/*	driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		return driver;*/
		
	}
	
	protected void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
	
	private WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	private void setDriver(WebDriver driver) {
		threadLocalDriver.set(driver);
	}

	public static int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(100000);
		return number;
	}

	public Date getDateTimeNow() {
		Date date = new Date();
		return date;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESS ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public void closeBrowser() {
		getDriver().manage().deleteAllCookies();
		getDriver().quit();
		
	}
}
