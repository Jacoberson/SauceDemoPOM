package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.LoginPageElements;

public class LoginPageAssertions {
	private LoginPageElements elements;

	public LoginPageAssertions(LoginPageElements elements) {
		this.elements = elements;
	}

	public void assertCorrectUrl(String url) {
		Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html");
	}

	public void assertLoginAlertDoesNotDisplay() {
		Assert.assertTrue(elements.loginAlertList().size() == 0);
	}

	public void assertLoginAlertDisplays() {
		Assert.assertTrue(elements.loginAlertList().size() > 0);
	}

	public void assertCorrectLoginAlert(String alertText) {
		Assert.assertEquals(alertText, elements.loginAlert().getText());
	}
}
