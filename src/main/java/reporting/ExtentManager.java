package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.Platform;

import java.io.File;

public class ExtentManager {

  private static ExtentReports extent;
  private static final String reportFileName = "Test-Automaton-Report.html";
  private static final String macPath = System.getProperty("user.dir") + "/TestReport";
  private static final String windowsPath = System.getProperty("user.dir") + "\\TestReport";
  private static final String macReportFileLoc = macPath + "/" + reportFileName;
  private static final String winReportFileLoc = windowsPath + "\\" + reportFileName;
  private static Platform platform;

  private ExtentReports getInstance() {
      if (extent == null) {
          createInstance();
      }
    return extent;
  }

  public static ExtentReports createInstance() {
    platform = getCurrentPlatform();
    String fileName = getReportFileLocation(platform);
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
    htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setTheme(Theme.DARK);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName("Automation Report");
    // Default view is dashboard
    htmlReporter.config().setJS(
        "            $(document).ready(function() {\n" +
            "                   $(\"#slide-out li > a[view='dashboard-view']\").click();\n" +
            "            });");
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    return extent;
  }

  //Select the extent report file location based on platform
  private static String getReportFileLocation(Platform platform) {
    String reportFileLocation = null;
    switch (platform) {
      case MAC:
        reportFileLocation = macReportFileLoc;
        createReportPath(macPath);
        System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
        break;
      case WINDOWS:
        reportFileLocation = winReportFileLoc;
        createReportPath(windowsPath);
        System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
        break;
      default:
        System.out.println("ExtentReport path has not been set! There is a problem!\n");
        break;
    }
    return reportFileLocation;
  }

  //Create the report path if it does not exist
  private static void createReportPath(String path) {
    File testDirectory = new File(path);
    if (!testDirectory.exists()) {
      if (testDirectory.mkdir()) {
        System.out.println("Directory: " + path + " is created!");
      } else {
        System.out.println("Failed to create directory: " + path);
      }
    } else {
      System.out.println("Directory already exists: " + path);
    }
  }

  //Get current platform
  private static Platform getCurrentPlatform() {
    if (platform == null) {
      String operSys = System.getProperty("os.name").toLowerCase();
      if (operSys.contains("win")) {
        platform = Platform.WINDOWS;
      } else if (operSys.contains("nix") || operSys.contains("nux")
          || operSys.contains("aix")) {
        platform = Platform.LINUX;
      } else if (operSys.contains("mac")) {
        platform = Platform.MAC;
      }
    }
    return platform;
  }
}
