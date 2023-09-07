package Pages;

import Consts.Consts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(MainPage.class);

    public static final String LOGO = "//img[@itemprop='logo']";
    public static final String CONTACT_US_OPTION = "//a[text()='Contact us']";
    public static final String BOOKS_BY_LANGUAGE_OPTION = "//a[@aria-controls='SiteNavLabel-books-by-language']";
    public static final String ENGLISH_ONLY_MENU_ITEM = "//*[@id='SiteNavLabel-books-by-language']//descendant::a[text()='English Only']";
    public static final String LOG_IN_BUTTON = "//a[@class='site-header__account']";

    public void navigateToMainPage(){
        webDriver.get(Consts.MAIN_URL);
    }

    public boolean isLogoExists(){
        return isElementExists(LOGO);
    }

    public ContactUsPage selectContactUsOption(){
        clickElementByXpath(CONTACT_US_OPTION);
        return new ContactUsPage();
    }

    public void selectBookByLanguageOption(){
        clickElementByXpath(BOOKS_BY_LANGUAGE_OPTION);
    }

    public BooksResultsPage selectEnglishOnlyMenuItem(){
        clickElementByXpath(ENGLISH_ONLY_MENU_ITEM);
        return new BooksResultsPage();
    }

    public LoginPage clickLogInButton(){
        clickElementByXpath(LOG_IN_BUTTON);
        return new LoginPage();
    }
}
