package driverManagement.services;

import java.util.List;

import org.openqa.selenium.WebElement;

import elementManagement.strategies.findStrategies.ElementFindStrategy;

public interface ElementFindService {
	public abstract WebElement findById(String id);
	public abstract WebElement findByClassName(String className);
	public abstract WebElement findByCssSelector(String cssSelector);
	public abstract WebElement findByXpath(String xpath);
	public abstract WebElement findByText(String text);
	public abstract List<WebElement> findAllById(String id);
	public abstract List<WebElement> findAllByClassName(String className);
	public abstract List<WebElement> findAllByCssSelector(String cssSelector);
	public abstract List<WebElement> findAllByXpath(String xpath);
	public abstract List<WebElement> findAllByText(String text);

	public abstract WebElement find(ElementFindStrategy findStrategy);
	public abstract List<WebElement> findAll(ElementFindStrategy findStrategy);
}
