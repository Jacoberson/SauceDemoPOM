package com.github.jacoberson.pages;

import java.util.List;

import driverManagement.Driver;
import elementManagement.ElementLogger;
import utilities.readers.ConfigFileReader;

public abstract class BasePage {
	protected Driver driver;
	protected ConfigFileReader configFileReader = new ConfigFileReader();
	protected String url;
	protected ElementLogger logger = new ElementLogger();

	public BasePage(Driver driver) {
		this.driver = driver;
	}

	public List<String> getWindowHandles() {
		return driver.getAllWindows();
	}

	public String getUrl() {
		return url;
	}

}
