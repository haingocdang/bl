package pageObjects.jupiter;

import commons.AbstractPage;
import commons.GlobalConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.alpaca.AbstracPageUI;
import cucumber.api.DataTable;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class TaoBanChaoPageObject extends AbstractPage {
	WebDriver driver;
	private JavascriptExecutor jsExecutor;

	public TaoBanChaoPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	/*public void chonGiaTri(String tenSelectBox, String giaTri){
		waitElementVisible(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
		selectItemInCustomDropdown(driver,AbstracPageUI.COMMON_PARENT_SELECTBOX, AbstracPageUI.COMMON_CHILD_SELECTBOX, giaTri,tenSelectBox);
	}

	public ArrayList<String> getAllGiaTriTrongSelectBox(String tenSelectBox ){
		waitElementVisible(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
		clickToElement(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX,tenSelectBox);
		List<WebElement> optionLists=finds(driver,AbstracPageUI.COMMON_CHILD_SELECTBOX);
		ArrayList<String> optionValue=new ArrayList<String>();
		for(WebElement option:optionLists){
			*//*jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);*//*
			optionValue.add(option.getText());
		}

		waitElementVisible(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
		clickToElement(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX,tenSelectBox);
		return optionValue;
	}*/

}
