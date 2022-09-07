package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.CartPageElements;

public class CartPageAssertions extends BaseAssertions {
	private CartPageElements elements;

	public CartPageAssertions(CartPageElements elements) {
		this.elements = elements;
	}

	public void assertCorrectTitle(String title) {
		Assert.assertEquals(headerElements().title().getText(), title);
	}

	public void assertCorrectItemCount(int itemCount) {
		Assert.assertEquals(elements.itemCount().size(), itemCount);
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
}
