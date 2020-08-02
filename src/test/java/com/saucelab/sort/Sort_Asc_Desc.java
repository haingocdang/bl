package com.saucelab.sort;

import org.testng.annotations.Test;

import com.bankguru.commons.Common_01_Register;

import browserFactory.BrowserDriverFactory;
import browserFactory.DriverManager;
import commons.AbstractTest;
import pageObject.jquerry.DataTablePageObject;
import pageObject.saucelab.SortPageObject;
import pageObjects.bankguru.EditCustomerPageObject;
import pageObjects.bankguru.HomePageObject;
import pageObjects.bankguru.LoginPageOjbect;
import pageObjects.bankguru.NewCustomerPageObject;
import pageObjects.bankguru.PageGeneratorManager;
import pageObjects.bankguru.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Sort_Asc_Desc extends AbstractTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {

		log.info("Pre-condition - Open Browser");
		driverManager=BrowserDriverFactory.getBrowserDriver(browserName);
		driver= getBrowserDriver(browserName, url); //driverManager.getDriver(url);
		System.out.println("Thread id in TC is "+ Thread.currentThread().getId()+ " "  + "Driver in TC is "+ driver.toString());
		sortPage= new SortPageObject(driver);

	}

	
	@Test
	public void TC_01_Sort_Name() {
		log.info("TC_01_Sort_Name-Step 01: Select sort Name(A to Z)"+ driver.toString());
		sortPage.selectItemInSortDropdown("Name (A to Z)");

		log.info("TC_01_Sort_Name-VP1: Name is sorted ascending"+ driver.toString());
		verifyTrue(sortPage.IsNameSortedAsc());
		
		log.info("TC_01_Sort_Name-Step 03: Select sort Name(Z to A)"+ driver.toString());
		sortPage.selectItemInSortDropdown("Name (Z to A)");
		log.info("TC_01_Sort_Name-VP1: Name is sorted descending"+ driver.toString());
		verifyTrue(sortPage.IsNameSortedDesc());
	
	}
	
	
	//@Test
	public void TC_02_Sort_Price() {
		log.info("TC_02_Sort_Price-Step 01: Select sort Price(low to high)");
		sortPage.selectItemInSortDropdown("Price (low to high)");
		log.info("TC_02_Sort_Price-VP1: Price is sorted ascending");
		verifyTrue(sortPage.IsPriceSortedAsc());
		
		log.info("TC_02_Sort_Price-Step 01: Select sort Price(high to low)");
		sortPage.selectItemInSortDropdown("Price (high to low)");
		log.info("TC_02_Sort_Price-VP1: Price is sorted descending");
		verifyTrue(sortPage.IsPriceSortedDesc());
	
	}

	@AfterClass
	public void afterClass() {
		//closeBrowserAndDriver(driver);
		removeDriver();
	}

	private WebDriver driver;
	SortPageObject sortPage;
	DriverManager driverManager;
	
	

}
