package reportportal;

import helper.StringConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.RestUtils;
import utils.RestUtils.HttpMethod;

import java.util.List;
import java.util.Map;

@SuppressWarnings("unchecked")
public class LaunchHandler {

	private static final JSONObject requestParams = new JSONObject();

	private LaunchHandler() { }

	static {
		RestUtils.setHeader("Authorization", "Bearer " + SessionContext.getUUID());
		RestUtils.setBaseURI(StringConstants.RP_API_ENDPOINT);
		RestUtils.setContentType(ContentType.JSON);
	}

	public static synchronized Response startLaunch() {
		RestUtils.setBasePath(String.format("%s/launch", SessionContext.getProject()));
		requestParams.put("name", "rp_launch");
		requestParams.put("startTime", "1574423221000");
		RestUtils.addJsonBody(requestParams);
		return RestUtils.send(HttpMethod.POST, requestParams);
	}

	public static synchronized String getLaunchId() {
		RestUtils.setBasePath(String.format("%s/launch/%s", SessionContext.getProject(), System.getProperty("rp.launch.id")));
		return RestUtils.send(HttpMethod.GET, null).jsonPath().getString("id");
	}

	public static synchronized void updateLaunch(List<Map<String, String>> attributes, String description) {
		requestParams.put("attributes", attributes);
		requestParams.put("description", description);
		RestUtils.addJsonBody(requestParams);
		RestUtils.setBasePath(String.format("%s/launch/%s/update", SessionContext.getProject(), getLaunchId()));
		RestUtils.send(HttpMethod.PUT, requestParams);
		requestParams.clear();
	}
}
