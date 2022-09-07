package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class XpathFindStrategy extends ElementFindStrategy {

	public XpathFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.xpath(getValue());
	}

}
