package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class ClassNameFindStrategy extends ElementFindStrategy {

	public ClassNameFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.className(getValue());
	}

}
