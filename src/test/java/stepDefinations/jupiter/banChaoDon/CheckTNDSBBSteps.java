package stepDefinations.jupiter.banChaoDon;

import commons.GlobalConstants;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumberOption.Hooks;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import pageUIs.alpaca.CommonPageUI;
import utils.excelutils.ExcelReader;
import utils.excelutils.ExcelUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static stepDefinations.common.stepDefinations.CommonPageSteps.commonPage;

public class CheckTNDSBBSteps {
    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    ExcelUtil excelFile;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;

    public CheckTNDSBBSteps() {
        driver = Hooks.openAndQuitBrowser();
        verify = VerifyHelper.getData();
    }

    @Then("^TNDSBB display correct value <Phí> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe>$")
    public void checkTyLeTNDSTNVeNguoi(String hangXe, String hieuXe, String MĐSD,
                                       String loaiXe, String nhomXe, DataTable data) {
        externalData = new ExcelReader();
        excelFile = new ExcelUtil();
        int row = 0;
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, TNDSBBSheet;
        Sheet TNDSBBSheetUltil = null;
        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        TNDSBBSheet = new ArrayList<Map<String, String>>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NhomLoaiXe");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            TNDSBBSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSBB");
            TNDSBBSheetUltil = externalData.getSheetByName(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSBB");
            excelFile.setExcelFileSheet("TEST_TNDSBB");
            // TNDSBBSheetUltil=excelFile.


        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        commonPage.iInputDateTimePicker(driver, "Ngày hiệu lực", "16/01/2021");
        commonPage.iInputDateTimePicker(driver, "Ngày hêt hiệu lực", "15/01/2022");*/
        for (Map<String, String> hangXeValue : hangXeSheet) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            commonPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            //  System.out.println(hangXeValue.get("Hãng Xe"));
            //taoBanChaoPage.selectItemInDropDown(driver, hangXe, hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hieuXeSheet) {
                if (hangHieuXeValue.get("Hãng Xe").equals("")) {
                    break;
                }

                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    // System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    commonPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    // System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    //taoBanChaoPage.selectGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    for (Map<String, String> MDSDValue : MDSDSheet) {
                        optionNhomXeUIValues = new ArrayList<>();
                        optionLoaiXeUIValues = new ArrayList<>();
                        nhomXeDataTableValues = new ArrayList<>();
                        loaiXeDataTabaleValues = new ArrayList<>();
                        if (MDSDValue.get("Hãng Xe").equals("")) {
                            break;
                        }
                        if (MDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            commonPage.chonGiaTri(driver, MĐSD, MDSDValue.get("MĐSD"));
                            //System.out.println(MDSDValue.get("MĐSD"));
                            for (Map<String, String> nhomLoaiXeValue : nhomLoaiXeSheet) {
                                //if (nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))) {
                                if (nhomLoaiXeValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (nhomLoaiXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && nhomLoaiXeValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                        && nhomLoaiXeValue.get("MĐSD").equals(MDSDValue.get("MĐSD"))) {
                                  //  commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));

                                    row = 0;
                                    for (Map<String, String> TNDSBBValue : TNDSBBSheet) {
                                        row = row + 1;

                                        if (TNDSBBValue.get("Nhóm Xe").equals("")) {
                                            break;
                                        }

                                            /*if (TNDSBBValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe")) &&
                                                    TNDSBBValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe")) &&
                                                    ((TNDSBBValue.get("MĐSD").equals("All")) || (TNDSBBValue.get("MĐSD").equals(MDSDValue.get("MĐSD")))) &&
                                                                *//*((TNDSBBValue.get("Số Chỗ").equals("true")) || (Boolean.parseBoolean(commonPage.applyCellFormular(TNDSBBValue.get("Số Chỗ"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi")))) || (TNDSBBValue.get("Số Chỗ").equals(nhomLoaiXeValue.get("Số Chỗ")))) &&
                                                                ((TNDSBBValue.get("Trọng Tải").equals("true")) || (Boolean.parseBoolean(commonPage.applyCellFormular(TNDSBBValue.get("Trọng Tải"), commonPage.getGiaTriTextBox(driver, "Trọng tải")))) || (TNDSBBValue.get("Trọng Tải").equals(nhomLoaiXeValue.get("Trọng Tải"))))) {*//*
                                                    ((TNDSBBValue.get("Số Chỗ").equals("All")) || (TNDSBBValue.get("Số Chỗ").equals(nhomLoaiXeValue.get("Số Chỗ"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSBBValue.get("Số Chỗ"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))))) &&
                                                    ((TNDSBBValue.get("Trọng Tải").equals("All")) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSBBValue.get("Trọng Tải"), commonPage.getGiaTriTextBox(driver, "Trọng tải")))) || (TNDSBBValue.get("Trọng Tải").equals(nhomLoaiXeValue.get("Trọng Tải"))))) {*/
                                        try {
                                            if ((TNDSBBValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe"))) &&
                                                    (TNDSBBValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe"))) &&
                                                    //  ((TNDSBBValue.get("MĐSD").equals("All")) || (TNDSBBValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                                    (((excelFile.getCellData(row, 12)).equals("NOT RUN YET"))) &&
                                                    (((TNDSBBValue.get("MĐSD").equals("All")) || (TNDSBBValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                                            ((TNDSBBValue.get("Số Chỗ").equals("All")) || (TNDSBBValue.get("Số Chỗ").equals(TNDSBBValue.get("Số Chỗ"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSBBValue.get("Số Chỗ"), TNDSBBValue.get("Inputted Số Chỗ"))))) &&
                                                            ((TNDSBBValue.get("Trọng Tải").equals("All")) || (TNDSBBValue.get("Trọng Tải").equals(TNDSBBValue.get("Trọng Tải"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSBBValue.get("Trọng Tải"), TNDSBBValue.get("Inputted Trọng Tải"))))))) {
                                                 commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                                commonPage.chonGiaTri(driver, loaiXe, TNDSBBValue.get("Loại Xe"));

                                                commonPage.inputValueIntoTextbox(driver, "Số chỗ ngồi", TNDSBBValue.get("Inputted Số Chỗ"));
                                                commonPage.sleepInSecond(1);
                                                commonPage.inputValueIntoTextbox(driver, "Trọng tải", TNDSBBValue.get("Inputted Trọng Tải"));
                                                commonPage.sleepInSecond(1);


                                                commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB, "Phạm vi bảo hiểm");


                                                String phiBBUI = commonPage.getValueFromCell(driver, "Phí Chuẩn (Sau Thuế)", "TNDS Bắt Buộc").replace(",","");
                                                String phiBBExpected = TNDSBBValue.get("Phí Final");
                                                String cellValue = excelFile.getCellData(row, 11);//.replace(",", "");

                                                if (verify.verifyEquals(cellValue, phiBBUI)) {
                                                    excelFile.setCellData("PASSED", row, 12);
                                                   /* excelFile.setCellData(nhomLoaiXeValue.get("MĐSD"), row, 13);
                                                    excelFile.setCellData(hangHieuXeValue.get("Hiệu Xe"), row, 14);*/

                                                } else {

                                                    excelFile.setCellData("FAILED", row, 12);
                                                    excelFile.setCellComment(phiBBUI, row, 11);
                                                    excelFile.setCellComment(cellValue, row, 12);

                                                   /* excelFile.setCellData(nhomLoaiXeValue.get("MĐSD"), row, 14);
                                                    excelFile.setCellData(hangHieuXeValue.get("Hiệu Xe"), row, 15);*/
                                                    // excelFile.setCellData(cellValue, row, 16);
                                                }

                                            }
                                            //row=row+1;
                                        } catch (ScriptException e) {
                                            e.printStackTrace();
                                        }
                                        commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB, "Thông tin xe");

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





