package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.tinylog.Logger;

import java.util.List;

public class RateMovieScreen extends BaseMobileScreen {

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.imdb.mobile:id/star_row\"]//*[@class=\"android.widget.ImageView\"]")
    private List<AndroidElement> starsRate;

    private MobileElement rateMovieButton = new MobileElement(By.Id, "com.imdb.mobile:id/rate_title_button", "Button to submit movie rate");
    private final MobileElement removeRatingButton = new MobileElement(By.Id, "com.imdb.mobile:id/remove_rating", "Remove rating button");

    public RateMovieScreen() {
        super();
    }

    public void rateMovie(int value){
        Logger.debug("Rating a movie with " + value + " stars...");
        if (value>0 && value<11){
            starsRate.get(value-1).click();
        }
        findMobileElement(rateMovieButton).click();
    }

    public void removeMovieRating(){
        Logger.debug("Removing your movie rate...");
        findMobileElement(removeRatingButton).click();
    }
}
