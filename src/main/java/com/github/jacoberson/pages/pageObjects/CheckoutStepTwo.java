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

	public String convertToTwoDecimals(double amount) {
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_UP);

		return df.format(amount);
	}

	public String calculateSubtotal() {
		int totalItems = elements().cartList().size();
		double[] prices = new double[totalItems];
		double subtotal = 0;

		for (var price : prices) {
			subtotal += price;
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
