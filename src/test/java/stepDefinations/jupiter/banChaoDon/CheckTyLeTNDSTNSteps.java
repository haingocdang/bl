package stepDefinations.jupiter.banChaoDon;

import commons.GlobalConstants;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import utils.excelutils.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import utils.excelutils.ExcelUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static stepDefinations.common.stepDefinations.CommonPageSteps.commonPage;

public class CheckTyLeTNDSTNSteps {
    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;
    ExcelUtil excelFile;

    public CheckTyLeTNDSTNSteps() {
        driver = Hooks.openAndQuitBrowser();
        verify = VerifyHelper.getData();
    }


    @When("^I click \\+ button$")
    public void iClickAddButton() {
        taoBanChaoPage.clickAddDoiTuongNhomButton();
    }

    @Then("^Đối tượng tham gia bảo hiểm Nhóm section appears$")
    public void đốiTượngThamGiaBảoHiểmNhómSectionAppears() {

    }

    @Then("^TNDSTN Về Người display correct value <Tỷ Lệ> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe>$")
    public void checkTyLeTNDSTNVeNguoi(String hangXe, String hieuXe, String MDSD,
                                       String loaiXe, String nhomXe, DataTable data) {
        externalData = new ExcelReader();
        excelFile = new ExcelUtil();
        int row=0;
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, TNDSTNVeNguoiSheet;
        Sheet TNDSTNVeNguoiUltil = null;

        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        TNDSTNVeNguoiSheet = new ArrayList<Map<String, String>>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NhomLoaiXe");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            TNDSTNVeNguoiSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSTN");
            TNDSTNVeNguoiUltil = externalData.getSheetByName(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSTN");
            excelFile.setExcelFileSheet("TEST_TNDSTN");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* commonPage.iInputDateTimePicker(driver, "Ngày Hiệu Lực", "16/01/2021");
        commonPage.iInputDateTimePicker(driver, "Ngày Hết Hiệu Lực", "15/01/2022");*/
        for (Map<String, String> hangXeValue : hangXeSheet) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            commonPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            System.out.println(hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hieuXeSheet) {
                if (hangHieuXeValue.get("Hãng Xe").equals("")) {
                    break;
                }

                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    //System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    commonPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    //taoBanChaoPage.selectGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    for (Map<String, String> MDSDValue : MDSDSheet) {
                        optionNhomXeUIValues = new ArrayList<>();
                        optionLoaiXeUIValues = new ArrayList<>();
                        nhomXeDataTableValues = new ArrayList<>();
                        loaiXeDataTabaleValues = new ArrayList<>();


                        if (MDSDValue.get("Hãng Xe").equals("")) {
                            break;
                        }
                        //if (MDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                        if (MDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            commonPage.chonGiaTri(driver, MDSD, MDSDValue.get("MĐSD"));
                            commonPage.chonGiaTri(driver, nhomXe, MDSDValue.get("Nhóm Xe"));
                           // System.out.println(MDSDValue.get("MDSD"));
                            //taoBanChaoPage.selectGiaTri(driver, MDSD, MDSDValue.get("MDSD"));
                            for (Map<String, String> nhomLoaiXeValue : nhomLoaiXeSheet) {
                                //if (nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))) {
                                if (nhomLoaiXeValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (nhomLoaiXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && nhomLoaiXeValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                        && nhomLoaiXeValue.get("MĐSD").equals(MDSDValue.get("MĐSD"))) {
                                    row=0;
                                    //commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                    commonPage.chonGiaTri(driver, loaiXe, nhomLoaiXeValue.get("Loại Xe"));

                                    //System.out.println(nhomLoaiXeValue.get("Nhóm Xe"));
                                    //taoBanChaoPage.selectGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                    for (Map<String, String> TNDSTNVeNguoiValue : TNDSTNVeNguoiSheet) {
                                        row=row+1;
                                        if (TNDSTNVeNguoiValue.get("Nhóm Xe").equals("")) {
                                            break;
                                        }

                                        try {
                                            if (TNDSTNVeNguoiValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe")) &&
                                                    TNDSTNVeNguoiValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe")) &&
                                                    ((TNDSTNVeNguoiValue.get("MĐSD").equals("All")) || (TNDSTNVeNguoiValue.get("MĐSD").equals(MDSDValue.get("MĐSD")))) &&
                                                                /*((TNDSTNVeNguoiValue.get("Số Chỗ").equals("true")) || (Boolean.parseBoolean(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Số Chỗ"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi")))) || (TNDSTNVeNguoiValue.get("Số Chỗ").equals(nhomLoaiXeValue.get("Số Chỗ")))) &&
                                                                ((TNDSTNVeNguoiValue.get("Trọng Tải").equals("true")) || (Boolean.parseBoolean(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Trọng Tải"), commonPage.getGiaTriTextBox(driver, "Trọng tải")))) || (TNDSTNVeNguoiValue.get("Trọng Tải").equals(nhomLoaiXeValue.get("Trọng Tải"))))) {*/
                                                    ((TNDSTNVeNguoiValue.get("Số Chỗ").equals("All")) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Số Chỗ"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi")))) || (TNDSTNVeNguoiValue.get("Số Chỗ").equals(nhomLoaiXeValue.get("Số Chỗ")))) &&
                                                    ((TNDSTNVeNguoiValue.get("Trọng Tải").equals("All")) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Trọng Tải"), commonPage.getGiaTriTextBox(driver, "Trọng tải")))) || (TNDSTNVeNguoiValue.get("Trọng Tải").equals(nhomLoaiXeValue.get("Trọng Tải"))))) {
                                                //commonPage.chonGiaTri(driver, loaiXe, TNDSTNVeNguoiValue.get("Loại Xe"));


                                                // taoBanChaoPage.chonGiaTri(driver, loaiXe, "Xe tải");
                                                commonPage.sleepInSecond(2);
                                                // commonPage.chonPhamViBH("TNDS Tự Nguyện");
                                                System.out.println(TNDSTNVeNguoiValue.get("Loại Xe"));
                                                String tyLeVeNguoiUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "MTN BT3 về người");
                                                String tyLeVeTaiSanUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "MTN BT3 về tài sản");
                                                String tyLeVeHanhKhachUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "MTN BT3 về hành khách");
                                                String cellVeNguoiValue = excelFile.getCellData(row, 9);
                                                String cellVeTaiSanValue = excelFile.getCellData(row, 10);
                                                String cellVeHanhKhachValue = excelFile.getCellData(row, 11);
                                                /*String cellVeNguoiValue = TNDSTNVeNguoiValue.get("Về Người");
                                                String cellVeTaiSanValue = TNDSTNVeNguoiValue.get("Về Tài Sản");
                                                String cellVeHanhKhachValue = TNDSTNVeNguoiValue.get("Hành Khách");*/
                                                System.out.println(nhomLoaiXeValue.get("Hãng Xe"));
                                                System.out.println(nhomLoaiXeValue.get("Hiệu Xe"));
                                                System.out.println(nhomLoaiXeValue.get("MĐSD"));
                                                System.out.println(nhomLoaiXeValue.get("Nhóm Xe"));
                                                System.out.println(TNDSTNVeNguoiValue.get("Loại Xe"));
                                              /*  tyLeVeNguoi=tyLeVeNguoi.replace("%","/100");
                                                tyLeVeTaiSan=tyLeVeTaiSan.replace("%","/100");
                                                tyLeVeHanhKhach=tyLeVeHanhKhach.replace("%","/100");
                                                System.out.println(engine.eval(tyLeVeNguoi));
                                                System.out.println(engine.eval(tyLeVeTaiSan));
                                                System.out.println(engine.eval(tyLeVeHanhKhach));*/
                                                /*Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Về Người"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeNguoiUI.replace("%", "/100")));
                                                Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Về Tài Sản"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeTaiSanUI.replace("%", "/100")));
                                                Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNVeNguoiValue.get("Hành Khách"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeHanhKhachUI.replace("%", "/100")));*/
                                                Assert.assertEquals(cellVeNguoiValue,tyLeVeNguoiUI.replace("%",""));
                                                Assert.assertEquals(cellVeTaiSanValue,tyLeVeTaiSanUI.replace("%",""));
                                                Assert.assertEquals(cellVeHanhKhachValue,tyLeVeHanhKhachUI.replace("%",""));

                                                    /*    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về tài sản"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hành khách"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hàng hóa"));*/
                                                //taoBanChaoPage.chonPhamViBH("TNDS Tự Nguyện");
                                                //break;

                                            }
                                        } catch (ScriptException e) {
                                            e.printStackTrace();
                                        }
                                        // break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
