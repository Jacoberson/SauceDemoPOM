package com.github.jacoberson.pages.pageElements;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class FooterElements {
	private Driver driver;

	public FooterElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement socialMediaLink(String socialMediaSite) {
		return driver.findByXpath(
				String.format("//a[contains(text(), '%s')]", socialMediaSite));
	}
}
