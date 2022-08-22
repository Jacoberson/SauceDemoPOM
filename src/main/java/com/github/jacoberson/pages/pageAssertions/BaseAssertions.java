package com.github.jacoberson.pages.pageAssertions;

import org.testng.Assert;

import com.github.jacoberson.pages.pageElements.FooterElements;
import com.github.jacoberson.pages.pageElements.HeaderElements;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;

public class BaseAssertions {
	protected Driver driver = WebCoreDriver.getInstance();

	public HeaderElements headerElements() {
		return new HeaderElements(WebCoreDriver.getInstance());
	}

	public FooterElements footerElements() {
		return new FooterElements(WebCoreDriver.getInstance());
	}

	public void assertCorrectUrl(String url) {
		String currentUrl = driver.getUrl();
		Assert.assertEquals(currentUrl, url);
	}
}
