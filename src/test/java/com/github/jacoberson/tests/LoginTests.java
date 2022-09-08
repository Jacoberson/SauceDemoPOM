package com.github.jacoberson.tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.LoginPage;
import com.github.jacoberson.utilities.TestUtils;

import utilities.writers.TextFileWriter;

public class LoginTests extends BaseTest {
	private LoginPage loginPage;

	@BeforeMethod
	public void startTest() {
		setUp();
		loginPage = new LoginPage(driver);
		driver.openPage(loginPage.getUrl());
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
		} else {
			String cookie = driver.getCookies().get(0).toString();

			try {
				TextFileWriter.writeFile("cookie file", cookie);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
