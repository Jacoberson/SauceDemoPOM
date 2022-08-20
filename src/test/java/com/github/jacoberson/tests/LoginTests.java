package com.github.jacoberson.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests {
	private WebDriver driver;
	private LoginPage login;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		login = new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void loginAsValidUser() {
		login.login("standard_user", "secret_sauce");

		Assert.assertFalse(login.loginAlertDisplays());
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void loginAsLockedOutUser() {
		login.login("locked_out_user", "secret_sauce");

		Assert.assertTrue(login.loginAlertDisplays());
		Assert.assertEquals(login.getLoginAlertText(),
				"Epic sadface: Sorry, this user has been locked out.");
	}

	@Test
	public void loginWithoutUsername() {
		login.login("", "secret_sauce");

		Assert.assertTrue(login.loginAlertDisplays());
		Assert.assertEquals(login.getLoginAlertText(),
				"Epic sadface: Username is required");
	}

	@Test
	public void loginWithoutPassword() {
		login.login("standard_user", "");

		Assert.assertTrue(login.loginAlertDisplays());
		Assert.assertEquals(login.getLoginAlertText(),
				"Epic sadface: Password is required");
	}

	@Test
	public void loginWithoutUsernameOrPassword() {
		login.login("", "");

		Assert.assertTrue(login.loginAlertDisplays());
		Assert.assertEquals(login.getLoginAlertText(),
				"Epic sadface: Username is required");
	}

	@Test
	public void closeLoginAlert() {
		loginWithoutUsername();

		login.closeAlert();
		Assert.assertFalse(login.loginAlertDisplays());
	}

}
