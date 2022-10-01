package adapter.screens;

import adapter.bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchScreen extends BaseMobileScreen {

    private MobileElement searchInput = new MobileElement(By.Id, "com.imdb.mobile:id/search_src_text", "Search movie input");
    private MobileElement firstMovieResult = new MobileElement(By.AndroidUISelector, "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\").index(1)", "First movie result");

    public SearchScreen() {
        super();
    }

    public void setMovieToSearch(String movie){
        findMobileElement(searchInput).click().clear().sendKeys(movie);
    }

    public void selectFirstSearchResult(){
        findMobileElement(firstMovieResult).click();
    }


}
