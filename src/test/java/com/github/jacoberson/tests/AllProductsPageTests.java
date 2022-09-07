package com.github.jacoberson.tests;

import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.utilities.TestUtils;

public class AllProductsPageTests extends BaseTest {
	private AllProductsPage productsPage;

	@BeforeMethod
	public void startTest() {
		setUp();
		loginWithCookie();
		productsPage = new AllProductsPage(driver);
		driver.openPage(productsPage.getUrl());
	}

	@Test
	public void verifyProductsPageTitle() {
		String title = config.properties.getProperty("productsPageTitle");

		productsPage.assertions().assertCorrectTitle(title);
	}

	@Test
	public void verifyItemsDisplayCorrectly() {
		productsPage.assertions().assertItemsDisplayCorrectly();
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyAddAndRemoveButtons(Hashtable<String, String> data) {
		String itemsToAdd = data.get("itemsToAdd");
		String itemsToRemove = data.get("itemsToRemove");
		int addButtonCount = Integer.valueOf(data.get("addButtonCount"));
		int removeButtonCount = Integer.valueOf(data.get("removeButtonCount"));
		int cartCount = Integer.valueOf(data.get("cartCount"));

		productsPage.addItemsToCart(itemsToAdd);
		productsPage.removeItemsFromCart(itemsToRemove);
		productsPage.assertions().assertAddAndRemoveButtonCount(addButtonCount,
				removeButtonCount);
		productsPage.assertions().assertCartCountIsCorrect(cartCount);
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyItemSort(Hashtable<String, String> data) {
		String sortType = data.get("sortType");
		String firstItem = data.get("firstItem");
		String lastItem = data.get("lastItem");

		productsPage.sortItems(sortType);
		productsPage.assertions().assertCorrectSortOrder(firstItem, lastItem);
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifySocialMediaLinks(Hashtable<String, String> data) {
		String socialMediaUrl = data.get("socialMediaUrl");
		String socialMediaSite = data.get("socialMediaSite");

		productsPage.goToSocialMedia(socialMediaSite);
		productsPage.assertions().assertSocialMediaLoads(driver.getAllWindows(),
				socialMediaUrl);
	}

}
