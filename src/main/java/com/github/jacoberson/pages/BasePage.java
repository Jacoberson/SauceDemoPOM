package com.github.jacoberson.pages;

import com.github.jacoberson.pages.pageObjects.Footer;
import com.github.jacoberson.pages.pageObjects.Header;

import driverManagement.Driver;

public abstract class BasePage {
	private Driver driver;

	public BasePage(Driver driver) {
		this.driver = driver;
	}

	public Header header() {
		return new Header(driver);
	}

	public Footer footer() {
		return new Footer(driver);
	}

}
