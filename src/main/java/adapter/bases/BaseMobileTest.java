package adapter.bases;

import adapter.screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.tinylog.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseMobileTest {

    private AndroidDriver<AndroidElement> driver;
    public NavigationBar navigationBar;
    public GeneralLoginScreen generalLoginScreen;
    public SearchScreen searchScreen;
    public MovieScreen movieScreen;
    public IMDbLoginScreen iMDbLoginScreen;
    public YouScreen youScreen;
    public WatchListScreen watchListScreen;
    public RateMovieScreen rateMovieScreen;
    public SettingsScreen settingsScreen;
    public LocationPopUp locationPopUp;
    public static final String EXPECTATIONS_FILE_PATH = "src/main/resources/expectations.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        Logger.debug("Starting test...");
        Logger.info("Setting up driver");
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        navigationBar = new NavigationBar();
        generalLoginScreen = new GeneralLoginScreen();
        searchScreen = new SearchScreen();
        movieScreen = new MovieScreen();
        iMDbLoginScreen = new IMDbLoginScreen();
        youScreen = new YouScreen();
        watchListScreen = new WatchListScreen();
        rateMovieScreen = new RateMovieScreen();
        settingsScreen = new SettingsScreen();
        locationPopUp = new LocationPopUp();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
            Logger.info("Destroying driver");
        }
        Logger.debug("Test finished.");
    }

    public AndroidDriver<AndroidElement> getDriver(){
        return driver;
    }

}
