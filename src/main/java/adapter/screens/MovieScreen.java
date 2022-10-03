package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class MovieScreen extends BaseMobileScreen {

    private MobileElement movieOverview = new MobileElement(By.Id, "com.imdb.mobile:id/plot_overview", "Movie overview");
    private MobileElement addToWatchListButton = new MobileElement(By.Id, "com.imdb.mobile:id/watchlist_button_view", "Button to add movie to watch list");
    private MobileElement movieTitle = new MobileElement(By.Id, "com.imdb.mobile:id/title", "Movie title");

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
}
