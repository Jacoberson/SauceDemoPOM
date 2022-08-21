package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.LoginPage;
import com.github.jacoberson.utilities.TestUtils;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import enums.Browser;

public class LoginTests {
	private Driver driver;
	private LoginPage login;

	@BeforeMethod
	public void setUp() {
		driver = WebCoreDriver.getInstance();
		driver.start(Browser.CHROME);
		driver.openPage("https://www.saucedemo.com/");
		login = new LoginPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void validateLogin(Hashtable<String, String> data) {
		String username = data.get("username");
		String password = data.get("password");

		login.login(username, password);

		if (login.loginAlertDisplays()) {
			String alert = data.get("alert");
			login.assertions().assertCorrectLoginAlert(alert);

			login.closeAlert();
			login.assertions().assertLoginAlertDoesNotDisplay();
		}
	}

}
