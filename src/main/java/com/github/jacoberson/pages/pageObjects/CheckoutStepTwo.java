package com.github.jacoberson.pages.pageObjects;

import java.math.RoundingMode;
import java.text.DecimalFormat;

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

	public void openItemPage(String item) {
		elements().itemNameLink(item).click();
	}

	/**
	 * Convert amount to two decimal places to prevent rounding issues
	 * 
	 * @param amount
	 *            to convert
	 * @return text format of amount rounded to two decimal places
	 */
	public String convertToTwoDecimals(double amount) {
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
		double taxRate = 0.08;
		double tax = subtotal * taxRate;

		return convertToTwoDecimals(tax);
	}

	public String calculateOrderTotal() {
		double subtotal = Double.parseDouble(calculateSubtotal());
		double tax = Double.parseDouble(calculateTax());
		double orderTotal = subtotal + tax;

		return convertToTwoDecimals(orderTotal);
	}

	public void goToAllProductsPage() {
		elements().cancelButton().click();
	}

	public void goToCheckoutComplete() {
		elements().finishButton().click();
	}

}
