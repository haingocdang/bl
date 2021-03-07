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
import pageUIs.alpaca.CommonPageUI;
import utils.excelutils.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
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

    @Then("^TNDSTN display correct value <Tỷ Lệ> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe>$")
    public void checkTyLeTNDSTN(String hangXe, String hieuXe, String MĐSD,
                                       String loaiXe, String nhomXe, DataTable data) {
        externalData = new ExcelReader();
        excelFile = new ExcelUtil();
        int row = 0;
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, TNDSTNSheet;
        Sheet TNDSTNUltil = null;

        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        TNDSTNSheet = new ArrayList<Map<String, String>>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NhomLoaiXe");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            TNDSTNSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSTN");
            TNDSTNUltil = externalData.getSheetByName(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_TNDSTN");
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
                        if (MDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            commonPage.chonGiaTri(driver, MĐSD, MDSDValue.get("MĐSD"));
                            System.out.println(MDSDValue.get("MĐSD"));
                            for (Map<String, String> nhomLoaiXeValue : nhomLoaiXeSheet) {
                                //if (nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))) {
                                if (nhomLoaiXeValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (nhomLoaiXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && nhomLoaiXeValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                        && nhomLoaiXeValue.get("MĐSD").equals(MDSDValue.get("MĐSD"))) {
                                    row = 0;

                                    for (Map<String, String> TNDSTNValue : TNDSTNSheet) {
                                        row = row + 1;
                                        if (TNDSTNValue.get("Nhóm Xe").equals("")) {
                                            break;
                                        }

                                        try {
                                            if ((TNDSTNValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe"))) &&
                                                    (TNDSTNValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe"))) &&
                                                    //  ((TNDSBBValue.get("MĐSD").equals("All")) || (TNDSBBValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                                    (((excelFile.getCellData(row, 15)).equals("NOT RUN YET"))) &&
                                                   /* (((excelFile.getCellData(row, 17)).equals("NOT RUN YET"))) &&
                                                    (((excelFile.getCellData(row, 19)).equals("NOT RUN YET")))&&*/
//                                                    (((excelFile.getCellData(row, 21)).equals("NOT RUN YET")))&&
                                                    (((TNDSTNValue.get("MĐSD").equals("All")) || (TNDSTNValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                                            ((TNDSTNValue.get("Số Chỗ").equals("All")) || (TNDSTNValue.get("Số Chỗ").equals(TNDSTNValue.get("Số Chỗ"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSTNValue.get("Số Chỗ"), TNDSTNValue.get("Inputted Số Chỗ"))))) &&
                                                            ((TNDSTNValue.get("Trọng Tải").equals("All")) || (TNDSTNValue.get("Trọng Tải").equals(TNDSTNValue.get("Trọng Tải"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(TNDSTNValue.get("Trọng Tải"), TNDSTNValue.get("Inputted Trọng Tải"))))))) {
                                                commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                                commonPage.chonGiaTri(driver, loaiXe, TNDSTNValue.get("Loại Xe"));
                                                //commonPage.inputCellValue(driver, TNDSTNValue.get("Số Chỗ"), "Số chỗ ngồi", TNDSTNValue.get("Inputted Số Chỗ"));
                                                commonPage.inputValueIntoTextbox(driver,"Số chỗ ngồi",TNDSTNValue.get("Inputted Số Chỗ"));
                                                commonPage.sleepInSecond(1);
                                                commonPage.inputValueIntoTextbox(driver,"Trọng tải",TNDSTNValue.get("Inputted Trọng Tải"));

                                               // commonPage.inputCellValue(driver, TNDSTNValue.get("Trọng Tải"), "Trọng tải", TNDSTNValue.get("Inputted Trọng Tải"));
                                                commonPage.sleepInSecond(1);

                                                commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB,"Phạm vi bảo hiểm");

                                                //   System.out.println(TNDSTNValue.get("Loại Xe"));
                                                String tyLeVeNguoiUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "MTN BT3 về người");
                                                String tyLeVeTaiSanUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "MTN BT3 về tài sản");
                                                String tyLeVeHanhKhachUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "MTN BT3 về hành khách");
                                                String cellVeNguoiValue = excelFile.getCellData(row, 11);
                                                String cellVeTaiSanValue = excelFile.getCellData(row, 12);
                                                String cellVeHanhKhachValue = excelFile.getCellData(row, 13);
                                                /*String cellVeNguoiValue = TNDSTNValue.get("Về Người");
                                                String cellVeTaiSanValue = TNDSTNValue.get("Về Tài Sản");
                                                String cellVeHanhKhachValue = TNDSTNValue.get("Hành Khách");*/
/*                                                System.out.println(nhomLoaiXeValue.get("Hãng Xe"));
                                                System.out.println(nhomLoaiXeValue.get("Hiệu Xe"));
                                                System.out.println(nhomLoaiXeValue.get("MĐSD"));
                                                System.out.println(nhomLoaiXeValue.get("Nhóm Xe"));
                                                System.out.println(TNDSTNValue.get("Loại Xe"));*/
                                              /*  tyLeVeNguoi=tyLeVeNguoi.replace("%","/100");
                                                tyLeVeTaiSan=tyLeVeTaiSan.replace("%","/100");
                                                tyLeVeHanhKhach=tyLeVeHanhKhach.replace("%","/100");
                                                System.out.println(engine.eval(tyLeVeNguoi));
                                                System.out.println(engine.eval(tyLeVeTaiSan));
                                                System.out.println(engine.eval(tyLeVeHanhKhach));*/
                                                /*Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNValue.get("Về Người"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeNguoiUI.replace("%", "/100")));
                                                Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNValue.get("Về Tài Sản"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeTaiSanUI.replace("%", "/100")));
                                                Assert.assertEquals(engine.eval(commonPage.applyCellFormular(TNDSTNValue.get("Hành Khách"), commonPage.getGiaTriTextBox(driver, "Số chỗ ngồi"))), engine.eval(tyLeVeHanhKhachUI.replace("%", "/100")));*/
                                               /* Assert.assertEquals(cellVeNguoiValue, tyLeVeNguoiUI.replace("%", ""));
                                                Assert.assertEquals(cellVeTaiSanValue, tyLeVeTaiSanUI.replace("%", ""));
                                                Assert.assertEquals(cellVeHanhKhachValue, tyLeVeHanhKhachUI.replace("%", ""));*/

                                                if (verify.verifyEquals(cellVeNguoiValue, tyLeVeNguoiUI.replace("%", "")) &&
                                                        (verify.verifyEquals(cellVeTaiSanValue, tyLeVeTaiSanUI.replace("%", ""))) &&
                                                        (verify.verifyEquals(cellVeHanhKhachValue, tyLeVeHanhKhachUI.replace("%", "")))
                                                ){
                                                    excelFile.setCellData("PASSED", row, 15);
                                                } else{
                                                    excelFile.setCellData("FAILED", row, 15);

                                                    excelFile.setCellComment("Actual value: "+ tyLeVeNguoiUI, row,11);
                                                    excelFile.setCellComment("Actual value: "+ tyLeVeTaiSanUI, row,12);
                                                    excelFile.setCellComment("Actual value: "+ tyLeVeHanhKhachUI, row,13);
                                                    System.out.println("Expected value Nguoi: "+cellVeNguoiValue);
                                                    System.out.println("Expected value Tai San: "+cellVeTaiSanValue);
                                                    System.out.println("Expected value Hanh Khach: "+cellVeHanhKhachValue);

                                                    // excelFile.setCellData(tyLeVeNguoiUI, row, 16);
                                                }

                                               /* if (verify.verifyEquals(cellVeTaiSanValue, tyLeVeTaiSanUI.replace("%", ""))){
                                                    excelFile.setCellData("PASSED", row, 15);
                                                } else{
                                                    excelFile.setCellData("FAILED", row, 15);
                                                    excelFile.setCellComment("Actual value: "+tyLeVeTaiSanUI, row,12);
                                                    excelFile.setCellData(tyLeVeTaiSanUI, row, 18);
                                                }

                                                if (verify.verifyEquals(cellVeHanhKhachValue, tyLeVeHanhKhachUI.replace("%", ""))){
                                                    excelFile.setCellData("PASSED", row, 19);
                                                } else{
                                                    excelFile.setCellData("FAILED", row, 19);
                                                    excelFile.setCellComment("Actual value: "+tyLeVeHanhKhachUI, row,13);

                                                }*/
                                                    /*    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về tài sản"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hành khách"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hàng hóa"));*/
                                                //taoBanChaoPage.chonPhamViBH("TNDS Tự Nguyện");
                                                //break;

                                            }
                                        } catch (ScriptException e) {
                                            e.printStackTrace();
                                        }
                                        commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB,"Thông tin xe");

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



