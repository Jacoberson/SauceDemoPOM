package com.github.jacoberson.tests;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import enums.Browser;

public class AllProductsPageTests {
	private Driver driver;
	private AllProductsPage productsPage;

	@BeforeMethod
	public void setUp() {
		driver = WebCoreDriver.getInstance();
		driver.start(Browser.CHROME);
		productsPage = new AllProductsPage(driver);
		driver.openPage("https://www.saucedemo.com/");
		driver.addCookie(new Cookie("session-username", "standard_user"));
		driver.openPage(productsPage.getUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyCorrectTitle() {
		productsPage.assertions().assertCorrectTitle();
	}
}