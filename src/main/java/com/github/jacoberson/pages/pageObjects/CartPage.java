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
			elements().removeButton(formattedItemName).click();
		}
	}

	public void openItemPage(String itemName) {
		elements().itemNameLink(itemName).click();
	}

	public void goToAllProductsPage() {
		elements().continueShoppingButton().click();
	}

	public void goToCheckout() {
		elements().checkoutButton().click();
	}

}
