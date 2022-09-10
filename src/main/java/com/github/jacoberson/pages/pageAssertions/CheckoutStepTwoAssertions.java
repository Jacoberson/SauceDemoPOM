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

	public void assertPaymentInformationDisplaysCorrectly(String cardInfo) {
		Assert.assertEquals(elements.cardInformation().getText(), cardInfo);
	}

	public void assertShippingInformationDisplaysCorrectly(
			String deliveryInfo) {
		Assert.assertEquals(elements.deliveryInformation().getText(),
				deliveryInfo);
	}

	public void assertSubtotalCalculatesCorrectly(String subtotal) {
		String displayedSubtotal = elements.subtotal().getText()
				.split("\\$")[1];

		Assert.assertEquals(subtotal, displayedSubtotal);
	}

	public void assertTaxCalculatesCorrectly(String tax) {
		String displayedTax = elements.taxTotal().getText().split("\\$")[1];

		Assert.assertEquals(tax, displayedTax);
	}

	public void assertOrderTotalCalculatesCorrectly(String orderTotal) {
		String displayedOrderTotal = elements.summaryTotal().getText()
				.split("\\$")[1];

		Assert.assertEquals(orderTotal, displayedOrderTotal);
	}
}
