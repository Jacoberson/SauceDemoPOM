package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.AllProductsPageElements;
import com.github.jacoberson.pages.pageElements.HeaderElements;

public class AllProductsPageAssertions extends BaseAssertions {
	private AllProductsPageElements elements;

	public AllProductsPageAssertions(AllProductsPageElements elements,
			HeaderElements headerElements) {
		this.elements = elements;
	}

	public void assertCorrectTitle() {
		Assert.assertEquals(headerElements().title().getText(), "PRODUCTS");
	}
}
