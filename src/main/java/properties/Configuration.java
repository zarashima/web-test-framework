package properties;

import static org.aeonbits.owner.Config.*;

@LoadPolicy(LoadType.MERGE)
@Sources({"file:src/test/resources/reportportal.properties",
		"file:src/test/resources/settings.properties",
		"file:src/test/resources/applitools.properties",
		"file:src/test/resources/percy.properties"})
public interface Configuration extends org.aeonbits.owner.Config {
	@Key("applitools.isIntegration")
	@DefaultValue("false")
	boolean appliToolsIntegration();

	@Key("applitools.apiKey")
	String apiKey();

	@Key("rp.endpoint")
	String rpEndPoint();

	@Key("rp.uuid")
	String rpUUID();

	@Key("rp.launch")
	String rpLaunch();

	@Key("rp.project")
	String rpProject();

	@Key("rp.enable")
	boolean rpIntegration();

	@Key("web.timeout")
	Integer timeout();

	@Key("aut.homepage")
	String baseURL();

	@Key("percy.integration")
	boolean percyIntegration();
}
