package com.github.jacoberson.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;

import com.github.jacoberson.pages.pageObjects.LoginPage;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import utilities.readers.ConfigFileReader;
import utilities.readers.CookieFileReader;

public class BaseTest {
	protected Driver driver = WebCoreDriver.getInstance();
	protected ConfigFileReader config = new ConfigFileReader();

	public void setUp() {
		driver.start(config.properties.getProperty("browser"));
	}

	public void loginWithCookie() throws IOException {
		String pathToCookieFile = System.getProperty("user.dir")
				+ "\\src\\test\\java\\com\\github\\jacoberson\\utilities\\textFiles\\cookie.txt";

		LoginPage loginPage = new LoginPage(driver);
		driver.openPage(loginPage.getUrl());
		CookieFileReader.readFile(pathToCookieFile);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
