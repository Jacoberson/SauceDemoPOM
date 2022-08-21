package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class CssSelectorFindStrategy extends ElementFindStrategy {

	public CssSelectorFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.cssSelector(getValue());
	}

}
