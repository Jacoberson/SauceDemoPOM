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
		elements().firstNameField().sendKeys(firstName);
		elements().lastNameField().sendKeys(lastName);
		elements().zipCodeField().sendKeys(zipCode);
		elements().continueButton().click();
	}

	public void closeAlert() {
		elements().closeAlertButton().click();
	}

	public void goToCart() {
		elements().cancelButton().click();
	}

	public void goToCheckoutStepTwo() {
		elements().continueButton().click();
	}

}
