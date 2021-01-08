package stepDefinations.mercury.chucNang;

import commons.PageGeneratorManager;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import pageObjects.mercury.DanhSachChucNangPageObject;
import pageObjects.mercury.DanhSachNguoiDungPageObject;
import pageObjects.mercury.LoginPageObject;
import pageObjects.mercury.TaoChucNangPageObject;
import utils.excelutils.ExcelReader;
import utils.excelutils.ExcelUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaoChucNangSteps {
    WebDriver driver;
    VerifyHelper verify;
    ExcelUtil excel;
    TaoChucNangPageObject taoChucNangPage;
    LoginPageObject loginPage;
    DanhSachNguoiDungPageObject danhSachNguoiDungPage;
    DanhSachChucNangPageObject danhSachChucNangPage;

    public TaoChucNangSteps() {
        driver = Hooks.openAndQuitBrowser();
        //Hooks.setupTestData();
        verify = VerifyHelper.getData();
        //excel=ExcelUtil.getData();

        loginPage = PageGeneratorManager.getLoginPage(driver);
    }



   /* @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String pageName) {
        danhSachNguoiDungPage.goToPage(driver, pageName);
        danhSachChucNangPage = PageGeneratorManager.getDanhSachChucNangPage(driver);
    }*/

   /* @When("^I click Tạo Mới button$")
    public void iClickTạoMớiButton() {
        danhSachChucNangPage.clickTaoMoiButton(driver);
        taoChucNangPage = PageGeneratorManager.getTaoChucNangPage(driver);
    }*/

    @When("^I input following data$")
    public void iInputFollowingData(DataTable tenChucNang) {
        ExcelReader externalData = new ExcelReader();
        List<Map<String, String>> testData = new ArrayList<Map<String, String>>();
        try {
            testData = externalData.getData(System.getProperty("user.dir") + "/src/test/resources/datatest/TenChucNang.xlsx", 0);
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for (Map<String, String> value : testData) {
            taoChucNangPage.nhapTenChucNang(value.get("Tên chức năng"));
        }
    }

    /*@When("^I click Tạo button$")
    public void iClickTaoButton() {
        taoChucNangPage.clickTaoButton(driver);
        danhSachChucNangPage = PageGeneratorManager.getDanhSachChucNangPage(driver);
    }*/

 /*   @Then("^toast message \"([^\"]*)\" appears$")
    public void toastMessageAppears(String message) {
        verify.verifyTrue(danhSachChucNangPage.checkToastMessage(driver, message));
    }*/

    @Then("^Trạng thái display \"([^\"]*)\"$")
    public void trangThaiDisplay(String trangThai, DataTable tenChucNang) {
        for (Map<String, String> value : tenChucNang.asMaps(String.class, String.class)) {
            verify.verifyTrue(danhSachChucNangPage.verifyTrangThai(value.get("Tên Chức Năng"), trangThai));
        }
    }

   /* @Then("^\"([^\"]*)\" column display correct value in Danh sách Chức Năng$")
    public void columnDisplayCorrectValueInDanhSáchChứcNăng(String tenCot, DataTable tenChucNang) {
        for (Map<String, String> value : tenChucNang.asMaps(String.class, String.class)) {
            verify.verifyTrue(danhSachChucNangPage.checkValueInList(driver, tenCot, value.get("Tên Chức Năng")));
        }
    }*/

    @Then("^toast message \"([^\"]*)\" appears and Trạng Thái is \"([^\"]*)\" and info of Chuc Nang display correctly in Danh Sach Chuc Nang Page and Detail page after I click Tạo Mới button and I input <Tên Chức Năng> and I click Tạo button$")
    public void verifyTaoChucNang(String message, String trangthai, DataTable tenChucnang) {
        ExcelReader externalData = new ExcelReader();
        List<Map<String, String>> testData = new ArrayList<Map<String, String>>();
        try {
            testData = externalData.getData(System.getProperty("user.dir") + "/src/test/resources/datatest/datatest.xlsx", "Ô tô");
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Map<String, String> value : testData) {
            if (value.get("Trường thông tin").equals("")) {
                break;
            }
            System.out.println(value.get("Trường thông tin"));
            System.out.println(value.get("Bắt buộc?"));
           /* danhSachChucNangPage.clickTaoMoiButton(driver);
            taoChucNangPage = PageGeneratorManager.getTaoChucNangPage(driver);
            taoChucNangPage.nhapTenChucNang(value.get("Tên chức năng"));
            taoChucNangPage.clickTaoButton(driver);
            danhSachChucNangPage = PageGeneratorManager.getDanhSachChucNangPage(driver);
            verify.verifyTrue(danhSachChucNangPage.checkToastMessage(driver, message));
            verify.verifyTrue(danhSachChucNangPage.checkValueInList(driver, "Tên chức năng", value.get("Tên chức năng")));
            verify.verifyTrue(danhSachChucNangPage.verifyTrangThai(value.get("Tên chức năng"), trangthai));*/
        }
    }
	

	/*@Then("^Danh sach Chức Năng display current date time for \"([^\"]*)\"$")
	public void danhSachChucNangDisplayCurrentDateTimeFor(String dateTime) {
	}

	@Then("^Chức Năng detail page display data correctly$")
	public void chucNangDetailPageDisplayDataCorrectly(DataTable tenChucNang) {
	}*/
}