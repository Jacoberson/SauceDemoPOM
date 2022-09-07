package com.github.jacoberson.tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;

import com.github.jacoberson.pages.pageObjects.LoginPage;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import utilities.ConfigFileReader;

public class BaseTest {
	protected Driver driver = WebCoreDriver.getInstance();
	protected ConfigFileReader config = new ConfigFileReader();

	public void setUp() {
		driver.start(config.properties.getProperty("browser"));
	}

	public void loginWithCookie() {
		LoginPage loginPage = new LoginPage(driver);
		driver.openPage(loginPage.getUrl());
		driver.addCookie(new Cookie("session-username", "standard_user"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
