package driverManagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCoreDriver extends Driver {
	private WebDriver webDriver;

	@Override
	public void start(Browser browser) {
		webDriver = switch (browser) {
			case FIREFOX -> {
				WebDriverManager.firefoxdriver().setup();
				yield new FirefoxDriver();
			}
			case EDGE -> {
				WebDriverManager.edgedriver().setup();
				yield new EdgeDriver();
			}
			default -> {
				WebDriverManager.chromedriver().setup();
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
	public WebElement find(By by) {
		return webDriver.findElement(by);
	}

	@Override
	public List<WebElement> findAll(By by) {
		return webDriver.findElements(by);
	}

}
