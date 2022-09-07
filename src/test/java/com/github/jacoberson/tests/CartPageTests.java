package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.pages.pageObjects.CartPage;
import com.github.jacoberson.pages.pageObjects.SingleProductPage;
import com.github.jacoberson.utilities.TestUtils;

public class CartPageTests extends BaseTest {
	private AllProductsPage productsPage;
	private CartPage cartPage;
	private SingleProductPage singleProductPage;

	@BeforeMethod
	public void startTest() {
		setUp();
		loginWithCookie();
		productsPage = new AllProductsPage(driver);
		cartPage = new CartPage(driver);
		singleProductPage = new SingleProductPage(driver);
		driver.openPage(productsPage.getUrl());
	}

	@Test
	public void verifyCartPageTitle() {
		String title = config.properties.getProperty("cartPageTitle");

		productsPage.header().goToCartPage();
		cartPage.assertions().assertCorrectTitle(title);
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyCartItemsDisplayCorrectly(
			Hashtable<String, String> data) {
		String itemsToAdd = data.get("itemsToAdd");
		int itemCount = Integer.valueOf(data.get("itemCount"));

		productsPage.addItemsToCart(itemsToAdd);
		productsPage.header().goToCartPage();

		cartPage.assertions().assertCorrectItemCount(itemCount);
		cartPage.assertions().assertItemsDisplayCorrectly();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyCartItemsCanBeRemoved(Hashtable<String, String> data) {
		String itemsToAdd = data.get("itemsToAdd");
		String itemsToRemove = data.get("itemsToRemove");
		int itemCount = Integer.valueOf(data.get("itemCount"));

		productsPage.addItemsToCart(itemsToAdd);
		productsPage.header().goToCartPage();

		cartPage.removeItemsFromCart(itemsToRemove);

		cartPage.assertions().assertCorrectItemCount(itemCount);
	}

	@Test
	public void verifyCanOpenItemDetailsPage() {
		String item = config.properties.getProperty("item");
		String itemUrl = config.properties.getProperty("itemUrl");

		productsPage.addItemsToCart(item);
		productsPage.header().goToCartPage();

		cartPage.openItemPage(item);

		singleProductPage.assertions().assertCorrectUrl(itemUrl);
	}

	public void verifyCanGoBackToProductsPage() {
		String title = config.properties.getProperty("productsPageTitle");

		productsPage.header().goToCartPage();

		cartPage.goToAllProductsPage();
		productsPage.assertions().assertCorrectTitle(title);
	}

}
