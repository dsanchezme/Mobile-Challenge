package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

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

    public void setMovieToSearch(String movie){
        findMobileElement(searchInput).click().clear().sendKeys(movie);
    }

    public void selectFirstSearchResult(){
        movieResults.get(0).click();
    }

    public void selectAnyMovieResult(){
        int selection = new Random().nextInt(movieResults.size());
        movieResults.get(selection).click();
    }


}
