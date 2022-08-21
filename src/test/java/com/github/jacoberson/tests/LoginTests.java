package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.LoginPage;
import com.github.jacoberson.utilities.TestUtils;

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
