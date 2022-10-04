package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import org.tinylog.Logger;

public class YouScreen extends BaseMobileScreen {

    private final MobileElement signInButton = new MobileElement(By.Id, "com.imdb.mobile:id/sign_in_button", "Got to login screen button");
    private final MobileElement fullWatchListButton = new MobileElement(By.Id, "com.imdb.mobile:id/see_all", "Button to display all movies added to watch list");
    private final MobileElement settingsButton = new MobileElement(By.Id, "com.imdb.mobile:id/settings_icon", "Go to account settings button");

    public YouScreen() {
        super();
    }

    public void goToLoginScreen(){
        Logger.debug("Going to login screen...");
        findMobileElement(signInButton).click();
    }

    public void seeFullWatchList(){
        Logger.debug("Displaying all movies in watch list...");
        findMobileElement(fullWatchListButton).click();
    }

    public void goToSettings(){
        Logger.debug("Going to account settings...");
        findMobileElement(settingsButton).click();
    }

    public String getSignInButtonText(){
        Logger.debug("Getting text in sign in button");
        return findMobileElement(signInButton).getText();
    }
}
