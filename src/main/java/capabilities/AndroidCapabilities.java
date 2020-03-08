package capabilities;


public class AndroidCapabilities {

  public DesiredCapabilities desiredCapabilities;

  public AndroidCapabilities() {
    this.desiredCapabilities = DesiredCapabilitiesManager.loadDesiredCapabilities().get("android");
  }

}
