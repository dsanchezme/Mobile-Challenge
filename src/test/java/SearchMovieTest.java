import adapter.bases.BaseMobileTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonReaderUtil;

public class SearchMovieTest extends BaseMobileTest {

    private static final String EXPECTATIONS_FILE_PATH = "src/main/resources/expectations.json";

    @Test
    public void matchOverviewSearchMovieResult(){
        loginScreen.skipSignIn();
        navigationBar.goToSearchScreen();
        String movieToSearch = JsonReaderUtil.getJsonDataProperty("movieTitle", EXPECTATIONS_FILE_PATH);
        searchScreen.setMovieToSearch(movieToSearch);
        searchScreen.selectFirstSearchResult();
        String expectedMovieOverview = JsonReaderUtil.getJsonDataProperty("movieOverview", EXPECTATIONS_FILE_PATH);
        String actualMovieOverview = movieScreen.getMovieOverview();
        Assert.assertEquals(expectedMovieOverview, actualMovieOverview);
    }
}
