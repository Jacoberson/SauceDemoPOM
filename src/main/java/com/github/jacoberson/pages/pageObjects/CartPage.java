package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CartPageAssertions;
import com.github.jacoberson.pages.pageElements.CartPageElements;

import driverManagement.Driver;

public class CartPage extends BaseLoggedInPage {
	private String url = configFileReader.properties.getProperty("cartPageUrl");

	public CartPage(Driver driver) {
		super(driver);
	}

	public CartPageElements elements() {
		return new CartPageElements(driver);
	}

	public CartPageAssertions assertions() {
		return new CartPageAssertions(elements());
	}

	public String getTitle() {
		return header().elements().title().getText();
	}

	public String getUrl() {
		return url;
	}

	public void removeItemsFromCart(String itemsToRemove) {
		String[] items = itemsToRemove.split(", ");
		for (String item : items) {
			String formattedItemName = formatItemName(item);
			elements().removeButton(formattedItemName).click();
		}
	}

	public void openItemPage(String itemName) {
		elements().itemNameLink(itemName).click();
	}

	public String formatItemName(String itemName) {
		return itemName.toLowerCase().replace(" ", "-");
	}

}
