package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverManagement.Driver;

public class LoginPageElements {
	private Driver driver;

	public LoginPageElements(Driver driver) {
		this.driver = driver;
	}

	public WebElement usernameField() {
		return driver.find(By.id("user-name"));
	}

	public WebElement passwordField() {
		return driver.find(By.id("password"));
	}

	public WebElement loginButton() {
		return driver.find(By.id("login-button"));
	}

	public WebElement loginAlert() {
		return driver.find(By.cssSelector("h3[data-test='error']"));
	}

	/**
	 * Used to determine if login alert exists
	 * 
	 * @return list of 1 or empty list if no login alert
	 */
	public List<WebElement> loginAlertList() {
		return driver.findAll(By.cssSelector("h3[data-test='error']"));
	}

	public WebElement closeAlertButton() {
		return driver.find(By.className("error-button"));
	}
}
