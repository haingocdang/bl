package stepDefinations.jupiter.banChaoDon;

import commons.GlobalConstants;
import commons.VerifyHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import utils.excelutils.ExcelReader;
import utils.excelutils.ExcelUtil;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static stepDefinations.common.stepDefinations.CommonPageSteps.commonPage;

public class CheckTyLeVCXSteps {
    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;
    ExcelUtil excelFile;

    public CheckTyLeVCXSteps() {
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

    @Then("^VCX display correct value <Tỷ Lệ> when selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and and \"([^\"]*)\" with value <Mục Đích Sử Dụng> and \"([^\"]*)\" with value <Loại Xe> and \"([^\"]*)\" with value <Nhóm Xe>$")
    public void checkTyLeTNDSTN(String hangXe, String hieuXe, String MĐSD,
                                String loaiXe, String nhomXe, DataTable data) {
        externalData = new ExcelReader();
        excelFile = new ExcelUtil();
        int row = 0;
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet, VCXSheet;
        Sheet VCXUltil = null;

        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        VCXSheet = new ArrayList<Map<String, String>>();
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NhomLoaiXe");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            VCXSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_VCX");
            VCXUltil = externalData.getSheetByName(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "TEST_VCX");
            excelFile.setExcelFileSheet("TEST_VCX");

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

                                    for (Map<String, String> VCXValue : VCXSheet) {
                                        row = row + 1;
                                        if (VCXValue.get("Nhóm Xe").equals("")) {
                                            break;
                                        }
                                        System.out.println("Nhom Xe VCX "+VCXValue.get("Nhóm Xe"));
                                        System.out.println("Loai Xe VCX "+VCXValue.get("Loại Xe"));
                                        System.out.println("Result "+ excelFile.getCellData(row, 42));
                                        if ((VCXValue.get("Nhóm Xe").equals(nhomLoaiXeValue.get("Nhóm Xe"))) &&
                                                (VCXValue.get("Loại Xe").equals(nhomLoaiXeValue.get("Loại Xe"))) &&
                                                //  ((TNDSBBValue.get("MĐSD").equals("All")) || (TNDSBBValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                                (((excelFile.getCellData(row, 42)).equals("NOT RUN YET"))))

//                                                    (((excelFile.getCellData(row, 21)).equals("NOT RUN YET")))&&
                                        // (((VCXValue.get("MĐSD").equals("All")) || (VCXValue.get("MĐSD").equals(nhomLoaiXeValue.get("MĐSD")))) &&
                                        // ((VCXValue.get("Số Chỗ").equals("All")) || (VCXValue.get("Số Chỗ").equals(VCXValue.get("Số Chỗ"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(VCXValue.get("Số Chỗ"), VCXValue.get("Inputted Số Chỗ"))))) &&
                                        //((VCXValue.get("Trọng Tải").equals("All")) || (VCXValue.get("Trọng Tải").equals(VCXValue.get("Trọng Tải"))) || ((Boolean) engine.eval(commonPage.applyCellFormular(VCXValue.get("Trọng Tải"), VCXValue.get("Inputted Trọng Tải")))))))
                                        {
                                            commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeValue.get("Nhóm Xe"));
                                            commonPage.chonGiaTri(driver, loaiXe, VCXValue.get("Loại Xe"));
                                            commonPage.iInputDateTimePicker(driver, "Ngày Đăng Ký Lần Đầu", VCXValue.get("Đăng ký lần đầu"));
                                            commonPage.inputValueIntoTextbox(driver, "Giá trị xe (Thực tế)", VCXValue.get("Gía trị xe điều chỉnh"));
                                            commonPage.inputValueIntoTextbox(driver, "Số chỗ ngồi", VCXValue.get("Số chỗ"));
                                            commonPage.chonGiaTri(driver, "Nơi sản xuất", VCXValue.get("Nơi sản xuất"));
                                            commonPage.chonGiaTri(driver, "Năm sản xuất", VCXValue.get("Năm sản xuất"));


                                            //   System.out.println(VCXValue.get("Loại Xe"));
                                            String phamViCoBanUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Phạm vi cơ bản");
                                            String boSung01UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 01");
                                            String boSung02UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 02");
                                            String boSung03UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 03");
                                            String boSung04aUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 04a");
                                            String boSung04bUI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 04b");
                                            String boSung05UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 05");
                                            String boSung06UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 06");
                                            String boSung07UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 07");
                                            String boSung08UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 08");
                                            String boSung09UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 09");
                                            String boSung10UI = commonPage.getValueFromCell(driver, "Tỉ Lệ Phí Quy Định (Gồm Thuế)", "Bổ sung 10");


                                            String cellPhamViCoBan = excelFile.getCellData(row, 29);
                                            String cellBoSung01 = excelFile.getCellData(row, 30);
                                            String cellBoSung02 = excelFile.getCellData(row, 31);
                                            String cellBoSung03 = excelFile.getCellData(row, 32);
                                            String cellBoSung04a = excelFile.getCellData(row, 33);
                                            String cellBoSung05 = excelFile.getCellData(row, 34);
                                            String cellBoSung06 = excelFile.getCellData(row, 35);
                                            String cellBoSung07 = excelFile.getCellData(row, 36);
                                            String cellBoSung08 = excelFile.getCellData(row, 37);
                                            String cellBoSung09 = excelFile.getCellData(row, 38);
                                            String cellBoSung10 = excelFile.getCellData(row, 39);


                                            if (verify.verifyEquals(phamViCoBanUI, cellPhamViCoBan.replace("%", ""))) {
                                                excelFile.setCellData("PASSED", row, 42);
                                            } else {
                                                excelFile.setCellData("FAILED", row, 42);
                                                excelFile.setCellComment("Actual value: " + phamViCoBanUI, row, 29);
                                                // excelFile.setCellData(cellPhamViCoBan, row, 16);
                                            }

                                               /* if (verify.verifyEquals(cellVeTaiSanValue, tyLeVeTaiSanUI.replace("%", ""))) {
                                                    excelFile.setCellData("PASSED", row, 17);
                                                } else {
                                                    excelFile.setCellData("FAILED", row, 17);
                                                    excelFile.setCellData(tyLeVeNguoiUI, row, 18);
                                                }

                                                if (verify.verifyEquals(cellVeHanhKhachValue, tyLeVeHanhKhachUI.replace("%", ""))) {
                                                    excelFile.setCellData("PASSED", row, 19);
                                                } else {
                                                    excelFile.setCellData("FAILED", row, 19);
                                                    excelFile.setCellData(tyLeVeNguoiUI, row, 20);
                                                }*/
                                                    /*    System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về tài sản"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hành khách"));
                                                        System.out.println(taoBanChaoPage.getValueFromCell(driver, "Phí Quy Định (Gồm Thuế)", "MTN BT3 về hàng hóa"));*/
                                            //taoBanChaoPage.chonPhamViBH("TNDS Tự Nguyện");
                                            //break;

                                        }
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




