package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.CheckoutStepOneElements;

public class CheckoutStepOneAssertions extends BaseAssertions {
	private CheckoutStepOneElements elements;

	public CheckoutStepOneAssertions(CheckoutStepOneElements elements) {
		this.elements = elements;
	}

	public void assertCorrectTitle(String title) {
		Assert.assertEquals(headerElements().title().getText(), title);
	}

	public void assertCheckoutAlertDoesNotDisplay() {
		Assert.assertTrue(elements.checkoutAlertList().size() == 0);
	}

	public void assertCorrectCheckoutAlert(String alertText) {
		Assert.assertEquals(elements.checkoutAlert().getText(), alertText);
	}
}
