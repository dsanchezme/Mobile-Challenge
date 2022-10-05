package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.qameta.allure.Step;
import org.tinylog.Logger;

public class NavigationBar extends BaseMobileScreen {

    private final MobileElement searchButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_search_browse", "Search button");
    private final MobileElement videoButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_video", "Video button");
    private final MobileElement youButton = new MobileElement(By.Id, "com.imdb.mobile:id/navigation_you", "Account button");

    public NavigationBar(){
        super();
    }

    @Step("Go to search screen")
    public void goToSearchScreen(){
        Logger.debug("Going to search screen...");
        findMobileElement(searchButton).click();
    }

    @Step("Go to video screen")
    public void goToVideoScreen(){
        Logger.debug("Going to video screen...");
        findMobileElement(videoButton).click();
    }

    @Step("Go to you screen")
    public void goToYouScreen(){
        Logger.debug("Going to account screen...");
        findMobileElement(youButton).click();
    }
}
