package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import org.tinylog.Logger;

public class SettingsScreen extends BaseMobileScreen {

    private MobileElement signOutButton = new MobileElement(By.Id, "com.imdb.mobile:id/logout_button", "Sign out button");

    public SettingsScreen() {
        super();
    }

    public void signOut(){
        Logger.debug("Logging out...");
        findMobileElement(signOutButton).click();
    }



}
