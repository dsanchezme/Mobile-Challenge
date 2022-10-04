package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class YouScreen extends BaseMobileScreen {

    private final MobileElement signInButton = new MobileElement(By.Id, "com.imdb.mobile:id/sign_in_button", "Got to login screen button");
    private final MobileElement fullWatchListButton = new MobileElement(By.Id, "com.imdb.mobile:id/see_all", "Button to display all movies added to watch list");
    private final MobileElement settingsButton = new MobileElement(By.Id, "com.imdb.mobile:id/settings_icon", "Go to account settings button");

    public YouScreen() {
        super();
    }

    public void goToLoginScreen(){
        findMobileElement(signInButton).click();
    }

    public void seeFullWatchList(){
        findMobileElement(fullWatchListButton).click();
    }

    public void goToSettings(){
        findMobileElement(settingsButton).click();
    }

    public String getSignInButtonText(){
        return findMobileElement(signInButton).getText();
    }
}
