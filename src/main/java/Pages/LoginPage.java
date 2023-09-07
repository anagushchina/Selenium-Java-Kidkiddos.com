package Pages;

import Consts.Consts;

public class LoginPage extends BasePage{

    public static final String LOGIN_HEADER="//h1[text()='Login']";
    public static final String EMAIL_INPUT="//input[@id='CustomerEmail']";
    public static final String PASSWORD_INPUT="//input[@id='CustomerPassword']";
    public static final String SIGN_IN_BUTTON= "//input[@value='Sign In']";
    public static final String ERROR_TEXT= "//*[text()='Incorrect email or password.']";
    public static final String RECAPTCHA="//*[@class='g-recaptcha']";
    public static final String CHECKBOX= "//span[@role='checkbox']";
    public static final String SUBMIT_BUTTON= "//input[@type='submit']";

    public void navigateToLoginPage(){
        webDriver.get(Consts.LOGIN_PAGE_URL);
    }

    public boolean isLoginHeaderExists(){
        return isElementExists(LOGIN_HEADER);
    }

    public boolean isReCaptchaExists(){
        return isElementExists(RECAPTCHA);
    }

    public void clickSignInButton(){
        clickElementByXpath(SIGN_IN_BUTTON);
    }

    public boolean isErrorTextExists(){
        return isElementExists(ERROR_TEXT);
    }

    public void typeIntoEmailInput(String text){
        sendTextToElementByXpath(EMAIL_INPUT, text);
    }

    public void typeIntoPasswordInput(String text){
        sendTextToElementByXpath(PASSWORD_INPUT, text);
    }


}
