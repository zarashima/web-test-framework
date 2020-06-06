package reportportal;

import helper.StringConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@SuppressWarnings("unchecked")
public class LaunchHandler {
	private static RequestSpecification request;
	private static Response response;
	private static JSONObject requestParams;
	private LaunchHandler() {}

	static {
		request = given().headers(
				"Authorization", "Bearer " + SessionContext.getUUID(),
				"Content-Type", ContentType.JSON);
		requestParams = new JSONObject();
	}

	public static String getLaunchId() {
		response = request.get(String.format("%s/%s/launch/%s",
				StringConstants.RP_API_ENDPOINT, SessionContext.getProject(),
				System.getProperty("rp.launch.id")));
		return response.jsonPath().getString("id");
	}

	public static void updateLaunch(String description) {
		requestParams.put("description", description);
		response = request.body(requestParams.toJSONString()).put(String.format("%s/%s/launch/%s/update",
				StringConstants.RP_API_ENDPOINT, SessionContext.getProject(), getLaunchId()));
		requestParams.clear();
	}

	public static void updateLaunch(List<Map<String,String>> attributes, String description) {
		requestParams.put("attributes", attributes);
		requestParams.put("description", description);
		response = request.body(requestParams.toJSONString()).put(String.format("%s/%s/launch/%s/update",
				StringConstants.RP_API_ENDPOINT, SessionContext.getProject(), getLaunchId()));
		requestParams.clear();
	}
}
