package pageObject.saucelab;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.saucelab.SortPageUI;

public class SortPageObject extends AbstractPage {
	WebDriver driver;
	
	public SortPageObject (WebDriver driver) {
		this.driver=driver;
	}

	public void selectItemInSortDropdown(String optionValue) {
		waitElementVisible(driver, SortPageUI.SORT_DROP_DOWN_LIST);
		selectItemInDropDown(driver, SortPageUI.SORT_DROP_DOWN_LIST, optionValue);
		
	}

	public boolean IsNameSortedAsc() {
		waitElementsVisible(driver, SortPageUI.PRODUCT_NAMES);
		return isDataSortedAsc(driver, SortPageUI.PRODUCT_NAMES);
	}

	public boolean IsNameSortedDesc() {
		waitElementsVisible(driver, SortPageUI.PRODUCT_NAMES);
		return isDataSortedDesc(driver, SortPageUI.PRODUCT_NAMES);
	}

	public boolean IsPriceSortedAsc() {
		waitElementsVisible(driver, SortPageUI.PRODUCT_PRICES);
		return isPriceSortedAsc(driver, SortPageUI.PRODUCT_PRICES);
	}

	public boolean IsPriceSortedDesc() {
		waitElementsVisible(driver, SortPageUI.PRODUCT_PRICES);
		return isPriceSortedDesc(driver, SortPageUI.PRODUCT_PRICES);
	}
	
	
}
