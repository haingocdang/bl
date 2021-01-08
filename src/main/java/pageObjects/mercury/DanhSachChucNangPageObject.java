package pageObjects.mercury;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.alpaca.CommonPageUI;


public class DanhSachChucNangPageObject extends AbstractPage {
	WebDriver driver;
	
	public DanhSachChucNangPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public boolean verifyTrangThai(String tenChucNang ,String trangThaiValue) {
		waitElementVisible(driver, CommonPageUI.TRANG_THAI_LABEL, tenChucNang,trangThaiValue);
		return checkTrue(isElementDisplay(driver,  CommonPageUI.TRANG_THAI_LABEL, tenChucNang,trangThaiValue));
	}
	
}
