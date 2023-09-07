import Pages.BookPage;
import Pages.CartPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookPageTest extends UseCaseBase {

    private static BookPage bookPage;

    @BeforeAll
    public static void classSetUp(){
        bookPage = new BookPage();
    }

    @BeforeEach
    public void testSetUp(){
        bookPage.navigateToBookPage();
    }

    @Test
    public void selectFormatTest(){
        bookPage.selectHardcoverMenuItem();
        String expectedResult = "Hardcover";
        String actualResult = bookPage.getFormatInputValue();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void typeQuantityTest(){
        String expectedAmount = "5";
        bookPage.typeInQuantityInput(expectedAmount);
        String actualAmount = bookPage.getQuantityInputValue();
        assertEquals(expectedAmount,actualAmount);
    }

    @Test
    public void openYourCartPageTest(){
        CartPage cartPage = bookPage.clickAddToCartButton();
        assertTrue(cartPage.isYourCartHeaderExists());
    }

    @Test
    public void updateCartTest(){
        CartPage cartPage = bookPage.clickAddToCartButton();
        assertTrue(cartPage.isYourCartHeaderExists());
        String expectedAmount = "6";
        cartPage.typeInQuantityInput(expectedAmount);
        cartPage.clickUpdateButton();
        String actualAmount = cartPage.getQuantityInputValue();
        assertEquals(expectedAmount,actualAmount);
    }


}
