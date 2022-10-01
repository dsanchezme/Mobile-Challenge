package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class LoginScreen extends BaseMobileScreen {

    private MobileElement skipLoginButton = new MobileElement(By.Id, "com.imdb.mobile:id/splash_not_now", "Skip sign in button");

    public LoginScreen() {
        super();
    }

    public void skipSignIn(){
        findMobileElement(skipLoginButton).click();
    }
}
