package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.CheckoutStepThreeElements;

public class CheckoutStepThreeAssertions extends BaseAssertions {
	private CheckoutStepThreeElements elements;

	public CheckoutStepThreeAssertions(CheckoutStepThreeElements elements) {
		this.elements = elements;
	}

	public void assertCorrectTitle(String title) {
		Assert.assertEquals(headerElements().title().getText(), title);
	}

	public void assertCorrectHeaderText(String headerText) {
		Assert.assertEquals(elements.completeHeader().getText(), headerText);
	}

	public void assertCorrectCompleteText(String text) {
		Assert.assertEquals(elements.completeText().getText(), text);
	}
}
