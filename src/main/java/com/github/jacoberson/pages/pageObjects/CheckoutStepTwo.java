package com.github.jacoberson.pages.pageObjects;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.github.jacoberson.pages.BaseLoggedInPage;
import com.github.jacoberson.pages.pageAssertions.CheckoutStepTwoAssertions;
import com.github.jacoberson.pages.pageElements.CheckoutStepTwoElements;

import driverManagement.Driver;

public class CheckoutStepTwo extends BaseLoggedInPage {
	private final double TAX_RATE = 0.08;

	public CheckoutStepTwo(Driver driver) {
		super(driver);
		url = configFileReader.properties.getProperty("checkoutStepTwoUrl");
	}

	public CheckoutStepTwoElements elements() {
		return new CheckoutStepTwoElements(driver);
	}

	public CheckoutStepTwoAssertions assertions() {
		return new CheckoutStepTwoAssertions(elements());
	}

	/**
	 * Convert amount to two decimal places to prevent rounding issues
	 * 
	 * @param amount
	 *            to convert
	 * @return text format of amount rounded to two decimal places
	 */
	private String convertToTwoDecimals(double amount) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);

		return df.format(amount);
	}

	public String calculateSubtotal() {
		double subtotal = 0;

		for (var price : elements().itemPriceList()) {
			subtotal += Double.parseDouble(price.getText().split("\\$")[1]);
		}

		return convertToTwoDecimals(subtotal);
	}

	public String calculateTax() {
		double subtotal = Double.parseDouble(calculateSubtotal());
		double tax = subtotal * TAX_RATE;

		return convertToTwoDecimals(tax);
	}

	public String calculateOrderTotal() {
		double subtotal = Double.parseDouble(calculateSubtotal());
		double tax = Double.parseDouble(calculateTax());
		double orderTotal = subtotal + tax;

		return convertToTwoDecimals(orderTotal);
	}

	public void openItemPage(String item) {
		logger.click(elements().itemNameLink(item));
	}

	public void goToAllProductsPage() {
		logger.click(elements().cancelButton());
	}

	public void goToCheckoutComplete() {
		logger.click(elements().finishButton());
	}

}
