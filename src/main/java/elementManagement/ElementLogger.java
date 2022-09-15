package elementManagement;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.github.jacoberson.utilities.LogSetup.ApplicationLogger;

public class ElementLogger {
	private static Logger logger = ApplicationLogger.getApplicationLogger();

	public void click(WebElement element) {
		element.click();
		logger.info(String.format("Clicking on element %s", element));
	}

	public void typeText(WebElement element, String textToType) {
		element.sendKeys(textToType);
		logger.info(String.format("Typing '%s' in %s", textToType, element));
	}
}
