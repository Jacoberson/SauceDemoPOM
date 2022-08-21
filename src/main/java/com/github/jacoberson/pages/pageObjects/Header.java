package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageElements.HeaderElements;

import driverManagement.Driver;

public class Header {
	private Driver driver;

	public Header(Driver driver) {
		this.driver = driver;
	}

	public HeaderElements elements() {
		return new HeaderElements(driver);
	}
}
