package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driverManagement.Driver;

public class AllProductsPageElements {
	private Driver driver;

	public AllProductsPageElements(Driver driver) {
		this.driver = driver;
	}

	public List<WebElement> totalItemCount() {
		return driver.findAllByClassName("inventory_item");
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

	public List<WebElement> addToCartButtonList() {
		return driver.findAllByCssSelector("button[id*='add-to-cart']");
	}

	public WebElement specificAddToCartButton(String item) {
		return driver.findById(String.format("add-to-cart-%s", item));
	}

	public List<WebElement> removeButtonList() {
		return driver.findAllByCssSelector("button[id*='remove']");
	}

	public WebElement specificRemoveButton(String item) {
		return driver.findById(String.format("remove-%s", item));
	}

	public WebElement itemNameLink(String item) {
		return driver.findByXpath(
				String.format("//*[contains(text(), '%s')]", item));
	}

	public Select sortDropdown() {
		return new Select(driver.findByClassName("product_sort_container"));
	}
}
