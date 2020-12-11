package pageObjects.mercury;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.alpaca.TaoChucNangPageUI;


public class TaoChucNangPageObject extends AbstractPage {
	WebDriver driver;
	
	public TaoChucNangPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void nhapTenChucNang(String tenChucNang) {
		waitElementVisible(driver, TaoChucNangPageUI.TEN_CHUC_NANG_TEXTBOX);
		sendKeyToElement(driver, TaoChucNangPageUI.TEN_CHUC_NANG_TEXTBOX, tenChucNang);
	}

}
