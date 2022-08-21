package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class XpathFindStrategy extends ElementFindStrategy {

	public XpathFindStrategy(String value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public By convertToBy() {
		return By.xpath(getValue());
	}

}
