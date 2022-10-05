import adapter.bases.BaseMobileTest;
import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tinylog.Logger;
import utils.JsonReaderUtil;

@Listeners({ TestListener.class })
public class IMDbTests extends BaseMobileTest {
    @Test
    public void matchOverviewFirstResult(){
        Logger.info("Verifying movie overview after movie search");
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
        Logger.info("Verifying add movie to watch list functionality");
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
        watchListScreen.selectMovie(movieSelected);
        movieScreen.removeFromWatchList();
    }

    @Test
    public void rateMovieTest(){
        Logger.info("Verifying rate a movie functionality");
        generalLoginScreen.signInWithIMDB();
        iMDbLoginScreen.signIn();
        navigationBar.goToSearchScreen();
        String movieToSearch = JsonReaderUtil.getJsonDataProperty("movieTitle", EXPECTATIONS_FILE_PATH);
        searchScreen.setMovieToSearch(movieToSearch);
        searchScreen.selectFirstSearchResult();
        movieScreen.goToRateMovie();
        rateMovieScreen.rateMovie(8);
        String expectedMessage = JsonReaderUtil.getJsonDataProperty("ratingSuccessMessage", EXPECTATIONS_FILE_PATH);
        Assert.assertEquals(movieScreen.getMessageAfterRating(), expectedMessage);
        movieScreen.goToYourMovieRate();
        rateMovieScreen.removeMovieRating();
    }


    @Test
    public void signOutTest(){
        Logger.info("Verifying logout functionality");
        generalLoginScreen.signInWithIMDB();
        iMDbLoginScreen.signIn();
        navigationBar.goToYouScreen();
        youScreen.goToSettings();
        settingsScreen.signOut();
        locationPopUp.dismissPopUpNotAllowing();
        navigationBar.goToYouScreen();
        String expectedButtonText = JsonReaderUtil.getJsonDataProperty("signInButtonText", EXPECTATIONS_FILE_PATH);
        Assert.assertEquals(youScreen.getSignInButtonText(), expectedButtonText);
    }

}
