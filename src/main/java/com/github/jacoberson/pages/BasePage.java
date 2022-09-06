package com.github.jacoberson.pages;

import java.util.List;

import com.github.jacoberson.pages.pageObjects.Footer;
import com.github.jacoberson.pages.pageObjects.Header;

import driverManagement.Driver;
import utilities.ConfigFileReader;

public abstract class BasePage {
	protected Driver driver;
	protected ConfigFileReader configFileReader = new ConfigFileReader();

	public BasePage(Driver driver) {
		this.driver = driver;
	}

	public Header header() {
		return new Header(driver);
	}

	public Footer footer() {
		return new Footer(driver);
	}

	public List<String> getWindowHandles() {
		return driver.getAllWindows();
	}

}
