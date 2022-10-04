package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MovieScreen extends BaseMobileScreen {

    private final MobileElement movieOverview = new MobileElement(By.Id, "com.imdb.mobile:id/plot_overview", "Movie overview");
    private final MobileElement addToWatchListButton = new MobileElement(By.Id, "com.imdb.mobile:id/watchlist_button_view", "Button to add movie to watch list");
    private final MobileElement movieTitle = new MobileElement(By.Id, "com.imdb.mobile:id/title", "Movie title");

    private final MobileElement messageAfterRating = new MobileElement(By.Id, "com.imdb.mobile:id/title", "Message displayed after rating a movie");

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.imdb.mobile:id/main_content_scroller\")).scrollIntoView(new UiSelector().resourceId(\"com.imdb.mobile:id/empty_user_rating\"))")
    private AndroidElement rateMovieButton;

    public MovieScreen(){
        super();
    }

    public String getMovieOverview(){
        return findMobileElement(movieOverview).getText();
    }

    public void addToWatchList(){
        findMobileElement(addToWatchListButton).click();
    }

    public String getMovieTitle(){
        return findMobileElement(movieTitle).getText();
    }

    public void goToRateMovie(){
        rateMovieButton.click();
    }

    public String getMessageAfterRating(){
        return findMobileElement(messageAfterRating).getText();
    }
}
