package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageElements.HeaderElements;

import driverManagement.Driver;
import elementManagement.ElementLogger;

public class Header {
	private Driver driver;
	private ElementLogger logger;

	public Header(Driver driver, ElementLogger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public HeaderElements elements() {
		return new HeaderElements(driver);
	}

	public void goToCartPage() {
		logger.click(elements().cartLink());
	}
}
