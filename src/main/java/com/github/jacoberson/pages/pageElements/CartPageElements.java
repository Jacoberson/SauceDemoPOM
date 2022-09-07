package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class CartPageElements {
	private Driver driver;

	public CartPageElements(Driver driver) {
		this.driver = driver;
	}

	public List<WebElement> itemCount() {
		return driver.findAllByClassName("cart_item");
	}

	public List<WebElement> itemNameList() {
		return driver.findAllByClassName("inventory_item_name");
	}

	public List<WebElement> itemDescriptionList() {
		return driver.findAllByClassName("inventory_item_desc");
	}

	public List<WebElement> itemPriceList() {
		return driver.findAllByClassName("inventory_item_price");
	}

	public List<WebElement> quantityList() {
		return driver.findAllByClassName("cart_quantity");
	}

	public WebElement removeButton(String item) {
		return driver.findById(String.format("remove-%s", item));
	}

	public WebElement itemNameLink(String itemName) {
		return driver.findByText(itemName);
	}

	public WebElement continueShoppingButton() {
		return driver.findById("continue-shopping");
	}

	public WebElement checkoutButton() {
		return driver.findById("checkout");
	}
}
