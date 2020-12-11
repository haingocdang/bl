package pageObjects.mercury;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.alpaca.AbstracPageUI;


public class DanhSachChucNangPageObject extends AbstractPage {
	WebDriver driver;
	
	public DanhSachChucNangPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifyTrangThai(String tenChucNang ,String trangThaiValue) {
		waitElementVisible(driver, AbstracPageUI.TRANG_THAI_LABEL, tenChucNang,trangThaiValue);
		return checkTrue(isElementDisplay(driver,  AbstracPageUI.TRANG_THAI_LABEL, tenChucNang,trangThaiValue));
	}
	
}