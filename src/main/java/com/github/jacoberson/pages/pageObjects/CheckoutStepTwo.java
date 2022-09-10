package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CheckoutStepTwoAssertions;
import com.github.jacoberson.pages.pageElements.CheckoutStepTwoElements;

import driverManagement.Driver;

public class CheckoutStepTwo extends BaseLoggedInPage {
	private String url = configFileReader.properties
			.getProperty("checkoutStepTwoUrl");

	public CheckoutStepTwo(Driver driver) {
		super(driver);
	}

	public CheckoutStepTwoElements elements() {
		return new CheckoutStepTwoElements(driver);
	}

	public CheckoutStepTwoAssertions assertions() {
		return new CheckoutStepTwoAssertions(elements());
	}

	public String getTitle() {
		return header().elements().title().getText();
	}

	public String getUrl() {
		return url;
	}

}
