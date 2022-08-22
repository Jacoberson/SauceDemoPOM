package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.SingleProductPageElements;

public class SingleProductPageAssertions extends BaseAssertions {
	private SingleProductPageElements elements;

	public SingleProductPageAssertions(SingleProductPageElements elements) {
		this.elements = elements;
	}

	public void assertItemDisplaysCorrectly(String itemName) {
		Assert.assertTrue(elements.itemName().getText().equals(itemName));
		Assert.assertFalse(elements.itemDescription().getText().isBlank());
		Assert.assertFalse(elements.itemPrice().getText().isBlank());
		Assert.assertTrue(elements.itemPrice().getText().contains("$"));
	}

	public void assertAddToCart() {
		Assert.assertTrue(elements.removeButtonList().size() > 0);
		Assert.assertTrue(
				Integer.valueOf(headerElements().itemCount().getText()) == 1);
	}

	public void assertRemoveFromCart() {
		Assert.assertTrue(elements.addToCartButtonList().size() > 0);
		Assert.assertTrue(headerElements().itemCountList().size() == 0);
	}
}
