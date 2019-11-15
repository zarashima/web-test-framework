package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.inject.Inject;

public class ExtentTest {
    private static ExtentReports extent;

    private ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    public static ExtentReports createInstance() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "reports/extent.html");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setJS(
                "            $(document).ready(function() {\n" +
                        "                   $(\"#slide-out li > a[view='dashboard-view']\").click();\n" +
                        "            });");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
}
