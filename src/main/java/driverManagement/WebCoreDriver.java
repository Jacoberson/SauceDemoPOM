package driverManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.output.NullOutputStream;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.service.DriverService;

import elementManagement.strategies.findStrategies.ClassNameFindStrategy;
import elementManagement.strategies.findStrategies.CssSelectorFindStrategy;
import elementManagement.strategies.findStrategies.ElementFindStrategy;
import elementManagement.strategies.findStrategies.IdFindStrategy;
import elementManagement.strategies.findStrategies.TextFindStrategy;
import elementManagement.strategies.findStrategies.XpathFindStrategy;

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
		Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

		webDriver = switch (browser) {
			case "Firefox" -> {
				System.setProperty("webdriver.gecko.driver",
						"src/main/resources/browsers/geckodriver.exe");

				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				disableFirefoxLogs();

				yield new FirefoxDriver(options);
			}
			case "Edge" -> {
				System.setProperty("webdriver.edge.driver",
						"src/main/resources/browsers/msedgedriver.exe");

				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				EdgeDriverService service = disableEdgeLogs();

				yield new EdgeDriver(service, options);
			}
			default -> {
				System.setProperty("webdriver.chrome.driver",
						"src/main/resources/browsers/chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				ChromeDriverService service = disableChromeLogs();

				yield new ChromeDriver(service, options);
			}
		};
		webDriver.manage().window().maximize();
	}

	private void disableFirefoxLogs() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				"/dev/null");
	}

	private EdgeDriverService disableEdgeLogs() {
		EdgeDriverService edgeDriverService = EdgeDriverService
				.createDefaultService();
		edgeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

		return edgeDriverService;
	}

	private ChromeDriverService disableChromeLogs() {
		DriverService.Builder<ChromeDriverService, ChromeDriverService.Builder> serviceBuilder = new ChromeDriverService.Builder();
		ChromeDriverService chromeDriverService = serviceBuilder.build();
		chromeDriverService.sendOutputTo(NullOutputStream.NULL_OUTPUT_STREAM);

		return chromeDriverService;
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

	@Override
	public List<Cookie> getCookies() {
		List<Cookie> cookies = new ArrayList<>(webDriver.manage().getCookies());
		return cookies;
	}

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

	@Override
	public File captureScreenshot() {
		File screenshotFile = ((TakesScreenshot) webDriver)
				.getScreenshotAs(OutputType.FILE);
		return screenshotFile;
	}

}
