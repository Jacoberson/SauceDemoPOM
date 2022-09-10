package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class CheckoutStepTwoElements {
	private Driver driver;

	public CheckoutStepTwoElements(Driver driver) {
		this.driver = driver;
	}

	public List<WebElement> cartList() {
		return driver.findAllByClassName("cart_list");
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
		return driver.findByText(
				"//*[contains(text(), 'Shipping Information')]/following-sibling::div[1]");
	}

	public WebElement subTotal() {
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
