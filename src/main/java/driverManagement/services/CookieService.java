package driverManagement.services;

import java.util.List;

import org.openqa.selenium.Cookie;

public interface CookieService {
	public abstract List<Cookie> getCookies();
	public abstract void addCookie(Cookie cookie);
}
