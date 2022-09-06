package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.pages.pageObjects.SingleProductPage;
import com.github.jacoberson.utilities.TestUtils;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import enums.Browser;

public class SingleProductPageTests {
	private Driver driver;
	private AllProductsPage productsPage;
	private SingleProductPage singleProductPage;

	@BeforeMethod
	public void setUp() {
		driver = WebCoreDriver.getInstance();
		driver.start(Browser.CHROME);
		productsPage = new AllProductsPage(driver);
		singleProductPage = new SingleProductPage(driver);
		driver.openPage("https://www.saucedemo.com/");
		driver.addCookie(new Cookie("session-username", "standard_user"));
		driver.openPage(productsPage.getUrl());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyCanOpenItemDetailsPage(Hashtable<String, String> data) {
		String itemName = data.get("itemName");
		String itemUrl = data.get("itemUrl");

		productsPage.openItemPage(itemName);
		singleProductPage.assertions().assertCorrectUrl(itemUrl);
		singleProductPage.assertions().assertItemDisplaysCorrectly(itemName);
	}

	@Test
	public void verifyCanAddAndRemoveFromCart() {
		productsPage.openItemPage("Sauce Labs Backpack");
		singleProductPage.addItemToCart();
		singleProductPage.assertions().assertAddToCart();
		singleProductPage.removeItemFromCart();
		singleProductPage.assertions().assertRemoveFromCart();
	}

	@Test
	public void verifyCanGoBackToProductsPage() {
		productsPage.openItemPage("Sauce Labs Backpack");
		singleProductPage.goToAllProductsPage();
		productsPage.assertions().assertCorrectTitle();
	}

}
