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
}
