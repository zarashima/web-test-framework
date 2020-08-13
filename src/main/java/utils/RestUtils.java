package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class RestUtils {

	public enum HttpMethod {
		GET("get"), POST("post"), PUT("put");

		private final String method;

		HttpMethod(String method) {
			this.method = method;
		}
	}

	private RestUtils() { }

	public static String path;
	public static Response response;
	public static RequestSpecification requestSpecification;
	public static RequestSpecBuilder builder = new RequestSpecBuilder();

	public static void setHeader(String key, String value) {
		builder.addHeader(key, value);
	}

	public static void setBaseURI(String baseURI) {
		builder.setBaseUri(baseURI);
	}

	public static void setBasePath(String basePathTerm) {
		builder.setBasePath(basePathTerm);
	}

	public static void  createSearchQueryPath(String searchTerm, String jsonPathTerm, String param, String paramValue) {
		path = searchTerm + "/" + jsonPathTerm + "?" + param + "=" + paramValue;
	}

	public static void addJsonBody(JSONObject body) {
		builder.setBody(body);
	}

	public static void resetBaseURI () {
		builder.setBaseUri("");
	}

	public static void resetBasePath() {
		builder.setBasePath("");
	}

	public static void setContentType (ContentType type) {
		builder.setContentType(type);
	}

	public static Response send(HttpMethod method, JSONObject requestBody) {
		response = null;
		requestSpecification = builder.build();
		if (method == HttpMethod.POST)
		{
			builder.setBody(requestBody);
			response = RestAssured.given().spec(requestSpecification).post();
		}
		else if (method == HttpMethod.GET)
		{
			response = RestAssured.given().spec(requestSpecification).get();
		}
		else if (method == HttpMethod.PUT) {
			builder.setBody(requestBody);
			response = RestAssured.given().spec(requestSpecification).put();
		}
		response.then().log().all();
		return response;
	}

	public static JsonPath getJsonPath(Response res) {
		String json = res.asString();
		return new JsonPath(json);
	}
}
