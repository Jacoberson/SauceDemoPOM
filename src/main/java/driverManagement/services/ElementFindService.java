package driverManagement.services;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ElementFindService {
	public abstract WebElement find(By by);
	public abstract List<WebElement> findAll(By by);
}
