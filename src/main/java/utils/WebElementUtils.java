package utils;

public class WebElementUtils {
	private WebElementUtils() {
	}

	public static synchronized String getElementXpathInfo(Object element) {
		String[] elementInfo;
		if (element.toString().contains("xpath: "))
			elementInfo = element.toString().split("xpath: ");
		else
			elementInfo = element.toString().split("css selector: ");
		return elementInfo[elementInfo.length - 1];
	}

}
