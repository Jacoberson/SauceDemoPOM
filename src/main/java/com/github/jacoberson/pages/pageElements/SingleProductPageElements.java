package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class SingleProductPageElements {
	private Driver driver;

	public SingleProductPageElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement itemName() {
		return driver.findByClassName("inventory_details_name");
	}

	public WebElement itemDescription() {
		return driver.findByClassName("inventory_details_desc");
	}

	public WebElement itemPrice() {
		return driver.findByClassName("inventory_details_price");
	}

	public WebElement addToCartButton() {
		return driver.findByCssSelector("button[id*='add-to-cart']");
	}

	public List<WebElement> addToCartButtonList() {
		return driver.findAllByCssSelector("button[id*='add-to-cart']");
	}

	public WebElement removeButton() {
		return driver.findByCssSelector("button[id*='remove']");
	}

	public List<WebElement> removeButtonList() {
		return driver.findAllByCssSelector("button[id*='remove']");
	}

	public WebElement backToProductsButton() {
		return driver.findById("back-to-products");
	}
}
