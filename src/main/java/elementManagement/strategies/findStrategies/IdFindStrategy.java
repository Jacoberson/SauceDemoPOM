package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public class IdFindStrategy extends ElementFindStrategy {

	public IdFindStrategy(String value) {
		super(value);
	}

	@Override
	public By convertToBy() {
		return By.id(getValue());
	}

}
