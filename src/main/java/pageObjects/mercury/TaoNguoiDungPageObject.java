package pageObjects.mercury;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.alpaca.mercury.TaoNguoiDungPageUI;


public class TaoNguoiDungPageObject extends AbstractPage {
	WebDriver driver;
	
	public TaoNguoiDungPageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void nhapTenDangNhap(String tenDangNhap) {
		waitElementVisible(driver, TaoNguoiDungPageUI.TEN_DANG_NHAP_TEXTBOX);
		sendKeyToElement(driver, TaoNguoiDungPageUI.TEN_DANG_NHAP_TEXTBOX, tenDangNhap);
	}
	
	public void nhapHoVaTen(String hoVaTen) {
		waitElementVisible(driver, TaoNguoiDungPageUI.HO_VA_TEN_TEXTBOX);
		sendKeyToElement(driver, TaoNguoiDungPageUI.HO_VA_TEN_TEXTBOX, hoVaTen);
	}
	
	public void nhapEmail(String email) {
		waitElementVisible(driver, TaoNguoiDungPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, TaoNguoiDungPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void nhapSoDienThoai(String soDienThoai) {
		waitElementVisible(driver, TaoNguoiDungPageUI.SO_DIEN_THOAI_TEXTBOX);
		sendKeyToElement(driver, TaoNguoiDungPageUI.SO_DIEN_THOAI_TEXTBOX, soDienThoai);
	}
	
	public void chonDonVi(String tenSelectBox, String giaTri) {
	//	waitElementVisible(driver, TaoNguoiDungPageUI.DON_VI_TRUC_THUOC_SELECTBOX);
		waitElementVisible(driver, TaoNguoiDungPageUI.COMMON_SELECTBOX, tenSelectBox);
		//clickToElement(driver, TaoNguoiDungPageUI.DON_VI_TRUC_THUOC_SELECTBOX);
		clickToElement(driver, TaoNguoiDungPageUI.COMMON_SELECTBOX, tenSelectBox);
		sleepInSecond(1);
		clickToElement(driver, "//div[contains(text(),'" + giaTri + "')]");
	}

}
