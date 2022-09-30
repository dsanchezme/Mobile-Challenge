package adapter.bases;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseMobileTest {

    private AndroidDriver<AndroidElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());

    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
