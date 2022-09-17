package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CheckoutStepThreeAssertions;
import com.github.jacoberson.pages.pageElements.CheckoutStepThreeElements;

import driverManagement.Driver;

public class CheckoutStepThree extends BaseLoggedInPage {

	public CheckoutStepThree(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("checkoutStepThreeUrl");
	}

	public CheckoutStepThreeElements elements() {
		return new CheckoutStepThreeElements(driver);
	}

	public CheckoutStepThreeAssertions assertions() {
		return new CheckoutStepThreeAssertions(elements());
	}

	public void goToAllProductsPage() {
		logger.click(elements().backHomeButton());
	}
}
