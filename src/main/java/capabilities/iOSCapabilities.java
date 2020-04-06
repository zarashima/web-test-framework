package capabilities;

public class iOSCapabilities {

  DesiredCapabilities desiredCapabilities;

  public iOSCapabilities() {
    this.desiredCapabilities = DesiredCapabilitiesManager.loadDesiredCapabilities().get("iOS");
  }

}
