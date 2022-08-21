package com.github.jacoberson.pages.pageObjects;

import java.util.List;

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
		return new AllProductsPageAssertions(elements(), header().elements());
	}

	public String getTitle() {
		return header().elements().title().getText();
	}

	public String getUrl() {
		return url;
	}

	public void addItemsToCart(List<String> itemsToAdd) {

	}

	public void removeItemsFromCart(List<String> itemsToRemove) {

	}

	public void openItemPage(String item) {

	}

	public void verifyItemsDisplay() {

	}

	public void sortItems(String sortType) {

	}

}
