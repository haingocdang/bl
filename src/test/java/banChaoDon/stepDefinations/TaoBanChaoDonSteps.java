package banChaoDon.stepDefinations;

import commons.GlobalConstants;
import cucumber.api.DataTable;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.jupiter.TaoBanChaoPageObject;
import pageObjects.mercury.LoginPageObject;
import commons.VerifyHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pageUIs.alpaca.AbstracPageUI;
import utils.excelutils.ExcelReader;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaoBanChaoDonSteps {

    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;

    public TaoBanChaoDonSteps() {
        driver = Hooks.openAndQuitBrowser();
        verify = VerifyHelper.getData();
    }

    @Given("^I launch and login Jupiter page$")
    public void i_launch_and_login_Jupiter_page() {
        driver.get(GlobalConstants.JUPITER_LOGIN_TEST_ENV_URL);
        driver.manage().window().maximize();
        LoginPageObject loginPage;
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputUserName("TEST");
        loginPage.inputUserPassword("12341234");
        loginPage.clickDangNhapButton();
        danhSachBanChaoPage = PageGeneratorManager.getDanhSachBanChaoPage(driver);
    }

    @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String pageName) {
        danhSachBanChaoPage.goToPage(driver, pageName);
    }

    @When("^I click Tạo Mới button$")
    public void iClickTaoMoiButton() {
        danhSachBanChaoPage.clickTaoMoiButton(driver);
        taoBanChaoPage = PageGeneratorManager.getTaoBanChaoPage(driver);

    }

    @When("^I select \"([^\"]*)\" drop down list with <Nhóm sản phẩm> value$")
    public void selectNhomSanPham(String tenField, DataTable nhomSanPhamDataTable) {
        for (Map<String, String> sanPham : nhomSanPhamDataTable.asMaps(String.class, String.class)) {
            taoBanChaoPage.chonGiaTri(driver, tenField, sanPham.get("Nhóm sản phẩm"));
        }
    }

    @When("^I select \"([^\"]*)\" drop down list with <Tên sản phẩm> value$")
    public void selectTenSanPham(String tenField, DataTable tenSanPhamDataTable) {
        for (Map<String, String> sanPham : tenSanPhamDataTable.asMaps(String.class, String.class)) {
            taoBanChaoPage.chonGiaTri(driver, tenField, sanPham.get("Tên sản phẩm"));
        }
    }

    @When("^I select \"([^\"]*)\" drop down list with <Loại Bản Chào> value$")
    public void iSelectDropDownListWithLoạiBảnChàoValue(String tenField, DataTable loaiBanChaoDataTable) {
        for (Map<String, String> sanPham : loaiBanChaoDataTable.asMaps(String.class, String.class)) {
            taoBanChaoPage.chonGiaTri(driver, tenField, sanPham.get("Loại Bản Chào"));
        }
    }

    @Then("^Bản Chào Đơn-Đối tượng tham gia bảo hiểm section appears$")
    public void bảnChàoĐơnĐốiTượngThamGiaBảoHiểmSectionAppears() {

    }

    @Then("^\"([^\"]*)\" display correct value <Hãng Xe> from PB$")
    public void checkHangXeValues(String tenfield, DataTable hangXeDataTable) {
       /* externalData = new ExcelReader();
        testData = new ArrayList<Map<String, String>>();
        optionUIValues = new ArrayList<>();
        dataTableValues = new ArrayList<>();
        optionUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(driver,tenfield);

        try {
            testData = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        for (Map<String, String> value : testData) {
            if (value.get("Tên Hãng Xe").equals("")) {
                break;
            }
            dataTableValues.add(value.get("Hãng Xe"));
        }
        System.out.println("Datatable in step 2" + dataTableValues);
        verify.verifyTrue(dataTableValues.equals(optionUIValues));
        if (dataTableValues.equals(optionUIValues)) {
            System.out.println("Verify 2: PASSED");
        } else {
            System.out.println("Verify 2: FAILED");
        }*/
    }

    @Then("^\"([^\"]*)\" display correct value <Hiệu Xe> from PB after selecting \"([^\"]*)\" with value <Hãng Xe>$")
    public void checkHieuXeValues(String hieuXe, String hangXeSelectbox, DataTable hangHieuXeDataTable) {
   /*     externalData = new ExcelReader();
        List<Map<String, String>> hangHieuXe, hangXe;
        hangXe = new ArrayList<Map<String, String>>();
        hangHieuXe = new ArrayList<Map<String, String>>();
        try {
            hangXe = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hangHieuXe = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map<String, String> hangXeValue : hangXe) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            taoBanChaoPage.chonGiaTri(driver, hangXeSelectbox, hangXeValue.get("Hãng Xe"));
            optionUIValues = new ArrayList<>();
            dataTableValues = new ArrayList<>();
            optionUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(driver, hieuXe);
            for (Map<String, String> hangHieuXevalue : hangHieuXe) {
                if (hangHieuXevalue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    if (hangHieuXevalue.get("Hãng Xe").equals("")) {
                        break;
                    }
                    dataTableValues.add(hangHieuXevalue.get("Hiệu Xe"));
                }
            }
            verify.verifyTrue(dataTableValues.equals(optionUIValues));
            System.out.println(hangXeValue.get("Hãng Xe"));
            System.out.println("UI " + optionUIValues);
            System.out.println("Datatable " + dataTableValues);
            if (verify.verifyTrue(dataTableValues.equals(optionUIValues))) {
                System.out.println("Verify 3: PASSED");
            } else {
                System.out.println("Verify 3: FAILED");

            }
    }*/

    }


    @Then("^\"([^\"]*)\" display correct value <Nhóm Xe> from PB and \"([^\"]*)\" display correct value <Mục Đích Sử Dụng> and \"([^\"]*)\" display correct value <Dòng Xe> and \"([^\"]*)\" dipsplay correct value <Số Chỗ Ngồi> and \"([^\"]*)\" display correct value <Trọng Tải> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe>$")
    public void checkNhomXeMDSDDongXeSoChoTrongTai(String nhomXe, String MDSD, String dongXe, String
            soCho, String trongTai, String hangXe, String hieuXe, DataTable data) {
      /*  externalData = new ExcelReader();
        List<Map<String, String>> hangHieuXeOToSheet, MDSDSheet, hangXeSheet;
        hangHieuXeOToSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        try {
            hangXeSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hangHieuXeOToSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
            MDSDSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //for (Map<String, String> mucDichSuDung : MDSDSheet) {
        for (Map<String, String> hangXeValue : hangXeSheet) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            taoBanChaoPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hangHieuXeOToSheet) {
                if (hangHieuXeValue.get("Hiệu Xe").equals("")) {

                    break;
                }
                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    taoBanChaoPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println("HANG XE " + hangXeValue.get("Hãng Xe"));
                    System.out.println("HIEU XE " + hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println("DONG XE UI " + taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, dongXe));
                    System.out.println("DONG XE DATA " + hangHieuXeValue.get("Dòng Xe"));
                    System.out.println("SO CHO UI " + taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, soCho));
                    System.out.println("SO CHO DATA " + hangHieuXeValue.get("Số Chỗ"));
                    System.out.println("TRONG TAI UI " + taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, trongTai));
                    System.out.println("TRONG TAI DATA " + hangHieuXeValue.get("Trọng Tải"));
                    if (verify.verifyEquals(taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, dongXe), hangHieuXeValue.get("Dòng Xe"))) {
                        System.out.println("VERIFY 4 DONG XE PASSED");
                    } else {
                        System.out.println("VERIFY 4 DONG XE FAILED");

                    }

                    if (verify.verifyEquals(taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, soCho), hangHieuXeValue.get("Số Chỗ"))) {
                        System.out.println("VERIFY 4 SO CHO PASSED");
                    } else {
                        System.out.println("VERIFY 4 SO CHO FAILED");
                    }

                    if (verify.verifyEquals(taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, trongTai), hangHieuXeValue.get("Trọng Tải"))) {
                        System.out.println("VERIFY 4 TRONG TAI PASSED");
                    } else {
                        System.out.println("VERIFY 4 TRONG TAI FAILED");

                    }
                    optionUIValues = new ArrayList<>();
                    dataTableValues = new ArrayList<>();
                    optionUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(driver, MDSD);
                    for (Map<String, String> mucDichSuDung : MDSDSheet) {
                        if (mucDichSuDung.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe")) && mucDichSuDung.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            dataTableValues.add(mucDichSuDung.get("MDSD"));
                        }
                    }
                    verify.verifyTrue(dataTableValues.equals(optionUIValues));
                    System.out.println(hangHieuXeValue.get("Hãng Xe"));
                    System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println("UI " + optionUIValues);
                    System.out.println("Datatable " + dataTableValues);
                    if (verify.verifyTrue(dataTableValues.equals(optionUIValues))) {
                        System.out.println("Verify 4: PASSED");
                    } else {
                        System.out.println("Verify 4: FAILED");

                    }
                }
            }
        }*/
    }

    @Then("^\"([^\"]*)\" display correct value <Loại Xe> and \"([^\"]*)\" display correct value <Nhóm Xe> after seleting <Hãng Xe> from \"([^\"]*)\" and <Hiệu Xe> from \"([^\"]*)\" and <Mục Đích Sử Dụng> from \"([^\"]*)\"$")
    public void checkLoaiXeNhomXe(String loaiXe, String nhomXe, String hangXe, String hieuXe, String
            MDSD, DataTable data) {
       /* externalData = new ExcelReader();
        List<Map<String, String>> nhomLoaiXeSheet, MDSDSheet,
                hangXeSheet, hieuXeSheet;
        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        nhomLoaiXeSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();

        try {
            hangXeSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");

            nhomLoaiXeSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Nhom_Loai_Dong_SoCho_TT");
            MDSDSheet = externalData.getData( GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map<String, String> hangXeValue : hangXeSheet) {
            taoBanChaoPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hieuXeSheet) {
                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    taoBanChaoPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    for (Map<String, String> hangHieuXeMDSDValue : MDSDSheet) {
                        optionNhomXeUIValues = new ArrayList<>();
                        optionLoaiXeUIValues = new ArrayList<>();
                        nhomXeDataTableValues = new ArrayList<>();
                        loaiXeDataTabaleValues = new ArrayList<>();

                        if (hangHieuXeMDSDValue.get("Hãng Xe").equals("")) {
                            break;
                        }
                        // taoBanChaoPage.chonGiaTri(driver, hangXe, hangHieuXeMDSDValue.get("Hãng Xe"));
                        // taoBanChaoPage.chonGiaTri(driver, hieuXe, hangHieuXeMDSDValue.get("Hiệu Xe"));
                        if (hangHieuXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            taoBanChaoPage.chonGiaTri(driver, MDSD, hangHieuXeMDSDValue.get("MDSD"));
                            optionLoaiXeUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(driver, loaiXe);
                            optionNhomXeUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(driver, nhomXe);
                            System.out.println("HANG XE " + hangXeValue.get("Hãng Xe"));
                            System.out.println("HIEU XE " + hangHieuXeValue.get("Hiệu Xe"));
                            System.out.println("MDSD " + hangHieuXeMDSDValue.get("MDSD"));

                            for (Map<String, String> nhomLoaiXeMDSDValue : nhomLoaiXeSheet) {
                                //if (nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))) {
                                if (nhomLoaiXeMDSDValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (nhomLoaiXeMDSDValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                        && nhomLoaiXeMDSDValue.get("MDSD").equals(hangHieuXeMDSDValue.get("MDSD"))) {
                                    loaiXeDataTabaleValues.add(nhomLoaiXeMDSDValue.get("Loại Xe"));
                                    nhomXeDataTableValues.add(nhomLoaiXeMDSDValue.get("Nhóm Xe"));
                                }
                            }
                            verify.verifyTrue(loaiXeDataTabaleValues.equals(optionLoaiXeUIValues));
                            verify.verifyTrue(nhomXeDataTableValues.equals(optionNhomXeUIValues));
                            System.out.println("LOAI XE UI: " + optionLoaiXeUIValues);
                            // System.out.println("NHOM XE UI: " + optionNhomXeUIValues);
                            System.out.println("DATA LOAI XE " + loaiXeDataTabaleValues);
                            //  System.out.println("DATA NHOM XE " + nhomXeDataTableValues);
                            if (verify.verifyTrue(loaiXeDataTabaleValues.equals(optionLoaiXeUIValues))) {
                                System.out.println("Verify 5: PASSED");
                            } else {
                                System.out.println("Verify 5: FAILED");

                            }
                        }
                    }
                }
            }
        }*/
    }


    @Then("^\"([^\"]*)\" display correct value <Giá Trị Xe Đề Xuất> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and \"([^\"]*)\" with value <Năm Sản Xuất>$")
    public void checkGiaTriXeDeXuat(String giaTriXeDeXuat, String hangXe, String hieuXe, String namSanXuat, DataTable arg4) {
        externalData = new ExcelReader();
        List<Map<String, String>> hangXeSheet, hieuXeSheet, giaTriXeSheet, namSanXuatSheet;
        List<String> optionNhomXeUIValues, optionLoaiXeUIValues,
                nhomXeDataTableValues, loaiXeDataTabaleValues;

        hangXeSheet = new ArrayList<Map<String, String>>();
        hieuXeSheet = new ArrayList<Map<String, String>>();
        namSanXuatSheet = new ArrayList<Map<String, String>>();
        giaTriXeSheet = new ArrayList<Map<String, String>>();

        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
            namSanXuatSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "NamSanXuat");
            giaTriXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "GiaTriXe_Oto");

        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map<String, String> namSanXuatValue : namSanXuatSheet) {
            if (namSanXuatValue.get("Năm Sản Xuất").equals("2020")) {
                taoBanChaoPage.chonGiaTri(driver, namSanXuat, namSanXuatValue.get("Năm Sản Xuất"));
                for (Map<String, String> hangXeValue : hangXeSheet) {
                    if (hangXeValue.get("Hãng Xe").equals("")) {
                        break;
                    }
                    taoBanChaoPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
                    for (Map<String, String> hieuXeValue : hieuXeSheet) {
                        if (hieuXeValue.get("Hiệu Xe").equals("")) {
                            break;
                        }
                        if (hieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                            taoBanChaoPage.chonGiaTri(driver, hieuXe, hieuXeValue.get("Hiệu Xe"));
                            for (Map<String, String> giaTriXeValue : giaTriXeSheet) {
                                if (giaTriXeValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (giaTriXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && giaTriXeValue.get("Hiệu Xe").equals(hieuXeValue.get("Hiệu Xe"))) {
                                    verify.verifyEquals(taoBanChaoPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, giaTriXeDeXuat),
                                            giaTriXeValue.get(namSanXuatValue.get("Năm Sản Xuất")));
                                    System.out.println("HANG XE " + hangXeValue.get("Hãng Xe"));
                                    System.out.println("HIEU XE " + hieuXeValue.get("Hiệu Xe"));
                                    System.out.println("NAM SAN SUAT " + namSanXuatValue.get("Năm Sản Xuất"));
                                    System.out.println("GIA TRI DATA " + giaTriXeValue.get(namSanXuatValue.get("Năm Sản Xuất")));
                                    System.out.println("GIA TRI UI " + taoBanChaoPage.getGiaTriTextBox(driver,
                                            AbstracPageUI.COMMON_TEXTBOX, giaTriXeDeXuat).replace(",", ""));
                                    if (verify.verifyEquals(taoBanChaoPage.getGiaTriTextBox(driver,
                                            AbstracPageUI.COMMON_TEXTBOX, giaTriXeDeXuat).replace(",", ""),
                                            giaTriXeValue.get(namSanXuatValue.get("Năm Sản Xuất")))) {
                                        System.out.println("Verify 6: PASSED");
                                    } else {
                                        System.out.println("Verify 6: FAILED");
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
