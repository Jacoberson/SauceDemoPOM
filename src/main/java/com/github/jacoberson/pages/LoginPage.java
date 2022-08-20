package com.github.jacoberson.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement usernameField() {
		return driver.findElement(By.id("user-name"));
	}

	private WebElement passwordField() {
		return driver.findElement(By.id("password"));
	}

	private WebElement loginButton() {
		return driver.findElement(By.id("login-button"));
	}

	private WebElement closeAlertButton() {
		return driver.findElement(By.className("error-button"));
	}

	public boolean loginAlertDisplays() {
		var loginAlert = driver
				.findElements(By.cssSelector("h3[data-test='error']"));

		return loginAlert.size() > 0;
	}

	public String getLoginAlertText() {
		return driver.findElement(By.cssSelector("h3[data-test='error']"))
				.getText();
	}

	public void login(String username, String password) {
		usernameField().sendKeys(username);
		passwordField().sendKeys(password);
		loginButton().click();
	}

	public void closeAlert() {
		closeAlertButton().click();
	}
}
