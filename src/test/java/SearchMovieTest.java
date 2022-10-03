import adapter.bases.BaseMobileTest;
import core.MobileAppDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReaderUtil;
import utils.SystemVariablesUtil;

public class SearchMovieTest extends BaseMobileTest {

    private static final String EXPECTATIONS_FILE_PATH = "src/main/resources/expectations.json";

    @Test
    public void matchOverviewFirstResult(){
        generalLoginScreen.skipSignIn();
        navigationBar.goToSearchScreen();
        String movieToSearch = JsonReaderUtil.getJsonDataProperty("movieTitle", EXPECTATIONS_FILE_PATH);
        searchScreen.setMovieToSearch(movieToSearch);
        searchScreen.selectFirstSearchResult();
        String expectedMovieOverview = JsonReaderUtil.getJsonDataProperty("movieOverview", EXPECTATIONS_FILE_PATH);
        String actualMovieOverview = movieScreen.getMovieOverview();
        Assert.assertEquals(expectedMovieOverview, actualMovieOverview);
    }

    @Test
    public void addMovieToWatchList(){
        generalLoginScreen.signInWithIMDB();
        iMDbLoginScreen.signIn();
        navigationBar.goToSearchScreen();
        String movieToSearch = JsonReaderUtil.getJsonDataProperty("movieTitle", EXPECTATIONS_FILE_PATH);
        searchScreen.setMovieToSearch(movieToSearch);
        searchScreen.selectAnyMovieResult();
        String movieSelected = movieScreen.getMovieTitle();
        movieScreen.addToWatchList();
        navigationBar.goToYouScreen();
        youScreen.seeFullWatchList();
        Assert.assertTrue(watchListScreen.movieInWatchList(movieSelected));
    }
}
