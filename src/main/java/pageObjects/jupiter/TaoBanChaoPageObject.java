package pageObjects.jupiter;

import commons.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.alpaca.AbstracPageUI;

import java.util.*;


public class TaoBanChaoPageObject extends AbstractPage {
	WebDriver driver;
	private JavascriptExecutor jsExecutor;

	public TaoBanChaoPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void chonGiaTri(String tenSelectBox, String giaTri){
		waitElementVisible(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
		selectItemInCustomDropdown(driver,AbstracPageUI.COMMON_PARENT_SELECTBOX, AbstracPageUI.COMMON_CHILD_SELECTBOX, giaTri,tenSelectBox);
	}

	public ArrayList<String> getAllGiaTriTrongSelectBox(String tenSelectBox){
		waitElementVisible(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX, tenSelectBox);
		clickToElement(driver, AbstracPageUI.COMMON_PARENT_SELECTBOX,tenSelectBox);
		List<WebElement> optionLists=finds(driver,AbstracPageUI.COMMON_CHILD_SELECTBOX);
		ArrayList<String> optionValue=new ArrayList<String>();
		for(WebElement option:optionLists){
			jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
			optionValue.add(option.getText());
			//System.out.println("Option UI: "+ optionValue);
		}
		//Collections.sort(optionValue);
		return optionValue;
	}
}
