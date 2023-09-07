import Pages.ContactUsPage;
import Pages.BooksResultsPage;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainPageTest extends UseCaseBase {

    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(MainPageTest.class);

    @BeforeAll
    public static void classSetUp(){
        mainPage = new MainPage();
    }

    @BeforeEach
    public void testSetUp(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void mainPageLoadTest(){
        logger.info("Main Page loading test is running");
        boolean success = mainPage.isLogoExists();
        mainPage.takeScreenShot("mainPageTest");
        assertTrue(success);
    }

    @Test
    public void openContactUsPageTest(){
        logger.info("openContactUsPageTest is running");
        ContactUsPage contactUsPage = mainPage.selectContactUsOption();
        assertTrue(contactUsPage.isContactUsHeaderExists());
    }

    @Test
    public void openLogInPageTest(){
        logger.info("openLogInPageTest is running");
        LoginPage logInPage = mainPage.clickLogInButton();
        assertTrue(logInPage.isLoginHeaderExists());
    }

    @Test
    public void openEnglishOnlyBooksPageTest(){
        logger.info("openEnglishOnlyBooksPageTest is running");
        mainPage.selectBookByLanguageOption();
        BooksResultsPage booksResultsPage = mainPage.selectEnglishOnlyMenuItem();
        assertTrue(booksResultsPage.isEnglishOnlyHeaderExists());
    }

}
