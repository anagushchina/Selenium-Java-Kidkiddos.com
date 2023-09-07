package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CartPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    public static final String YOUR_CART_HEADER = "//h1[text()='Your cart']";
    public static final String QUANTITY_INPUT = "//input[@class='cart__qty-input']";
    public static final String UPDATE_BUTTON = "//a[text()='Continue shopping']//following-sibling::input[@name='update']";
    public static final String PRICE_FIELD = "//td[@class='cart__price-wrapper cart-flex-item']//descendant::span[@class='cbb-price-digits']";
    public static final String TOTAL_FIELD = "//td[@class='text-right small--hide']//descendant::span[@class='cbb-price-digits']";

    public boolean isYourCartHeaderExists(){
        return isElementExists(YOUR_CART_HEADER);
    }

    public void typeInQuantityInput(String amount){
        sendTextToElementByXpath(QUANTITY_INPUT, amount);
    }

    public void clickUpdateButton(){
        clickElementByXpath(UPDATE_BUTTON);
    }

    public String getQuantityInputValue(){
        return getElementValue(QUANTITY_INPUT);
    }

    public String getPriceFieldValue(){
        return getElementText(PRICE_FIELD);
    }

    public String getTotalFieldValue(){
        return getElementText(TOTAL_FIELD);
    }

}
