package pageObject.jquerry;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.jquerry.DataTablePageUI;

public class DataTablePageObject extends AbstractPage {
	WebDriver driver;

	public DataTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void searchByColoum(String value, String columnName) {
		sendKeyToDynamicTextbox(driver, value, columnName);
		sendKeyBoardToDynamicDataTableTextbox(driver, columnName, Keys.ENTER);
	}

	public boolean isOnlyRowIsDisplayed(String value) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		int rowsNumber=countElementNumber(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		
		boolean status=isElementDisplay(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT,value);
		
		return rowsNumber==1 && status;
	}
	
	public boolean isRowDeleted(String value) {
		//waitElementInVisible(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT,value);
		int rowsNumber=countElementNumber(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT, value);
		
		boolean status=isElementNotDisplay(driver, DataTablePageUI.DYNAMIC_ONLY_ONE_ROW_WITH_TEXT,value);
		
		return rowsNumber==0 && status;
	}

	public void clickToDyNamicIconByName(String iconName, String columnName, String valueOfColumne) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_ICON, columnName,valueOfColumne,iconName);
		clickToElement(driver, DataTablePageUI.DYNAMIC_ICON, columnName,valueOfColumne,iconName);
		
	}

	public boolean isEditPopupDisplay(String columnName, String value) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_EDIT_POPUP, columnName, value);
		return isElementDisplay(driver,DataTablePageUI.DYNAMIC_EDIT_POPUP,columnName,value);
	}

	public void navigatePageNumberByIndex(String pageNum) {
		waitElementClickable(driver, DataTablePageUI.DYNAMIC_PAGE_NUMBER, pageNum);
		clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE_NUMBER, pageNum);
		
	}

	public boolean isPageActived(String pageNum) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVE, pageNum);
		return isElementDisplay(driver, DataTablePageUI.DYNAMIC_PAGE_ACTIVE, pageNum);
	}

	public void inputToDynamicTextboxByRowNum(String colummName, String rowNum, String value) {
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_COLUMN_INDEX, colummName);
		int columnPosition=countElementNumber(driver, DataTablePageUI.DYNAMIC_COLUMN_INDEX, colummName)+1;
		
		waitElementVisible(driver, DataTablePageUI.DYNAMIC_CELL_INDEX,rowNum,Integer.toString(columnPosition));
		sendKeyToElement(driver, DataTablePageUI.DYNAMIC_CELL_INDEX, value,rowNum, Integer.toString(columnPosition));
		
	}
	
	
	

}
