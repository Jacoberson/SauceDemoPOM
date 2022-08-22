package com.github.jacoberson.pages.pageAssertions;

import java.util.List;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.AllProductsPageElements;

public class AllProductsPageAssertions extends BaseAssertions {
	private AllProductsPageElements elements;

	public AllProductsPageAssertions(AllProductsPageElements elements) {
		this.elements = elements;
	}

	public void assertCorrectTitle() {
		Assert.assertEquals(headerElements().title().getText(), "PRODUCTS");
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

	public void assertAddAndRemoveButtonCount(String addCount,
			String removeCount) {
		Assert.assertEquals(elements.addToCartButtonList().size(),
				Integer.valueOf(addCount));
		Assert.assertEquals(elements.removeButtonList().size(),
				Integer.valueOf(removeCount));
	}

	public void assertCartCountIsCorrect(String itemCount) {
		if (Integer.valueOf(itemCount) == 0)
			Assert.assertTrue(headerElements().itemCountList().size() == 0);

		else
			Assert.assertEquals(headerElements().itemCount().getText(),
					itemCount);
	}

	public void assertCorrectSortOrder(String firstItem, String lastItem) {
		int totalItemCount = elements.totalItemCount().size();

		String actualFirstItem = elements.itemNameList().get(0).getText();
		String actualLastItem = elements.itemNameList().get(totalItemCount - 1)
				.getText();

		Assert.assertEquals(firstItem, actualFirstItem);
		Assert.assertEquals(lastItem, actualLastItem);
	}

	public void assertTwitterLoads(List<String> windows) {
		if (windows.size() < 2) {
			Assert.fail();
		}

		for (var window : windows) {
			if (!driver.getCurrentWindow().equals(window)) {
				driver.switchWindow(window);
				break;
			}
		}

		Assert.assertEquals(driver.getUrl(), "https://twitter.com/saucelabs");
	}

	public void assertFacebookLoads(List<String> windows) {
		if (windows.size() < 2) {
			Assert.fail();
		}

		for (var window : windows) {
			if (!driver.getCurrentWindow().equals(window)) {
				driver.switchWindow(window);
				break;
			}
		}

		Assert.assertEquals(driver.getUrl(),
				"https://www.facebook.com/saucelabs");
	}
}
