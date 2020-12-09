package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.alpaca.DanhSachChucNangPageObject;
import pageObjects.alpaca.DanhSachNguoiDungPageObject;
import pageObjects.alpaca.LoginPageObject;
import pageObjects.alpaca.TaoChucNangPageObject;
import pageObjects.alpaca.TaoNguoiDungPageObject;

public class PageGeneratorManager {

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static TaoNguoiDungPageObject getTaoNguoiDungPage(WebDriver driver) {
		return new TaoNguoiDungPageObject(driver);
	}
	
	public static TaoChucNangPageObject getTaoChucNangPage (WebDriver driver) {
		return new TaoChucNangPageObject(driver);
	}

	public static DanhSachNguoiDungPageObject getDanhSachNguoiDungPage (WebDriver driver) {
		return new DanhSachNguoiDungPageObject(driver);
	}
	
	public static DanhSachChucNangPageObject getDanhSachChucNangPage (WebDriver driver) {
		return new DanhSachChucNangPageObject(driver);
	}

}
