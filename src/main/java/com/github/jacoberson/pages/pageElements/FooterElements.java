package com.github.jacoberson.pages.pageElements;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class FooterElements {
	private Driver driver;

	public FooterElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement twitterLink() {
		return driver.findByXpath("//a[contains(text(), 'Twitter')]");
	}

	public WebElement facebookLink() {
		return driver.findByXpath("//a[contains(text(), 'Facebook')]");
	}
}
