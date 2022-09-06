package driverManagement.services;

import java.util.List;

public interface BrowserService {
	public abstract void start(String browser);
	public abstract void quit();
	public abstract String getUrl();
	public abstract String getCurrentWindow();
	public abstract List<String> getAllWindows();
	public abstract void switchWindow(String window);
}
