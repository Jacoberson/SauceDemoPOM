package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BasePage;
import com.github.jacoberson.pages.pageAssertions.SingleProductPageAssertions;
import com.github.jacoberson.pages.pageElements.SingleProductPageElements;

import driverManagement.Driver;

public class SingleProductPage extends BasePage {

	public SingleProductPage(Driver driver) {
		super(driver);
	}

	public SingleProductPageElements elements() {
		return new SingleProductPageElements(driver);
	}

	public SingleProductPageAssertions assertions() {
		return new SingleProductPageAssertions(elements());
	}

	public void addItemToCart() {
		logger.click(elements().addToCartButton());
	}

	public void removeItemFromCart() {
		logger.click(elements().removeButton());
	}

	public void goToAllProductsPage() {
		logger.click(elements().backToProductsButton());
	}
}
