package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class CheckoutStepTwoElements {
	private Driver driver;

	public CheckoutStepTwoElements(Driver driver) {
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

	public WebElement itemNameLink(String itemName) {
		return driver.findByText(itemName);
	}

	public WebElement paymentInformation() {
		return driver.findByText("Payment Information");
	}

	public WebElement cardInformation() {
		return driver.findByXpath(
				"//*[contains(text(), 'Payment Information')]/following-sibling::div[1]");
	}

	public WebElement shippingInformation() {
		return driver.findByText("Shipping Information");
	}

	public WebElement deliveryInformation() {
		return driver.findByXpath(
				"//*[contains(text(), 'Shipping Information')]/following-sibling::div[1]");
	}

	public WebElement subtotal() {
		return driver.findByClassName("summary_subtotal_label");
	}

	public WebElement taxTotal() {
		return driver.findByClassName("summary_tax_label");
	}

	public WebElement summaryTotal() {
		return driver.findByClassName("summary_total_label");
	}

	public WebElement cancelButton() {
		return driver.findById("cancel");
	}

	public WebElement finishButton() {
		return driver.findById("finish");
	}
}
