package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageElements.FooterElements;

import driverManagement.Driver;

public class Footer {
	private Driver driver;

	public Footer(Driver driver) {
		this.driver = driver;
	}

	public FooterElements elements() {
		return new FooterElements(driver);
	}
}
