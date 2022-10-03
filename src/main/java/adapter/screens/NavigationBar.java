package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class NavigationBar extends BaseMobileScreen {

    private final MobileElement homeButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_home", "Home button");
    private final MobileElement searchButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_search_browse", "Search button");
    private final MobileElement videoButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_video", "Video button");
    private final MobileElement youButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_you", "Account button");

    public NavigationBar(){
        super();
    }

    public void goToHomeScreen(){
        findMobileElement(homeButton).click();
    }

    public void goToSearchScreen(){
        findMobileElement(searchButton).click();
    }

    public void goToVideoScreen(){
        findMobileElement(videoButton).click();
    }

    public void goToYouScreen(){
        findMobileElement(youButton).click();
    }
}
