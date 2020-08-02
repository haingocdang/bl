package com.jquerry.datatable;

import org.testng.annotations.Test;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObject.jquerry.DataTablePageObject;
import pageObjects.liveguru.AccountInformationPageObject;
import pageObjects.liveguru.AddresBookPageObject;
import pageObjects.liveguru.BillingAgreementsPageObject;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyApplicationsPageObject;
import pageObjects.liveguru.MyDashboardPageObject;
import pageObjects.liveguru.PageGeneratorManager;
import pageObjects.liveguru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class JQuerry_01_DataTable extends AbstractTest {
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
				
		driver=getBrowserDriver(browserName, url);
		dataTablePage= new DataTablePageObject(driver);
		
	}
	
//	@Test
	public void Testcase_01_Input_To_Dynamic_Column_By_Name() {
		//Action
		dataTablePage.searchByColoum("Argentina", "Country");
		
		dataTablePage.refreshCurrentPage(driver);
		
		//Verify
		Assert.assertTrue(dataTablePage.isOnlyRowIsDisplayed("Argentina"));
		
		dataTablePage.searchByColoum("687522", "Total");
		Assert.assertTrue(dataTablePage.isOnlyRowIsDisplayed("687522"));
		
	}
	
	@Test
	public void Testcase_02_Click_Edit__Delete_Icon_By_Country_Name() {
		dataTablePage.clickToDyNamicIconByName("remove","country","Argentina");
		Assert.assertTrue(dataTablePage.isRowDeleted("Argentina"));
		
		dataTablePage.clickToDyNamicIconByName("remove","country","Afghanistan");
		Assert.assertTrue(dataTablePage.isRowDeleted("Afghanistan"));
		
		dataTablePage.clickToDyNamicIconByName("edit","country","Albania");
		Assert.assertTrue(dataTablePage.isEditPopupDisplay("country","Albania"));
		
		dataTablePage.refreshCurrentPage(driver);
		
		dataTablePage.clickToDyNamicIconByName("edit","total","24853148");
		Assert.assertTrue(dataTablePage.isEditPopupDisplay("total","24853148"));
	}
	


//	@Test
	public void Testcase_03_Paging_By_Page_Index() {
		dataTablePage.navigatePageNumberByIndex("10");
		Assert.assertTrue(dataTablePage.isPageActived("10"));
	
	}
	
//	@Test
	public void Testcase_04_Dynamic_Row() {
		dataTablePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		dataTablePage.inputToDynamicTextboxByRowNum("Company","2","Samsung");
		dataTablePage.inputToDynamicTextboxByRowNum("Order Placed","1","Ho Chi Minh");
		dataTablePage.inputToDynamicTextboxByRowNum("Contact Person","3","Dang Ngoc Hai");
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	DataTablePageObject dataTablePage;
	
}
