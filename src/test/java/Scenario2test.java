import Pages.BookPage;
import Pages.BooksResultsPage;
import Pages.CartPage;
import Pages.MainPage;
import Utils.UseCaseBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Scenario2test extends UseCaseBase {

    private static MainPage mainPage;
    private static final Logger logger = LogManager.getLogger(Scenario2test.class);

    @BeforeAll
    public static void classSetUp(){
        mainPage = new MainPage();
    }

    @BeforeEach
    public void testSetUp(){
        mainPage.navigateToMainPage();
    }

    @Test
    public void updateCartTest(){
        logger.info("Running updateCartTest");
        mainPage.selectBookByLanguageOption();

        BooksResultsPage booksResultsPage = mainPage.selectEnglishOnlyMenuItem();
        assertTrue(booksResultsPage.isEnglishOnlyHeaderExists());
        booksResultsPage.scrollDownPage();
        if(booksResultsPage.isDiscountBannerVisible()){
            booksResultsPage.clickBannerCloseButton();
        }

        BookPage bookPage = booksResultsPage.clickBookTitle();
        bookPage.isBookTitleExists();
        bookPage.selectHardcoverMenuItem();
        String expectedFormat = "Hardcover";
        String actualFormat = bookPage.getFormatInputValue();
        assertEquals(expectedFormat,actualFormat);
        String expectedAmount = "5";
        bookPage.typeInQuantityInput(expectedAmount);
        String actualAmount = bookPage.getQuantityInputValue();
        assertEquals(expectedAmount,actualAmount);

        CartPage cartPage = bookPage.clickAddToCartButton();
        assertTrue(cartPage.isYourCartHeaderExists());

        String expectedNewAmount = "6";
        cartPage.typeInQuantityInput(expectedNewAmount);
        cartPage.clickUpdateButton();
        String actualNewAmount = cartPage.getQuantityInputValue();
        assertEquals(expectedNewAmount, actualNewAmount);
        String expectedTotalPrice = String.valueOf(Integer.valueOf(expectedNewAmount)*Double.valueOf(cartPage.getPriceFieldValue()));
        String actualTotalPrice = cartPage.getTotalFieldValue();
        assertEquals(expectedTotalPrice, actualTotalPrice);
    }

}
