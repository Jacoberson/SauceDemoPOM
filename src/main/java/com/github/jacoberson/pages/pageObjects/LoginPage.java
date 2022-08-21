package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageAssertions.LoginPageAssertions;
import com.github.jacoberson.pages.pageElements.LoginPageElements;

import driverManagement.Driver;

public class LoginPage {
	private LoginPageElements elements;
	private LoginPageAssertions assertions;
	private Driver driver;
	private String url = "https://www.saucedemo.com/";

	public LoginPage(Driver driver) {
		this.driver = driver;
	}

	public LoginPageElements elements() {
		elements = new LoginPageElements(driver);
		return elements;
	}

	public LoginPageAssertions assertions() {
		assertions = new LoginPageAssertions(elements());
		return assertions;
	}

	public String getUrl() {
		return url;
	}

	public boolean loginAlertDisplays() {
		return elements().loginAlertList().size() > 0;
	}

	public String getLoginAlertText() {
		return elements().loginAlert().getText();
	}

	public void login(String username, String password) {
		elements().usernameField().sendKeys(username);
		elements().passwordField().sendKeys(password);
		elements().loginButton().click();
	}

	public void closeAlert() {
		elements().closeAlertButton().click();
	}
}
