package driverManagement;

import driverManagement.services.BrowserService;
import driverManagement.services.CookieService;
import driverManagement.services.DriverService;
import driverManagement.services.ElementFindService;
import driverManagement.services.NavigationService;

public abstract class Driver
		implements
			BrowserService,
			NavigationService,
			ElementFindService,
			CookieService,
			DriverService {
}
