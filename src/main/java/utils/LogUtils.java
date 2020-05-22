package utils;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.log4j.Logger;

public class LogUtils {

	private LogUtils() {
	}

	private static final Logger Log = Logger.getLogger(LogUtils.class.getName());

	//Info Level Logs
	public static void info(String message) {
		Log.info(message);
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	//Warn Level Logs
	public static void warn(String message) {
		Log.warn(message);
	}

	//Passed Level Logs
	public static void pass(String message) {
		ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	//Error Level Logs
	public static void fail(String message) {
		ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Error Level Logs
	public static void error(String message) {
		ExtentTestManager.getTest().log(Status.ERROR, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Fatal Level Logs
	public static void fatal(String message) {
		ExtentTestManager.getTest().log(Status.FATAL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	//Debug Level Logs
	public static void debug(String message) {
		ExtentTestManager.getTest().log(Status.DEBUG, MarkupHelper.createLabel(message, ExtentColor.RED));
	}
}
