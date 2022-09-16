package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CartPageAssertions;
import com.github.jacoberson.pages.pageElements.CartPageElements;

import driverManagement.Driver;
import utilities.testHelpers.Helper;

public class CartPage extends BaseLoggedInPage {

	public CartPage(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("cartPageUrl");
	}

	public CartPageElements elements() {
		return new CartPageElements(driver);
	}

	public CartPageAssertions assertions() {
		return new CartPageAssertions(elements());
	}

	public void removeItemsFromCart(String itemsToRemove) {
		String[] items = itemsToRemove.split(", ");
		for (String item : items) {
			String formattedItemName = Helper.formatItemName(item);
			logger.click(elements().removeButton(formattedItemName));
		}
	}

	public void openItemPage(String itemName) {
		logger.click(elements().itemNameLink(itemName));
	}

	public void goToAllProductsPage() {
		logger.click(elements().continueShoppingButton());
	}

	public void goToCheckout() {
		logger.click(elements().checkoutButton());
	}

}
