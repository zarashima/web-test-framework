package capabilities;


public class AndroidCapabilities {

  DesiredCapabilities desiredCapabilities;

  public AndroidCapabilities() {
    this.desiredCapabilities = DesiredCapabilitiesManager.loadDesiredCapabilities().get("android");
  }

}
