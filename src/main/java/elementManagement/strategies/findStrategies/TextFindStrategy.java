package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class TextFindStrategy extends ElementFindStrategy {

	public TextFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.xpath(
				String.format("//*[contains(text(), '%s')]", getValue()));
	}

}
