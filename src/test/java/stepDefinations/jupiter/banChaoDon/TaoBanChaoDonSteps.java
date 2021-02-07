package stepDefinations.jupiter.banChaoDon;

import commons.CommonPageObjects;
import commons.GlobalConstants;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.*;
import static stepDefinations.common.stepDefinations.CommonPageSteps.commonPage;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObjects.jupiter.DanhSachBanChaoPageObject;
import pageObjects.mercury.LoginPageObject;
import commons.VerifyHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;
import pageUIs.alpaca.CommonPageUI;
import utils.excelutils.ExcelReader;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class TaoBanChaoDonSteps {

    WebDriver driver;
    VerifyHelper verify;
    CommonPageObjects commonPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;
    ExcelReader externalData;
    List<Map<String, String>> testData;
    List<String> optionUIValues, dataTableValues;
    SoftAssertions sa;
    //Log log;

    public TaoBanChaoDonSteps() {
        driver = Hooks.openAndQuitBrowser();
        verify = VerifyHelper.getData();
        sa = new SoftAssertions();
        //log= LogFactory.getLog(getClass());
        commonPage = PageGeneratorManager.getCommonPage(driver);
    }

   /* @Given("^I launch and login Jupiter page$")
    public void  i_launch_and_login_Jupiter_page() {
        driver.get(GlobalConstants.JUPITER_LOGIN_DEV_ENV_URL);
        driver.manage().window().maximize();
        LoginPageObject loginPage;
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputUserName("test002");
        loginPage.inputUserPassword("12341234");
        loginPage.clickDangNhapButton();
       // driver.get("http://61.14.237.89:3201/");
        danhSachBanChaoPage = PageGeneratorManager.getDanhSachBanChaoPage(driver);
    }*/

  /*  @Given("^I open \"([^\"]*)\" page$")
    public void iOpenPage(String pageName) {
        danhSachBanChaoPage.goToPage(driver, pageName);
    }
*/
/*    @When("^I click Tạo Mới button$")
    public void iClickTaoMoiButton() {
        danhSachBanChaoPage.clickTaoMoiButton(driver);
        commonPage = PageGeneratorManager.getcommonPage(driver);

    }*/

/*    @When("^I select \"([^\"]*)\" drop down list with <Nhóm sản phẩm> value$")
    public void selectNhomSanPham(String tenField, DataTable nhomSanPhamDataTable) {
        for (Map<String, String> sanPham : nhomSanPhamDataTable.asMaps(String.class, String.class)) {
            commonPage.chonGiaTri(driver, tenField, sanPham.get("Nhóm sản phẩm"));
        }
    }

    @When("^I select \"([^\"]*)\" drop down list with <Tên sản phẩm> value$")
    public void selectTenSanPham(String tenField, DataTable tenSanPhamDataTable) {
        for (Map<String, String> sanPham : tenSanPhamDataTable.asMaps(String.class, String.class)) {
            commonPage.chonGiaTri(driver, tenField, sanPham.get("Tên sản phẩm"));
        }
    }*/

  /*  @When("^I select \"([^\"]*)\" drop down list with <Loại Bản Chào> value$")
    public void iSelectDropDownListWithLoạiBảnChàoValue(String tenField, DataTable loaiBanChaoDataTable) {
        for (Map<String, String> sanPham : loaiBanChaoDataTable.asMaps(String.class, String.class)) {
            commonPage.chonGiaTri(driver, tenField, sanPham.get("Loại Bản Chào"));
        }
    }*/

    @Then("^Bản Chào Đơn-Đối tượng tham gia bảo hiểm section appears$")
    public void bảnChàoĐơnĐốiTượngThamGiaBảoHiểmSectionAppears() {

    }

    @And("^\"([^\"]*)\" dropdown displays correct values$")
    public void checkDropDownValue(String tenDropdown, DataTable dataTable) {
        externalData = new ExcelReader();
        testData = new ArrayList<Map<String, String>>();
        optionUIValues = new ArrayList<>();
        dataTableValues = new ArrayList<>();
        optionUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, tenDropdown);

        try {
            testData = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        for (Map<String, String> value : testData) {
            if (value.get("Hãng Xe").equals("")) {
                break;
            }
            dataTableValues.add(value.get("Hãng Xe"));
        }
        System.out.println("Datatable in step 2" + dataTableValues);
        //log.info("Datatable in step 2" + dataTableValues);

        //verify.verifyTrue(dataTableValues.equals(optionUIValues));
        Assert.assertEquals(dataTableValues, optionUIValues);
        //sa.assertThat(dataTableValues).isEqualTo(optionUIValues);
        //Assert.assertTrue("Does not equal",dataTableValues.equals(optionUIValues));

        if (dataTableValues.equals(optionUIValues)) {
            System.out.println("Verify 2: PASSED");
        } else {
            System.out.println("Verify 2: FAILED");
        }
        //sa.assertAll();
    }

    @Then("^\"([^\"]*)\" display correct value <Hiệu Xe> from PB after selecting \"([^\"]*)\" with value <Hãng Xe>$")
    public void checkHieuXeValues(String hieuXe, String hangXeSelectbox, DataTable hangHieuXeDataTable) {
        externalData = new ExcelReader();
        List<Map<String, String>> hangHieuXe, hangXe;
        hangXe = new ArrayList<Map<String, String>>();
        hangHieuXe = new ArrayList<Map<String, String>>();
        try {
            hangXe = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hangHieuXe = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map<String, String> hangXeValue : hangXe) {
            if (hangXeValue.get("Hãng Xe").equals("")) {
                break;
            }
            commonPage.chonGiaTri(driver, hangXeSelectbox, hangXeValue.get("Hãng Xe"));
            optionUIValues = new ArrayList<>();
            dataTableValues = new ArrayList<>();
            optionUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, hieuXe);
            for (Map<String, String> hangHieuXevalue : hangHieuXe) {
                if (hangHieuXevalue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    if (hangHieuXevalue.get("Hãng Xe").equals("")) {
                        break;
                    }
                    dataTableValues.add(hangHieuXevalue.get("Hiệu Xe"));
                }
            }
            System.out.println(hangXeValue.get("Hãng Xe"));
            System.out.println("UI " + optionUIValues);
            System.out.println("Datatable " + dataTableValues);
            if (verify.verifyTrue(dataTableValues.equals(optionUIValues))) {
                System.out.println("Verify 3: PASSED");
            } else {
                System.out.println("Verify 3: FAILED");

            }
           // Collections.sort(optionUIValues);
            //verify.verifyTrue(dataTableValues.equals(optionUIValues));
            //sa.assertThat(dataTableValues).isEqualTo(optionUIValues);
            Assert.assertEquals(dataTableValues, optionUIValues);

        }
        //sa.assertAll();
    }


    @Then("^\"([^\"]*)\" display correct value <Nhóm Xe> from PB and \"([^\"]*)\" display correct value <Mục Đích Sử Dụng> and \"([^\"]*)\" display correct value <Dòng Xe> and \"([^\"]*)\" dipsplay correct value <Số Chỗ Ngồi> and \"([^\"]*)\" display correct value <Trọng Tải> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe>$")
    public void checkNhomXeMDSDDongXeSoChoTrongTai(String nhomXe, String MDSD, String dongXe, String
            soCho, String trongTai, String hangXe, String hieuXe, DataTable data) {
        externalData = new ExcelReader();
        List<Map<String, String>> hangHieuXeOToSheet, MDSDSheet, hangXeSheet;
        hangHieuXeOToSheet = new ArrayList<Map<String, String>>();
        MDSDSheet = new ArrayList<Map<String, String>>();
        hangXeSheet = new ArrayList<Map<String, String>>();
        try {
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hangHieuXeOToSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
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
            commonPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hangHieuXeOToSheet) {
                if (hangHieuXeValue.get("Hiệu Xe").equals("")) {

                    break;
                }
                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    commonPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                   /* System.out.println("HANG XE " + hangXeValue.get("Hãng Xe"));
                    System.out.println("HIEU XE " + hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println("DONG XE UI " + commonPage.getGiaTriTextBox(driver, dongXe));
                    System.out.println("DONG XE DATA " + hangHieuXeValue.get("Dòng Xe"));
                    System.out.println("SO CHO UI " + commonPage.getGiaTriTextBox(driver,  soCho));
                    System.out.println("SO CHO DATA " + hangHieuXeValue.get("Số Chỗ"));
                    System.out.println("TRONG TAI UI " + commonPage.getGiaTriTextBox(driver,  trongTai));
                    System.out.println("TRONG TAI DATA " + hangHieuXeValue.get("Trọng Tải"));*/
                    Assert.assertEquals(commonPage.getGiaTriTextBox(driver, dongXe), hangHieuXeValue.get("Dòng Xe"));

                    Assert.assertEquals(commonPage.getGiaTriTextBox(driver, soCho), hangHieuXeValue.get("Số Chỗ"));

                    Assert.assertEquals(commonPage.getGiaTriTextBox(driver, trongTai), hangHieuXeValue.get("Trọng Tải"));

                    optionUIValues = new ArrayList<>();
                    dataTableValues = new ArrayList<>();
                    optionUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, MDSD);
                    for (Map<String, String> mucDichSuDung : MDSDSheet) {
                        if (mucDichSuDung.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe")) && mucDichSuDung.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            dataTableValues.add(mucDichSuDung.get("MDSD"));
                        }
                    }
                    //Assert.assertEquals(dataTableValues,optionUIValues);
                  /*  System.out.println(hangHieuXeValue.get("Hãng Xe"));
                    System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println("UI " + optionUIValues);
                    System.out.println("Datatable " + dataTableValues);
                    if (verify.verifyTrue(dataTableValues.equals(optionUIValues))) {
                        System.out.println("Verify 4: PASSED");
                    } else {
                        System.out.println("Verify 4: FAILED");

                    }*/
                }
            }
        }
    }

    @Then("^\"([^\"]*)\" display correct value <Loại Xe> and \"([^\"]*)\" display correct value <Nhóm Xe> after seleting <Hãng Xe> from \"([^\"]*)\" and <Hiệu Xe> from \"([^\"]*)\" and <Mục Đích Sử Dụng> from \"([^\"]*)\"$")
    public void checkLoaiXeNhomXe(String loaiXe, String nhomXe, String hangXe, String hieuXe, String
            MDSD, DataTable data) {
        externalData = new ExcelReader();
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
            hangXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "HangXe_OTo");
            hieuXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Hang_HieuXe_OTo");
            MDSDSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
            nhomLoaiXeSheet = externalData.getData(GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "Nhom_Loai_Dong_SoCho_TT");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Map<String, String> hangXeValue : hangXeSheet) {
            commonPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
            System.out.println(hangXeValue.get("Hãng Xe"));
            for (Map<String, String> hangHieuXeValue : hieuXeSheet) {
                if (hangHieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                    commonPage.chonGiaTri(driver, hieuXe, hangHieuXeValue.get("Hiệu Xe"));
                    System.out.println(hangHieuXeValue.get("Hiệu Xe"));
                    for (Map<String, String> hangHieuXeMDSDValue : MDSDSheet) {
                        optionLoaiXeUIValues = new ArrayList<>();
                        loaiXeDataTabaleValues = new ArrayList<>();

                        if (hangHieuXeMDSDValue.get("Hãng Xe").equals("")) {
                            break;
                        }
                        if (hangHieuXeMDSDValue.get("Hãng Xe").equals(hangHieuXeValue.get("Hãng Xe"))
                                && hangHieuXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))) {
                            commonPage.chonGiaTri(driver, MDSD, hangHieuXeMDSDValue.get("MDSD"));
                            commonPage.chonGiaTri(driver, nhomXe, hangHieuXeMDSDValue.get("Nhóm Xe"));
                            optionLoaiXeUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, loaiXe);
                          //  Collections.sort(optionLoaiXeUIValues);
                            //optionLoaiXeUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, loaiXe);
                            // optionNhomXeUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, nhomXe);
                            for (Map<String, String> nhomLoaiXeMDSDValue : nhomLoaiXeSheet) {
                                if (nhomLoaiXeMDSDValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (nhomLoaiXeMDSDValue.get("Hãng Xe").equals(hangHieuXeMDSDValue.get("Hãng Xe"))
                                        && nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeMDSDValue.get("Hiệu Xe"))
                                        && nhomLoaiXeMDSDValue.get("MDSD").equals(hangHieuXeMDSDValue.get("MDSD"))
                                        && nhomLoaiXeMDSDValue.get("Nhóm Xe").equals(hangHieuXeMDSDValue.get("Nhóm Xe"))) {
                                    //  commonPage.chonGiaTri(driver, nhomXe, nhomLoaiXeMDSDValue.get("Nhóm Xe"));
                                    //  optionLoaiXeUIValues = commonPage.getAllGiaTriTrongSelectBox(driver, loaiXe);
                                    /*if (nhomLoaiXeMDSDValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                            && nhomLoaiXeMDSDValue.get("Hiệu Xe").equals(hangHieuXeValue.get("Hiệu Xe"))
                                            && nhomLoaiXeMDSDValue.get("MDSD").equals(hangHieuXeMDSDValue.get("MDSD"))
                                            && nhomLoaiXeMDSDValue.get("Nhóm Xe").equals(hangHieuXeMDSDValue.get("Nhóm Xe"))) {*/
                                    // loaiXeDataTabaleValues.add(nhomLoaiXeMDSDValue.get("Loại Xe"));
                                    loaiXeDataTabaleValues.add(nhomLoaiXeMDSDValue.get("Loại Xe"));
                                }
                            }
                            Assert.assertEquals(loaiXeDataTabaleValues, optionLoaiXeUIValues);

                            // Assert.assertEquals(nhomXeDataTableValues, optionNhomXeUIValues);
                        }
                    }
                }
            }
        }
    }


    @Then("^\"([^\"]*)\" display correct value <Giá Trị Xe Đề Xuất> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and \"([^\"]*)\" with value <Năm Sản Xuất>$")
    public void checkGiaTriXeDeXuat(String giaTriXeDeXuat, String hangXe, String hieuXe, String namSanXuat, DataTable arg4) {
        /*externalData = new ExcelReader();
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
                commonPage.chonGiaTri(driver, namSanXuat, namSanXuatValue.get("Năm Sản Xuất"));
                for (Map<String, String> hangXeValue : hangXeSheet) {
                    if (hangXeValue.get("Hãng Xe").equals("")) {
                        break;
                    }
                    commonPage.chonGiaTri(driver, hangXe, hangXeValue.get("Hãng Xe"));
                    for (Map<String, String> hieuXeValue : hieuXeSheet) {
                        if (hieuXeValue.get("Hiệu Xe").equals("")) {
                            break;
                        }
                        if (hieuXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))) {
                            commonPage.chonGiaTri(driver, hieuXe, hieuXeValue.get("Hiệu Xe"));
                            for (Map<String, String> giaTriXeValue : giaTriXeSheet) {
                                if (giaTriXeValue.get("Hãng Xe").equals("")) {
                                    break;
                                }
                                if (giaTriXeValue.get("Hãng Xe").equals(hangXeValue.get("Hãng Xe"))
                                        && giaTriXeValue.get("Hiệu Xe").equals(hieuXeValue.get("Hiệu Xe"))) {
                                    verify.verifyEquals(commonPage.getGiaTriTextBox(driver, AbstracPageUI.COMMON_TEXTBOX, giaTriXeDeXuat),
                                            giaTriXeValue.get(namSanXuatValue.get("Năm Sản Xuất")));
                                    System.out.println("HANG XE " + hangXeValue.get("Hãng Xe"));
                                    System.out.println("HIEU XE " + hieuXeValue.get("Hiệu Xe"));
                                    System.out.println("NAM SAN SUAT " + namSanXuatValue.get("Năm Sản Xuất"));
                                    System.out.println("GIA TRI DATA " + giaTriXeValue.get(namSanXuatValue.get("Năm Sản Xuất")));
                                    System.out.println("GIA TRI UI " + commonPage.getGiaTriTextBox(driver,
                                            AbstracPageUI.COMMON_TEXTBOX, giaTriXeDeXuat).replace(",", ""));
                                    if (verify.verifyEquals(commonPage.getGiaTriTextBox(driver,
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
        }*/
    }


}
