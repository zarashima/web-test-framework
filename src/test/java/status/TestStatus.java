package status;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestStatus {
	@JsonProperty("testClass")
	private String testClass;

	@JsonProperty("description")
	private String description;

	@JsonProperty("status")
	private String status;

	@JsonProperty("executionTime")
	private String executionTime;

	@JsonProperty("statusMessage")
	private String statusMessage;

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExecutionDate(String executionTime) {
		this.executionTime = executionTime;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTestClass(String testClass) {
		this.testClass = testClass;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
}
