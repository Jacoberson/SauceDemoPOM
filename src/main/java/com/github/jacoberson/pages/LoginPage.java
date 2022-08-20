package com.github.jacoberson.pages;

import org.openqa.selenium.WebDriver;

import com.github.jacoberson.pages.pageAssertions.LoginPageAssertions;
import com.github.jacoberson.pages.pageElements.LoginPageElements;

public class LoginPage {
	private LoginPageElements elements;
	private LoginPageAssertions assertions;
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
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
