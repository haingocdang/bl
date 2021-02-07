package commons;

//import java.sql.Driver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Period;
import java.time.temporal.Temporal;
import java.util.*;
//import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
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


public abstract class AbstractPage {

    protected AbstractPage() {
        //log=LogFactory.getLog(getClass());
        this.log = Logger.initLog();
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
        element = find(driver, xpathValue);
        if (driver.toString().toLowerCase().contains("internet explorer")) {
            clickToElementByJS(driver, xpathValue);
            sleepInSecond(3);
        } else {
            element.click();
        }
    }

    public void clickToElement(WebDriver driver, String xpathValue, String... elementName) {
        xpathValue = castToObject(xpathValue, elementName);
        element = find(driver, xpathValue);
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

    public void clearValueInField(WebDriver driver, String xpathValue, String... elementName) {
        xpathValue = castToObject(xpathValue, elementName);
        element = find(driver, xpathValue);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
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

    public void selectItemInDropDown(WebDriver driver, String xpathValue, String itemValue, String ...values) {
        xpathValue=castToObject(xpathValue,values);
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

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
                                           String expectedItem, String... parentName) {
        parentLocator = castToObject(parentLocator, parentName);
        clickToElement(driver, parentLocator);
       // clickToElementByJS(driver, parentLocator);
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
        /*jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);");*/
        return find(driver, xpathValue).getText();
    }

    public String getElementTextByJS(WebDriver driver, String cssLocator, String... values) {
        cssLocator = castToObject(cssLocator, values);
        jsExecutor = (JavascriptExecutor) driver;

        return (String) jsExecutor.executeScript( "return $('"+ cssLocator+"').text()");
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
        overideGlobalTimeOut(driver, shortTimeOut);
        elements = finds(driver, xpathValue);
        if (elements.size() == 0) {
            /*
             * System.out.println("Element not in DOM"); System.out.println("End Time:" +new
             * Date().toString());
             */
            overideGlobalTimeOut(driver, longTimeOut);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            /*
             * System.out.println("Element in DOM but is not visible/displayed ");
             * System.out.println("End Time:" +new Date().toString());
             */
            overideGlobalTimeOut(driver, longTimeOut);
            return true;
        } else {
            /* System.out.println("Element in DOM and is visible/displayed "); */
            overideGlobalTimeOut(driver, longTimeOut);
            return false;
        }

    }

    public boolean isElementNotDisplay(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToObject(xpathValue, values);

        /* System.out.println("Start Time:" +new Date().toString()); */
        overideGlobalTimeOut(driver, shortTimeOut);
        elements = finds(driver, xpathValue);
        if (elements.size() == 0) {
            /*
             * System.out.println("Element not in DOM"); System.out.println("End Time:" +new
             * Date().toString());
             */
            overideGlobalTimeOut(driver, longTimeOut);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            /*
             * System.out.println("Element is in DOM but is not visible/displayed ");
             * System.out.println("End Time:" +new Date().toString());
             */
            overideGlobalTimeOut(driver, longTimeOut);
            return true;
        } else {
            /* System.out.println("Element in DOM and is visible/displayed "); */
            overideGlobalTimeOut(driver, longTimeOut);
            return false;
        }

    }

    public boolean isElementEnable(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).isEnabled();
    }

    public boolean isElementEnable(WebDriver driver, String xpathValue, String ...values) {
        xpathValue=castToObject(xpathValue,values);
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

    public void sendKeyBoardToElement(WebDriver driver, String xpathValue, Keys key, String... tenField) {
        xpathValue = castToObject(xpathValue, tenField);
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

    public void removeAttributeInDOM(WebDriver driver, String xpathValue, String attributeRemove, String... values) {
        xpathValue = castToObject(xpathValue, values);
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
        overideGlobalTimeOut(driver, shortTimeOut);
        /*
         * System.out.println("Start time for wait invisible:"+new Date().toString());
         */
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
        /* System.out.println("End time for wait invisible:"+new Date().toString()); */
        overideGlobalTimeOut(driver, longTimeOut);
        explicitWait = new WebDriverWait(driver, longTimeOut);

    }

    public void waitAllElementInvisible(WebDriver driver, String xpathValue) {
        explicitWait = new WebDriverWait(driver, longTimeOut);
        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(finds(driver, xpathValue)));

    }

    public void waitElementInVisible(WebDriver driver, String xpathValue, String... values) {
        xpathValue = castToObject(xpathValue, values);
        // explicitWait = new WebDriverWait(driver, shortTimeOut);
        overideGlobalTimeOut(driver, shortTimeOut);
        /*
         * System.out.println("Start time for wait invisible:"+new Date().toString());
         */
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(xpathValue)));
        /* System.out.println("End time for wait invisible:"+new Date().toString()); */
        overideGlobalTimeOut(driver, longTimeOut);
    }

    private void overideGlobalTimeOut(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

    }

    public void waitUntilDateTime(WebDriver driver,String dateTime){
        Date dateTimeFuture=null;
        try {
            dateTimeFuture = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //get current date time with Date()
        Date dateTimeCurrent = new Date();
        long diff= dateTimeFuture.getTime()-dateTimeCurrent.getTime();
        System.out.println("Time out"+diff);
        overideGlobalTimeOut(driver, (diff/1000)+2);
        elements = finds(driver, "//div[@class='No elements']");
        overideGlobalTimeOut(driver, longTimeOut);

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
        jsExecutor = (JavascriptExecutor) driver;

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
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

        }
        return pass;
    }


    public boolean isDataSortedAsc(WebDriver driver, String xpathValue) {
        // Khai bao 1 Array List
        ArrayList<String> arrayList = new ArrayList();

        //Tim tat ca element matchig vs dk (Name/Price/...)
        List<WebElement> elementList = finds(driver, xpathValue);

        //Lay text tung elemnt
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        System.out.println("-----------Data on UI-----------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 arry list moi de SORT trong code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        // Thuc hien Sort ASC
        Collections.sort(arrayList);

        System.out.println("-----------Data da sort ASC on Code-----------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        //Verify 2 arary bang nhau
        return sortedList.equals(arrayList);
    }

    public boolean isDataSortedDesc(WebDriver driver, String xpathValue) {
        // Khai bao 1 Array List
        ArrayList<String> arrayList = new ArrayList();

        //Tim tat ca element matchig vs dk (Name/Price/...)
        List<WebElement> elementList = finds(driver, xpathValue);

        //Lay text tung elemnt
        for (WebElement element : elementList) {
            arrayList.add(element.getText());
        }

        System.out.println("-----------Data on UI-----------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 arry list moi de SORT trong code
        ArrayList<String> sortedList = new ArrayList<>();
        for (String child : arrayList) {
            sortedList.add(child);
        }

        // Thuc hien Sort ASC
        Collections.sort(arrayList);

        System.out.println("-----------Data da sort ASC on Code-----------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        //Reverse data de sort DESC (2 cach)
        Collections.reverse(arrayList);
        //Collections.sort(arrayList,Collections.reverseOrder());

        System.out.println("----------Data da sort DESC on Code-----------");
        for (String name : arrayList) {
            System.out.println(name);
        }

        //Verify 2 arary bang nhau
        return sortedList.equals(arrayList);
    }

    public boolean isPriceSortedAsc(WebDriver driver, String xpathValue) {
        // Khai bao 1 Array List
        ArrayList<Float> arrayList = new ArrayList<Float>();

        //Tim tat ca element matchig vs dk (Name/Price/...)
        List<WebElement> elementList = finds(driver, xpathValue);

        //Lay text tung elemnt
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
        }

        System.out.println("-----------Data on UI-----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 arry list moi de SORT trong code
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        // Thuc hien Sort ASC
        Collections.sort(arrayList);

        System.out.println("-----------Data da sort ASC on Code-----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        //Verify 2 arary bang nhau
        return sortedList.equals(arrayList);
    }

    public boolean isPriceSortedDesc(WebDriver driver, String xpathValue) {
        // Khai bao 1 Array List
        ArrayList<Float> arrayList = new ArrayList<Float>();

        //Tim tat ca element matchig vs dk (Name/Price/...)
        List<WebElement> elementList = finds(driver, xpathValue);

        //Lay text tung elemnt
        for (WebElement element : elementList) {
            arrayList.add(Float.parseFloat(element.getText().replace("$", "").trim()));
        }

        System.out.println("-----------Data on UI-----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        //Copy qua 1 arry list moi de SORT trong code
        ArrayList<Float> sortedList = new ArrayList<Float>();
        for (Float child : arrayList) {
            sortedList.add(child);
        }

        // Thuc hien Sort ASC
        Collections.sort(arrayList);

        System.out.println("-----------Data da sort ASC on Code-----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        //Reverse data de sort DESC (2 cach)
        Collections.reverse(arrayList);
        //Collections.sort(arrayList,Collections.reverseOrder());

        System.out.println("----------Data da sort DESC on Code-----------");
        for (Float name : arrayList) {
            System.out.println(name);
        }

        //Verify 2 arary bang nhau
        return sortedList.equals(arrayList);
    }

    public String getCurrentDateTime(WebDriver driver){
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String date1= dateFormat.format(date);

        return date1;
    }

    public String getDateTimeInTheFuture(WebDriver driver, String amount){
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        //get current date time with Date()
        Date date = new Date();

        // Convert Date to Calendar
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.MINUTE, Integer.parseInt(amount) );

        // Convert calendar back to Date
        date = c.getTime();

        // Now format the date
        String date1= dateFormat.format(date);

        return date1;
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
