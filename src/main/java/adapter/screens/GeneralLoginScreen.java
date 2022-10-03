package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class GeneralLoginScreen extends BaseMobileScreen {

    private final MobileElement skipLoginButton = new MobileElement(By.Id, "com.imdb.mobile:id/splash_not_now", "Skip sign in button");
    private final MobileElement imdbLoginButton = new MobileElement(By.Id, "com.imdb.mobile:id/imdb_auth_portal", "Sign in with IMDB button");

    public GeneralLoginScreen() {
        super();
    }

    public void skipSignIn(){
        findMobileElement(skipLoginButton).click();
    }

    public void signInWithIMDB(){
        findMobileElement(imdbLoginButton).click();
    }
}
