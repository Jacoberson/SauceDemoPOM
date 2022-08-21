package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageElements.HamburgerMenuElements;

import driverManagement.Driver;

public class HamburgerMenu {
	private Driver driver;

	public HamburgerMenu(Driver driver) {
		this.driver = driver;
	}

	public HamburgerMenuElements elements() {
		return new HamburgerMenuElements(driver);
	}
}
