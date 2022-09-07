package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class CheckoutStepOneElements {
	private Driver driver;

	public CheckoutStepOneElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement firstNameField() {
		return driver.findById("first-name");
	}

	public WebElement lastNameField() {
		return driver.findById("last-name");
	}

	public WebElement zipCodeField() {
		return driver.findById("postal-code");
	}

	public WebElement cancelButton() {
		return driver.findById("cancel");
	}

	public WebElement continueButton() {
		return driver.findById("continue");
	}

	public WebElement checkoutAlert() {
		return driver.findByCssSelector("h3[data-test='error'");
	}

	/**
	 * Used to determine if checkout alert exists
	 * 
	 * @return list of 1 if alert or empty list if no alert
	 */
	public List<WebElement> checkoutAlertList() {
		return driver.findAllByCssSelector("h3[data-test='error'");
	}

	public WebElement closeAlertButton() {
		return driver.findByClassName("error-button");
	}
}
