package com.github.jacoberson.pages.pageAssertions;

import com.github.jacoberson.pages.pageElements.FooterElements;
import com.github.jacoberson.pages.pageElements.HeaderElements;

import driverManagement.WebCoreDriver;

public class BaseAssertions {

	public HeaderElements headerElements() {
		return new HeaderElements(WebCoreDriver.getInstance());
	}

	public FooterElements footerElements() {
		return new FooterElements(WebCoreDriver.getInstance());
	}
}
