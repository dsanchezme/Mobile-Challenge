package core;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.JsonReaderUtil;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "deviceName";
    private static final String APP_PACKAGE = "appPackage";
    private static final String APP_ACTIVITY = "appActivity";
    private static final String PLATFORM_NAME = "platformName";
    private static final String CAPABILITIES_FILE_PATH = "src/main/resources/capabilities.json";
    private static final DesiredCapabilities capabilities = new DesiredCapabilities();

    private ConfigCapabilities(){}

    private static void applicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability(APP_PACKAGE, JsonReaderUtil.getJsonDataProperty(APP_PACKAGE, CAPABILITIES_FILE_PATH));
        capabilities.setCapability(APP_ACTIVITY, JsonReaderUtil.getJsonDataProperty(APP_ACTIVITY, CAPABILITIES_FILE_PATH));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, JsonReaderUtil.getJsonDataProperty(DEVICE_NAME, CAPABILITIES_FILE_PATH));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, JsonReaderUtil.getJsonDataProperty(PLATFORM_NAME, CAPABILITIES_FILE_PATH));
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    public static DesiredCapabilities getCapabilities(){
        if(capabilities.toJson().isEmpty()){
            ConfigCapabilities.applicationSetUp(capabilities);
        }
        return capabilities;
    }

}