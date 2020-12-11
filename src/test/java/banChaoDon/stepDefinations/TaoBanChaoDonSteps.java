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
import utils.excelutils.ExcelReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaoBanChaoDonSteps {

    WebDriver driver;
    VerifyHelper verify;
    TaoBanChaoPageObject taoBanChaoPage;
    DanhSachBanChaoPageObject danhSachBanChaoPage;

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
            taoBanChaoPage.chonGiaTri(tenField, sanPham.get("Nhóm sản phẩm"));
        }
    }

    @When("^I select \"([^\"]*)\" drop down list with <Tên sản phẩm> value$")
    public void selectTenSanPham(String tenField, DataTable tenSanPhamDataTable) {
        for (Map<String, String> sanPham : tenSanPhamDataTable.asMaps(String.class, String.class)) {
            taoBanChaoPage.chonGiaTri(tenField, sanPham.get("Tên sản phẩm"));
        }
    }

    @When("^I select \"([^\"]*)\" drop down list with <Loại Bản Chào> value$")
    public void iSelectDropDownListWithLoạiBảnChàoValue(String tenField, DataTable loaiBanChaoDataTable) {
        for (Map<String, String> sanPham : loaiBanChaoDataTable.asMaps(String.class, String.class)) {
            taoBanChaoPage.chonGiaTri(tenField, sanPham.get("Loại Bản Chào"));
        }
    }

    @Then("^Bản Chào Đơn-Đối tượng tham gia bảo hiểm section appears$")
    public void bảnChàoĐơnĐốiTượngThamGiaBảoHiểmSectionAppears() {

    }

    @Then("^\"([^\"]*)\" display correct value <Hãng Xe> from PB$")
    public void checkHangXeValues(String tenfield, DataTable hangXeDataTable) {
        ExcelReader externalData = new ExcelReader();
        List<Map<String, String>> testData = new ArrayList<Map<String, String>>();
        List<String> optionUIValues, dataTableValues= new ArrayList<>();
        optionUIValues = taoBanChaoPage.getAllGiaTriTrongSelectBox(tenfield);
        try {
            testData = externalData.getData(System.getProperty("user.dir") + GlobalConstants.TEST_DATA_EXCEL_FILE_NAME, "MDSD_OTo");
        } catch (InvalidFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Map<String, String> value : testData) {
            if (value.get("Hãng Xe").equals("")) {
                break;
            }
            //dataTableValues.add(value.get("Tên Hãng Xe"));
            System.out.println(value.get("Hãng Xe"));

        }
     /* verify.verifyTrue(dataTableValues.equals(optionUIValues));
        if (dataTableValues.equals(optionUIValues)) {
            System.out.println("PASSED");
        }
        else {
            System.out.println("FAILED");
        }*/
    }

    @Then("^\"([^\"]*)\" display correct value <Nhóm Xe> from PB and \"([^\"]*)\" display correct value <Mục Đích Sử Dụng> and \"([^\"]*)\" display correct value <Dòng Xe> and \"([^\"]*)\" dipsplay correct value <Số Chỗ Ngồi> and \"([^\"]*)\" display correct value <Trọng Tải> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe>$")
    public void checkNhomXeMDSDDongXeSoChoTrongTai(String tenField1, String tenField2, String tenField3, String
            tenField4, String tenField5, String tenField6, String tenField7, DataTable arg8) {

    }

    @Then("^\"([^\"]*)\" display correct value <Hiệu Xe> from PB and \"([^\"]*)\" display correct value <Dòng Xe> from PB after selecting \"([^\"]*)\" with value <Hãng Xe>$")
    public void hiệuXeDisplayCorrectValueHiệuXeFromPBAndDòngXeDisplayCorrectValueDòngXeFromPBAfterSelectingWithValueHãngXe
            (String tenField1, String tenField2, String tenField3, DataTable arg2) {

    }


    @Then("^\"([^\"]*)\" correct value <Loại Xe> after seleting <Hãng Xe> from \"([^\"]*)\" and <Hiệu Xe> from \"([^\"]*)\" and <Nhóm Xe> from \"([^\"]*)\" and <Mục Đích Sử Dụng> from \"([^\"]*)\"$")
    public void loạiXeCorrectValueLoạiXeAfterSeletingHãngXeFromAndHiệuXeFromAndNhómXeFromAndMụcĐíchSửDụngFrom
            (String tenField1, String tenField2, String tenField3, String tenField4, String tenField5, DataTable arg5) {

    }

    @Then("^Giá Trị Xe display correct value <Giá Trị Xe Đề Xuất> after selecting \"([^\"]*)\" with value <Hãng Xe> and \"([^\"]*)\" with value <Hiệu Xe> and \"([^\"]*)\" with value <Năm Sản Xuất>$")
    public void giáTrịXeDisplayCorrectValueGiáTrịXeĐềXuấtAfterSelectingWithValueHãngXeAndWithValueHiệuXeAndWithValueNămSảnXuất
            (String tenField1, String tenField2, String tenField3, DataTable arg4) {

    }


}
