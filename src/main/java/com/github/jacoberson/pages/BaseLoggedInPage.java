package com.github.jacoberson.pages;

import com.github.jacoberson.pages.pageObjects.Footer;
import com.github.jacoberson.pages.pageObjects.Header;

import driverManagement.Driver;

public class BaseLoggedInPage extends BasePage {

	public BaseLoggedInPage(Driver driver) {
		super(driver);
	}

	public Header header() {
		return new Header(driver);
	}

	public Footer footer() {
		return new Footer(driver);
	}
}
