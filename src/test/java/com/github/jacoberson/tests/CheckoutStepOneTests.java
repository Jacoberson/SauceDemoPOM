package com.github.jacoberson.tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.pages.pageObjects.CartPage;
import com.github.jacoberson.pages.pageObjects.CheckoutStepOne;
import com.github.jacoberson.utilities.TestUtils;

public class CheckoutStepOneTests extends BaseTest {
	private AllProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutStepOne checkoutStepOne;

	@BeforeMethod
	public void startTest() {
		setUp();

		try {
			loginWithCookie();
		} catch (IOException e) {
			e.printStackTrace();
		}

		productsPage = new AllProductsPage(driver);
		cartPage = new CartPage(driver);
		checkoutStepOne = new CheckoutStepOne(driver);
		driver.openPage(productsPage.getUrl());
		productsPage.header().goToCartPage();
		cartPage.goToCheckout();
	}

	public void verifyCheckoutStepOneTitle() {
		String title = config.properties.getProperty("checkoutStepOneTitle");

		checkoutStepOne.assertions().assertCorrectTitle(title);
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyCheckoutInformation(Hashtable<String, String> data) {
		String firstName = data.get("firstName");
		String lastName = data.get("lastName");
		String zipCode = data.get("zipCode");

		checkoutStepOne.enterCheckoutInformation(firstName, lastName, zipCode);

		if (checkoutStepOne.checkoutAlertDisplays()) {
			String alert = data.get("alert");
			checkoutStepOne.assertions().assertCorrectCheckoutAlert(alert);

			checkoutStepOne.closeAlert();
			checkoutStepOne.assertions().assertCheckoutAlertDoesNotDisplay();
		}
	}

	public void verifyCanGoBackToCartPage() {
		String title = config.properties.getProperty("cartPageTitle");

		checkoutStepOne.goToCart();
		cartPage.assertions().assertCorrectTitle(title);
	}
}
