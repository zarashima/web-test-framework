package utils;

public class ExecutionUtils {

	private ExecutionUtils() {
	}

	public static String getParameter(String name) {
		String value = System.getProperty(name);
		if (value == null)
			throw new RuntimeException(name + " is not a parameter!");
		if (value.isEmpty())
			throw new RuntimeException(name + " is empty!");
		return value;
	}
}
