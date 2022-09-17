package com.github.jacoberson.pages.pageElements;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class CheckoutStepThreeElements {
	private Driver driver;

	public CheckoutStepThreeElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement completeHeader() {
		return driver.findByClassName("complete-header");
	}

	public WebElement completeText() {
		return driver.findByClassName("complete-text");
	}

	public WebElement backHomeButton() {
		return driver.findById("back-to-products");
	}
}
