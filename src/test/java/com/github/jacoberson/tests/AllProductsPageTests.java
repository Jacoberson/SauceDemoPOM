package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.utilities.TestUtils;

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

	@Test
	public void verifyItemsDisplayCorrectly() {
		productsPage.assertions().assertItemsDisplayCorrectly();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyAddAndRemoveButtons(Hashtable<String, String> data) {
		productsPage.addItemsToCart(data.get("itemsToAdd"));
		productsPage.removeItemsFromCart(data.get("itemsToRemove"));
		productsPage.assertions().assertAddAndRemoveButtonCount(
				data.get("addButtonCount"), data.get("removeButtonCount"));
		productsPage.assertions()
				.assertCartCountIsCorrect(data.get("cartCount"));
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyItemSort(Hashtable<String, String> data) {
		productsPage.sortItems(data.get("sortType"));
		productsPage.assertions().assertCorrectSortOrder(data.get("firstItem"),
				data.get("lastItem"));;
	}

}
