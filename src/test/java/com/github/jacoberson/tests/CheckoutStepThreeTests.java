package com.github.jacoberson.tests;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.pages.pageObjects.CartPage;
import com.github.jacoberson.pages.pageObjects.CheckoutStepOne;
import com.github.jacoberson.pages.pageObjects.CheckoutStepThree;
import com.github.jacoberson.pages.pageObjects.CheckoutStepTwo;

public class CheckoutStepThreeTests extends BaseTest {
	private final String firstName = config.properties.getProperty("firstName");
	private final String lastName = config.properties.getProperty("lastName");
	private final String zipCode = config.properties.getProperty("zipCode");
	private AllProductsPage productsPage;
	private CartPage cartPage;
	private CheckoutStepOne checkoutStepOne;
	private CheckoutStepTwo checkoutStepTwo;
	private CheckoutStepThree checkoutStepThree;

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
		checkoutStepTwo = new CheckoutStepTwo(driver);
		checkoutStepThree = new CheckoutStepThree(driver);
		checkoutStepThreeTestSetup();
	}

	private void checkoutStepThreeTestSetup() {
		driver.openPage(productsPage.getUrl());
		productsPage.header().goToCartPage();
		cartPage.goToCheckout();
		checkoutStepOne.enterCheckoutInformation(firstName, lastName, zipCode);
		checkoutStepTwo.goToCheckoutComplete();
	}

	@Test
	public void verifyCheckoutStepThreeTitle() {
		String title = config.properties.getProperty("checkoutStepThreeTitle");

		checkoutStepThree.assertions().assertCorrectTitle(title);
	}

	@Test
	public void verifyCheckoutComplete() {
		String headerText = config.properties.getProperty("completeHeaderText");
		String completeText = config.properties.getProperty("completeText");

		checkoutStepThree.assertions().assertCorrectHeaderText(headerText);
		checkoutStepThree.assertions().assertCorrectCompleteText(completeText);
	}

	@Test
	public void verifyCanGoBackToProductsPage() {
		String title = config.properties.getProperty("productsPageTitle");

		checkoutStepThree.goToAllProductsPage();
		productsPage.assertions().assertCorrectTitle(title);
	}
}
