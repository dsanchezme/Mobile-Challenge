package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class WatchListScreen extends BaseMobileScreen {


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/primaryText\")")
    private List<AndroidElement> watchListTitles;

    public WatchListScreen() {
        super();
    }

    public boolean movieInWatchList(String movie){
        return watchListTitles.stream().map(AndroidElement::getText).map(String::toLowerCase).collect(Collectors.toList()).contains(movie.toLowerCase());
    }

}

