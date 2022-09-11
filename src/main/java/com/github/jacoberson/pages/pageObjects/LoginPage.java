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
		elements().usernameField().sendKeys(username);
		elements().passwordField().sendKeys(password);
		elements().loginButton().click();
	}

	public void closeAlert() {
		elements().closeAlertButton().click();
	}
}
