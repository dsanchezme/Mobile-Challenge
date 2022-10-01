package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class YouScreen extends BaseMobileScreen {

    private MobileElement signInButton = new MobileElement(By.Id, "com.imdb.mobile:id/sign_in_button", "Got to login screen button");

    public YouScreen() {
        super();
    }

    public void goToLoginScreen(){
        findMobileElement(signInButton).click();
    }
}
