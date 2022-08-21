package com.github.jacoberson.pages.pageElements;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class HamburgerMenuElements {
	private Driver driver;

	public HamburgerMenuElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement allItemsLink() {
		return driver.findById("inventory_sidebar_link");
	}

	public WebElement aboutLink() {
		return driver.findById("about_sidebar_link");
	}

	public WebElement logoutLink() {
		return driver.findById("logout_sidebar_link");
	}

	public WebElement resetAppStateLink() {
		return driver.findById("reset_sidebar_link");
	}
}
