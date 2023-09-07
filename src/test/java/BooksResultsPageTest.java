import Pages.BookPage;
import Pages.BooksResultsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BooksResultsPageTest extends UseCaseBase {

    private static BooksResultsPage booksResultsPage;

    @BeforeAll
    public static void classSetUp(){
        booksResultsPage = new BooksResultsPage();
    }

    @BeforeEach
    public void testSetUp(){
        booksResultsPage.navigateToEnglishOnlyBooksPage();
    }

    @Test
    public void selectBook(){
        booksResultsPage.scrollDownPage();
        if(booksResultsPage.isDiscountBannerVisible()){
            booksResultsPage.clickBannerCloseButton();
        }
        BookPage bookPage = booksResultsPage.clickBookTitle();
        assertTrue(bookPage.isBookTitleExists());
    }

}
