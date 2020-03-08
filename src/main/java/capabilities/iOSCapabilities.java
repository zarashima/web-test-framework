package capabilities;

public class iOSCapabilities {

  public DesiredCapabilities desiredCapabilities;

  public iOSCapabilities() {
    this.desiredCapabilities = DesiredCapabilitiesManager.loadDesiredCapabilities().get("iOS");
  }

}
