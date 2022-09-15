package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BasePage;
import com.github.jacoberson.pages.pageAssertions.LoginPageAssertions;
import com.github.jacoberson.pages.pageElements.LoginPageElements;

import driverManagement.Driver;

public class LoginPage extends BasePage {

	public LoginPage(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("loginPageUrl");
	}

	public LoginPageElements elements() {
		return new LoginPageElements(driver);
	}

	public LoginPageAssertions assertions() {
		return new LoginPageAssertions(elements());
	}

	public boolean loginAlertDisplays() {
		return elements().loginAlertList().size() > 0;
	}

	public void login(String username, String password) {
		logger.typeText(elements().usernameField(), username);
		logger.typeText(elements().passwordField(), password);
		logger.click(elements().loginButton());
	}

	public void closeAlert() {
		logger.click(elements().closeAlertButton());
	}
}
