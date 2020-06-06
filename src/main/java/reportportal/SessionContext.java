package reportportal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SessionContext {
	private static final Properties reportPortalProperties;
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionContext.class.getSimpleName());

	static {
		LOGGER.info("SessionContext default constructor");
		reportPortalProperties = loadReportPortalProperties();
	}

	private static Properties loadReportPortalProperties() {
		Properties properties = new Properties();
		try {
			String reportPortalPropertiesFile = "src/test/resources/reportportal.properties";
			File reportPortalFile = new File(reportPortalPropertiesFile);
			String absolutePath = reportPortalFile.getAbsolutePath();
			if (reportPortalFile.exists()) {
				properties.load(new FileInputStream(absolutePath));
				LOGGER.info("Loaded reportportal.properties file - " + absolutePath);
			} else {
				LOGGER.info("reportportal.properties file NOT FOUND - " + absolutePath);
			}
		}
		catch (IOException e) {
			LOGGER.error("ERROR in loading reportportal.properties file\n" + e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return properties;
	}

	public static String getEndPoint() {
		return reportPortalProperties.getProperty("rp.endpoint");
	}

	public static String getUUID() {
		return reportPortalProperties.getProperty("rp.uuid");
	}

	public static String getLaunchName() {
		return reportPortalProperties.getProperty("rp.launch");
	}

	public static String getProject() {
		return reportPortalProperties.getProperty("rp.project");
	}

	public static boolean getRpEnable() {
		return Boolean.parseBoolean(reportPortalProperties.getProperty("rp.enable"));
	}

}
