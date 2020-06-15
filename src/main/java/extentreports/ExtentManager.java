package extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import utils.ReportUtils;

public class ExtentManager {

	private ExtentManager() {}

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	//Create an extent report instance
	public static ExtentReports createInstance() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(ReportUtils.getReportFileLocation());
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().enableTimeline(true);
		htmlReporter.config().setDocumentTitle("Test Report");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		htmlReporter.config().setAutoCreateRelativePathMedia(true);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

}
