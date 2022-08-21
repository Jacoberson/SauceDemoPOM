package com.github.jacoberson.pages.pageElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements {
	private WebDriver driver;

	public LoginPageElements(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement usernameField() {
		return driver.findElement(By.id("user-name"));
	}

	public WebElement passwordField() {
		return driver.findElement(By.id("password"));
	}

	public WebElement loginButton() {
		return driver.findElement(By.id("login-button"));
	}

	public WebElement loginAlert() {
		return driver.findElement(By.cssSelector("h3[data-test='error']"));
	}

	/**
	 * Used to determine if login alert exists
	 * 
	 * @return list of 1 or empty list if no login alert
	 */
	public List<WebElement> loginAlertList() {
		return driver.findElements(By.cssSelector("h3[data-test='error']"));
	}

	public WebElement closeAlertButton() {
		return driver.findElement(By.className("error-button"));
	}
}
