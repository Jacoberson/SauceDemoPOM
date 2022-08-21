package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.jacoberson.pages.pageObjects.HamburgerMenu;

import driverManagement.Driver;

public class HeaderElements {
	private Driver driver;

	public HeaderElements(Driver driver) {
		this.driver = driver;
	}

	public HamburgerMenu hamburgerMenu() {
		return new HamburgerMenu(driver);
	}

	public WebElement cartLink() {
		return driver.findByClassName("shopping_cart_link");
	}

	public WebElement title() {
		return driver.findByClassName("title");
	}

	public List<WebElement> itemCountList() {
		return driver.findAllByClassName("shopping_cart_badge");
	}

	public WebElement itemCount() {
		return driver.findByClassName("shopping_cart_badge");
	}
}
