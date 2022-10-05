package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.tinylog.Logger;

public class MovieScreen extends BaseMobileScreen {

    private final MobileElement movieOverview = new MobileElement(By.Id, "com.imdb.mobile:id/plot_overview", "Movie overview");
    private final MobileElement addToWatchListButton = new MobileElement(By.Id, "com.imdb.mobile:id/watchlist_button_view", "Button to add movie to watch list");
    private final MobileElement movieTitle = new MobileElement(By.Id, "com.imdb.mobile:id/title", "Movie title");
    private final MobileElement messageAfterRating = new MobileElement(By.Id, "com.imdb.mobile:id/title", "Message displayed after rating a movie");

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.imdb.mobile:id/main_content_scroller\")).scrollIntoView(new UiSelector().resourceId(\"com.imdb.mobile:id/empty_user_rating\"))")
    private AndroidElement rateMovieButton;
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().resourceId(\"com.imdb.mobile:id/main_content_scroller\")).scrollIntoView(new UiSelector().resourceId(\"com.imdb.mobile:id/your_rating_group\"))")
    private AndroidElement yourRateButton;

    public MovieScreen(){
        super();
    }

    @Step("Get movie overview")
    public String getMovieOverview(){
        Logger.debug("Getting movie overview...");
        return findMobileElement(movieOverview).getText();
    }

    @Step("Add movie to watch list")
    public void addToWatchList(){
        Logger.debug("Adding movie to watch list...");
        findMobileElement(addToWatchListButton).click();
    }

    @Step("Remove movie from watch list")
    public void removeFromWatchList(){
        Logger.debug("Removing movie from watch list...");
        findMobileElement(addToWatchListButton).click();
    }

    @Step("Get movie title")
    public String getMovieTitle(){
        Logger.debug("Getting movie title...");
        return findMobileElement(movieTitle).getText();
    }

    @Step("Go to rate movie")
    public void goToRateMovie(){
        Logger.debug("Going to rate movie screen...");
        rateMovieButton.click();
    }

    public String getMessageAfterRating(){
        Logger.debug("Getting message displayed after rating a movie...");
        return findMobileElement(messageAfterRating).getText();
    }

    public void goToYourMovieRate(){
        Logger.debug("Going to your movie rate screen...");
        yourRateButton.click();
    }

}
