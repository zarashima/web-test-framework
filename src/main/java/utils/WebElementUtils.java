package utils;

import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementUtils {
	private WebElementUtils() {
	}

	public static String getElementXpathInfo(WebElement element) {
		String[] elementInfo;
		if (element.toString().contains("xpath: "))
			elementInfo = element.toString().split("xpath: ");
		else
			elementInfo = element.toString().split("css selector: ");
		return elementInfo[elementInfo.length - 1];
	}

	public static String getElementsXpathInfo(List<WebElement> elements) {
		String[] elementInfo;
		if (elements.toString().contains("xpath: "))
			elementInfo = elements.toString().split("xpath: ");
		else
			elementInfo = elements.toString().split("css selector: ");
		return elementInfo[elementInfo.length - 1];
	}
}
