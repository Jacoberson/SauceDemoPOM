package com.github.jacoberson.tests;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jacoberson.pages.pageObjects.AllProductsPage;
import com.github.jacoberson.pages.pageObjects.CartPage;
import com.github.jacoberson.pages.pageObjects.CheckoutStepOne;
import com.github.jacoberson.pages.pageObjects.CheckoutStepTwo;
import com.github.jacoberson.pages.pageObjects.SingleProductPage;
import com.github.jacoberson.utilities.TestUtils;

public class CheckoutStepTwoTests extends BaseTest {
	private final String firstName = config.properties.getProperty("firstName");
	private final String lastName = config.properties.getProperty("lastName");
	private final String zipCode = config.properties.getProperty("zipCode");
	private AllProductsPage productsPage;
	private CartPage cartPage;
	private SingleProductPage singleProductPage;
	private CheckoutStepOne checkoutStepOne;
	private CheckoutStepTwo checkoutStepTwo;

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
		singleProductPage = new SingleProductPage(driver);
		checkoutStepOne = new CheckoutStepOne(driver);
		checkoutStepTwo = new CheckoutStepTwo(driver);
		driver.openPage(productsPage.getUrl());
	}

	private void checkoutStepTwoTestSetup() {
		productsPage.header().goToCartPage();
		cartPage.goToCheckout();
		checkoutStepOne.enterCheckoutInformation(firstName, lastName, zipCode);
	}

	@Test
	public void verifyCheckoutStepTwoTitle() {
		checkoutStepTwoTestSetup();
		String title = config.properties.getProperty("checkoutStepTwoTitle");

		checkoutStepTwo.assertions().assertCorrectTitle(title);
	}

	@Test
	public void verifyCanOpenItemDetailsPage() {
		String item = config.properties.getProperty("item");
		String itemUrl = config.properties.getProperty("itemUrl");

		productsPage.addItemsToCart(item);
		checkoutStepTwoTestSetup();
		checkoutStepTwo.openItemPage(item);

		singleProductPage.assertions().assertCorrectUrl(itemUrl);
	}

	@Test(dataProviderClass = TestUtils.class, dataProvider = "dp")
	public void verifyCheckoutOverview(Hashtable<String, String> data)
			throws InterruptedException {
		String itemsToAdd = data.get("itemsToAdd");
		String cardInfo = config.properties.getProperty("cardInfo");
		String deliveryInfo = config.properties.getProperty("shippingInfo");

		productsPage.addItemsToCart(itemsToAdd);
		checkoutStepTwoTestSetup();

		checkoutStepTwo.assertions().assertItemsDisplayCorrectly();

		String subtotal = checkoutStepTwo.calculateSubtotal();
		String tax = checkoutStepTwo.calculateTax();
		String orderTotal = checkoutStepTwo.calculateOrderTotal();

		checkoutStepTwo.assertions()
				.assertPaymentInformationDisplaysCorrectly(cardInfo);
		checkoutStepTwo.assertions()
				.assertShippingInformationDisplaysCorrectly(deliveryInfo);
		checkoutStepTwo.assertions()
				.assertSubtotalCalculatesCorrectly(subtotal);
		checkoutStepTwo.assertions().assertTaxCalculatesCorrectly(tax);
		checkoutStepTwo.assertions()
				.assertOrderTotalCalculatesCorrectly(orderTotal);
	}

	@Test
	public void verifyCanGoBackToProductsPage() {
		checkoutStepTwoTestSetup();
		String title = config.properties.getProperty("productsPageTitle");

		checkoutStepTwo.goToAllProductsPage();
		productsPage.assertions().assertCorrectTitle(title);
	}
}
