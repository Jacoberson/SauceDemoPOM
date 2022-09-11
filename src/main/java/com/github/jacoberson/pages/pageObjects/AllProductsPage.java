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
			elements().specificAddToCartButton(formattedItemName).click();
		}
	}

	public void removeItemsFromCart(String itemsToRemove) {
		String[] items = itemsToRemove.split(", ");
		for (String item : items) {
			String formattedItemName = Helper.formatItemName(item);
			elements().specificRemoveButton(formattedItemName).click();
		}
	}

	public void openItemPage(String itemName) {
		elements().itemNameLink(itemName).click();
	}

	public void sortItems(String sortType) {
		elements().sortDropdown().selectByVisibleText(sortType);
	}

	public void goToSocialMedia(String socialMediaSite) {
		footer().elements().socialMediaLink(socialMediaSite).click();
	}

}
