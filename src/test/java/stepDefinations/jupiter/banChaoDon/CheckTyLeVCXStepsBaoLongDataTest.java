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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static stepDefinations.common.stepDefinations.CommonPageSteps.commonPage;

public class CheckTyLeVCXStepsBaoLongDataTest {
    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;
    ExcelUtil excelFile;

    public CheckTyLeVCXStepsBaoLongDataTest() {
        driver = Hooks.openAndQuitBrowser();
        verify = VerifyHelper.getData();
    }


 /*   @When("^I click \\+ button$")
    public void iClickAddButton() {
        taoBanChaoPage.clickAddDoiTuongNhomButton();
    }

    @Then("^Đối tượng tham gia bảo hiểm Nhóm section appears$")
    public void đốiTượngThamGiaBảoHiểmNhómSectionAppears() {

    }*/

    @Then("^Pham Vi VCX display correct value <Tỷ Lệ> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe>$")
    public void checkTyLeVCX(String hangXe, String hieuXe, String MĐSD,
                             String loaiXe, String nhomXe, DataTable data) {
        externalData = new ExcelReader();
        excelFile = new ExcelUtil();
        //  SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMdd");


        int row = 0;
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, QuotingSheet;
        Sheet VCXUltil = null;

        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        QuotingSheet = new ArrayList<Map<String, String>>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            QuotingSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Quoting");
            excelFile.setExcelFileSheet("Quoting");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        row = 0;
        for (Map<String, String> quotationValue : QuotingSheet) {
            row = row + 1;
            if (quotationValue.get("Tên Hãng xe").equals("")) {
                break;
            }
            commonPage.chonGiaTri(driver, hangXe, quotationValue.get("Tên Hãng xe"));
            commonPage.chonGiaTri(driver, hieuXe, quotationValue.get("Tên Hiệu xe"));
            commonPage.chonGiaTri(driver, MĐSD, quotationValue.get("MĐSD"));

            if (quotationValue.get("Nhóm-Loại xe").contains("Xe chở người")) {
                commonPage.chonGiaTri(driver, nhomXe, "Nhóm xe chở người");

            } else if (quotationValue.get("Nhóm-Loại xe").contains("Xe chở hàng")) {
                commonPage.chonGiaTri(driver, nhomXe, "Nhóm xe chở hàng");
                // commonPage.chonGiaTri(driver, nhomXe, quotationValue.get("Xe vừa chở người vừa chở hàng"));

            } else {
                commonPage.chonGiaTri(driver, nhomXe, "Xe vừa chở người vừa chở hàng");
            }
            commonPage.chonGiaTri(driver, loaiXe, quotationValue.get("Loại xe"));
            commonPage.iInputDateTimePicker(driver, "Ngày Đăng Ký Lần Đầu", excelFile.getCellDate(row, 17));
            commonPage.iInputDateTimePicker(driver, "Ngày bắt đầu", excelFile.getCellDate(row, 19));
            commonPage.iInputDateTimePicker(driver, "Ngày kết thúc", excelFile.getCellDate(row, 20));
            commonPage.inputValueIntoTextbox(driver, "Giá trị xe thực tế", quotationValue.get("Gía trị xe điều chỉnh"));
            commonPage.inputValueIntoTextbox(driver, "Số chỗ ngồi", quotationValue.get("Số chỗ"));

            commonPage.chonGiaTri(driver, "Nơi sản xuất", quotationValue.get("Nơi sản xuất"));
            commonPage.chonGiaTri(driver, "Năm sản xuất", quotationValue.get("Năm sản xuất"));
            commonPage.sleepInSecond(1);
            commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB, "Phạm vi bảo hiểm");
            commonPage.checkToCheckbox(driver, CommonPageUI.LOAI_HINH_BH_PARENT_CHECKBOX, "Vật chất xe");

            String phamViCoBanUI, boSung01UI, boSung02UI,
                    boSung03UI, boSung04aUI, boSung04bUI,
                    boSung05UI, boSung06UI, boSung07UI,
                    boSung08UI, boSung09UI, boSung10UI;

            phamViCoBanUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Phạm vi cơ bản");
            if (excelFile.getCellData(row, 21).equals("Y")) {
                boSung01UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 01");

            } else {
                boSung01UI = "0%";
            }
            if (excelFile.getCellData(row, 22).equals("Y")) {

                boSung02UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 02");
            } else {
                boSung02UI = "0%";
            }
            //   boSung03UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 03");
            if (excelFile.getCellData(row, 24).equals("Y")) {
                boSung04aUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 04a");
            } else {
                boSung04aUI = "0%";
            }
            boSung04bUI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 04b");
            if (excelFile.getCellData(row, 25).equals("Y")) {
                boSung05UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 05");
            } else {
                boSung05UI = "0%";
            }
            //   String boSung06UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 06");
            if (excelFile.getCellData(row, 27).equals("Y")) {
                boSung07UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 07");
            } else {
                boSung07UI = "0%";
            }

            if (excelFile.getCellData(row, 28).equals("Y")) {
                boSung08UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 08");
            } else {
                boSung08UI = "0%";
            }

            if (excelFile.getCellData(row, 29).equals("Y")) {

                boSung09UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 09");
            } else {
                boSung09UI = "0%";
            }

            if (excelFile.getCellData(row, 30).equals("Y")) {
                boSung10UI = commonPage.getValueFromCell(driver, "TLP Chuẩn (Sau thuế)", "Bổ sung 10");
            } else {
                boSung10UI = "0%";
            }


            String cellPhamViCoBan = excelFile.getCellData(row, 37);
            String cellBoSung01 = excelFile.getCellData(row, 38);
            String cellBoSung02 = excelFile.getCellData(row, 39);
            // String cellBoSung03 = excelFile.getCellData(row, 35);
            String cellBoSung04a = excelFile.getCellData(row, 41);
            String cellBoSung05 = excelFile.getCellData(row, 42);
            String cellBoSung06 = excelFile.getCellData(row, 43);
            String cellBoSung07 = excelFile.getCellData(row, 44);
            // String cellBoSung08 = excelFile.getCellData(row, 45);
            String cellBoSung09 = excelFile.getCellData(row, 47);
            String cellBoSung10 = excelFile.getCellData(row, 46);


            //  Assert.assertEquals(cellPhamViCoBan, phamViCoBanUI.replace("%", ""));
            if (verify.verifyEquals(cellPhamViCoBan, phamViCoBanUI.replace("%", "")) &&
                    (verify.verifyEquals(cellBoSung01, boSung01UI.replace("%", ""))) &&
                    (verify.verifyEquals(cellBoSung02, boSung02UI.replace("%", ""))) &&
                    (verify.verifyEquals(cellBoSung04a, boSung04aUI.replace("%", ""))) &&
                    (verify.verifyEquals(cellBoSung05, boSung05UI.replace("%", ""))) &&
                    (verify.verifyEquals(cellBoSung07, boSung07UI.replace("%", ""))) &&
                    // (verify.verifyEquals(cellBoSung08, boSung08UI.replace("%", ""))) &&
                    (verify.verifyEquals(cellBoSung09, boSung09UI.replace("%", "")) &&
                    (verify.verifyEquals(cellBoSung10, boSung10UI.replace("%", ""))))) {
                excelFile.setCellData("PASSED", row, 50);
            } else {
                excelFile.setCellData("FAILED", row, 50);
                                                /*System.out.println("Excell "+cellPhamViCoBan);
                                                System.out.println("UI "+phamViCoBanUI);*/

                excelFile.setCellComment("Actual value: " + phamViCoBanUI, row, 37);
                excelFile.setCellComment("Actual value: " + boSung01UI, row, 38);
                excelFile.setCellComment("Actual value: " + boSung02UI, row, 39);
                excelFile.setCellComment("Actual value: " + boSung04aUI, row, 41);
                excelFile.setCellComment("Actual value: " + boSung05UI, row, 42);
                excelFile.setCellComment("Actual value: " + boSung07UI, row, 43);
                excelFile.setCellComment("Actual value: " + boSung08UI, row, 45);
                excelFile.setCellComment("Actual value: " + boSung09UI, row, 47);
                excelFile.setCellComment("Actual value: " + boSung10UI, row, 46);

            }
            commonPage.sleepInSecond(1);
            commonPage.clickToElement(driver, CommonPageUI.COMMON_TAB, "Thông tin xe");
        }


    }
}




