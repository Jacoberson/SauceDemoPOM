package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.LoginPage;
import com.github.jacoberson.utilities.TestUtils;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import enums.Browser;

public class LoginTests {
	private Driver driver;
	private LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		driver = WebCoreDriver.getInstance();
		driver.start(Browser.CHROME);
		loginPage = new LoginPage(driver);
		driver.openPage(loginPage.getUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyLogin(Hashtable<String, String> data) {
		String username = data.get("username");
		String password = data.get("password");

		loginPage.login(username, password);

		if (loginPage.loginAlertDisplays()) {
			String alert = data.get("alert");
			loginPage.assertions().assertCorrectLoginAlert(alert);

			loginPage.closeAlert();
			loginPage.assertions().assertLoginAlertDoesNotDisplay();
		}
	}

}
