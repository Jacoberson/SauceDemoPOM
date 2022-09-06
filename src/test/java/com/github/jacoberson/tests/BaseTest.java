package com.github.jacoberson.tests;

import org.testng.annotations.AfterMethod;

import driverManagement.Driver;
import driverManagement.WebCoreDriver;
import utilities.ConfigFileReader;

public class BaseTest {
	protected Driver driver = WebCoreDriver.getInstance();
	protected ConfigFileReader config = new ConfigFileReader();

	public void setUp() {
		driver.start(config.properties.getProperty("browser"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
