package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.AllProductsPageAssertions;
import com.github.jacoberson.pages.pageElements.AllProductsPageElements;

import driverManagement.Driver;
import utilities.testHelpers.Helper;

public class AllProductsPage extends BaseLoggedInPage {

	public AllProductsPage(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("productsPageUrl");
	}

	public AllProductsPageElements elements() {
		return new AllProductsPageElements(driver);
	}

	public AllProductsPageAssertions assertions() {
		return new AllProductsPageAssertions(elements());
	}

	public void addItemsToCart(String itemsToAdd) {
		String[] items = itemsToAdd.split(", ");
		for (String item : items) {
			String formattedItemName = Helper.formatItemName(item);
			logger.click(elements().specificAddToCartButton(formattedItemName));
		}
	}

	public void removeItemsFromCart(String itemsToRemove) {
		String[] items = itemsToRemove.split(", ");
		for (String item : items) {
			String formattedItemName = Helper.formatItemName(item);
			logger.click(elements().specificRemoveButton(formattedItemName));
		}
	}

	public void openItemPage(String itemName) {
		logger.click(elements().itemNameLink(itemName));
	}

	public void sortItems(String sortType) {
		logger.select(elements().sortDropdown(), sortType);
	}

	public void goToSocialMedia(String socialMediaSite) {
		logger.click(footer().elements().socialMediaLink(socialMediaSite));
	}

}
