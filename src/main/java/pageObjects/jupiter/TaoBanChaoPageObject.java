package pageObjects.jupiter;

import commons.AbstractPage;
import commons.CommonPageObjects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pageUIs.alpaca.CommonPageUI;
import pageUIs.alpaca.jupiter.TaoBanChaoPageUI;


public class TaoBanChaoPageObject extends CommonPageObjects {
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

	public void clickAddDoiTuongNhomButton(){
		waitElementClickable(driver, TaoBanChaoPageUI.ADD_DOI_TUONG_NHOM_BUTTON);
		clickToElement(driver,TaoBanChaoPageUI.ADD_DOI_TUONG_NHOM_BUTTON);
	}

	/*public void chonPhamViBH(String phamViBH){
		waitElementClickable(driver, CommonPageUI.PHAM_VI_BH_CHECKBOX,phamViBH);
		clickToElement(driver, CommonPageUI.PHAM_VI_BH_CHECKBOX,phamViBH);
	}*/

}
