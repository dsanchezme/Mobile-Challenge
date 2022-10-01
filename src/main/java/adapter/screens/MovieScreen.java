package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class MovieScreen extends BaseMobileScreen {

    private MobileElement movieOverview = new MobileElement(By.Id, "com.imdb.mobile:id/plot_overview", "Movie overview");

    public MovieScreen(){
        super();
    }

    public String getMovieOverview(){
        return findMobileElement(movieOverview).getText();
    }
}
