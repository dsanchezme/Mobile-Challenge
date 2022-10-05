package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.tinylog.Logger;

import java.util.List;
import java.util.Random;

public class SearchScreen extends BaseMobileScreen {

    private final MobileElement searchInput = new MobileElement(By.Id, "com.imdb.mobile:id/search_src_text", "Search movie input");
    private final MobileElement firstMovieResult = new MobileElement(By.AndroidUISelector, "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\").index(1)", "First movie result");

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\")")
    private List<AndroidElement> movieResults;

    public SearchScreen() {
        super();
    }

    @Step("Set movie to search")
    public void setMovieToSearch(String movie){
        Logger.debug("Typing " + movie + " in the movie search bar...");
        findMobileElement(searchInput).click().clear().sendKeys(movie);
    }

    @Step("Select first search result")
    public void selectFirstSearchResult(){
        Logger.debug("Selecting first result...");
        movieResults.get(0).click();
    }

    @Step("Select any search result")
    public void selectAnyMovieResult(){
        int selection = new Random().nextInt(movieResults.size());
        Logger.debug("Selecting the result number " + selection);
        movieResults.get(selection).click();
    }


}
