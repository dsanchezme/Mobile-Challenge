package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.RemoteWebElement;
import org.tinylog.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class WatchListScreen extends BaseMobileScreen {


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/primaryText\")")
    private List<AndroidElement> watchListTitles;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/primary_view\")")
    private List<AndroidElement> watchListCards;

    public WatchListScreen() {
        super();
    }

    public int getMovieSelectedIndex(String movie){
        return watchListTitles.stream().map(AndroidElement::getText).map(String::toLowerCase).collect(Collectors.toList()).indexOf(movie.toLowerCase());
    }

    public boolean movieInWatchList(String movie){
        Logger.debug("Checking if " + movie + " is in the watch list...");
        return getMovieSelectedIndex(movie) >= 0;
    }

    public void selectMovie(String movie){
        int index = getMovieSelectedIndex(movie);
        watchListCards.get(index).click();
    }

}

