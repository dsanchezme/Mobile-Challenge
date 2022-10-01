package adapter.bases;

import adapter.screens.LoginScreen;
import adapter.screens.MovieScreen;
import adapter.screens.NavigationBar;
import adapter.screens.SearchScreen;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseMobileTest {

    private AndroidDriver<AndroidElement> driver;

    public NavigationBar navigationBar;
    public LoginScreen loginScreen;
    public SearchScreen searchScreen;
    public MovieScreen movieScreen;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        navigationBar = new NavigationBar();
        loginScreen = new LoginScreen();
        searchScreen = new SearchScreen();
        movieScreen = new MovieScreen();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

}
