package reportportal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Launch {

	private String uuid;
	private String id;
	private String description;
	private final List<Map<String, String>> attributes = new ArrayList<>();

	Launch() { }

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Map<String, String>> getAttributes() {
		return attributes;
	}

	public void setAttributes(String key, String value) {
		Map<String, String> attribute = new HashMap<>();
		attribute.put("key", key);
		attribute.put("value", value);
		this.attributes.add(attribute);
	}
}
