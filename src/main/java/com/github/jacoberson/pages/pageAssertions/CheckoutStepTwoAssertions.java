package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.CheckoutStepTwoElements;

public class CheckoutStepTwoAssertions extends BaseAssertions {
	private CheckoutStepTwoElements elements;

	public CheckoutStepTwoAssertions(CheckoutStepTwoElements elements) {
		this.elements = elements;
	}

	public void assertCorrectTitle(String title) {
		Assert.assertEquals(headerElements().title().getText(), title);
	}

	public void assertItemsDisplayCorrectly() {
		for (var name : elements.itemNameList()) {
			Assert.assertFalse(name.getText().isBlank());
		}

		for (var description : elements.itemDescriptionList()) {
			Assert.assertFalse(description.getText().isBlank());
		}

		for (var price : elements.itemPriceList()) {
			Assert.assertFalse(price.getText().isBlank());
			Assert.assertTrue(price.getText().contains("$"));
		}
	}

	public void assertPaymentInformationDisplaysCorrectly() {
		Assert.assertTrue(elements.paymentInformation().getText().isBlank());
		Assert.assertTrue(elements.cardInformation().getText().isBlank());
	}

	public void assertShippingInformationDisplaysCorrectly() {
		Assert.assertTrue(elements.shippingInformation().getText().isBlank());
		Assert.assertTrue(elements.deliveryInformation().getText().isBlank());
	}

	public void assertSubtotalCalculatesCorrectly() {

	}

	public void assertTaxCalculatesCorrectly() {

	}

	public void assertOrderTotalCalculatesCorrectly() {

	}
}
