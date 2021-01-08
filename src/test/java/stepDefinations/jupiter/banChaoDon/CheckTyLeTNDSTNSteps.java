package stepDefinations.jupiter.banChaoDon;

import commons.GlobalConstants;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import org.openqa.selenium.WebDriver;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import utils.excelutils.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckTyLeTNDSTNSteps {
    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;

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

    @Then("^TNDSTN Về Người display correct value <Tỷ Lệ> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe> and inputting \"([^\"]*)\" with value <Số Chỗ Ngồi> and inputting \"([^\"]*)\" with value <Trọng Tải>$")
    public void checkTyLeTNDSTNVeNguoi(String hangXe, String hieuXe, String MDSD,
                                       String loaiXe, String nhomXe, String soCho, String trongTai, DataTable data) {
       externalData = new ExcelReader();
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, TNDSTNVeNguoiSheet;
        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        TNDSTNVeNguoiSheet = new ArrayList<Map<String, String>>();

        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NhomLoaiXe");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            TNDSTNVeNguoiSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TNDSTNVeNguoi");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map<String, String> hangXeValue : hangXeSheet) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            if (hangXeValue.get("Hãng Xe").equals("THACO")) {
                taoBanChaoPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
                //taoBanChaoPage.selectItemInDropDown(driver, hangXe, hangXeValue.get("Hãng Xe"));
                for (Map<String, String> hangHieuXeValue : hieuXeSheet) {
                    if (hangHieuXeValue.get("Hãng Xe").equals("")) {
                        break;
                    }
                    if (hangHieuXeValue.get("Hiệu Xe").equals("OLLIN 345")) {

                        if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                            //System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                            taoBanChaoPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));

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
                                    taoBanChaoPage.chonGiaTri(driver, MDSD, MDSDValue.get("MDSD"));
                                    //taoBanChaoPage.selectGiaTri(driver, MDSD, MDSDValue.get("MDSD"));
                                    for (Map<String, String> nhomLoaiXeValue : nhomLoaiXeSheet) {
                                        //if (nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))) {
                                        if (nhomLoaiXeValue.get("Hãng Xe").equals("")) {
                                            break;
                                        }
                                        if (nhomLoaiXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                                && nhomLoaiXeValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                                && nhomLoaiXeValue.get("MDSD").equals(MDSDValue.get("MDSD"))) {
                                            taoBanChaoPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                            //taoBanChaoPage.selectGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                            for (Map<String, String> TNDSTNVeNguoiValue : TNDSTNVeNguoiSheet) {
                                                if (TNDSTNVeNguoiValue.get("Nhóm Xe").equals("")) {
                                                    break;
                                                }
                                                if (TNDSTNVeNguoiValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe")) &&
                                                        TNDSTNVeNguoiValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe")) &&
                                                        ((TNDSTNVeNguoiValue.get("MDSD").equals("true")) || (TNDSTNVeNguoiValue.get("MDSD").equals(MDSDValue.get("MDSD")))) &&
                                                        ((TNDSTNVeNguoiValue.get("Số Chỗ").equals("true")) || (Boolean.parseBoolean(taoBanChaoPage.applyCellFormular(TNDSTNVeNguoiValue.get("Số Chỗ"), taoBanChaoPage.getGiaTriTextBox(driver, soCho)))) || (TNDSTNVeNguoiValue.get("Số Chỗ").equals(nhomLoaiXeValue.get("Số Chỗ")))) &&
                                                        ((TNDSTNVeNguoiValue.get("Trọng Tải").equals("true")) || (Boolean.parseBoolean(taoBanChaoPage.applyCellFormular(TNDSTNVeNguoiValue.get("Trọng Tải"), taoBanChaoPage.getGiaTriTextBox(driver, trongTai)))) || (TNDSTNVeNguoiValue.get("Trọng Tải").equals(nhomLoaiXeValue.get("Trọng Tải"))))) {
                                                    //taoBanChaoPage.selectGiaTri(driver, loaiXe, TNDSTNVeNguoiValue.get("Loại Xe"));
                                                    taoBanChaoPage.chonGiaTri(driver, loaiXe, "Xe tải");
                                                    taoBanChaoPage.sleepInSecond(2);
                                                    taoBanChaoPage.chonPhamViBH("TNDS Tự Nguyện");
                                                    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Tỉ lệ phí quy định (gồm thuế)", "MTN BT3 về người"));
                                                    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Tỉ lệ phí quy định (gồm thuế)", "MTN BT3 về tài sản"));
                                                    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Tỉ lệ phí quy định (gồm thuế)", "MTN BT3 về hành khách"));
                                                    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Tỉ lệ phí quy định (gồm thuế)", "MTN BT3 về hàng hóa"));
                                                    taoBanChaoPage.chonPhamViBH("TNDS Tự Nguyện");
                                                    break;

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
        }

    }
}
