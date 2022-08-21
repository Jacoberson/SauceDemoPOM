package driverManagement.services;

import enums.Browser;

public interface BrowserService {
	public abstract void start(Browser browser);
	public abstract void quit();
	public abstract String getUrl();
}
