package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CheckoutStepOneAssertions;
import com.github.jacoberson.pages.pageElements.CheckoutStepOneElements;

import driverManagement.Driver;

public class CheckoutStepOne extends BaseLoggedInPage {

	public CheckoutStepOne(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("checkoutStepOneUrl");
	}

	public CheckoutStepOneElements elements() {
		return new CheckoutStepOneElements(driver);
	}

	public CheckoutStepOneAssertions assertions() {
		return new CheckoutStepOneAssertions(elements());
	}

	public boolean checkoutAlertDisplays() {
		return elements().checkoutAlertList().size() > 0;
	}

	public void enterCheckoutInformation(String firstName, String lastName,
			String zipCode) {
		logger.typeText(elements().firstNameField(), firstName);
		logger.typeText(elements().lastNameField(), lastName);
		logger.typeText(elements().zipCodeField(), zipCode);
		logger.click(elements().continueButton());
	}

	public void closeAlert() {
		logger.click(elements().closeAlertButton());
	}

	public void goToCart() {
		logger.click(elements().cancelButton());
	}

	public void goToCheckoutStepTwo() {
		logger.click(elements().continueButton());
	}

}
