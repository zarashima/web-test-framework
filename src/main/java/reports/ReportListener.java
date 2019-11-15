package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportListener implements ITestListener {
    private static ExtentReports extent = reports.ExtentTest.createInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {

    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {

    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public synchronized void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public synchronized void onStart(ITestContext context) {

    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();

    }
}
