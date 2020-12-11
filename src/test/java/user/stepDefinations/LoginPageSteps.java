package user.stepDefinations;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import pageObjects.mercury.LoginPageObject;
import commons.VerifyHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOption.Hooks;

public class LoginPageSteps {

	WebDriver driver;
	VerifyHelper verify;
	LoginPageObject loginPage;

	public LoginPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		verify = VerifyHelper.getData();
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}

	@Given("^I open Login page$")
	public void iOpenLoginPage() {

	}

	@When("^I input \"([^\"]*)\" into username textbox$")
	public void iInputIntoUsernameTextbox(String username) {
		loginPage.inputUserName(username);
	}

	@When("^I input \"([^\"]*)\" into password textbox$")
	public void iInputIntoPasswordTextbox(String password) {
		loginPage.inputUserPassword(password);
	}

	@When("^I click Login button$")
	public void iClickLoginButton() {
		loginPage.clickDangNhapButton();
	}

	@Then("^Home Page appears$")
	public void homePageAppears() {
	}
}
