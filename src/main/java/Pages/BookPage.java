package Pages;

import Consts.Consts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BookPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(BookPage.class);

    public static final String BOOK_TITLE_TEMPLATE = "//h1[contains(text(),'TITLE')]";
    public static final String FORMAT_INPUT = "//select[@id='SingleOptionSelector-0'][count(*)=2]";
    public static final String HARDCOVER_MENU_ITEM = "//select[@id='SingleOptionSelector-0'][count(*)=2]//descendant::option[@value='Hardcover']";
    public static final String QUANTITY_INPUT = "//label[text()='Quantity']//following-sibling::input[@id='Quantity']";
    public static final String ADD_TO_CART_BUTTON = "//div[@class='product-form__item product-form__item--submit']//descendant::button[@type='submit']";

    public void navigateToBookPage(){
        webDriver.get(Consts.BOOK_PAGE_URL);
    }

    private String getBookTitleXpath(){
        logger.info("Getting xPath of the 'Book Title' web element");
        String bookTitleXPath = BOOK_TITLE_TEMPLATE.replace("TITLE", Consts.BOOK_TITLE);
        return bookTitleXPath;
    }

    public boolean isBookTitleExists(){
        return isElementExists(getBookTitleXpath());
    }

    public String getFormatInputValue(){
        return getElementValue(FORMAT_INPUT);
    }

    public String getQuantityInputValue(){
        return getElementValue(QUANTITY_INPUT);
    }

    public void clickFormatInput(){
        clickElementByXpath(FORMAT_INPUT);
    }

    public void selectHardcoverMenuItem(){
        clickElementByXpath(HARDCOVER_MENU_ITEM);
    }

    public void typeInQuantityInput(String amount){
        sendTextToElementByXpath(QUANTITY_INPUT, amount);
    }

    public CartPage clickAddToCartButton(){
        clickElementByXpath(ADD_TO_CART_BUTTON);
        return new CartPage();
    }

}
