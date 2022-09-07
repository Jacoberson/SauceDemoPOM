package driverManagement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import elementManagement.strategies.findStrategies.ClassNameFindStrategy;
import elementManagement.strategies.findStrategies.CssSelectorFindStrategy;
import elementManagement.strategies.findStrategies.ElementFindStrategy;
import elementManagement.strategies.findStrategies.IdFindStrategy;
import elementManagement.strategies.findStrategies.TextFindStrategy;
import elementManagement.strategies.findStrategies.XpathFindStrategy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCoreDriver extends Driver {
	private static WebDriver webDriver;
	private static WebCoreDriver instance = new WebCoreDriver();

	private WebCoreDriver() {
	}

	public static WebCoreDriver getInstance() {
		return instance;
	}

	@Override
	public void start(String browser) {
		webDriver = switch (browser) {
			case "Firefox" -> {
				WebDriverManager.firefoxdriver().setup();
				yield new FirefoxDriver();
			}
			case "Edge" -> {
				WebDriverManager.edgedriver().setup();
				yield new EdgeDriver();
			}
			default -> {
				WebDriverManager.chromedriver().setup();
				// yield new ChromeDriver(
				// new ChromeOptions().addArguments("--headless"));
				yield new ChromeDriver();
			}
		};
		webDriver.manage().window().maximize();
	}

	@Override
	public void quit() {
		if (webDriver != null)
			webDriver.quit();
	}

	@Override
	public String getUrl() {
		return webDriver.getCurrentUrl();
	}

	@Override
	public void openPage(String url) {
		webDriver.get(url);
	}

	@Override
	public WebElement find(ElementFindStrategy findStrategy) {
		return webDriver.findElement(findStrategy.convertToBy());
	}

	@Override
	public List<WebElement> findAll(ElementFindStrategy findStrategy) {
		return webDriver.findElements(findStrategy.convertToBy());
	}

	@Override
	public WebElement findById(String id) {
		return find(new IdFindStrategy(id));
	}

	@Override
	public WebElement findByClassName(String className) {
		return find(new ClassNameFindStrategy(className));
	}

	@Override
	public WebElement findByXpath(String xpath) {
		return find(new XpathFindStrategy(xpath));
	}

	@Override
	public WebElement findByCssSelector(String cssSelector) {
		return find(new CssSelectorFindStrategy(cssSelector));
	}

	@Override
	public WebElement findByText(String text) {
		return find(new TextFindStrategy(text));
	}

	@Override
	public List<WebElement> findAllById(String id) {
		return findAll(new IdFindStrategy(id));
	}

	@Override
	public List<WebElement> findAllByClassName(String className) {
		return findAll(new ClassNameFindStrategy(className));
	}

	@Override
	public List<WebElement> findAllByCssSelector(String cssSelector) {
		return findAll(new CssSelectorFindStrategy(cssSelector));

	}

	@Override
	public List<WebElement> findAllByXpath(String xpath) {
		return findAll(new XpathFindStrategy(xpath));
	}

	@Override
	public List<WebElement> findAllByText(String text) {
		return findAll(new TextFindStrategy(text));
	}

	// @Override
	// public void getCookies() {
	// // TODO Auto-generated method stub
	//
	// }

	@Override
	public void addCookie(Cookie cookie) {
		webDriver.manage().addCookie(cookie);
	}

	@Override
	public String getCurrentWindow() {
		return webDriver.getWindowHandle();
	}

	@Override
	public List<String> getAllWindows() {
		ArrayList<String> windows = new ArrayList<>(
				webDriver.getWindowHandles());
		return windows;
	}

	@Override
	public void switchWindow(String window) {
		webDriver.switchTo().window(window);
	}

}
