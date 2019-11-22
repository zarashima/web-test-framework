package core.log;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import org.apache.log4j.Logger;

public class Log {

    private static final Logger LOGGER = Logger.getLogger(Log.class.getName());

    public static void startLog(String testClassName) {
        LOGGER.info("Starting test: " + testClassName);
    }

    public static void endLog(String testClassName) {
        LOGGER.info("Ending test: " + testClassName);
    }

    public static void log(Type type, String message) {
        switch (type) {
            case INFO:
                LOGGER.info(message);
                ExtentTestManager.getTest().log(Status.INFO, message);
                break;
            case FAIL:
                LOGGER.error(message);
                //ExtentTestManager.getTest().log(Status.FAIL, message);
                break;
            case PASS:
                LOGGER.info(message);
                //ExtentTestManager.getTest().log(Status.PASS, message);
                break;
            case ERROR:
                LOGGER.error(message);
                //ExtentTestManager.getTest().log(Status.ERROR, message);
                break;
            case SKIPPED:
                LOGGER.warn(message);
                //ExtentTestManager.getTest().log(Status.SKIP, message);
                break;
            default:
                throw new IllegalArgumentException("No log type(INFO/FAIL/PASS/ERROR) is provided");
        }

    }
}
