package elementManagement.strategies.findStrategies;

import org.openqa.selenium.By;

public abstract class ElementFindStrategy {
	private final String value;

	public ElementFindStrategy(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public abstract By convertToBy();
}
