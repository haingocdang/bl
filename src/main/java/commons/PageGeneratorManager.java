package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import pageObjects.mercury.DanhSachChucNangPageObject;
import pageObjects.mercury.DanhSachNguoiDungPageObject;
import pageObjects.mercury.LoginPageObject;
import pageObjects.mercury.TaoChucNangPageObject;
import pageObjects.mercury.TaoNguoiDungPageObject;

public class PageGeneratorManager {

    public static LoginPageObject getLoginPage(WebDriver driver) {

    	return new LoginPageObject(driver);
    }

    public static TaoNguoiDungPageObject getTaoNguoiDungPage(WebDriver driver) {
        return new TaoNguoiDungPageObject(driver);
    }

    public static TaoChucNangPageObject getTaoChucNangPage(WebDriver driver) {
        return new TaoChucNangPageObject(driver);
    }

    public static DanhSachNguoiDungPageObject getDanhSachNguoiDungPage(WebDriver driver) {
        return new DanhSachNguoiDungPageObject(driver);
    }

    public static DanhSachChucNangPageObject getDanhSachChucNangPage(WebDriver driver) {
        return new DanhSachChucNangPageObject(driver);
    }

    public static DanhSachBanChaoPageObject getDanhSachBanChaoPage(WebDriver driver) {
        return new DanhSachBanChaoPageObject(driver);
    }

    public static TaoBanChaoPageObject getTaoBanChaoPage(WebDriver driver) {
        return new TaoBanChaoPageObject(driver);
    }

    public static CommonPageObjects getCommonPage(WebDriver driver) {
        return new CommonPageObjects();
    }
}
