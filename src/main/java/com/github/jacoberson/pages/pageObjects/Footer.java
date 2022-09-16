package com.github.jacoberson.pages.pageObjects;

import com.github.jacoberson.pages.pageElements.FooterElements;

import driverManagement.Driver;
import elementManagement.ElementLogger;

public class Footer {
	private Driver driver;
	private ElementLogger logger;

	public Footer(Driver driver, ElementLogger logger) {
		this.driver = driver;
		this.logger = logger;
	}

	public FooterElements elements() {
		return new FooterElements(driver);
	}

	public void goToSocialMedia(String socialMedia) {
		logger.click(elements().socialMediaLink(socialMedia));
	}
}
