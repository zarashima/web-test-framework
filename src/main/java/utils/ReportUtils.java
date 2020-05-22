package utils;

import java.io.File;
import java.time.format.DateTimeFormatter;

import static java.time.LocalDateTime.now;

public class ReportUtils {

	private static final DateTimeFormatter simpleDate = DateTimeFormatter.ofPattern("dd_MM_yyyy-HH_mm_ss");
	private static final String reportFileName = String.format("Test-Automaton-Report-%s.html", simpleDate.format(now()));
	private static final String reportPath = System.getProperty("user.dir") + File.separator + "TestReport";
	private static final String reportFileLoc = reportPath + File.separator + reportFileName;

	public static String getReportFileLocation() {
		createReportPath();
		return reportFileLoc;
	}

	private static void createReportPath() {
		File testDirectory = new File(ReportUtils.reportPath);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + ReportUtils.reportPath + " is created!");
			} else {
				System.out.println("Failed to create directory: " + ReportUtils.reportPath);
			}
		} else {
			System.out.println("Directory already exists: " + ReportUtils.reportPath);
		}
	}
}
