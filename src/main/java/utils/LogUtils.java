package utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import extentreports.ExtentTestManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class LogUtils {

	private static final Logger Log = LoggerFactory.getLogger(LogUtils.class);
	private LogUtils() {}

	//Info Level Logs
	public static void info(String message) {
		Log.info(message);
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	//Info Level Logs
	public static void info(String message, Object o, Object o1) {
		Log.info(message, o, o1);
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	//Warn Level Logs
	public static void warn(String message) {
		Log.warn(message);
		ExtentTestManager.getTest().log(Status.WARNING, MarkupHelper.createLabel(message, ExtentColor.BLACK));
	}

	//Passed Level Logs
	public static void pass(String message) {
		Log.info(message);
		ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	//Error Level Logs
	public static void fail(String message) {
		Log.error(MarkerFactory.getMarker("FAIL"), message);
		ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Error Level Logs
	public static void error(String message) {
		Log.error(message);
		ExtentTestManager.getTest().log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Fatal Level Logs
	public static void fatal(String message) {
		Log.error(MarkerFactory.getMarker("FATAL"), message);
		ExtentTestManager.getTest().log(Status.FATAL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Debug Level Logs
	public static void debug(String message) {
		Log.debug(message);
		ExtentTestManager.getTest().log(Status.DEBUG, MarkupHelper.createLabel(message, ExtentColor.RED));
	}
}
