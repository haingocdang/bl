package com.liveguru.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level_01_Register_Repeat_Yourself {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", ".\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Open URL
		driver.get("http://live.demoguru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@BeforeMethod
	public void BeforeMethod() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
	}

	@Test
	public void Register_01_With_Empty_Data() {
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-firstname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-lastname']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-email_address']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-password']")).getText(), "This is a required field.");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-required-entry-confirmation']")).getText(), "This is a required field.");
	}

	@Test
	public void Register_02_With_Invalid_Email() {
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("123@123.456");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-email-email_address']")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void Register_03_With_Password_Less_Than_6Chars() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-password-password']")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void Register_04_With_ConfirmPassword_Not_Matching() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("456321");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='advice-validate-cpassword-confirmation']")).getText(), "Please make sure your passwords match.");
	}

	@Test
	public void Register_05_With_All_Valid_Data() {
		String emailAddress = "hai.dang" + randomNumber() + "@yopmail.com";
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Hai");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Ngoc");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Dang");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(emailAddress);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Thank you for registering with Main Website Store.')]")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(100000);
		return number;

	}

	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
