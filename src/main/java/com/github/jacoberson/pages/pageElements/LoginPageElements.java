package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class LoginPageElements {
	private Driver driver;

	public LoginPageElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement usernameField() {
		return driver.findById("user-name");
	}

	public WebElement passwordField() {
		return driver.findById("password");
	}

	public WebElement loginButton() {
		return driver.findById("login-button");
	}

	public WebElement loginAlert() {
		return driver.findByCssSelector("h3[data-test='error']");
	}

	/**
	 * Used to determine if login alert exists
	 * 
	 * @return list of 1 or empty list if no login alert
	 */
	public List<WebElement> loginAlertList() {
		return driver.findAllByCssSelector("h3[data-test='error']");
	}

	public WebElement closeAlertButton() {
		return driver.findByClassName("error-button");
	}
}
