package commons;

//import java.sql.Driver;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.AddresBookPageObject;
import pageObjects.liveguru.BillingAgreementsPageObject;
import pageObjects.liveguru.MyApplicationsPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageUI.jquerry.DataTablePageUI;
import pageUIs.liveguru.AbstractLiveGuruPageUI;
import pageUIs.bankguru.AbstractBankGuruPageUI;
import pageUIs.bankguru.LoginPageUI;
import commons.Logger;

public abstract class AbstractPage {

	protected AbstractPage() {
		//log=LogFactory.getLog(getClass());
		this.log=Logger.initLog();
	}

	public boolean isPageLoaded(WebDriver driver, String pageUrl) {
		String actualUrl = driver.getCurrentUrl();
		return actualUrl.contains(pageUrl);
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public void setImcplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getAlertText(WebDriver driver) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String text) {
		waitAlertPresence(driver);
		alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public String castToObject(String xpathValue, String... values) {

		return String.format(xpathValue, (Object[]) values);
	}

	public void clickToElement(WebDriver driver, String xpathValue) {
		element=find(driver, xpathValue);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, xpathValue);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String xpathValue, String... elementName) {
		xpathValue = castToObject(xpathValue, elementName);
		element=find(driver, xpathValue);
		if (driver.toString().toLowerCase().contains("internet explorer")) {
			clickToElementByJS(driver, xpathValue);
			sleepInSecond(3);
		} else {
			element.click();
		}
	}

	public void sendKeyToElement(WebDriver driver, String xpathValue, String value) {
		element = find(driver, xpathValue);
		element.clear();
		element.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String xpathValue, String value, String... elementName) {
		xpathValue = castToObject(xpathValue, elementName);
		element = find(driver, xpathValue);
		element.clear();
		element.sendKeys(value);
	}

	public WebElement find(WebDriver driver, String xpathValue) {
		return driver.findElement(byXpath(xpathValue));
	}

	public List<WebElement> finds(WebDriver driver, String xpathValue) {
		return driver.findElements(byXpath(xpathValue));
	}

	public By byXpath(String xpathValue) {
		return By.xpath(xpathValue);
	}

	public void selectItemInDropDown(WebDriver driver, String xpathValue, String itemValue) {
		select = new Select(find(driver, xpathValue));
		select.selectByVisibleText(itemValue);
	}

	public String getTextSelectedItemInDropDown(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropDownMultiple(WebDriver driver, String xpathValue) {
		select = new Select(find(driver, xpathValue));
		return select.isMultiple();

	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		clickToElement(driver, parentLocator);
		sleepInSecond(1);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));
		elements = finds(driver, childItemLocator);
		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathValue, String attributeName) {
		return find(driver, xpathValue).getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String xpathValue, String attributeName, String... values) {
		xpathValue = castToObject(xpathValue, values);
		return find(driver, xpathValue).getAttribute(attributeName);
	}

	public String getElementText(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).getText();
	}

	public String getElementText(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		return find(driver, xpathValue).getText();
	}

	public int countElementNumber(WebDriver driver, String xpathValue) {
		return finds(driver, xpathValue).size();
	}

	public int countElementNumber(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		return finds(driver, xpathValue).size();
	}

	public void checkToCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToCheckbox(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpathValue) {
		try {
			element = find(driver, xpathValue);
			return element.isDisplayed();
		} catch (NoSuchElementException noSuchException) {
			noSuchException.printStackTrace();
			return false;
		}
	}

	public boolean isElementDisplay(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		try {
			element = find(driver, xpathValue);
			return element.isDisplayed();
		} catch (NoSuchElementException noSuchException) {
			noSuchException.printStackTrace();
			return false;
		}
	}

	public boolean isElementNotDisplay(WebDriver driver, String xpathValue, String value) {
		/* System.out.println("Start Time:" +new Date().toString()); */
		ovrideGlobalTimeOut(driver, shortTimeOut);
		elements = finds(driver, xpathValue);
		if (elements.size() == 0) {
			/*
			 * System.out.println("Element not in DOM"); System.out.println("End Time:" +new
			 * Date().toString());
			 */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			/*
			 * System.out.println("Element not in DOM but is not visible/displayed ");
			 * System.out.println("End Time:" +new Date().toString());
			 */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return true;
		} else {
			/* System.out.println("Element in DOM and is visible/displayed "); */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return false;
		}

	}

	public boolean isElementNotDisplay(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);

		/* System.out.println("Start Time:" +new Date().toString()); */
		ovrideGlobalTimeOut(driver, shortTimeOut);
		elements = finds(driver, xpathValue);
		if (elements.size() == 0) {
			/*
			 * System.out.println("Element not in DOM"); System.out.println("End Time:" +new
			 * Date().toString());
			 */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			/*
			 * System.out.println("Element not in DOM but is not visible/displayed ");
			 * System.out.println("End Time:" +new Date().toString());
			 */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return true;
		} else {
			/* System.out.println("Element in DOM and is visible/displayed "); */
			ovrideGlobalTimeOut(driver, longTimeOut);
			return false;
		}

	}

	public boolean isElementEnable(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isEnabled();
	}

	public boolean isElementSelected(WebDriver driver, String xpathValue) {
		return find(driver, xpathValue).isSelected();
	}

	public void switchToFrameOrIframe(WebDriver driver, String xpathValue) {
		driver.switchTo().frame(find(driver, xpathValue));
		
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String xpathValue) {
		action = new Actions(driver);
		action.moveToElement(find(driver, xpathValue)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String xpathValue, Keys key) {
		action = new Actions(driver);
		find(driver, xpathValue).clear();
		action.sendKeys(find(driver, xpathValue), key).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String xpathValue, Keys key, String... columnName) {
		xpathValue = castToObject(xpathValue, columnName);
		action = new Actions(driver);
		find(driver, xpathValue).clear();
		action.sendKeys(find(driver, xpathValue), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaSript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaSript);
	}

	public boolean verifyTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void scrollToTPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		//jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		jsExecutor.executeScript("window.scrollTo(0,0)");

	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String xpathValue) {
		element = find(driver, xpathValue);
		String originalStyle = element.getAttribute("style");
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 5px solid red; border-style: dashed;");
		sleepInSecond(2);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, xpathValue));
	}

	public void scrollToElement(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, xpathValue));
	}

	public void sendkeyToElementByJS(WebDriver driver, String xpathValue, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, xpathValue));
	}

	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
	}
	
	public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove, String ...values) {
		xpathValue=castToObject(xpathValue, values);
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, xpathValue));
	}

	public boolean isImageLoaded(WebDriver driver, String xpathValue) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth>0",
				find(driver, xpathValue));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public boolean verifyTextInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor
				.executeScript("return document.documentElement.innerText.match(" + textExpected + ")[0]");
		return textActual.equals(textExpected);
	}

	public void waitElementVisible(WebDriver driver, String xpathValue) {

		explicitWait = new WebDriverWait(driver, longTimeOut);

		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
		} catch (TimeoutException exception) {
			// log.debug("Element does not exist");
			exception.printStackTrace();
		}
	}

	public void waitElementsVisible(WebDriver driver, String xpathValue) {

		explicitWait = new WebDriverWait(driver, longTimeOut);

		try {
			explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(xpathValue)));
		} catch (TimeoutException exception) {
			// log.debug("Element does not exist");
			exception.printStackTrace();
		}
	}
	
	public void waitElementVisible(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(xpathValue)));
		} catch (TimeoutException exception) {
			exception.printStackTrace();

		}
	}

	public void waitAlertIsPresent(WebDriver driver, Alert alert) {

		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitElementInVisible(WebDriver driver, String xpathValue) {
		// explicitWait = new WebDriverWait(driver, shortTimeOut);
		ovrideGlobalTimeOut(driver, shortTimeOut);
		/*
		 * System.out.println("Start time for wait invisible:"+new Date().toString());
		 */
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
		/* System.out.println("End time for wait invisible:"+new Date().toString()); */
		ovrideGlobalTimeOut(driver, longTimeOut);
		explicitWait = new WebDriverWait(driver, longTimeOut);

	}

	public void waitAllElementInvisible(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(finds(driver, xpathValue)));

	}

	public void waitElementInVisible(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		// explicitWait = new WebDriverWait(driver, shortTimeOut);
		ovrideGlobalTimeOut(driver, shortTimeOut);
		/*
		 * System.out.println("Start time for wait invisible:"+new Date().toString());
		 */
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
		/* System.out.println("End time for wait invisible:"+new Date().toString()); */
		ovrideGlobalTimeOut(driver, longTimeOut);
	}

	private void ovrideGlobalTimeOut(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

	}

	public void waitElementClickable(WebDriver driver, String xpathValue) {
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}

	public void waitElementClickable(WebDriver driver, String xpathValue, String... values) {
		xpathValue = castToObject(xpathValue, values);
		explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(xpathValue)));
	}
	
	public boolean waitForJStoLoad(WebDriver driver) {
	    explicitWait = new WebDriverWait(driver, longTimeOut);
	    jsExecutor=(JavascriptExecutor) driver;

	    // wait for jQuery to load
	    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            try {
	                return ((Long)jsExecutor.executeScript("return jQuery.active") == 0);
	            }
	            catch (Exception e) {
	                return true;
	            }
	        }
	    };
	    // wait for Javascript to load
	    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver driver) {
	            return ((JavascriptExecutor) driver)
	                    .executeScript("return document.readyState")
	                    .toString().equals("complete");
	        }
	    };
	    return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + GlobalConstants.UPLOAD_FOLDER + file + "\n";
		}
		fullFileName = fullFileName.trim();
		sendKeyToElement(driver, AbstractLiveGuruPageUI.UPLOAD_FILE_TYPE, fullFileName);

	}

	public boolean areFilesUploadedSuccess(WebDriver driver, String... fileNames) {
		String uploadedImageXpath;
		boolean status = true;

		waitAllElementInvisible(driver, AbstractLiveGuruPageUI.PROGRESS_BAR);

		for (String fileName : fileNames) {
			String[] files = fileName.split("\\.");
			uploadedImageXpath = castToObject(AbstractLiveGuruPageUI.UPLOADED_IMAGES, files[0].toLowerCase());
			if (!isElementDisplay(driver, uploadedImageXpath)) {
				status = false;
				return status;
			}
		}
		return status;
	}

	protected boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	// Common Funtion-> Open Pages
	public AccountInformationPageObject clickToAccountInforLink(WebDriver driver) {

		waitElementClickable(driver, AbstractLiveGuruPageUI.ACCOUNT_INFOLINK);
		clickToElement(driver, AbstractLiveGuruPageUI.ACCOUNT_INFOLINK);
		return PageGeneratorManager.getAccountInforPage(driver);
	}

	public AddresBookPageObject clickToAddressBookLink(WebDriver driver) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.ADDRESS_BOOK_LINK);
		clickToElement(driver, AbstractLiveGuruPageUI.ADDRESS_BOOK_LINK);
		return PageGeneratorManager.getAddressBookPage(driver);
	}

	public MyDashboardPageObject clickToAccountDashboardLink(WebDriver driver) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.ACCOUNT_DASHBOARD_LINK);
		clickToElement(driver, AbstractLiveGuruPageUI.ACCOUNT_DASHBOARD_LINK);
		return PageGeneratorManager.getMyDashboardPage(driver);
	}

	public BillingAgreementsPageObject clickToBillingAgreementsLink(WebDriver driver) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.BILLING_AGREEMENTS_LINK);
		clickToElement(driver, AbstractLiveGuruPageUI.BILLING_AGREEMENTS_LINK);
		return PageGeneratorManager.getBillingPage(driver);
	}

	public MyApplicationsPageObject clickToMyApplicationLink(WebDriver driver) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.MY_APPLICATIONS_LINK);
		clickToElement(driver, AbstractLiveGuruPageUI.MY_APPLICATIONS_LINK);
		return PageGeneratorManager.getMyApplicationsPage(driver);
	}

	// Dynamic Locator

	// Apply cho it Common pages- Live Guru (10-20 pages)
	public AbstractPage clickToLessDynamicPagesMenu(WebDriver driver, String pageName) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractLiveGuruPageUI.DYNAMIC_PAGE_LINK, pageName);
		/*
		 * if(pageName.equals("Account Information")) { return
		 * PageGeneratorManager.getAccountInforPage(driver); }else
		 * if(pageName.equals("Address Book")) { return
		 * PageGeneratorManager.getAddressBookPage(driver); }else
		 * if(pageName.equals("Billing Agreements")) { return
		 * PageGeneratorManager.getBillingPage(driver); }else
		 * if(pageName.equals("Account Dashboard")) { return
		 * PageGeneratorManager.getMyDashboardPage(driver); }else
		 * if(pageName.equals("My Applications")) { return
		 * PageGeneratorManager.getMyApplicationsPage(driver); }else { return
		 * PageGeneratorManager.getMyDashboardPage(driver); }
		 */
		switch (pageName) {
		case "Account Information":
			return PageGeneratorManager.getAccountInforPage(driver);
		case "Address Book":
			return PageGeneratorManager.getAddressBookPage(driver);
		case "Billing Agreements":
			return PageGeneratorManager.getBillingPage(driver);
		case "Account Dashboard":
			return PageGeneratorManager.getMyDashboardPage(driver);
		case "My Applications":
			return PageGeneratorManager.getMyApplicationsPage(driver);
		default:
			return PageGeneratorManager.getMyDashboardPage(driver);

		}

	}

	// Apply cho nhieu Common pages (Live Guru)
	public void clickToMoreDynamicPagesMenu(WebDriver driver, String pageName) {
		waitElementClickable(driver, AbstractLiveGuruPageUI.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractLiveGuruPageUI.DYNAMIC_PAGE_LINK, pageName);
	}

	public void sendKeyToDynamicTextbox(WebDriver driver, String value, String columnName) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_TEXTBOX, columnName);
		sendKeyToElement(driver, DataTablePageUI.DYNAMIC_TEXTBOX, value, columnName);

	}

	public void sendKeyBoardToDynamicDataTableTextbox(WebDriver driver, String columnName, Keys key) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_TEXTBOX, columnName);
		sendKeyBoardToElement(driver, DataTablePageUI.DYNAMIC_TEXTBOX, key, columnName);

	}
	
	public void sendKeyBoardToDynamicBankGuruTextbox(WebDriver driver, String fieldName, Keys key) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, fieldName);
		sendKeyBoardToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, key, fieldName);

	}
	
	public void sendKeyBoardToDynamicBankGuruTextArea(WebDriver driver,  String fieldName, Keys key) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, fieldName);
		sendKeyBoardToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, key, fieldName);

	}

	// Bankguru Dynamic Component
	public void inputToDynamicTextbox(WebDriver driver, String componentName, String inputValue) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, componentName);
		if(getElementAttribute(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX,"type",componentName).equals("date")) {
			removeAttributeInDOM(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX,"type",componentName);
		}
		sendKeyToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, inputValue, componentName);

	}

	public void inputToDynamicTextarea(WebDriver driver, String componentName, String inputValue) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, componentName);
		sendKeyToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, inputValue, componentName);
	}

	public void clickToDynamicLink(WebDriver driver, String componentName) {
		waitElementClickable(driver, AbstractBankGuruPageUI.DYNAMIC_LINK, componentName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_LINK, componentName);

	}

	public void clickToDynamicRadioButton(WebDriver driver, String componentName) {
		waitElementClickable(driver, AbstractBankGuruPageUI.DYNAMIC_RADIO_BUTTON, componentName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_RADIO_BUTTON, componentName);
	}

	public void clickToDynamicButton(WebDriver driver, String componentName) {
		waitElementClickable(driver, AbstractBankGuruPageUI.DYNAMIC_BUTTON, componentName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_BUTTON, componentName);
	}

	public boolean IsDyNamicMessageDisplay(WebDriver driver, String componentName) {
		boolean status = false;
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_MESSAGE, componentName);
		status = isElementDisplay(driver, AbstractBankGuruPageUI.DYNAMIC_MESSAGE, componentName);
		return status;
	}
	
	public boolean IsDyNamicLabelDisplay(WebDriver driver, String componentName) {
		boolean status = false;
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_LABEL, componentName);
		status = isElementDisplay(driver, AbstractBankGuruPageUI.DYNAMIC_LABEL, componentName);
		return status;
	}

	public String getDyNamicValueByColumnName(WebDriver driver, String componentName) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_VALUE_BY_COLUMN_NAME, componentName);
		return getElementText(driver, AbstractBankGuruPageUI.DYNAMIC_VALUE_BY_COLUMN_NAME, componentName);
	}
	
	public String getDyNamicErrorMessageByColumnName(WebDriver driver, String componentName) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_ERROR_MESSAGE, componentName);
		return getElementText(driver,AbstractBankGuruPageUI.DYNAMIC_ERROR_MESSAGE, componentName);
	}
	
	public void closeAd(WebDriver driver) {
		sleepInSecond(1);
		if (isElementDisplay(driver, AbstractBankGuruPageUI.IFRAME)) {
			waitElementVisible(driver, AbstractBankGuruPageUI.IFRAME);
			switchToFrameOrIframe(driver, AbstractBankGuruPageUI.IFRAME);
			waitElementClickable(driver, AbstractBankGuruPageUI.IFRAME_CLOSE_BUTTON);
			clickToElement(driver, AbstractBankGuruPageUI.IFRAME_CLOSE_BUTTON);
			switchToDefaultContent(driver);
		}
	}
	
	public void releaseEmptyTextboxField(WebDriver driver, String fieldName) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX,fieldName);
		//clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTBOX, fieldName);
		sendKeyBoardToDynamicBankGuruTextbox(driver,fieldName,key.TAB);

	}
	
	public void releaseEmptyTextAreaField(WebDriver driver, String fieldName) {
		waitElementVisible(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA,fieldName);
		clickToElement(driver, AbstractBankGuruPageUI.DYNAMIC_TEXTAREA, fieldName);
		sendKeyBoardToDynamicBankGuruTextArea(driver,fieldName,key.TAB);

	}
	
	public boolean isDataSortedAsc(WebDriver driver,String xpathValue) {
		// Khai bao 1 Array List
		ArrayList<String> arrayList= new ArrayList();
		
		//Tim tat ca element matchig vs dk (Name/Price/...)
		List<WebElement> elementList= finds(driver, xpathValue);
		
		//Lay text tung elemnt
		for (WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-----------Data on UI-----------");
		for (String name:arrayList) {
			System.out.println(name);
		}
		
		//Copy qua 1 arry list moi de SORT trong code
		ArrayList<String> sortedList=new ArrayList<>();
		for (String child:arrayList) {
			sortedList.add(child);
		}
		
		// Thuc hien Sort ASC
		Collections.sort(arrayList);
		
		System.out.println("-----------Data da sort ASC on Code-----------");
		for (String name:arrayList) {
			System.out.println(name);
		}
		
		//Verify 2 arary bang nhau
		return sortedList.equals(arrayList);
	}
	
	public boolean isDataSortedDesc(WebDriver driver,String xpathValue) {
		// Khai bao 1 Array List
		ArrayList<String> arrayList= new ArrayList();
		
		//Tim tat ca element matchig vs dk (Name/Price/...)
		List<WebElement> elementList= finds(driver, xpathValue);
		
		//Lay text tung elemnt
		for (WebElement element:elementList) {
			arrayList.add(element.getText());
		}
		
		System.out.println("-----------Data on UI-----------");
		for (String name:arrayList) {
			System.out.println(name);
		}
		
		//Copy qua 1 arry list moi de SORT trong code
		ArrayList<String> sortedList=new ArrayList<>();
		for (String child:arrayList) {
			sortedList.add(child);
		}
		
		// Thuc hien Sort ASC
		Collections.sort(arrayList);
		
		System.out.println("-----------Data da sort ASC on Code-----------");
		for (String name:arrayList) {
			System.out.println(name);
		}
		
		//Reverse data de sort DESC (2 cach)
		Collections.reverse(arrayList);
		//Collections.sort(arrayList,Collections.reverseOrder());
		
		System.out.println("----------Data da sort DESC on Code-----------");
		for (String name:arrayList) {
			System.out.println(name);
		}
			
		//Verify 2 arary bang nhau
		return sortedList.equals(arrayList);
	}
	
	public boolean isPriceSortedAsc(WebDriver driver,String xpathValue) {
		// Khai bao 1 Array List
		ArrayList<Float> arrayList= new ArrayList<Float>();
		
		//Tim tat ca element matchig vs dk (Name/Price/...)
		List<WebElement> elementList= finds(driver, xpathValue);
		
		//Lay text tung elemnt
		for (WebElement element:elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		System.out.println("-----------Data on UI-----------");
		for (Float name:arrayList) {
			System.out.println(name);
		}
		
		//Copy qua 1 arry list moi de SORT trong code
		ArrayList<Float> sortedList=new ArrayList<Float>();
		for (Float child:arrayList) {
			sortedList.add(child);
		}
		
		// Thuc hien Sort ASC
		Collections.sort(arrayList);
		
		System.out.println("-----------Data da sort ASC on Code-----------");
		for (Float name:arrayList) {
			System.out.println(name);
		}
		
		//Verify 2 arary bang nhau
		return sortedList.equals(arrayList);
	}
	
	public boolean isPriceSortedDesc(WebDriver driver,String xpathValue) {
		// Khai bao 1 Array List
		ArrayList<Float> arrayList= new ArrayList<Float>();
		
		//Tim tat ca element matchig vs dk (Name/Price/...)
		List<WebElement> elementList= finds(driver, xpathValue);
		
		//Lay text tung elemnt
		for (WebElement element:elementList) {
			arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
		}
		
		System.out.println("-----------Data on UI-----------");
		for (Float name:arrayList) {
			System.out.println(name);
		}
		
		//Copy qua 1 arry list moi de SORT trong code
		ArrayList<Float> sortedList=new ArrayList<Float>();
		for (Float child:arrayList) {
			sortedList.add(child);
		}
		
		// Thuc hien Sort ASC
		Collections.sort(arrayList);
		
		System.out.println("-----------Data da sort ASC on Code-----------");
		for (Float name:arrayList) {
			System.out.println(name);
		}
		
		//Reverse data de sort DESC (2 cach)
		Collections.reverse(arrayList);
		//Collections.sort(arrayList,Collections.reverseOrder());
		
		System.out.println("----------Data da sort DESC on Code-----------");
		for (Float name:arrayList) {
			System.out.println(name);
		}
			
		//Verify 2 arary bang nhau
		return sortedList.equals(arrayList);
	}

	Log log;
	private Keys key;
	private long longTimeOut = 30;
	private long shortTimeOut = 10;
	private Alert alert;
	private Select select;
	private WebElement element;
	private Actions action;
	private List<WebElement> elements;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;
}
