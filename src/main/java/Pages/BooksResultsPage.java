package Pages;

import Consts.Consts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BooksResultsPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(BooksResultsPage.class);

    public static final String ENGLISH_ONLY_HEADER = "//h1[text()='English Only']";
    public static final String BOOK_TITLE_TEMPLATE = "//div[contains(text(),'TITLE')]";
    public static final String DISCOUNT_BANNER = "//div[text()='Enjoy 10% off your first order!']";
    public static final String BANNER_CLOSE_BUTTON = "//i[@class='_close-icon']";

    private String getBookTitleXPath(String bookTitle){
        logger.info("Getting xPath of the 'Book Title' web element");
        String bookTitleXPath = BOOK_TITLE_TEMPLATE.replace("TITLE", bookTitle);
        return bookTitleXPath;
    }

    public void navigateToEnglishOnlyBooksPage(){
        webDriver.get(Consts.ENGLISH_ONLY_BOOKS_URL);
    }

    public boolean isEnglishOnlyHeaderExists(){
        return isElementExists(ENGLISH_ONLY_HEADER);
    }

    public boolean isDiscountBannerVisible(){
        return isElementVisible(DISCOUNT_BANNER);
    }

    public void clickBannerCloseButton(){
        clickElementByXpath(BANNER_CLOSE_BUTTON);
    }

    public BookPage clickBookTitle(){
        clickElementByXpath(getBookTitleXPath(Consts.BOOK_TITLE));
        return new BookPage();
    }

}
