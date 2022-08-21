package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BasePage;
import com.github.jacoberson.pages.pageAssertions.AllProductsPageAssertions;
import com.github.jacoberson.pages.pageElements.AllProductsPageElements;

import driverManagement.Driver;

public class AllProductsPage extends BasePage {
	private String url = "https://www.saucedemo.com/inventory.html";

	public AllProductsPage(Driver driver) {
		super(driver);
	}

	public AllProductsPageElements elements() {
		return new AllProductsPageElements(driver);
	}

	public AllProductsPageAssertions assertions() {
		return new AllProductsPageAssertions(elements());
	}

	public String getTitle() {
		return header().elements().title().getText();
	}

	public String getUrl() {
		return url;
	}

	public void addItemsToCart(String itemsToAdd) {
		String[] items = itemsToAdd.split(", ");
		for (String item : items) {
			String formattedItemName = formatItemName(item);
			elements().specificAddToCartButton(formattedItemName).click();
		}
	}

	public void removeItemsFromCart(String itemsToRemove) {
		String[] items = itemsToRemove.split(", ");
		for (String item : items) {
			String formattedItemName = formatItemName(item);
			elements().specificRemoveButton(formattedItemName).click();
		}
	}

	public void openItemPage(String itemName) {
		elements().itemNameLink(itemName).click();;
	}

	public void sortItems(String sortType) {
		elements().sortDropdown().selectByVisibleText(sortType);
	}

	public String formatItemName(String itemName) {
		return itemName.toLowerCase().replace(" ", "-");
	}

}
