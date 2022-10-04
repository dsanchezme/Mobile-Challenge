package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import org.tinylog.Logger;

public class NavigationBar extends BaseMobileScreen {

    private final MobileElement homeButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_home", "Home button");
    private final MobileElement searchButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_search_browse", "Search button");
    private final MobileElement videoButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_video", "Video button");
    private final MobileElement youButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_you", "Account button");

    public NavigationBar(){
        super();
    }

    public void goToHomeScreen(){
        Logger.debug("Going to home screen...");
        findMobileElement(homeButton).click();
    }

    public void goToSearchScreen(){
        Logger.debug("Going to search screen...");
        findMobileElement(searchButton).click();
    }

    public void goToVideoScreen(){
        Logger.debug("Going to video screen...");
        findMobileElement(videoButton).click();
    }

    public void goToYouScreen(){
        Logger.debug("Going to account screen...");
        findMobileElement(youButton).click();
    }
}
