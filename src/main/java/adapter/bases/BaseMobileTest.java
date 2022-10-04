package adapter.bases;

import adapter.screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
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

    @BeforeTest(alwaysRun = true)
    public void setUp(){
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

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
