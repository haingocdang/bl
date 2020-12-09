package banChaoDon.stepDefinations;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObjects.alpaca.LoginPageObject;
import pageObjects.alpaca.TaoNguoiDungPageObject;
import pageUIs.alpaca.AbstracPageUI;
import commons.VerifyHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class TaoBanChaoDonSteps {

	WebDriver driver;
	VerifyHelper verify;
	TaoNguoiDungPageObject taoNguoiDungPage;

	public TaoBanChaoDonSteps() {
		driver = Hooks.openAndQuitBrowser();
		verify = VerifyHelper.getData();
		taoNguoiDungPage = PageGeneratorManager.getTaoNguoiDungPage(driver);
	}

	@When("^I click to Tao Moi button$")
	public void iClickToTaoMoiButton() {
		taoNguoiDungPage.clickToElement(driver, AbstracPageUI.TAO_MOI_BUTTON);

	}

	@When("^I input Ten Dang Nhap with value \"([^\"]*)\"$")
	public void iInputTenDangNhapWithValue(String tenDangNhap) {
		taoNguoiDungPage.nhapTenDangNhap(tenDangNhap);
	}

	@When("^I input Ho Va Ten with value \"([^\"]*)\"$")
	public void iInputHoVaTenWithValue(String hoVaTen) {
		taoNguoiDungPage.nhapHoVaTen(hoVaTen);

	}

	@When("^I input Email with value \"([^\"]*)\"$")
	public void iInputEmailWithValue(String email) {
		taoNguoiDungPage.nhapEmail(email);

	}

	@When("^I select \"([^\"]*)\" with value \"([^\"]*)\"$")
	public void iSelectWithValue(String tenSelectBox, String giaTriChon) {
		taoNguoiDungPage.chonDonVi(tenSelectBox, giaTriChon);

	}
}
