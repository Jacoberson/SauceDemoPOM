package driverManagement;

import driverManagement.services.BrowserService;
import driverManagement.services.ElementFindService;
import driverManagement.services.NavigationService;

public abstract class Driver
		implements
			BrowserService,
			NavigationService,
			ElementFindService {

}
